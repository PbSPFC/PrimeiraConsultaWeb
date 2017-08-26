/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao;

import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.entidade.Usuario;
import java.util.List;

/**
 *
 * @author PB
 */
public interface ProntuarioDao {
    
    public List<Prontuario> todas();
    public List<Prontuario> todasPorUsuario(Long id);
    public Prontuario porNumProntuario(String ra);
    public Prontuario porUsuario(Long id);
    public Prontuario salvar(Prontuario prontuario);
    public void deletar (Prontuario prontuario);
    
    public String quantidadeProntuarios(Long id);
    
}
