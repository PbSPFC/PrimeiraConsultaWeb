/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.view;

import br.uninove.primeiraconsulta.dao.ProntuarioDao;
import br.uninove.primeiraconsulta.dao.UsuarioDao;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.util.Repositorios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author PB
 */
@ManagedBean
@ViewScoped
public class SessaoUsuarioView implements Serializable {

    private Repositorios repositorios = new Repositorios();
    private Usuario usuario = new Usuario();

    @PostConstruct
    public void inicializar() {

        try {
            UsuarioDao usuarioDao = this.repositorios.getUsuarioHibernate();
            this.usuario = usuarioDao.porRA(FacesContext.getCurrentInstance().getExternalContext()
                    .getUserPrincipal().getName());

        } catch (Exception e) {

        }

    }

    public String getNumeroDeProntuarios() {
        try {
            ProntuarioDao prontuarioDao = this.repositorios.getProntuarioHibernate();
            return prontuarioDao.quantidadeProntuarios(this.usuario.getId());
        } catch (Exception e) {
            return null;
        }
        
    }

    public boolean isLogado() {
        try {
            String user = FacesContext.getCurrentInstance().getExternalContext()
                    .getUserPrincipal().getName();
            return user != null && !user.isEmpty();
        } catch (Exception e) {
            return false;
        }

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
