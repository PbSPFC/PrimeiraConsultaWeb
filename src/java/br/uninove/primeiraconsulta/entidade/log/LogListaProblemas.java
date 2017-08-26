/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.entidade.log;

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
@Table(name = "LOG_LISTA_PROBLEMAS")
public class LogListaProblemas implements Serializable {

    public LogListaProblemas() {}

    public LogListaProblemas(ListaProblemas listaProblemas) {
        this.id = listaProblemas.getId();
        this.numProntuario = listaProblemas.getNumProntuario();
        this.descricao = listaProblemas.getDescricao();
        this.acao = listaProblemas.getAcao();
        this.dataEdicao = listaProblemas.getDataEdicao();
    }

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "NUM_PRONTUARIO")
    private String numProntuario;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "ACAO")
    private String acao;
    @Column(name = "DATA_EDICAO")
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(String dataEdicao) {
        this.dataEdicao = dataEdicao;
    }
}
