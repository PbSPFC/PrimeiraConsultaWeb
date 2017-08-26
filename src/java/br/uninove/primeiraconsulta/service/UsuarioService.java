/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.service;

import br.uninove.primeiraconsulta.dao.UsuarioDao;
import br.uninove.primeiraconsulta.entidade.Usuario;
import java.io.Serializable;

/**
 *
 * @author PB
 */
public class UsuarioService{

    private UsuarioDao usuarioDao;

    public UsuarioService(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public void salvar(Usuario usuario) throws RegraNegocioException {
        if (raJaExiste(usuario) || emailJaExiste(usuario)) {
            throw new RegraNegocioException("existing_entry");
        }
        usuario.setStatusId("Aluno");
        this.usuarioDao.salvar(usuario);
    }

    private boolean raJaExiste(Usuario usuario) {
        Usuario usuarioRA = this.usuarioDao.porRA(usuario.getRa());

        return usuarioRA != null && !usuarioRA.equals(usuario);
    }

    private boolean emailJaExiste(Usuario usuario) {
        Usuario usuarioEmail = this.usuarioDao.porEmail(usuario);

        return usuarioEmail != null && !usuarioEmail.equals(usuario);
    }
    
}
