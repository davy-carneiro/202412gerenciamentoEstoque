package controller;

import helpers.ConexaoBanco;
import DAO.UsuarioDAO;

/**
 *
 * @author Dav6C
 */
public class UsuarioController {
    ConexaoBanco conexao;
    
    public UsuarioController (ConexaoBanco conexao) {
        this.conexao = conexao;
    }
    
    public boolean fazerLogin (String usuario, String senha) {
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
        boolean resultado = usuarioDAO.fazerLogin(usuario, senha);
        return resultado;
    }
}
