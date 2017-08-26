/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.entidade.log;

import br.uninove.primeiraconsulta.dao.AnamneseDao;
import br.uninove.primeiraconsulta.entidade.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author PB
 */
@Entity
@Table(name="log_anamnese")
public class LogAnamnese implements Serializable{

    public LogAnamnese() {} 

    public LogAnamnese(Anamnese anamnese) {
        this.id = anamnese.getId();
        this.numProntuario = anamnese.getNumProntuario();
        this.queixa = anamnese.getQueixa();
        this.historiaDoenca = anamnese.getHistoriaDoenca();
        this.interrogatorio = anamnese.getInterrogatorio();
        this.percepcao = anamnese.getPercepcao();
        this.dataEdicao = anamnese.getDataEdicao();
    }
    
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="num_prontuario")
    private String numProntuario;
    @Column(name="QUEIXA_DURACAO")
    private String queixa;
    @Column(name="HISTORIA_DOENCA_ATUAL")
    private String historiaDoenca;
    @Column(name="INTERROGATORIO")
    private String interrogatorio;
    @Column(name="PERCEPCAO_PACIENTE")
    private String percepcao;
    @Column(name="DATA_EDICAO")
    private String dataEdicao;

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumProntuario() {
        return numProntuario;
    }

    public void setNumProntuario(String numProntuario) {
        this.numProntuario = numProntuario;
    }

    public String getQueixa() {
        return queixa;
    }

    public void setQueixa(String queixa) {
        this.queixa = queixa;
    }

    public String getHistoriaDoenca() {
        return historiaDoenca;
    }

    public void setHistoriaDoenca(String historiaDoenca) {
        this.historiaDoenca = historiaDoenca;
    }

    public String getInterrogatorio() {
        return interrogatorio;
    }

    public void setInterrogatorio(String interrogatorio) {
        this.interrogatorio = interrogatorio;
    }

    public String getPercepcao() {
        return percepcao;
    }

    public void setPercepcao(String percepcao) {
        this.percepcao = percepcao;
    }

    public String getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(String dataEdicao) {
        this.dataEdicao = dataEdicao;
    }
}

