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
import br.uninove.primeiraconsulta.dao.ProntuarioDao;
import br.uninove.primeiraconsulta.dao.UsuarioDao;
import br.uninove.primeiraconsulta.entidade.Anamnese;
import br.uninove.primeiraconsulta.entidade.EstiloDeVida;
import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.ListaProblemas;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.entidade.Rastreamento;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.util.FacesUtil;
import br.uninove.primeiraconsulta.util.RastreamentoUtil;
import br.uninove.primeiraconsulta.util.Repositorios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class VerProntuarioView implements Serializable{
    
    private Repositorios repositorios = new Repositorios();
    private Prontuario prontuario = new Prontuario();
    private Anamnese anamnese = new Anamnese();
    private ExameFisico exameFisico = new ExameFisico();
    private EstiloDeVida estiloDeVida = new EstiloDeVida();
    private List<ListaProblemas> listaProblemas = new ArrayList<>();
    private List<Rastreamento> listaRastreamento = new ArrayList<>();
    
    @PostConstruct
    public void inicializar() {
        try {
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
            listaRastreamento = RastreamentoUtil.getRastreamento(prontuario, estiloDeVida, exameFisico);
        } catch (Exception e) {
            //FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
        }
    }
    
    public String getReferencias() throws Exception{
        return RastreamentoUtil.getReferencias();
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

    public List<Rastreamento> getListaRastreamento() {
        return listaRastreamento;
    }

    public void setListaRastreamento(List<Rastreamento> listaRastreamento) {
        this.listaRastreamento = listaRastreamento;
    }
    
    
    
}
