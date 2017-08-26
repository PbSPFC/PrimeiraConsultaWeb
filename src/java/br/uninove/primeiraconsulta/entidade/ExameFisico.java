/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.entidade;

import br.uninove.primeiraconsulta.entidade.log.LogExameFisico;
import java.io.Serializable;
import java.util.Objects;
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
@Table(name="EXAME_FISICO")
public class ExameFisico implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    @Column(name="NUM_PRONTUARIO")
    private String numProntuario;

    //Exame Fisico
    @Column(name="SISTOLE")
    private Integer sistole;
    @Column(name="DIASTOLE")
    private Integer diastole;
    @Column(name="IMC")
    private Float imc;
    @Column(name="CERVICAL")
    private Integer cervical;
    @Column(name="CINTURA")
    private Integer cintura;
    @Column(name="QUADRIL")
    private Float quadril;
    @Column(name="SNELLEN_DIREITA")
    private Integer snellenDireita;
    @Column(name="SNELLEN_ESQUERDA")
    private Integer snellenEsquerda;

    @Column(name="PA_RESULTADO")
    private String paResultado;
    @Column(name="IMC_RESULTADO")
    private String imcResultado;
    @Column(name="CERVICAL_RESULTADO")
    private String cervicalResultado;
    @Column(name="CINTURA_RESULTADO")
    private String cinturaResultado;
    @Column(name="QUADRIL_RESULTADO")
    private String quadrilResultado;
    @Column(name="SNELLEN_RESULTADO")
    private String snellenResultado;

    @Column(name="COMENTARIO")
    private String comentario;
    @Transient
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

    public Integer getSistole() {
        return sistole;
    }

    public void setSistole(Integer sistole) {
        this.sistole = sistole;
    }

    public Integer getDiastole() {
        return diastole;
    }

    public void setDiastole(Integer diastole) {
        this.diastole = diastole;
    }

    public Float getImc() {
        return imc;
    }

    public void setImc(Float imc) {
        this.imc = imc;
    }

    public Integer getCervical() {
        return cervical;
    }

    public void setCervical(Integer cervical) {
        this.cervical = cervical;
    }

    public Integer getCintura() {
        return cintura;
    }

    public void setCintura(Integer cintura) {
        this.cintura = cintura;
    }

    public Float getQuadril() {
        return quadril;
    }

    public void setQuadril(Float quadril) {
        this.quadril = quadril;
    }

    public Integer getSnellenDireita() {
        return snellenDireita;
    }

    public void setSnellenDireita(Integer snellenDireita) {
        this.snellenDireita = snellenDireita;
    }

    public Integer getSnellenEsquerda() {
        return snellenEsquerda;
    }

    public void setSnellenEsquerda(Integer snellenEsquerda) {
        this.snellenEsquerda = snellenEsquerda;
    }

    public String getPaResultado() {
        return paResultado;
    }

    public void setPaResultado(String paResultado) {
        this.paResultado = paResultado;
    }

    public String getImcResultado() {
        return imcResultado;
    }

    public void setImcResultado(String imcResultado) {
        this.imcResultado = imcResultado;
    }

    public String getCervicalResultado() {
        return cervicalResultado;
    }

    public void setCervicalResultado(String cervicalResultado) {
        this.cervicalResultado = cervicalResultado;
    }

    public String getCinturaResultado() {
        return cinturaResultado;
    }

    public void setCinturaResultado(String cinturaResultado) {
        this.cinturaResultado = cinturaResultado;
    }

    public String getQuadrilResultado() {
        return quadrilResultado;
    }

    public void setQuadrilResultado(String quadrilResultado) {
        this.quadrilResultado = quadrilResultado;
    }

    public String getSnellenResultado() {
        return snellenResultado;
    }

    public void setSnellenResultado(String snellenResultado) {
        this.snellenResultado = snellenResultado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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
        final ExameFisico other = (ExameFisico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}

