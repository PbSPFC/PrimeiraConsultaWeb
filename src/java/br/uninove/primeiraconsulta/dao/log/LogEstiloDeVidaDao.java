/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao.log;

import br.uninove.primeiraconsulta.dao.*;
import br.uninove.primeiraconsulta.entidade.log.LogEstiloDeVida;
import br.uninove.primeiraconsulta.entidade.Usuario;
import java.util.List;

/**
 *
 * @author PB
 */
public interface LogEstiloDeVidaDao {
    
    public List<LogEstiloDeVida> todasPorNumProntuario(String numProntuario);
    public LogEstiloDeVida porNumProntuarioEData(String numProntuario, String dataEdicao);
    public LogEstiloDeVida porId(Long id);
    public LogEstiloDeVida salvar(LogEstiloDeVida logEstiloDeVida); 
    public void deletar(LogEstiloDeVida logEstiloDeVida);
    
}
