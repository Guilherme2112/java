package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Usuario;

public class UsuarioBO {
	
	private static  List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public void cadastrar(Usuario usuario, String repitaSenha) throws Exception{
		if (!usuario.getSenha().equals(repitaSenha)) {
			throw new Exception("Senha e RepitaSenha n�o s�o iguais");
		}
		usuarios.add(usuario);
	}
	public boolean logar(String email, String senha) {
		for(Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
				return true;	
			}			
		}
		return false;
	}
	public List<Usuario> listar() {
		return usuarios;
	}
}
