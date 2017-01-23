package br.com.fiap.bo;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.fiap.Excecao.Excecoes;
import br.com.fiap.beans.LancaHonorario;
import br.com.fiap.dao.LancHonDAO;

public abstract class LancHonBO {
	
	public static void c(LancaHonorario lch, Connection conexao) throws Exception {
		if (lch.getData() == null) {
			throw new Excecoes("O lançamento precisa de uma data!");
		}
		LancHonDAO.c(lch, conexao);
	}

	public static LancaHonorario r(int cdLancamento, Connection conexao) throws Exception {
		return LancHonDAO.r(cdLancamento, conexao);
	}

	 public static void u(LancaHonorario lch,Connection conexao)throws Exception{
	 LancHonDAO.u(lch, conexao);
	 }
	public static void d(int cdLancamento, Connection conexao) throws Exception {
		LancHonDAO.d(cdLancamento, conexao);
	}
	public static ArrayList<LancaHonorario> l (Connection conexao, int numProc) throws Exception{
		return LancHonDAO.l(conexao,numProc);
	}

}
