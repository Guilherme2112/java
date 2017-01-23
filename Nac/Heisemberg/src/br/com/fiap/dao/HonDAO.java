package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Honorario;

//tudo errado
public class HonDAO {
	public static List<Honorario> l(Connection  conexao)throws Exception{
			String sql = "SELECT CD_TIPO_TAREFA,"
					+ "INITCAP(DS_TIPO_TAREFA) AS TIPO"
					+ " FROM T_AM_HBG_TIPO_TAREFA";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			List <Honorario> honos = new ArrayList<Honorario>();
			Honorario h;
			while (res.next()) {
				h= new Honorario(res.getInt("CD_TIPO_TAREFA"),
						res.getString("TIPO"));
				
				honos.add(h);
				
			}
			res.close();
			stmt.close();
			return honos;
	}
	
	
	
}