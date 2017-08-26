/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao.hibernate;

import br.uninove.primeiraconsulta.dao.AnamneseDao;
import br.uninove.primeiraconsulta.entidade.Anamnese;
import br.uninove.primeiraconsulta.entidade.Usuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author PB
 */
public class AnamneseHibernate implements AnamneseDao{

    private Session session;
    
    public AnamneseHibernate(Session session){
        this.session = session;
    }
    
    public List<Anamnese> todas() {
        return session.createCriteria(Anamnese.class)
                .addOrder(Order.asc("numProntuario"))
                .list();
    }
    
    public Anamnese porNumProntuario(String numProntuario) {
        return (Anamnese) this.session.createCriteria(Anamnese.class)
                .add(Restrictions.ilike("numProntuario", numProntuario))
                .uniqueResult();
    }

    public Anamnese porId(Long id) {
        return (Anamnese) this.session.createCriteria(Anamnese.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    public Anamnese salvar(Anamnese anamnese) {
        return (Anamnese) session.merge(anamnese);
    }

    @Override
    public void deletar(Anamnese anamnese) {
        this.session.delete(anamnese);
    }
    
}
