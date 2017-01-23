package br.com.fiap.bo;

import br.com.fiap.Excecao.Excecoes;
import br.com.fiap.beans.TipoCausa;
import br.com.fiap.dao.AdvDAO;
import br.com.fiap.dao.TipoCausaDAO;

public abstract class TipoCausaBO {
	static void c(TipoCausa tpc) throws Exception {
		try{
		TipoCausaDAO.c(tpc);
		}catch(Exception e){
			throw new Excecoes(e);
		}
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
