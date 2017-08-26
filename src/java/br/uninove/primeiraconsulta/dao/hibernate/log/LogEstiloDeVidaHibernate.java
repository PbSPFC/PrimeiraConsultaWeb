/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao.hibernate.log;

import br.uninove.primeiraconsulta.dao.hibernate.*;
import br.uninove.primeiraconsulta.dao.EstiloDeVidaDao;
import br.uninove.primeiraconsulta.dao.log.LogEstiloDeVidaDao;
import br.uninove.primeiraconsulta.entidade.EstiloDeVida;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.entidade.log.LogEstiloDeVida;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author PB
 */
public class LogEstiloDeVidaHibernate implements LogEstiloDeVidaDao{

    private Session session;
    
    public LogEstiloDeVidaHibernate(Session session){
        this.session = session;
    }

    @Override
    public List<LogEstiloDeVida> todasPorNumProntuario(String numProntuario) {
        return session.createCriteria(LogEstiloDeVida.class)
                .add(Restrictions.eq("numProntuario", numProntuario))
                .addOrder(Order.asc("numProntuario"))
                .list();
    }

    @Override
    public LogEstiloDeVida porNumProntuarioEData(String numProntuario, String dataEdicao) {
        return (LogEstiloDeVida) this.session.createCriteria(LogEstiloDeVida.class)
                .add(Restrictions.eq("numProntuario", numProntuario))
                .add(Restrictions.eq("dataEdicao", dataEdicao))
                .uniqueResult();
    }

    @Override
    public LogEstiloDeVida porId(Long id) {
        return (LogEstiloDeVida) this.session.createCriteria(LogEstiloDeVida.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public LogEstiloDeVida salvar(LogEstiloDeVida logEstiloDeVida) {
        return (LogEstiloDeVida) session.merge(logEstiloDeVida);
    }

    @Override
    public void deletar(LogEstiloDeVida logEstiloDeVida) {
        this.session.delete(logEstiloDeVida);
    }
    

    
}
