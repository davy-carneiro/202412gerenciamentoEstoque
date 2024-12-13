/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import helpers.ConexaoBanco;
import helpers.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dav6C
 */
public class UsuarioDAO {
    ConexaoBanco conexao;
    
    public UsuarioDAO (ConexaoBanco conexao) {
        this.conexao = conexao;
    }
    
    public boolean fazerLogin (String usuario, String senha) {         
        boolean retorno = false;
        
        try (Connection conn = conexao.getConnection()) {
            
            String sql = "SELECT usuario FROM usuarios WHERE usuario = ? AND senha =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            
            ResultSet rows = stmt.executeQuery();
            int quantidadeDeResultados = 0;
            
            while(rows.next()) {
                String u = rows.getString("usuario");
                System.out.println(u);
                quantidadeDeResultados++;
            }
            
            if (quantidadeDeResultados >= 1) {
                retorno = true;
            }
        }
        catch (SQLException e) {
            System.out.println("Erro ao fazer login!");
        }
            
        return retorno;
    }
}
