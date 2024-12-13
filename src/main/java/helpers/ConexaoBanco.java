package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dav6C
 */
public class ConexaoBanco {
    private String usuario;
    private String senha;
    private String url;
    private String driver;
    private String  bancoDeDados;
    private Connection conexao;
    private String mensagem;
    
    public ConexaoBanco () {
        usuario = "root";
        senha = "";
        bancoDeDados = "estoque_farmacia512";
        url = "jdbc:mysql://127.0.0.1/"+bancoDeDados;
        driver = "com.mysql.cj.jdbc.Driver";
    }
    
     public boolean conectar () {
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,usuario,senha);
            mensagem = "Conexão realizada com sucesso.";
            
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            mensagem = "Erro: Não foi possível realizar a conexão.\n";
            mensagem += ex.getMessage();
            
            return false;
        }
    }
     
     public String getMensagem () {
         return this.mensagem;
     }
     
     public Connection getConnection () {
        return conexao;
    }
}
