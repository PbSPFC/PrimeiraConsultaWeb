/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao.log;

import br.uninove.primeiraconsulta.dao.*;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.entidade.log.LogProntuario;
import java.util.List;

/**
 *
 * @author PB
 */
public interface LogProntuarioDao {
    
    public List<LogProntuario> todasPorNumProntuario(String numProntuario);
    public List<LogProntuario> todasPorUsuario(Long id);
    public LogProntuario porNumProntuarioEData(String numProntuario, String dataEdicao);
    public LogProntuario porUsuario(Long id);
    public LogProntuario salvar(LogProntuario prontuario);
    public void deletar (LogProntuario prontuario);
    
}
