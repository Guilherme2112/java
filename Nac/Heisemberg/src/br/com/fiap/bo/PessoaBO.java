package br.com.fiap.bo;

import br.com.fiap.Excecao.Excecoes;
import br.com.fiap.beans.Pessoa;
import br.com.fiap.dao.PessoaDAO;

public abstract class PessoaBO {
	static void c(Pessoa pessoa) throws Exception {
		try{
		PessoaDAO.c(pessoa);
		}
		catch(Exception e){
			throw new Excecoes(e);
		}
	}

	static void r(String search) {
		PessoaDAO.r(search);
	}
	static void u(String n){
		PessoaDAO.u(n);
	}
	static void d(String n){
		PessoaDAO.d(n);
	}

}
