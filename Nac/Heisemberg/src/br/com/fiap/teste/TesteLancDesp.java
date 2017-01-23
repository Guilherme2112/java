package br.com.fiap.teste;

import java.sql.Connection;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import br.com.fiap.beans.LancaDespesa;
import br.com.fiap.bo.LancDespBO;
import br.com.fiap.conexao.Conexao;

public class TesteLancDesp {

	public static void main(String[] args) throws Exception{
		Connection conexao = null;
		int nrProc = 0;
		try{
			conexao = Conexao.controlarInstancia().getConnection("OPS$RM76824", "270298");

		/*	
			Despesa desp = new Despesa(6,"Waste");
			String usuario = JOptionPane.showInputDialog("Digite o usuario");
			String senha = JOptionPane.showInputDialog("Digite a senha");
			conexao = Conexao.controlarInstancia().getConnection(usuario, senha);
			nrProc = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero do processo: "));
			LancaDespesa lcd = new LancaDespesa("27/02/2013", 1.2,"TesteBackEnd",0,desp);
			LancDespBO.c(lcd, nrProc, conexao);
			
			
			//retrieve
			 lcd = LancDespBO.r(JOptionPane.showInputDialog("Pesquise uma despesa"),conexao);
			System.out.println(lcd.getData());
			System.out.println(lcd.getObservacao());
			System.out.println(lcd.getVlHora());
			//delete
			
			LancDespBO.d(JOptionPane.showInputDialog("Digite o codigo de lancamento que deseja deletar"), conexao);
			//update
			int n = Integer.parseInt(JOptionPane.showInputDialog("Informe o novo numero do processo a ser alterada"));
			LancaDespesa lcdNew = new LancaDespesa(JOptionPane.showInputDialog("Informe a nova data"),
									Double.parseDouble(JOptionPane.showInputDialog("Informe o novo valor de despesa"))
									,JOptionPane.showInputDialog("Digite a nova obs."),0,desp);
			LancDespBO.u(lcdNew,n, conexao);
			*/
			List<LancaDespesa> lcd = LancDespBO.l(conexao,2);
			for (LancaDespesa lancaDespesa : lcd) {
				System.out.println(lancaDespesa.getDesp().getTipoDespesa());
				System.out.println(lancaDespesa.getProcesso().getNumProc());
			}
		}catch(Exception e){
			throw new Exception(e);
		}

	}

}
