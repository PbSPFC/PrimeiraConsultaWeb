/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao;

import br.uninove.primeiraconsulta.entidade.Usuario;
import java.util.List;

/**
 *
 * @author PB
 */
public interface UsuarioDao {
    
    public List<Usuario> todas();
    public Usuario porRA(String ra);
    public Usuario porEmail(Usuario usuario);
    public Usuario salvar(Usuario usuario); 
    
}
