/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao.log;

import br.uninove.primeiraconsulta.dao.*;
import br.uninove.primeiraconsulta.entidade.ListaProblemas;
import br.uninove.primeiraconsulta.entidade.log.LogListaProblemas;
import java.util.List;

/**
 *
 * @author PB
 */
public interface LogListaProblemasDao {
    
    public List<LogListaProblemas> todasPorNumProntuario(String numProntuario);
    public List<LogListaProblemas> porNumProntuarioEData(String numProntuario, String dataEdicao);
    public LogListaProblemas porId(Long id);
    public LogListaProblemas salvar(LogListaProblemas listaProblemas); 
    public void deletar(LogListaProblemas listaProblemas);
    
}
