package br.com.fiap.bo;

import br.com.fiap.Excecao.Excecoes;
import br.com.fiap.beans.Cliente;
import br.com.fiap.dao.CliDAO;

public abstract class CliBO {
	static void c(Cliente cli) throws Exception {
		if(cli.getNome().length() <2){
			throw new Excecoes("Nome muito curto!");
		}
		CliDAO.c(cli);
		
	}

	static void r(String search) {
		CliDAO.r(search);
	}
	static void u(String n){
		CliDAO.u(n);
	}
	static void d(String n){
		CliDAO.d(n);
	}

}
