/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao.hibernate;

import br.uninove.primeiraconsulta.dao.ListaProblemasDao;
import br.uninove.primeiraconsulta.entidade.ListaProblemas;
import br.uninove.primeiraconsulta.entidade.Usuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author PB
 */
public class ListaProblemasHibernate implements ListaProblemasDao{

    private Session session;
    
    public ListaProblemasHibernate(Session session){
        this.session = session;
    }
    
    public List<ListaProblemas> todas() {
        return session.createCriteria(ListaProblemas.class)
                .addOrder(Order.asc("numProntuario"))
                .list();
    }
    
    public List<ListaProblemas> porNumProntuario(String numProntuario) {
        return (List<ListaProblemas>) this.session.createCriteria(ListaProblemas.class)
                .add(Restrictions.ilike("numProntuario", numProntuario))
                .list();
    }

    public ListaProblemas porId(Long id) {
        return (ListaProblemas) this.session.createCriteria(ListaProblemas.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    public ListaProblemas salvar(ListaProblemas listaProblemas) {
        return (ListaProblemas) session.merge(listaProblemas);
    }

    @Override
    public void deletar(ListaProblemas listaProblemas) {
        this.session.delete(listaProblemas);
    }
    
}
