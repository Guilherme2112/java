package br.com.fiap.teste;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.Excecao.Excecoes;
import br.com.fiap.beans.Honorario;
import br.com.fiap.beans.LancaHonorario;
import br.com.fiap.bo.LancHonBO;
import br.com.fiap.conexao.Conexao;

public class TesteLancHono {

	public static void main(String[] args) throws Exception {
		Connection comns = null;
		try{
			//CREATE
	
			Conexao conexao = new Conexao();
			comns = conexao.getConnection("OPS$RM76824", "270298");
		
			Honorario hono = new Honorario(2, "AUDIÊNCIA");
			LancaHonorario lch = new LancaHonorario(3, "27/02/2013", 1.2, "TesteBKND", hono);
			LancHonBO.c(lch, 1, comns);
			
		
			
			//RETRIEVE
		
			LancaHonorario lchR = LancHonBO.r(Integer.parseInt(JOptionPane.showInputDialog("Digite o cd lanc.")), comns);
			System.out.println(lchR.getCdLancamento());
			System.out.println(lchR.getData());
			System.out.println(lchR.getObservacao());
			System.out.println(lchR.getQtHora());
			System.out.println(lchR.getHonorario().getCdHonorario());
			System.out.println(lchR.getHonorario().getTipoHonorario());
			
			//remove
			LancHonBO.d(JOptionPane.showInputDialog("Digite o cdLancHon que deseja remover"), comns);
		}catch(Exception e){
			throw new Exception(e);
		}finally {
			try {
				comns.close();
			} catch (Exception e) {
				throw new Excecoes(e);
			}
		}
		
	}

}
