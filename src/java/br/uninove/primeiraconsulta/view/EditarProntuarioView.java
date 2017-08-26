/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.view;

import br.uninove.primeiraconsulta.dao.AnamneseDao;
import br.uninove.primeiraconsulta.dao.EstiloDeVidaDao;
import br.uninove.primeiraconsulta.dao.ExameFisicoDao;
import br.uninove.primeiraconsulta.dao.ListaProblemasDao;
import br.uninove.primeiraconsulta.dao.UsuarioDao;
import br.uninove.primeiraconsulta.entidade.Anamnese;
import br.uninove.primeiraconsulta.entidade.EstiloDeVida;
import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.ListaProblemas;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.entidade.Usuario;
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
public class EditarProntuarioView implements Serializable {

    private Repositorios repositorios = new Repositorios();
    private Prontuario prontuario = new Prontuario();
    private Usuario usuario = new Usuario();
    private Anamnese anamnese = new Anamnese();
    private ExameFisico exameFisico = new ExameFisico();
    private EstiloDeVida estiloDeVida = new EstiloDeVida();
    private List<ListaProblemas> listaProblemas = new ArrayList<>();

    @PostConstruct
    public void inicializar() {
        prontuario = (Prontuario) FacesContext.getCurrentInstance().getExternalContext()
                .getFlash().get("prontuarioSelecionado");
        AnamneseDao anamneseDao = this.repositorios.getAnamneseDao();
        EstiloDeVidaDao estiloDeVidaDao = this.repositorios.getEstiloDeVidaDao();
        ExameFisicoDao exameFisicoDao = this.repositorios.getExameFisicoDao();
        ListaProblemasDao listaProblemasDao = this.repositorios.getListaProblemasDao();
        
        anamnese = anamneseDao.porId(prontuario.getIdAnamnese());
        estiloDeVida = estiloDeVidaDao.porId(prontuario.getIdEstiloDeVida());
        exameFisico = exameFisicoDao.porId(prontuario.getIdExameFisico());
        listaProblemas = listaProblemasDao.porNumProntuario(prontuario.getNumProntuario());
    }

    public void salvar() throws RegraNegocioException {
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
            prontuarioService.salvar(prontuario, anamnese, estiloDeVida, exameFisico, listaProblemas);

            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Prontuario salvo com sucesso!");
        } catch (RegraNegocioException e) {
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
        }

    }

    public String verProntuario() {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("prontuarioSelecionado", this.prontuario);
        return "VerProntuario";
    }
    
    public void addListaProblemas() {
        this.listaProblemas.add(new ListaProblemas());
    }

    public void removeListaProblemas() {
        if (this.listaProblemas.size() > 1) {
            this.listaProblemas.remove(this.listaProblemas.get(this.listaProblemas.size() - 1));
        }
    }
    
    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public Anamnese getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(Anamnese anamnese) {
        this.anamnese = anamnese;
    }
    
    public ExameFisico getExameFisico() {
        return exameFisico;
    }

    public void setExameFisico(ExameFisico exameFisico) {
        this.exameFisico = exameFisico;
    }

    public EstiloDeVida getEstiloDeVida() {
        return estiloDeVida;
    }

    public void setEstiloDeVida(EstiloDeVida estiloDeVida) {
        this.estiloDeVida = estiloDeVida;
    }

    public List<ListaProblemas> getListaProblemas() {
        return listaProblemas;
    }

    public void setListaProblemas(List<ListaProblemas> listaProblemas) {
        this.listaProblemas = listaProblemas;
    }
    
    
}
