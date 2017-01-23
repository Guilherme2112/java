package br.com.fiap.bo;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.fiap.Excecao.Excecoes;
import br.com.fiap.beans.Processo;
import br.com.fiap.dao.ProcDAO;

public abstract class ProcBO {
	static void c(Processo proc,Connection conexao) throws Exception {
		if (proc.getAdvogado() == null) {
			throw new Excecoes("Um processo requer um advogado!");
		}
		if (proc.getCliente() == null) {
			throw new Excecoes("Um processo requer um cliente!");
		}
		if (proc.getForum() == null) {
			throw new Excecoes("Um processo requer um fórum!");
		}
		if (proc.getSituacao() != 0 || proc.getSituacao() != 1) {
			throw new Excecoes("Situação vazia ou inválida!");
		}
		if (proc.getResultado() != 0 || proc.getResultado() != 1) {
			throw new Excecoes("Resultado inválido!");
		}
		ProcDAO.c(proc,conexao);
	}

	public static Processo r(int search,Connection conexao) throws Exception {
		return ProcDAO.r(search,conexao);
	}

	static void u(String n) {
		ProcDAO.u(n); //na sala
	}

	static void d(String n) {
	//	ProcDAO.d(n); //na sala
	}
	public static ArrayList<Processo> l(Connection conexao) throws Exception{
		return ProcDAO.l(conexao);
	}

}
