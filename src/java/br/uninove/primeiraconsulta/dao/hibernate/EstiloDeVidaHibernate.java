/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao.hibernate;

import br.uninove.primeiraconsulta.dao.EstiloDeVidaDao;
import br.uninove.primeiraconsulta.entidade.EstiloDeVida;
import br.uninove.primeiraconsulta.entidade.Usuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author PB
 */
public class EstiloDeVidaHibernate implements EstiloDeVidaDao{

    private Session session;
    
    public EstiloDeVidaHibernate(Session session){
        this.session = session;
    }
    
    public List<EstiloDeVida> todas() {
        return session.createCriteria(EstiloDeVida.class)
                .addOrder(Order.asc("numProntuario"))
                .list();
    }
    
    public EstiloDeVida porNumProntuario(String numProntuario) {
        return (EstiloDeVida) this.session.createCriteria(EstiloDeVida.class)
                .add(Restrictions.ilike("numProntuario", numProntuario))
                .uniqueResult();
    }

    public EstiloDeVida porId(Long id) {
        return (EstiloDeVida) this.session.createCriteria(EstiloDeVida.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    public EstiloDeVida salvar(EstiloDeVida estiloDeVida) {
        return (EstiloDeVida) session.merge(estiloDeVida);
    }

    @Override
    public void deletar(EstiloDeVida estiloDeVida) {
        this.session.delete(estiloDeVida);
    }
    
}
