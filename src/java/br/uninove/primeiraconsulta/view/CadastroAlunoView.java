/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.view;

import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.service.RegraNegocioException;
import br.uninove.primeiraconsulta.service.UsuarioService;
import br.uninove.primeiraconsulta.util.FacesUtil;
import br.uninove.primeiraconsulta.util.Repositorios;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author PB
 */
@ManagedBean
@ViewScoped
public class CadastroAlunoView implements Serializable{

    private Repositorios repositorios = new Repositorios();
    private Usuario usuario = new Usuario();

    public void salvar() {
        UsuarioService usuarioService = new UsuarioService(this.repositorios.getUsuarioHibernate());
        try {
            usuarioService.salvar(usuario);

            this.usuario = new Usuario();

            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, FacesUtil.getMensagemI18n("entry_saved"));
        } catch (RegraNegocioException e) {
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, FacesUtil.getMensagemI18n(e.getMessage()));
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
