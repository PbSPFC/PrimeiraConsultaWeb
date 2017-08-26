/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.view;

import br.uninove.primeiraconsulta.dao.ProntuarioDao;
import br.uninove.primeiraconsulta.dao.UsuarioDao;
import br.uninove.primeiraconsulta.dao.log.LogProntuarioDao;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.entidade.log.LogProntuario;
import br.uninove.primeiraconsulta.service.ProntuarioService;
import br.uninove.primeiraconsulta.service.RegraNegocioException;
import br.uninove.primeiraconsulta.util.FacesUtil;
import br.uninove.primeiraconsulta.util.Repositorios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author PB
 */
@ManagedBean
@ViewScoped
public class ProntuariosView implements Serializable {

    private Repositorios repositorios = new Repositorios();
    private List<Prontuario> listaProntuario = new ArrayList<Prontuario>();
    private Prontuario prontuario = new Prontuario();
    private Prontuario prontuarioSelecionado = new Prontuario();

    @PostConstruct
    public void inicializar() {
        ProntuarioDao prontuarioDao = this.repositorios.getProntuarioHibernate();
        Usuario usuario = new Usuario();
        try {
            UsuarioDao usuarioDao = this.repositorios.getUsuarioHibernate();
            usuario = usuarioDao.porRA(FacesContext.getCurrentInstance().getExternalContext()
                    .getUserPrincipal().getName());

        } catch (Exception e) {
        }
        this.listaProntuario = prontuarioDao.todasPorUsuario(usuario.getId());
    }

    public void excluir() {
        ProntuarioService prontuarioService = new ProntuarioService(
                this.repositorios.getProntuarioHibernate(),
                this.repositorios.getAnamneseDao(),
                this.repositorios.getEstiloDeVidaDao(),
                this.repositorios.getExameFisicoDao(),
                this.repositorios.getListaProblemasDao(),
                this.repositorios.getLogProntuarioHibernate(),
                this.repositorios.getLogAnamneseDao(),
                this.repositorios.getLogEstiloDeVidaDao(),
                this.repositorios.getLogExameFisicoDao(),
                this.repositorios.getLogListaProblemasDao());
        try {
            prontuarioService.excluir(this.prontuarioSelecionado);

            this.inicializar();

            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Prontuário excluído com sucesso!");
        } catch (RegraNegocioException e) {
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
        }
    }

    public String getNumLogs(Prontuario prontuario) {
        try {
            LogProntuarioDao logProntuarioDao = this.repositorios.getLogProntuarioHibernate();
            List<LogProntuario> listaLog = logProntuarioDao.todasPorNumProntuario(prontuario.getNumProntuario());

            return listaLog.size() + "";
        } catch (Exception e) {
            return "Home?faces-redirect=true";
        }
    }

    public String verProntuario() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("prontuarioSelecionado", this.prontuarioSelecionado);
            return "VerProntuario";
        } catch (Exception e) {
            return "Home?faces-redirect=true";
        }
    }

    public String verHistorico() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("prontuarioSelecionado", this.prontuarioSelecionado);
            return "Historico";
        } catch (Exception e) {
            return "Home?faces-redirect=true";
        }
    }

    public String editarProntuario() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("prontuarioSelecionado", this.prontuarioSelecionado);
            return "EditarProntuario";
        } catch (Exception e) {
            return "Home?faces-redirect=true";
        }
    }

    public List<Prontuario> getListaProntuario() {
        return listaProntuario;
    }

    public void setListaProntuario(List<Prontuario> listaProntuario) {
        this.listaProntuario = listaProntuario;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public Prontuario getProntuarioSelecionado() {
        return prontuarioSelecionado;
    }

    public void setProntuarioSelecionado(Prontuario prontuarioSelecionado) {
        this.prontuarioSelecionado = prontuarioSelecionado;
    }

}
