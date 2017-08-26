/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.entidade;

import br.uninove.primeiraconsulta.entidade.log.LogEstiloDeVida;
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
@Table(name="ESTILO_DE_VIDA")
public class EstiloDeVida implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    @Column(name="NUM_PRONTUARIO")
    private String numProntuario;

    //Estilo de vida / Habitos.
    @Column(name="GORDURA_OPT")
    private Integer gorduraOpt;
    @Column(name="GORDURA")
    private String gordura;

    @Column(name="FIBRA_OPT")
    private Integer fibraOpt;
    @Column(name="FIBRA")
    private String fibra;

    @Column(name="CALCIO_OPT")
    private Integer calcioOpt;
    @Column(name="CALCIO")
    private String calcio;

    @Column(name="SODIO_OPT")
    private Integer sodioOpt;
    @Column(name="SODIO")
    private String sodio;

    @Column(name="ACUCAR_OPT")
    private Integer acucarOpt;
    @Column(name="ACUCAR")
    private String acucar;

    @Column(name="REFRI_OPT")
    private Integer refriOpt;
    @Column(name="REFRI")
    private String refri;

    @Column(name="AGUA_OPT")
    private Integer aguaOpt;
    @Column(name="AGUA")
    private String agua;

    @Column(name="ATFISICA_OPT")
    private Integer atFisicaOpt;
    @Column(name="ATFISICA")
    private String atFisica;

    @Column(name="SONO_OPT_1")
    private Integer sonoOpt1;
    @Column(name="SONO_OPT_2")
    private Integer sonoOpt2;
    @Column(name="SONO_OPT_3")
    private Integer sonoOpt3;
    @Column(name="SONO_OPT_4")
    private Integer sonoOpt4;
    @Column(name="SONO_OPT_5")
    private Integer sonoOpt5;
    @Column(name="SONO_OPT_6")
    private Integer sonoOpt6;
    @Column(name="SONO_PONTOS")
    private Integer sonoPontos;
    @Column(name="SONO")
    private String sono;

    @Column(name="CIGARRO_ATIVO_OPT")
    private Integer cigarroAtivoOpt;
    @Column(name="CIGARRO_OPT_1")
    private Integer cigarroOpt1;
    @Column(name="CIGARRO_1")
    private String cigarro1;
    @Column(name="CIGARRO_OPT_2")
    private Integer cigarroOpt2;
    @Column(name="CIGARRO_2")
    private String cigarro2;
    @Column(name="CIGARRO_OPT_3")
    private Integer cigarroOpt3;
    @Column(name="CIGARRO_3")
    private String cigarro3;
    @Column(name="CIGARRO_OPT_4")
    private Integer cigarroOpt4;
    @Column(name="CIGARRO_4")
    private String cigarro4;
    @Column(name="CIGARRO_OPT_5")
    private Integer cigarroOpt5;
    @Column(name="CIGARRO_5")
    private String cigarro5;
    @Column(name="CIGARRO_OPT_6")
    private Integer cigarroOpt6;
    @Column(name="CIGARRO_6")
    private String cigarro6;
    @Column(name="CIGARRO_PONTOS")
    private Integer cigarroPontos;
    @Column(name="CIGARRO")
    private String cigarro;

    @Column(name="ALCOOL_ATIVO_OPT")
    private Integer alcoolAtivoOpt;
    @Column(name="ALCOOL_OPT_1")
    private Integer alcoolOpt1;
    @Column(name="ALCOOL_OPT_2")
    private Integer alcoolOpt2;
    @Column(name="ALCOOL_OPT_3")
    private Integer alcoolOpt3;
    @Column(name="ALCOOL_OPT_4")
    private Integer alcoolOpt4;
    @Column(name="ALCOOL_1")
    private String alcool1;
    @Column(name="ALCOOL_2")
    private String alcool2;
    @Column(name="ALCOOL_3")
    private String alcool3;
    @Column(name="ALCOOL_4")
    private String alcool4;
    @Column(name="ALCOOL")
    private String alcool;
    @Column(name="SEXUALMENTE_ATIVO")
    private String sexualmenteAtivo;
    @Column(name="SEXUALMENTE_ATIVO_OPT")
    private Integer sexualmenteAtivoOpt;

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

    public Integer getGorduraOpt() {
        return gorduraOpt;
    }

    public void setGorduraOpt(Integer gorduraOpt) {
        this.gorduraOpt = gorduraOpt;
    }

    public String getGordura() {
        return gordura;
    }

    public void setGordura(String gordura) {
        this.gordura = gordura;
    }

    public Integer getFibraOpt() {
        return fibraOpt;
    }

    public void setFibraOpt(Integer fibraOpt) {
        this.fibraOpt = fibraOpt;
    }

    public String getFibra() {
        return fibra;
    }

    public void setFibra(String fibra) {
        this.fibra = fibra;
    }

    public Integer getCalcioOpt() {
        return calcioOpt;
    }

    public void setCalcioOpt(Integer calcioOpt) {
        this.calcioOpt = calcioOpt;
    }

    public String getCalcio() {
        return calcio;
    }

    public void setCalcio(String calcio) {
        this.calcio = calcio;
    }

    public Integer getSodioOpt() {
        return sodioOpt;
    }

    public void setSodioOpt(Integer sodioOpt) {
        this.sodioOpt = sodioOpt;
    }

    public String getSodio() {
        return sodio;
    }

    public void setSodio(String sodio) {
        this.sodio = sodio;
    }

    public Integer getAcucarOpt() {
        return acucarOpt;
    }

    public void setAcucarOpt(Integer acucarOpt) {
        this.acucarOpt = acucarOpt;
    }

    public String getAcucar() {
        return acucar;
    }

    public void setAcucar(String acucar) {
        this.acucar = acucar;
    }

    public Integer getRefriOpt() {
        return refriOpt;
    }

    public void setRefriOpt(Integer refriOpt) {
        this.refriOpt = refriOpt;
    }

    public String getRefri() {
        return refri;
    }

    public void setRefri(String refri) {
        this.refri = refri;
    }

    public Integer getAguaOpt() {
        return aguaOpt;
    }

    public void setAguaOpt(Integer aguaOpt) {
        this.aguaOpt = aguaOpt;
    }

    public String getAgua() {
        return agua;
    }

    public void setAgua(String agua) {
        this.agua = agua;
    }

    public Integer getAtFisicaOpt() {
        return atFisicaOpt;
    }

    public void setAtFisicaOpt(Integer atFisicaOpt) {
        this.atFisicaOpt = atFisicaOpt;
    }

    public String getAtFisica() {
        return atFisica;
    }

    public void setAtFisica(String atFisica) {
        this.atFisica = atFisica;
    }

    public Integer getSonoOpt1() {
        return sonoOpt1;
    }

    public void setSonoOpt1(Integer sonoOpt1) {
        this.sonoOpt1 = sonoOpt1;
    }

    public Integer getSonoOpt2() {
        return sonoOpt2;
    }

    public void setSonoOpt2(Integer sonoOpt2) {
        this.sonoOpt2 = sonoOpt2;
    }

    public Integer getSonoOpt3() {
        return sonoOpt3;
    }

    public void setSonoOpt3(Integer sonoOpt3) {
        this.sonoOpt3 = sonoOpt3;
    }

    public Integer getSonoOpt4() {
        return sonoOpt4;
    }

    public void setSonoOpt4(Integer sonoOpt4) {
        this.sonoOpt4 = sonoOpt4;
    }

    public Integer getSonoOpt5() {
        return sonoOpt5;
    }

    public void setSonoOpt5(Integer sonoOpt5) {
        this.sonoOpt5 = sonoOpt5;
    }

    public Integer getSonoOpt6() {
        return sonoOpt6;
    }

    public void setSonoOpt6(Integer sonoOpt6) {
        this.sonoOpt6 = sonoOpt6;
    }

    public Integer getSonoPontos() {
        return sonoPontos;
    }

    public void setSonoPontos(Integer sonoPontos) {
        this.sonoPontos = sonoPontos;
    }

    public String getSono() {
        return sono;
    }

    public void setSono(String sono) {
        this.sono = sono;
    }

    public Integer getCigarroAtivoOpt() {
        return cigarroAtivoOpt;
    }

    public void setCigarroAtivoOpt(Integer cigarroAtivoOpt) {
        this.cigarroAtivoOpt = cigarroAtivoOpt;
    }

    public Integer getCigarroOpt1() {
        return cigarroOpt1;
    }

    public void setCigarroOpt1(Integer cigarroOpt1) {
        this.cigarroOpt1 = cigarroOpt1;
    }

    public String getCigarro1() {
        return cigarro1;
    }

    public void setCigarro1(String cigarro1) {
        this.cigarro1 = cigarro1;
    }

    public Integer getCigarroOpt2() {
        return cigarroOpt2;
    }

    public void setCigarroOpt2(Integer cigarroOpt2) {
        this.cigarroOpt2 = cigarroOpt2;
    }

    public String getCigarro2() {
        return cigarro2;
    }

    public void setCigarro2(String cigarro2) {
        this.cigarro2 = cigarro2;
    }

    public Integer getCigarroOpt3() {
        return cigarroOpt3;
    }

    public void setCigarroOpt3(Integer cigarroOpt3) {
        this.cigarroOpt3 = cigarroOpt3;
    }

    public String getCigarro3() {
        return cigarro3;
    }

    public void setCigarro3(String cigarro3) {
        this.cigarro3 = cigarro3;
    }

    public Integer getCigarroOpt4() {
        return cigarroOpt4;
    }

    public void setCigarroOpt4(Integer cigarroOpt4) {
        this.cigarroOpt4 = cigarroOpt4;
    }

    public String getCigarro4() {
        return cigarro4;
    }

    public void setCigarro4(String cigarro4) {
        this.cigarro4 = cigarro4;
    }

    public Integer getCigarroOpt5() {
        return cigarroOpt5;
    }

    public void setCigarroOpt5(Integer cigarroOpt5) {
        this.cigarroOpt5 = cigarroOpt5;
    }

    public String getCigarro5() {
        return cigarro5;
    }

    public void setCigarro5(String cigarro5) {
        this.cigarro5 = cigarro5;
    }

    public Integer getCigarroOpt6() {
        return cigarroOpt6;
    }

    public void setCigarroOpt6(Integer cigarroOpt6) {
        this.cigarroOpt6 = cigarroOpt6;
    }

    public String getCigarro6() {
        return cigarro6;
    }

    public void setCigarro6(String cigarro6) {
        this.cigarro6 = cigarro6;
    }

    public Integer getCigarroPontos() {
        return cigarroPontos;
    }

    public void setCigarroPontos(Integer cigarroPontos) {
        this.cigarroPontos = cigarroPontos;
    }

    public String getCigarro() {
        return cigarro;
    }

    public void setCigarro(String cigarro) {
        this.cigarro = cigarro;
    }

    public Integer getAlcoolAtivoOpt() {
        return alcoolAtivoOpt;
    }

    public void setAlcoolAtivoOpt(Integer alcoolAtivoOpt) {
        this.alcoolAtivoOpt = alcoolAtivoOpt;
    }

    public Integer getAlcoolOpt1() {
        return alcoolOpt1;
    }

    public void setAlcoolOpt1(Integer alcoolOpt1) {
        this.alcoolOpt1 = alcoolOpt1;
    }

    public Integer getAlcoolOpt2() {
        return alcoolOpt2;
    }

    public void setAlcoolOpt2(Integer alcoolOpt2) {
        this.alcoolOpt2 = alcoolOpt2;
    }

    public Integer getAlcoolOpt3() {
        return alcoolOpt3;
    }

    public void setAlcoolOpt3(Integer alcoolOpt3) {
        this.alcoolOpt3 = alcoolOpt3;
    }

    public Integer getAlcoolOpt4() {
        return alcoolOpt4;
    }

    public void setAlcoolOpt4(Integer alcoolOpt4) {
        this.alcoolOpt4 = alcoolOpt4;
    }

    public String getAlcool1() {
        return alcool1;
    }

    public void setAlcool1(String alcool1) {
        this.alcool1 = alcool1;
    }

    public String getAlcool2() {
        return alcool2;
    }

    public void setAlcool2(String alcool2) {
        this.alcool2 = alcool2;
    }

    public String getAlcool3() {
        return alcool3;
    }

    public void setAlcool3(String alcool3) {
        this.alcool3 = alcool3;
    }

    public String getAlcool4() {
        return alcool4;
    }

    public void setAlcool4(String alcool4) {
        this.alcool4 = alcool4;
    }

    public String getAlcool() {
        return alcool;
    }

    public void setAlcool(String alcool) {
        this.alcool = alcool;
    }

    public String getSexualmenteAtivo() {
        return sexualmenteAtivo;
    }

    public void setSexualmenteAtivo(String sexualmenteAtivo) {
        this.sexualmenteAtivo = sexualmenteAtivo;
    }

    public Integer getSexualmenteAtivoOpt() {
        return sexualmenteAtivoOpt;
    }

    public void setSexualmenteAtivoOpt(Integer sexualmenteAtivoOpt) {
        this.sexualmenteAtivoOpt = sexualmenteAtivoOpt;
    }

    public String getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(String dataEdicao) {
        this.dataEdicao = dataEdicao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final EstiloDeVida other = (EstiloDeVida) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}

