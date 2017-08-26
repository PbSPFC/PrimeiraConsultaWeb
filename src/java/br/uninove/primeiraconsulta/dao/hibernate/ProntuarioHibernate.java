/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao.hibernate;

import br.uninove.primeiraconsulta.dao.ProntuarioDao;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author PB
 */
public class ProntuarioHibernate implements ProntuarioDao{

    private Session session;
    
    public ProntuarioHibernate(Session session){
        this.session = session;
    }
    
    public List<Prontuario> todas() {
        return session.createCriteria(Prontuario.class)
                .addOrder(Order.asc("numProntuario"))
                .list();
    }

    public List<Prontuario> todasPorUsuario(Long id) {
        return session.createCriteria(Prontuario.class)
                .add(Restrictions.eq("idUsuario", id))
                .addOrder(Order.asc("numProntuario"))
                .list();
    }
    
    public Prontuario porNumProntuario(String numProntuario) {
        return (Prontuario) this.session.createCriteria(Prontuario.class)
                .add(Restrictions.eq("numProntuario", numProntuario))
                .uniqueResult();
    }

    public Prontuario porUsuario(Long idUsuario) {
        return (Prontuario) this.session.createCriteria(Prontuario.class)
                .add(Restrictions.eq("idUsuario", idUsuario))
                .uniqueResult();
    }

    public Prontuario salvar(Prontuario prontuario) {
        return (Prontuario) session.merge(prontuario);
    }

    @Override
    public void deletar(Prontuario prontuario) {
        this.session.delete(prontuario);
    }

    @Override
    public String quantidadeProntuarios(Long id) {
        List<Prontuario> lista = session.createCriteria(Prontuario.class)
                .add(Restrictions.eq("idUsuario", id))
                .addOrder(Order.asc("numProntuario"))
                .list();
        
        return lista.size() + "";
    }
    
}
