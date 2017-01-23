package br.com.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public final class Conexao {
	
	private static Conexao connection = null;
	
	public static Conexao controlarInstancia() {
		if(connection == null) {
			connection = new Conexao();
		}
		return connection;
	}
	
	public Connection getConnection(String usuario, String senha) throws Exception {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL");
		
	}
}