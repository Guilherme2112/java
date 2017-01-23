package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.fiap.beans.Honorario;
import br.com.fiap.beans.LancaHonorario;
import br.com.fiap.beans.Processo;


public class LancHonDAO {
	public static void c(LancaHonorario c,Connection conexao)throws Exception{
		String sql = "INSERT INTO T_AM_HBG_LANCA_HONORARIO(CD_LANCAMENTO ,"
				+ " CD_TIPO_TAREFA , DS_OBSERVACAO , DT_HONORARIO , NR_PROCESSO ,"
				+ " QT_HORA) VALUES(SQ_AM_LANCA_HONORARIO.NEXTVAL,?,?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1,c.getHono().getCdHonorario());
		stmt.setString(2,c.getObservacao());
		stmt.setString(3, c.getData());
		stmt.setInt(4, c.getProcesso().getNumProc());
		stmt.setDouble(5, c.getQtHora());
		stmt.execute();
		stmt.close();
	}

	public static LancaHonorario r(int cdLancamento, Connection conexao) throws Exception {
		LancaHonorario lch = new LancaHonorario();
		Honorario hono = new Honorario();
		Processo proc;
		String sql = "SELECT CD_LANCAMENTO, CD_TIPO_TAREFA,"
				+ " INITCAP(DS_OBSERVACAO)AS DS_OBSERVACAO, TO_CHAR(DT_HONORARIO,'DD/MM/YYYY') AS DT_HONORARIO,NR_PROCESSO ,"
				+ " QT_HORA FROM T_AM_HBG_LANCA_HONORARIO WHERE CD_LANCAMENTO =?";	
		
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, cdLancamento);
		ResultSet honoRes = stmt.executeQuery();
	
		if(honoRes.next()){
			hono.setCdHonorario(honoRes.getInt("CD_TIPO_TAREFA"));
			proc= new Processo(honoRes.getInt("NR_PROCESSO"));
			lch.setData(honoRes.getString("DT_HONORARIO"));
			lch.setCdLancamento(honoRes.getInt("CD_LANCAMENTO"));
			lch.setObservacao(honoRes.getString("DS_OBSERVACAO"));
			lch.setQtHora(honoRes.getDouble("QT_HORA"));
			lch.setHono(hono);
			lch.setProcesso(proc);
		honoRes.close();
		stmt.close();
		}
		return lch;
	}

	public static void u(LancaHonorario lch,Connection conexao) throws Exception{
		String sql = "UPDATE T_AM_HBG_LANCA_HONORARIO SET CD_TIPO_TAREFA =?,"
				+ "NR_PROCESSO = ?,DT_HONORARIO=TO_DATE(?,'DD/MM/YYYY'),QT_HORA=?,DS_OBSERVACAO = ? WHERE CD_LANCAMENTO =?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, lch.getHono().getCdHonorario());
		stmt.setInt(2, lch.getProcesso().getNumProc());
		stmt.setString(3, lch.getData());
		stmt.setDouble(4, lch.getQtHora());
		stmt.setString(5, lch.getObservacao());
		stmt.setInt(6, lch.getCdLancamento());
		stmt.executeUpdate();
		stmt.close();

	}

	public static void d(int cdLancamento,Connection conexao) throws Exception{
		PreparedStatement stmt = conexao
				.prepareStatement("DELETE FROM T_AM_HBG_LANCA_HONORARIO WHERE CD_LANCAMENTO = ? ");
		stmt.setInt(1,cdLancamento);
		stmt.execute();
		stmt.close();
	}
	public static ArrayList<LancaHonorario> l(Connection conexao, int numProc)throws Exception{
		String sql = "SELECT CD_LANCAMENTO,CD_TIPO_TAREFA,"
				+ "INITCAP((SELECT DS_TIPO_TAREFA FROM T_AM_HBG_TIPO_TAREFA WHERE CD_TIPO_TAREFA ="
				+ " T_AM_HBG_LANCA_HONORARIO.CD_TIPO_TAREFA))AS TIPO,"
				+ "INITCAP(DS_OBSERVACAO)AS DS_OBSERVACAO,TO_CHAR(DT_HONORARIO,'DD/MM/YYYY')AS DT_HONORARIO,"
				+ "NR_PROCESSO,QT_HORA FROM T_AM_HBG_LANCA_HONORARIO WHERE NR_PROCESSO = ?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, numProc);
		ResultSet res = stmt.executeQuery();
		LancaHonorario lch;
		Honorario hono; 
		Processo p;
		ArrayList <LancaHonorario>honos  = new ArrayList<LancaHonorario>();
		while(res.next()){
			p=new Processo(res.getInt("NR_PROCESSO"));
			lch=  new LancaHonorario();
			lch.setCdLancamento(res.getInt("CD_LANCAMENTO"));
			lch.setData(res.getString("DT_HONORARIO"));
			lch.setQtHora(res.getDouble("QT_HORA"));
			lch.setObservacao(res.getString("DS_OBSERVACAO"));
			hono = new Honorario(res.getInt("CD_TIPO_TAREFA"),res.getString("TIPO"));
			lch.setHono(hono);
			lch.setProcesso(p);
			honos.add(lch);
		}
		stmt.close();
		return honos;		
	}

}