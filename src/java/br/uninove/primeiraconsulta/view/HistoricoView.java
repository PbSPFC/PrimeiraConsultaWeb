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
public class HistoricoView implements Serializable {

    private Repositorios repositorios = new Repositorios();
    private List<LogProntuario> listaProntuario = new ArrayList<LogProntuario>();
    private Prontuario prontuario = new Prontuario();
    private LogProntuario logProntuario = new LogProntuario();
    private LogProntuario prontuarioSelecionado = new LogProntuario();

    @PostConstruct
    public void inicializar() {
        prontuario = (Prontuario) FacesContext.getCurrentInstance().getExternalContext()
                .getFlash().get("prontuarioSelecionado");
        LogProntuarioDao logProntuarioDao = this.repositorios.getLogProntuarioHibernate();
        this.listaProntuario = logProntuarioDao.todasPorNumProntuario(prontuario.getNumProntuario());
    }

    public String excluir() {
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
            prontuarioService.excluirLog(this.prontuarioSelecionado);

            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Log excluído com sucesso!");
            return "Home?faces-redirect=true";
        } catch (RegraNegocioException e) {
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
        }
        return "Home?faces-redirect=true";
    }

    public String verProntuario() {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("logProntuarioSelecionado", (LogProntuario)this.prontuarioSelecionado);
        return "VerLogProntuario";
    }

    public List<LogProntuario> getListaProntuario() {
        return listaProntuario;
    }

    public void setListaProntuario(List<LogProntuario> listaProntuario) {
        this.listaProntuario = listaProntuario;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public LogProntuario getLogProntuario() {
        return logProntuario;
    }

    public void setLogProntuario(LogProntuario logProntuario) {
        this.logProntuario = logProntuario;
    }

    public LogProntuario getProntuarioSelecionado() {
        return prontuarioSelecionado;
    }

    public void setProntuarioSelecionado(LogProntuario prontuarioSelecionado) {
        this.prontuarioSelecionado = prontuarioSelecionado;
    }

    

}
