package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.fiap.beans.Despesa;
import br.com.fiap.beans.LancaDespesa;
import br.com.fiap.beans.Processo;

public class LancDespDAO {


	public static void c(LancaDespesa c, Connection conexao) throws Exception {
		String sql = "INSERT INTO T_AM_HBG_LANCA_DESPESA (CD_LANCAMENTO , CD_TIPO_DESPESA ,"
				+ " DS_OBSERVACAO , DT_DESPESA , NR_PROCESSO ,VL_DESPESA)"
				+ " VALUES (SQ_AM_LANCA_DESPESA.NEXTVAL,?,?,TO_DATE(?,'DD/MM/YYYY'),?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, c.getDesp().getCdDespesa());
		stmt.setString(2, c.getObservacao());
		stmt.setString(3, c.getData());
		stmt.setInt(4, c.getProcesso().getNumProc());
		stmt.setDouble(5, c.getVlHora());
		stmt.execute();
		stmt.close();
	}

	public static LancaDespesa r(int cdLancamento, Connection conexao) throws Exception {
		LancaDespesa lcd = new LancaDespesa();
		Despesa desp = new Despesa();
		Processo proc;
		String sql = "SELECT CD_LANCAMENTO, CD_TIPO_DESPESA,"
				+ " INITCAP(DS_OBSERVACAO)AS DS_OBSERVACAO, TO_CHAR(DT_DESPESA,'DD/MM/YYYY') AS DT_DESPESA,NR_PROCESSO ,"
				+ " VL_DESPESA  FROM T_AM_HBG_LANCA_DESPESA WHERE CD_LANCAMENTO =?";	
		
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, cdLancamento);
		ResultSet despRes = stmt.executeQuery();
	
		if(despRes.next()){
			desp.setCdDespesa(despRes.getInt("CD_TIPO_DESPESA"));
			proc= new Processo(despRes.getInt("NR_PROCESSO"));
			lcd.setData(despRes.getString("DT_DESPESA"));
			lcd.setCdLancamento(despRes.getInt("CD_LANCAMENTO"));
			lcd.setObservacao(despRes.getString("DS_OBSERVACAO"));
			lcd.setVlHora(despRes.getDouble("VL_DESPESA"));
			lcd.setDesp(desp);
			lcd.setProcesso(proc);
		despRes.close();
		stmt.close();
		}
		return lcd;
	}

	public static void u(LancaDespesa lcd, Connection conexao) throws Exception {
		String sql = "UPDATE T_AM_HBG_LANCA_DESPESA SET CD_TIPO_DESPESA =?,"
				+ "NR_PROCESSO = ?,DT_DESPESA=TO_DATE(?,'DD/MM/YYYY'),VL_DESPESA=?,DS_OBSERVACAO = ? WHERE CD_LANCAMENTO =?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, lcd.getDesp().getCdDespesa());
		stmt.setInt(2, lcd.getProcesso().getNumProc());
		stmt.setString(3, lcd.getData());
		stmt.setDouble(4, lcd.getVlHora());
		stmt.setString(5, lcd.getObservacao());
		stmt.setInt(6, lcd.getCdLancamento());
		stmt.executeUpdate();
		stmt.close();
		
	}

	public static void d(int cdLancamento, Connection conexao) throws Exception {
		PreparedStatement stmt = conexao
				.prepareStatement("DELETE FROM T_AM_HBG_LANCA_DESPESA WHERE CD_LANCAMENTO = ? ");
		stmt.setInt(1, cdLancamento);
		stmt.execute();
		stmt.close();
	}
	
	public static ArrayList<LancaDespesa> l(Connection conexao,int numProc)throws Exception{
		String sql = "SELECT CD_LANCAMENTO,CD_TIPO_DESPESA,"
				+ "INITCAP((SELECT DS_TIPO_DESPESA FROM T_AM_HBG_TIPO_DESPESA WHERE CD_TIPO_DESPESA ="
				+ " T_AM_HBG_LANCA_DESPESA.CD_TIPO_DESPESA))AS TIPO,"
				+ "INITCAP(DS_OBSERVACAO)AS DS_OBSERVACAO,TO_CHAR(DT_DESPESA,'DD/MM/YYYY')AS DT_DESPESA,"
				+ "NR_PROCESSO,VL_DESPESA FROM T_AM_HBG_LANCA_DESPESA WHERE NR_PROCESSO = ?";

		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1,numProc);
		ResultSet res = stmt.executeQuery();
		LancaDespesa lcd;
		
		Despesa desp;
		ArrayList <LancaDespesa>despesas  = new ArrayList<LancaDespesa>();
		while(res.next()){
			
			lcd = new LancaDespesa();
			lcd.setCdLancamento(res.getInt("CD_LANCAMENTO"));
			lcd.setData(res.getString("DT_DESPESA"));
			lcd.setVlHora(res.getDouble("VL_DESPESA"));
			lcd.setObservacao(res.getString("DS_OBSERVACAO"));
			Processo processo = new Processo(res.getInt("NR_PROCESSO"));
			lcd.setProcesso(processo);
			desp = new Despesa(res.getInt("CD_TIPO_DESPESA"),res.getString("TIPO"));
			lcd.setDesp(desp);
			despesas.add(lcd);
		}
		stmt.close();
		return despesas;		
	}
	

}