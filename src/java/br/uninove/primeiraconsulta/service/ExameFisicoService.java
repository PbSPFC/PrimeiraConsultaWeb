/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.service;

import br.uninove.primeiraconsulta.dao.ExameFisicoDao;
import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.Prontuario;

/**
 *
 * @author PB
 */
public class ExameFisicoService {

    private ExameFisicoDao exameFisicoDao;

    public ExameFisicoService(ExameFisicoDao exameFisicoDao) {
        this.exameFisicoDao = exameFisicoDao;
    }

    public ExameFisico salvar(ExameFisico exameFisico, Prontuario prontuario) throws RegraNegocioException {
        try {
            
            exameFisico = validar(exameFisico, prontuario);

            return (ExameFisico) this.exameFisicoDao.salvar(exameFisico);
        } catch (Exception e) {
            throw new RegraNegocioException("Verifique os campos do exame físico!");
        }

    }

    private ExameFisico validar(ExameFisico exameFisico, Prontuario prontuario) throws Exception {

        if ((exameFisico.getSistole() != null && exameFisico.getDiastole() != null)) {
            if (exameFisico.getSistole() >= 140 || exameFisico.getDiastole() >= 90) {
                exameFisico.setPaResultado("Pressão arterial acima do normal");
            } else if (exameFisico.getSistole() == 0 && exameFisico.getDiastole() == 0) {
                exameFisico.setPaResultado("N/D");
            } else {
                exameFisico.setPaResultado("Pressão arterial está normal");
            }
        } else {
            exameFisico.setPaResultado("N/D");
        }
        if (prontuario.getPeso() != null && prontuario.getAltura() != null) {
            exameFisico.setImc(getImc(prontuario.getPeso(), prontuario.getAltura()));
            exameFisico.setImcResultado(getImcResultado(exameFisico.getImc()));
        }

        if (exameFisico.getCervical() != null) {
            if (exameFisico.getCervical() == 0) {
                exameFisico.setCervicalResultado("N/D");
            } else if (prontuario.getSexo().equals("Masculino")) {
                if (exameFisico.getCervical() > 37) {
                    exameFisico.setCervicalResultado("Circunferência está elevada!");
                } else {
                    exameFisico.setCervicalResultado("Circunferência está normal.");
                }
            } else if (prontuario.getSexo().equals("Feminino")) {
                if (exameFisico.getCervical() > 34) {
                    exameFisico.setCervicalResultado("Circunferência está elevada!");
                } else {
                    exameFisico.setCervicalResultado("Circunferência está normal.");
                }
            }
        } else {
            exameFisico.setCervicalResultado("N/D");
        }

        if (exameFisico.getCintura() != null) {
            if (exameFisico.getCintura() == 0) {
                exameFisico.setCinturaResultado("N/D");
            } else if (prontuario.getSexo().equals("Masculino")) {
                if (exameFisico.getCintura() > 102) {
                    exameFisico.setCinturaResultado("Circunferência está elevada!");
                } else {
                    exameFisico.setCinturaResultado("Circunferência está normal.");
                }
            } else if (prontuario.getSexo().equals("Feminino")) {
                if (exameFisico.getCintura() > 88) {
                    exameFisico.setCinturaResultado("Circunferência está elevada!");
                } else {
                    exameFisico.setCinturaResultado("Circunferência está normal.");
                }
            }
        } else {
            exameFisico.setCinturaResultado("N/D");
        }

        if (exameFisico.getQuadril() != null) {
            if (exameFisico.getQuadril() == 0 || exameFisico.getQuadril() == 0.0) {
                exameFisico.setQuadrilResultado("N/D");
            } else if (prontuario.getSexo().equals("Masculino")) {
                if (exameFisico.getQuadril() >= 0.9) {
                    exameFisico.setQuadrilResultado("Risco para complicações metabólicas!");
                } else {
                    exameFisico.setQuadrilResultado("Cintura/Quadril está normal.");
                }
            } else if (prontuario.getSexo().equals("Feminino")) {
                if (exameFisico.getQuadril() >= 0.85) {
                    exameFisico.setQuadrilResultado("Risco para complicações metabólicas!");
                } else {
                    exameFisico.setQuadrilResultado("Cintura/Quadril está normal.");
                }
            }
        } else {
            exameFisico.setQuadrilResultado("N/D");
        }

        if (exameFisico.getSnellenDireita() != null && exameFisico.getSnellenEsquerda() != null) {
            if (exameFisico.getSnellenDireita() == 0 || exameFisico.getSnellenEsquerda() == 0) {
                exameFisico.setSnellenResultado("N/D");
            } else if (exameFisico.getSnellenDireita() > 20 || exameFisico.getSnellenEsquerda() > 20) {
                exameFisico.setSnellenResultado("Vista está alterada!");
            } else {
                exameFisico.setSnellenResultado("Vista está normal.");
            }
        } else {
            exameFisico.setSnellenResultado("N/D");
        }

        return exameFisico;
    }

    private Float getImc(Integer peso, Float altura) throws Exception {
        try {
            Float imc = peso / (altura * altura);
            return imc;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private String getImcResultado(Float imc) throws Exception {
        try {
            if (imc < 18.5) {
                return "Magreza.";
            } else if (imc >= 18.5 && imc < 25) {
                return "Peso normal.";
            } else if (imc >= 25 && imc < 30) {
                return "Sobrepeso.";
            } else if (imc >= 30 && imc < 35) {
                return "Obesidade Classe I.";
            } else if (imc >= 35 && imc < 40) {
                return "Obesidade Classe II.";
            } else {
                return "Obesidade Classe III.";
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
