/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao.hibernate.log;

import br.uninove.primeiraconsulta.dao.hibernate.*;
import br.uninove.primeiraconsulta.dao.ListaProblemasDao;
import br.uninove.primeiraconsulta.dao.log.LogListaProblemasDao;
import br.uninove.primeiraconsulta.entidade.ListaProblemas;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.entidade.log.LogListaProblemas;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author PB
 */
public class LogListaProblemasHibernate implements LogListaProblemasDao {

    private Session session;

    public LogListaProblemasHibernate(Session session) {
        this.session = session;
    }

    @Override
    public List<LogListaProblemas> todasPorNumProntuario(String numProntuario) {
        return session.createCriteria(LogListaProblemas.class)
                .add(Restrictions.eq("numProntuario", numProntuario))
                .addOrder(Order.asc("numProntuario"))
                .list();
    }

    @Override
    public List<LogListaProblemas> porNumProntuarioEData(String numProntuario, String dataEdicao) {
        return (List<LogListaProblemas>) this.session.createCriteria(LogListaProblemas.class)
                .add(Restrictions.eq("numProntuario", numProntuario))
                .add(Restrictions.eq("dataEdicao", dataEdicao))
                .list();
    }

    @Override
    public LogListaProblemas porId(Long id) {
        return (LogListaProblemas) this.session.createCriteria(LogListaProblemas.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public LogListaProblemas salvar(LogListaProblemas listaProblemas) {
        return (LogListaProblemas) session.merge(listaProblemas);

    }

    @Override
    public void deletar(LogListaProblemas listaProblemas) {
        this.session.delete(listaProblemas);

    }

}
