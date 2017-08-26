/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao.log;

import br.uninove.primeiraconsulta.dao.*;
import br.uninove.primeiraconsulta.entidade.Anamnese;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.entidade.log.LogAnamnese;
import java.util.List;

/**
 *
 * @author PB
 */
public interface LogAnamneseDao {
    
    public List<LogAnamnese> todasPorNumProntuario(String numProntuario);
    public LogAnamnese porNumProntuarioEData(String numProntuario, String dataEdicao);
    public LogAnamnese porId(Long id);
    public LogAnamnese salvar(LogAnamnese anamnese); 
    public void deletar(LogAnamnese anamnese);
    
}
