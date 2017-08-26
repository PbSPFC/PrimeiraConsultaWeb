/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.dao.hibernate;

import br.uninove.primeiraconsulta.dao.UsuarioDao;
import br.uninove.primeiraconsulta.entidade.Usuario;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author PB
 */
public class UsuarioHibernate implements UsuarioDao {

    private Session session;

    public UsuarioHibernate(Session session) {
        this.session = session;
    }

    @Override
    public List<Usuario> todas() {
        return session.createCriteria(Usuario.class)
                .addOrder(Order.asc("nome"))
                .list();
    }

    @Override
    public Usuario porRA(String ra) {
        return (Usuario) this.session.createCriteria(Usuario.class)
                .add(Restrictions.ilike("ra", ra))
                .uniqueResult();
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        return (Usuario) session.merge(usuario);
    }

    @Override
    public Usuario porEmail(Usuario usuario) {
        return (Usuario) this.session.createCriteria(Usuario.class)
                .add(Restrictions.eq("email", usuario.getEmail()))
                .uniqueResult();
    }

}
