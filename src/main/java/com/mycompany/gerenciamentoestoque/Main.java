package com.mycompany.gerenciamentoestoque;

import helpers.ConexaoBanco;
import helpers.Util;
import javax.swing.JOptionPane;
import views.Login;

/**
 *
 * @author Dav6C
 */
public class Main {
    public static void main (String[] args) {
        ConexaoBanco conexaoBanco = new ConexaoBanco();
        boolean result = conexaoBanco.conectar();
        
        String mensagem = conexaoBanco.getMensagem();
        System.out.println(mensagem);
        
        // se a conexão com o banco de dados der certo
        if (result == true) {
            Login telaLogin = new Login();
            telaLogin.setVisible(true);
            telaLogin.setLocationRelativeTo(null);
        }
        else {
            Util.show("Erro ao acessar o servidor");
        }
    }
}
