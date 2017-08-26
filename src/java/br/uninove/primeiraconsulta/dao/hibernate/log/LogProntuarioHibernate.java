/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao.hibernate.log;

import br.uninove.primeiraconsulta.dao.log.LogProntuarioDao;
import br.uninove.primeiraconsulta.entidade.log.LogProntuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author PB
 */
public class LogProntuarioHibernate implements LogProntuarioDao {

    private Session session;

    public LogProntuarioHibernate(Session session) {
        this.session = session;
    }

    @Override
    public List<LogProntuario> todasPorNumProntuario(String numProntuario) {
        return session.createCriteria(LogProntuario.class)
                .add(Restrictions.eq("numProntuario", numProntuario))
                .addOrder(Order.asc("id"))
                .list();
    }

    @Override
    public List<LogProntuario> todasPorUsuario(Long id) {
        return session.createCriteria(LogProntuario.class)
                .add(Restrictions.eq("idUsuario", id))
                .addOrder(Order.asc("numProntuario"))
                .list();
    }

    @Override
    public LogProntuario porNumProntuarioEData(String numProntuario, String dataEdicao) {
        return (LogProntuario) this.session.createCriteria(LogProntuario.class)
                .add(Restrictions.eq("numProntuario", numProntuario))
                .add(Restrictions.eq("dataEdicao", dataEdicao))
                .uniqueResult();
    }

    @Override
    public LogProntuario porUsuario(Long id) {
        return (LogProntuario) this.session.createCriteria(LogProntuario.class)
                .add(Restrictions.eq("idUsuario", id))
                .uniqueResult();
    }

    @Override
    public LogProntuario salvar(LogProntuario prontuario) {
        return (LogProntuario) session.merge(prontuario);
    }

    @Override
    public void deletar(LogProntuario prontuario) {
        this.session.delete(prontuario);

    }

}
