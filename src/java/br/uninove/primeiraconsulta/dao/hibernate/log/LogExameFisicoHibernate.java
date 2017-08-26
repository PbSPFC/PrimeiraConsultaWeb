/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao.hibernate.log;

import br.uninove.primeiraconsulta.dao.log.LogExameFisicoDao;
import br.uninove.primeiraconsulta.entidade.log.LogExameFisico;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author PB
 */
public class LogExameFisicoHibernate implements LogExameFisicoDao {

    private Session session;

    public LogExameFisicoHibernate(Session session) {
        this.session = session;
    }

    @Override
    public List<LogExameFisico> todasPorNumProntuario(String numProntuario) {
        return session.createCriteria(LogExameFisico.class)
                .add(Restrictions.eq("numProntuario", numProntuario))
                .addOrder(Order.asc("numProntuario"))
                .list();
    }

    @Override
    public LogExameFisico porNumProntuarioEData(String numProntuario, String dataEdicao) {
        return (LogExameFisico) this.session.createCriteria(LogExameFisico.class)
                .add(Restrictions.eq("numProntuario", numProntuario))
                .add(Restrictions.eq("dataEdicao", dataEdicao))
                .uniqueResult();
    }

    @Override
    public LogExameFisico porId(Long id) {
        return (LogExameFisico) this.session.createCriteria(LogExameFisico.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public LogExameFisico salvar(LogExameFisico exameFisico) {
        return (LogExameFisico) session.merge(exameFisico);

    }

    @Override
    public void deletar(LogExameFisico exameFisico) {
        this.session.delete(exameFisico);

    }

}
