package br.com.fiap.bo;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.fiap.Excecao.Excecoes;
import br.com.fiap.beans.LancaDespesa;
import br.com.fiap.dao.LancDespDAO;

public abstract class LancDespBO {
	
	public static void c(LancaDespesa lcd, Connection conexao) throws Exception {
		if (lcd.getData() == null) {
			throw new Excecoes("O lançamento precisa de uma data!");
		}
		LancDespDAO.c(lcd, conexao);
	}

	public static LancaDespesa r(int cdLancamento, Connection conexao) throws Exception {
		return LancDespDAO.r(cdLancamento, conexao);
	}

	 public static void u(LancaDespesa lcd,Connection conexao)throws Exception{
	 LancDespDAO.u(lcd, conexao);
	 }
	public static void d(int cdLancamento, Connection conexao) throws Exception {
		LancDespDAO.d(cdLancamento, conexao);
	}
	public static ArrayList<LancaDespesa> l (Connection conexao,int numProc) throws Exception{
		return LancDespDAO.l(conexao,numProc);
	}

}
