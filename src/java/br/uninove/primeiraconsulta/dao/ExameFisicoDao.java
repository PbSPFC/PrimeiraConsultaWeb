/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao;

import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.Usuario;
import java.util.List;

/**
 *
 * @author PB
 */
public interface ExameFisicoDao {
    
    public List<ExameFisico> todas();
    public ExameFisico porNumProntuario(String ra);
    public ExameFisico porId(Long id);
    public ExameFisico salvar(ExameFisico exameFisico); 
    public void deletar(ExameFisico exameFisico);
    
}
