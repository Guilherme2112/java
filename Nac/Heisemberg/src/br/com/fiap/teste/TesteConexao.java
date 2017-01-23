package br.com.fiap.teste;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.Excecao.Excecoes;
import br.com.fiap.conexao.Conexao;

public class TesteConexao {
	public static void main(String[] args) throws Exception {
		Connection connection = null;
		try {
			String usuario = JOptionPane.showInputDialog("Digite o usuario");
			String senha = JOptionPane.showInputDialog("Digite a senha");
			connection = Conexao.controlarInstancia().getConnection(usuario, senha);
			System.out.println("Conexao aberta!");
		} catch (Exception e) {
			System.out.println("Erro de conexao");
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				throw new Excecoes(e);
			}
		}
	}
}
