/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao;

import br.uninove.primeiraconsulta.entidade.EstiloDeVida;
import br.uninove.primeiraconsulta.entidade.Usuario;
import java.util.List;

/**
 *
 * @author PB
 */
public interface EstiloDeVidaDao {
    
    public List<EstiloDeVida> todas();
    public EstiloDeVida porNumProntuario(String ra);
    public EstiloDeVida porId(Long id);
    public EstiloDeVida salvar(EstiloDeVida estiloDeVida); 
    public void deletar(EstiloDeVida estiloDeVida);
    
}
