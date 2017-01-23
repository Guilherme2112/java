package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.fiap.beans.Advogado;
import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.Forum;
import br.com.fiap.beans.Processo;
import br.com.fiap.beans.TipoCausa;

//tudo errado
public class ProcDAO {
	public static void c(Processo c,Connection conexao)throws Exception{
		String sql = "INSERT INTO T_AM_HBG_PROCESSO(CD_ADVOGADO ,"
				+ " CD_CAUSA , CD_CLIENTE , CD_FORUM , DS_OBSERVACAO ,"
				+ " DS_PROCESSO , DT_ABERTURA , DT_DIA_VENCIMENTO , DT_FECHAMENTO ,"
				+ " NR_PROCESSO , NR_RESULTADO , NR_SITUACAO)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,SQ_AM_PROCESSO.NEXTVAL,?,?);";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1,c.getAdvogado().getCdPessoa());
		stmt.setInt(2, c.getCausa().getCdTipo());
		stmt.setInt(3, c.getCliente().getCdPessoa());
		stmt.setInt(4, c.getForum().getCdPessoa());
		stmt.setString(5, c.getObservacao());
		stmt.setString(6, c.getDescricao());
		stmt.setString(7, c.getDtAbertura());
		stmt.setInt(8, c.getDiaVencimento());
		stmt.setString(9, c.getDtFechamento());
		stmt.setByte(10, c.getResultado());
		stmt.setByte(11, c.getSituacao());
		
		stmt.execute();
		stmt.close();
	}
	public static Processo  r(int r,Connection conexao)throws Exception{
		Processo p = new Processo();
		String sql = "SELECT * FROM T_AM_HBG_PROCESSO WHERE NR_PROCESSO = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, r);
		//como eu não vou exibir a porra toda,o meu obj processo só vai puxar alguns atributos
		ResultSet res = stmt.executeQuery();
		if(res.next()){
			p.setDescricao(res.getString("DS_PROCESSO"));
			p.setResultado(res.getByte(10));
			p.setSituacao(res.getByte("NR_SITUACAO"));
			//VERIFICAR SE O BODAO PERMITE O OBJ PROCESSO COMPLETO...SENAO...
		}
		return p;
	}
	public static void u(String u){
		//na sala
	}
	public static void d(int d,Connection conexao)throws Exception{
		PreparedStatement stmt = conexao.prepareStatement("DELETE * FROM T_AM_HBG_PROCESSO WHERE NR_PROCESSO =?;");
		stmt.execute();
		stmt.close();
	}
	public static ArrayList<Processo> l(Connection conexao) throws Exception{
		ArrayList<Processo> procs = new ArrayList<Processo>();
		String sql = "SELECT CD_ADVOGADO,INITCAP((SELECT NM_PESSOA FROM T_AM_HBG_PESSOA WHERE T_AM_HBG_PESSOA.CD_PESSOA = T_AM_HBG_PROCESSO.CD_ADVOGADO)) AS NOMEADV,"
				+ " CD_CAUSA,INITCAP((SELECT DS_CAUSA FROM T_AM_HBG_TIPO_CAUSA WHERE T_AM_HBG_TIPO_CAUSA.CD_CAUSA = T_AM_HBG_PROCESSO.CD_CAUSA)) AS CAUSA,"
				+ "CD_CLIENTE ,INITCAP((SELECT NM_PESSOA FROM T_AM_HBG_PESSOA WHERE T_AM_HBG_PESSOA.CD_PESSOA = T_AM_HBG_PROCESSO.CD_CLIENTE)) AS NOMECLIENTE,"
				+ "CD_FORUM,INITCAP((SELECT NM_PESSOA FROM T_AM_HBG_PESSOA WHERE T_AM_HBG_PESSOA.CD_PESSOA = T_AM_HBG_PROCESSO.CD_FORUM)) AS NOMEFORUM,"
				+ "INITCAP(DS_OBSERVACAO)as DS_OBSERVACAO,"
				+ "INITCAP(DS_PROCESSO) as DS_PROCESSO,"
				+ "TO_CHAR(DT_ABERTURA, 'DD/MM/YYYY') AS DT_ABERTURA, DT_DIA_VENCIMENTO,TO_CHAR(DT_FECHAMENTO,'DD/MM/YYYY') AS DT_FECHAMENTO,NR_PROCESSO,NR_RESULTADO,NR_SITUACAO"
				+ " FROM T_AM_HBG_PROCESSO";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		Processo p;
		Cliente cliente;
		Forum forum;
		Advogado advogado;
		TipoCausa causa;
		ResultSet result = stmt.executeQuery();
		while(result.next()){
			advogado = new Advogado(result.getString("NOMEADV"),result.getInt("CD_ADVOGADO"));
			cliente = new Cliente(result.getString("NOMECLIENTE"),result.getInt("CD_CLIENTE"));
			forum = new Forum(result.getString("NOMEFORUM"), result.getInt("CD_FORUM"));
			causa = new TipoCausa(result.getInt("CD_CAUSA"), result.getString("CAUSA"));
			p = new Processo();
			p.setAdvogado(advogado);
			p.setCausa(causa);
			p.setCliente(cliente);
			p.setDescricao(result.getString("DS_PROCESSO"));
			//p.setDespesas(despesas);
			p.setDiaVencimento(result.getShort("DT_DIA_VENCIMENTO"));
			p.setDtAbertura(result.getString("DT_ABERTURA"));
			p.setDtFechamento(result.getString("DT_FECHAMENTO"));
			p.setForum(forum);
			//p.setHonorarios(honorarios);
			p.setNumProc(result.getInt("NR_PROCESSO"));
			p.setObservacao(result.getString("DS_OBSERVACAO"));
			p.setResultado(result.getByte("NR_RESULTADO"));
			p.setSituacao(result.getByte("NR_SITUACAO"));
			procs.add(p);
			
		}
		result.close();
		stmt.close();
		return procs;
	
	}
	
	
}