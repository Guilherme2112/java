package br.com.fiap.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.beans.Despesa;
import br.com.fiap.dao.DespDAO;

public abstract class DespBO {
	
	public static  List<Despesa> l(Connection conexao) throws Exception{
		return DespDAO.l(conexao);
	}

}
