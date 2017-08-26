/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao.log;

import br.uninove.primeiraconsulta.dao.*;
import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.entidade.log.LogExameFisico;
import java.util.List;

/**
 *
 * @author PB
 */
public interface LogExameFisicoDao {
    
    public List<LogExameFisico> todasPorNumProntuario(String numProntuario);
    public LogExameFisico porNumProntuarioEData(String numProntuario, String dataEdicao);
    public LogExameFisico porId(Long id);
    public LogExameFisico salvar(LogExameFisico exameFisico); 
    public void deletar(LogExameFisico exameFisico);
    
}
