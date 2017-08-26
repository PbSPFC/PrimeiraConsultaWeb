/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao.hibernate.log;

import br.uninove.primeiraconsulta.dao.hibernate.*;
import br.uninove.primeiraconsulta.dao.AnamneseDao;
import br.uninove.primeiraconsulta.dao.log.LogAnamneseDao;
import br.uninove.primeiraconsulta.entidade.Anamnese;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.entidade.log.LogAnamnese;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author PB
 */
public class LogAnamneseHibernate implements LogAnamneseDao{

    private Session session;
    
    public LogAnamneseHibernate(Session session){
        this.session = session;
    }

    public LogAnamnese porId(Long id) {
        return (LogAnamnese) this.session.createCriteria(LogAnamnese.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<LogAnamnese> todasPorNumProntuario(String numProntuario) {
        return session.createCriteria(LogAnamnese.class)
                .add(Restrictions.eq("numProntuario", numProntuario))
                .addOrder(Order.asc("numProntuario"))
                .list();
    }

    @Override
    public LogAnamnese porNumProntuarioEData(String numProntuario, String dataEdicao) {
        return (LogAnamnese) this.session.createCriteria(LogAnamnese.class)
                .add(Restrictions.eq("numProntuario", numProntuario))
                .add(Restrictions.eq("dataEdicao", dataEdicao))
                .uniqueResult();
    }

    @Override
    public LogAnamnese salvar(LogAnamnese anamnese) {
        return (LogAnamnese) session.merge(anamnese);
    }

    @Override
    public void deletar(LogAnamnese anamnese) {
        this.session.delete(anamnese);
    }
    
}
