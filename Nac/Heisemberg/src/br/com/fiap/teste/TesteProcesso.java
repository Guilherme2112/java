package br.com.fiap.teste;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.beans.Processo;
import br.com.fiap.bo.ProcBO;
import br.com.fiap.conexao.Conexao;

public class TesteProcesso {

	public static void main(String[] args) throws Exception {
	Conexao comn = new Conexao();
	Connection c = null;
	List<Processo> p = null;
	try{
		c = comn.getConnection("OPS$RM76824","270298");
		
		 p = ProcBO.l(c);
		 for (Processo processo : p) {
			 System.out.println(processo.getTudo());
		}
		 
	}catch(Exception e){
		throw new Exception(e);
	}finally {
		try{
			c.close();
		}catch(Exception e){
			throw new Exception(e);
		}
	}
	}

}
