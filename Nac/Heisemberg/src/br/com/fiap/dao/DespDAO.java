package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Despesa;

//tudo errado
public class DespDAO {
	public static List<Despesa> l(Connection conexao)throws Exception{
		String sql = "SELECT CD_TIPO_DESPESA,"
				+ "INITCAP(DS_TIPO_DESPESA) AS TIPO"
				+ " FROM T_AM_HBG_TIPO_DESPESA";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet res = stmt.executeQuery();
		List <Despesa> desps = new ArrayList<Despesa>();
		Despesa d;
		while (res.next()) {
			d= new Despesa(res.getInt("CD_TIPO_DESPESA"),
					res.getString("TIPO"));
			
			desps.add(d);
			
		}
		res.close();
		stmt.close();
		return desps;
		

		
	}

	
	
}