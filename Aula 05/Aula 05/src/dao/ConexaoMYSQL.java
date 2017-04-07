package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoMYSQL {

	public static String status = "N�o conectou...";

	public ConexaoMYSQL() {

	}
	// M�todo de Conex�o//

	public static java.sql.Connection getConexaoMySQL() {

		Connection connection = null;

		try {
			// Configurando a nossa conex�o com um banco de dados//
			String serverName = "localhost:3306"; // caminho do servidor do BD
			String mydatabase = "projeto"; // nome do seu banco de dados
                        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			String username = "root"; // nome de um usu�rio de seu BD
			String password = "admin"; // sua senha de acesso
                        
                        
			connection = DriverManager.getConnection(url, username, password);
			if (connection != null) {
				status = ("STATUS--Conectado com sucesso!");
			} else {
				status = ("STATUS--N�o foi possivel realizar conex�o");
			}
			return connection;
		} catch (SQLException e) { // Nao conectar ao banco,cai neste Exception
			JOptionPane.showMessageDialog(null,"Nao foi possivel conectar ao Banco de Dados.");
			return null;
		}
	}// METODO get CONEXAOMYSQL

	public static boolean FecharConexao() {

		try {
			ConexaoMYSQL.getConexaoMySQL().close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}// FecharConexao
}
