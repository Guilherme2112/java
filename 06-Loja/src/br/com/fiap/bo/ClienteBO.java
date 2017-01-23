package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Cliente;

public class ClienteBO {
	
	private static List<Cliente> clientes = new ArrayList<Cliente>();
			
	public void cadastrar(Cliente cliente) {
		cliente.setCodigo(clientes.size()+1);
		clientes.add(cliente);
	}
	
	public List<Cliente> listar() {
		return clientes;
	}
	
}
