/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao.hibernate;

import br.uninove.primeiraconsulta.dao.ExameFisicoDao;
import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.Usuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author PB
 */
public class ExameFisicoHibernate implements ExameFisicoDao{

    private Session session;
    
    public ExameFisicoHibernate(Session session){
        this.session = session;
    }
    
    public List<ExameFisico> todas() {
        return session.createCriteria(ExameFisico.class)
                .addOrder(Order.asc("numProntuario"))
                .list();
    }
    
    public ExameFisico porNumProntuario(String numProntuario) {
        return (ExameFisico) this.session.createCriteria(ExameFisico.class)
                .add(Restrictions.ilike("numProntuario", numProntuario))
                .uniqueResult();
    }

    public ExameFisico porId(Long id) {
        return (ExameFisico) this.session.createCriteria(ExameFisico.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    public ExameFisico salvar(ExameFisico exameFisico) {
        return (ExameFisico) session.merge(exameFisico);
    }

    @Override
    public void deletar(ExameFisico exameFisico) {
        this.session.delete(exameFisico);
    }
    
}
