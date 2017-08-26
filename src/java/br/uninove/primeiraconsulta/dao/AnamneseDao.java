/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao;

import br.uninove.primeiraconsulta.entidade.Anamnese;
import br.uninove.primeiraconsulta.entidade.Usuario;
import java.util.List;

/**
 *
 * @author PB
 */
public interface AnamneseDao {
    
    public List<Anamnese> todas();
    public Anamnese porNumProntuario(String ra);
    public Anamnese porId(Long id);
    public Anamnese salvar(Anamnese anamnese); 
    public void deletar(Anamnese anamnese);
    
}
