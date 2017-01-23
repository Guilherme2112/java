package br.com.fiap.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.beans.Honorario;
import br.com.fiap.dao.HonDAO;

public abstract class HonBO {
	public static  List<Honorario> l(Connection conexao) throws Exception{
		return HonDAO.l(conexao);
	}

}
