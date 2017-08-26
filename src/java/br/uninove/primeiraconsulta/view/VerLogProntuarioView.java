/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.view;

import br.uninove.primeiraconsulta.dao.log.LogAnamneseDao;
import br.uninove.primeiraconsulta.dao.log.LogEstiloDeVidaDao;
import br.uninove.primeiraconsulta.dao.log.LogExameFisicoDao;
import br.uninove.primeiraconsulta.dao.log.LogListaProblemasDao;
import br.uninove.primeiraconsulta.entidade.Rastreamento;
import br.uninove.primeiraconsulta.entidade.log.LogAnamnese;
import br.uninove.primeiraconsulta.entidade.log.LogEstiloDeVida;
import br.uninove.primeiraconsulta.entidade.log.LogExameFisico;
import br.uninove.primeiraconsulta.entidade.log.LogListaProblemas;
import br.uninove.primeiraconsulta.entidade.log.LogProntuario;
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
public class VerLogProntuarioView implements Serializable{
    
    private Repositorios repositorios = new Repositorios();
    private LogProntuario prontuario = new LogProntuario();
    private LogAnamnese anamnese = new LogAnamnese();
    private LogExameFisico exameFisico = new LogExameFisico();
    private LogEstiloDeVida estiloDeVida = new LogEstiloDeVida();
    private List<LogListaProblemas> listaProblemas = new ArrayList<>();
    private List<Rastreamento> listaRastreamento = new ArrayList<>();
    
    @PostConstruct
    public void inicializar() {
        try {
            prontuario = (LogProntuario) FacesContext.getCurrentInstance().getExternalContext()
                    .getFlash().get("logProntuarioSelecionado");
            LogAnamneseDao anamneseDao = this.repositorios.getLogAnamneseDao();
            LogEstiloDeVidaDao estiloDeVidaDao = this.repositorios.getLogEstiloDeVidaDao();
            LogExameFisicoDao exameFisicoDao = this.repositorios.getLogExameFisicoDao();
            LogListaProblemasDao listaProblemasDao = this.repositorios.getLogListaProblemasDao();
            
            anamnese = anamneseDao.porNumProntuarioEData(prontuario.getNumProntuario(), prontuario.getDataEdicao());
            estiloDeVida = estiloDeVidaDao.porNumProntuarioEData(prontuario.getNumProntuario(), prontuario.getDataEdicao());
            exameFisico = exameFisicoDao.porNumProntuarioEData(prontuario.getNumProntuario(), prontuario.getDataEdicao());
            listaProblemas = listaProblemasDao.porNumProntuarioEData(prontuario.getNumProntuario(), prontuario.getDataEdicao());
            listaRastreamento = RastreamentoUtil.getLogRastreamento(prontuario, estiloDeVida, exameFisico);
        } catch (Exception e) {
            //FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
        }
    }

    public String getReferencias() throws Exception{
        return RastreamentoUtil.getReferencias();
    }
    
    public LogProntuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(LogProntuario prontuario) {
        this.prontuario = prontuario;
    }

    public LogAnamnese getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(LogAnamnese anamnese) {
        this.anamnese = anamnese;
    }

    public LogExameFisico getExameFisico() {
        return exameFisico;
    }

    public void setExameFisico(LogExameFisico exameFisico) {
        this.exameFisico = exameFisico;
    }

    public LogEstiloDeVida getEstiloDeVida() {
        return estiloDeVida;
    }

    public void setEstiloDeVida(LogEstiloDeVida estiloDeVida) {
        this.estiloDeVida = estiloDeVida;
    }

    public List<LogListaProblemas> getListaProblemas() {
        return listaProblemas;
    }

    public void setListaProblemas(List<LogListaProblemas> listaProblemas) {
        this.listaProblemas = listaProblemas;
    }
    
    public List<Rastreamento> getListaRastreamento() {
        return listaRastreamento;
    }

    public void setListaRastreamento(List<Rastreamento> listaRastreamento) {
        this.listaRastreamento = listaRastreamento;
    }
    
}
