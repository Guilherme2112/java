package br.com.fiap.bo;

import br.com.fiap.Excecao.Excecoes;
import br.com.fiap.beans.Advogado;
import br.com.fiap.dao.AdvDAO;

public abstract class AdvBO {
	static void c(Advogado adv) throws Exception {
		if (adv.getNome().length() < 2) {
			throw new Excecoes("Nome muito Curto!");
		}
		if(adv.getCausas() == null){
			new Excecoes("O advogado precisa de especialidades!");
		}
		AdvDAO.c(adv);
	}

	static void r(String search) {
		AdvDAO.r(search);
	}
	static void u(String n){
		AdvDAO.u(n);
	}
	static void d(String n){
		AdvDAO.d(n);
	}

}
