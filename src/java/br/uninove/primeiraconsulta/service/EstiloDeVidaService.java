/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.service;

import br.uninove.primeiraconsulta.dao.EstiloDeVidaDao;
import br.uninove.primeiraconsulta.entidade.EstiloDeVida;

/**
 *
 * @author PB
 */
public class EstiloDeVidaService {

    private EstiloDeVidaDao estiloDeVidaDao;

    public EstiloDeVidaService(EstiloDeVidaDao estiloDeVidaDao) {
        this.estiloDeVidaDao = estiloDeVidaDao;
    }

    public EstiloDeVida salvar(EstiloDeVida estiloDeVida) throws RegraNegocioException {
        try {
            estiloDeVida = sonoPontos(estiloDeVida);
            estiloDeVida = cigarroPontos(estiloDeVida);
            estiloDeVida = alcoolPontos(estiloDeVida);

            return (EstiloDeVida) this.estiloDeVidaDao.salvar(estiloDeVida);
        } catch (Exception e) {
            throw new RegraNegocioException("Verifique os campos do estilo de vida!");
        }

    }

    private EstiloDeVida sonoPontos(EstiloDeVida estiloDeVida) {
        Integer pontos = 0;

        pontos = estiloDeVida.getSonoOpt1() != null
                ? pontos + estiloDeVida.getSonoOpt1()
                : pontos + 0;

        pontos = estiloDeVida.getSonoOpt2() != null
                ? pontos + estiloDeVida.getSonoOpt2()
                : pontos + 0;

        pontos = estiloDeVida.getSonoOpt3() != null
                ? pontos + estiloDeVida.getSonoOpt3()
                : pontos + 0;

        pontos = estiloDeVida.getSonoOpt4() != null
                ? pontos + estiloDeVida.getSonoOpt4()
                : pontos + 0;

        pontos = estiloDeVida.getSonoOpt5() != null
                ? pontos + estiloDeVida.getSonoOpt5()
                : pontos + 0;

        pontos = estiloDeVida.getSonoOpt6() != null
                ? pontos + estiloDeVida.getSonoOpt6()
                : pontos + 0;

        estiloDeVida.setSonoPontos(pontos);

        if (estiloDeVida.getSonoPontos() >= 10) {
            estiloDeVida.setSono("Sonolência diurna excessiva!");
        } else {
            estiloDeVida.setSono("Sono regular.");
        }

        return estiloDeVida;
    }

    private EstiloDeVida cigarroPontos(EstiloDeVida estiloDeVida) {

        if(estiloDeVida.getCigarroAtivoOpt() == null)
            estiloDeVida.setCigarroAtivoOpt(0);
        
        Integer pontos = 0;

        if (estiloDeVida.getCigarroAtivoOpt() == 1) {
            switch (estiloDeVida.getCigarro1()) {
                case "Dentro de 5 minutos. (3 pontos)":
                    pontos = +3;
                    break;
                case "Entre 6-30 minutos. (2 pontos)":
                    pontos = +2;
                    break;
                case "Entre 31-60 minutos. (1 ponto)":
                    pontos = +1;
                    break;
                case "Após 60 minutos. (0 ponto)":
                    pontos = +0;
                    break;
                default:
                    break;
            }

            if (estiloDeVida.getCigarro2().equals("Sim. (1 pontos)")) {
                pontos = +1;
            } else if (estiloDeVida.getCigarro2().equals("Não. (0 pontos)")) {
                pontos = +0;
            }

            switch (estiloDeVida.getCigarro3()) {
                case "O primeira do dia. (1 pontos)":
                    pontos = +1;
                    break;
                case "Outros. (0 pontos)":
                    pontos = +0;
                    break;
                case "Nenhum. (0 pontos)":
                    pontos = +0;
                    break;
                default:
                    break;
            }

            switch (estiloDeVida.getCigarro4()) {
                case "Menos de 10. (0 pontos)":
                    pontos = +0;
                    break;
                case "De 11 a 20. (1 pontos)":
                    pontos = +1;
                    break;
                case "De 21 a 30. (2 ponto)":
                    pontos = +2;
                    break;
                case "Mais de 31. (3 ponto)":
                    pontos = +3;
                    break;
                default:
                    break;
            }

            if (estiloDeVida.getCigarro5().equals("Sim. (1 pontos)")) {
                pontos = +1;
            } else if (estiloDeVida.getCigarro5().equals("Não. (0 pontos)")) {
                pontos = +0;
            }

            if (estiloDeVida.getCigarro6().equals("Sim. (1 pontos)")) {
                pontos = +1;
            } else if (estiloDeVida.getCigarro6().equals("Não. (0 pontos)")) {
                pontos = +0;
            }

            estiloDeVida.setCigarroPontos(pontos);
            if (estiloDeVida.getCigarroPontos() >= 0 && estiloDeVida.getCigarroPontos() <= 2) {
                estiloDeVida.setCigarro("Grau de dependência do tabagismo: Muito baixo.");
            } else if (estiloDeVida.getCigarroPontos() >= 3 && estiloDeVida.getCigarroPontos() <= 4) {
                estiloDeVida.setCigarro("Grau de dependência do tabagismo: Baixo.");
            } else if (estiloDeVida.getCigarroPontos() == 5) {
                estiloDeVida.setCigarro("Grau de dependência do tabagismo: Médio.");
            } else if (estiloDeVida.getCigarroPontos() >= 6 && estiloDeVida.getCigarroPontos() <= 7) {
                estiloDeVida.setCigarro("Grau de dependência do tabagismo: Elevado.");
            } else {
                estiloDeVida.setCigarro("Grau de dependência do tabagismo: Muito elevado.");
            }

        } else {
            estiloDeVida.setCigarroAtivoOpt(0);
            estiloDeVida.setCigarroOpt1(null);
            estiloDeVida.setCigarro1("Paciente não é usuário ativo.");
            estiloDeVida.setCigarroOpt2(null);
            estiloDeVida.setCigarro2("Paciente não é usuário ativo.");
            estiloDeVida.setCigarroOpt3(null);
            estiloDeVida.setCigarro3("Paciente não é usuário ativo.");
            estiloDeVida.setCigarroOpt4(null);
            estiloDeVida.setCigarro4("Paciente não é usuário ativo.");
            estiloDeVida.setCigarroOpt5(null);
            estiloDeVida.setCigarro5("Paciente não é usuário ativo.");
            estiloDeVida.setCigarroOpt6(null);
            estiloDeVida.setCigarro6("Paciente não é usuário ativo.");
            estiloDeVida.setCigarroPontos(pontos);
            estiloDeVida.setCigarro("Paciente não é usuário ativo.");
        }

        return estiloDeVida;
    }

    private EstiloDeVida alcoolPontos(EstiloDeVida estiloDeVida) {

        if(estiloDeVida.getAlcoolAtivoOpt() == null)
            estiloDeVida.setAlcoolAtivoOpt(0);
        
        Integer pontos = 0;

        if (estiloDeVida.getAlcoolAtivoOpt() == 1) {

            pontos = estiloDeVida.getAlcool1().equals("Sim.")
                    ? pontos + 1
                    : pontos + 0;

            pontos = estiloDeVida.getAlcool2().equals("Sim.")
                    ? pontos + 1
                    : pontos + 0;

            pontos = estiloDeVida.getAlcool3().equals("Sim.")
                    ? pontos + 1
                    : pontos + 0;

            pontos = estiloDeVida.getAlcool4().equals("Sim.")
                    ? pontos + 1
                    : pontos + 0;

            if (pontos >= 2) {
                estiloDeVida.setAlcool("Grau de dependência do álcool: Clinicamente significante (" + pontos + " 'Sim').");
            } else {
                estiloDeVida.setAlcool("Grau de dependência do álcool: Muito baixo.");
            }

        } else {
            estiloDeVida.setAlcoolAtivoOpt(0);
            estiloDeVida.setAlcoolOpt1(null);
            estiloDeVida.setAlcool1("Paciente não consome álcool.");
            estiloDeVida.setAlcoolOpt2(null);
            estiloDeVida.setAlcool2("Paciente não consome álcool.");
            estiloDeVida.setAlcoolOpt3(null);
            estiloDeVida.setAlcool3("Paciente não consome álcool.");
            estiloDeVida.setAlcoolOpt4(null);
            estiloDeVida.setAlcool4("Paciente não consome álcool.");
            estiloDeVida.setAlcool("Paciente não consome álcool.");
        }

        return estiloDeVida;
    }

}
