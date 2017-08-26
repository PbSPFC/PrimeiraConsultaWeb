/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao;

import br.uninove.primeiraconsulta.entidade.ListaProblemas;
import java.util.List;

/**
 *
 * @author PB
 */
public interface ListaProblemasDao {
    
    public List<ListaProblemas> todas();
    public List<ListaProblemas> porNumProntuario(String numProntuario);
    public ListaProblemas porId(Long id);
    public ListaProblemas salvar(ListaProblemas listaProblemas); 
    public void deletar(ListaProblemas listaProblemas);
    
}
