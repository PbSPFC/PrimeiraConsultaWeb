/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.entidade;

import br.uninove.primeiraconsulta.entidade.log.LogProntuario;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author PB
 */
@Entity
@Table(name="PRONTUARIO")
public class Prontuario implements Serializable {

    public Prontuario() {
    }

    @Id
    @GeneratedValue
    private Long id;
    @Column(name="ID_ESTILO_DE_VIDA")
    private Long idEstiloDeVida;
    @Column(name="ID_EXAME_FISICO")
    private Long idExameFisico;
    @Column(name="ID_ANAMNESE")
    private Long idAnamnese;
    @Column(name="NUM_PRONTUARIO")
    private String numProntuario;
    @Column(name="USUARIO_ID")
    private Long idUsuario;
    @Column(name="USUARIO_RA")
    private String raUsuario;
    @Column(name="NOME_MEDICO")
    private String nomeMedico;
    @Column(name="SEXO")
    private String sexo;
    @Column(name="IDADE")
    private Integer idade;
    @Column(name="PESO")
    private Integer peso;
    @Column(name="ALTURA")
    private Float altura;
    @Column(name="COMENTARIO_FINAL")
    private String comentario;
    @Column(name="DATA_")
    private String data;
    @Column(name="DATA_EDICAO")
    private String dataEdicao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEstiloDeVida() {
        return idEstiloDeVida;
    }

    public Long getIdAnamnese() {
        return idAnamnese;
    }

    public void setIdAnamnese(Long idAnamnese) {
        this.idAnamnese = idAnamnese;
    }

    public void setIdEstiloDeVida(Long idEstiloDeVida) {
        this.idEstiloDeVida = idEstiloDeVida;
    }

    public Long getIdExameFisico() {
        return idExameFisico;
    }

    public void setIdExameFisico(Long idExameFisico) {
        this.idExameFisico = idExameFisico;
    }

    public String getNumProntuario() {
        return numProntuario;
    }

    public void setNumProntuario(String numProntuario) {
        this.numProntuario = numProntuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRaUsuario() {
        return raUsuario;
    }

    public void setRaUsuario(String raUsuario) {
        this.raUsuario = raUsuario;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(String dataEdicao) {
        this.dataEdicao = dataEdicao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prontuario other = (Prontuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
