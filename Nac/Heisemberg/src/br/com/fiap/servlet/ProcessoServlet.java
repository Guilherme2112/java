package br.com.fiap.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.beans.Processo;
import br.com.fiap.bo.ProcBO;
import br.com.fiap.conexao.Conexao;

@WebServlet("/processo")
public class ProcessoServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao =req.getParameter("acao");
			Connection conexao = null;
			try {
				conexao = new Conexao().getConnection("OPS$RM76824", "270298");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//recuperar todas as empresas cadastradas no banco

			List<Processo> lista = null;
			try {
				lista = ProcBO.l(conexao);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			//mandar a lista pro nosso jsp
			req.setAttribute("procs", lista);
			//redirecionar o infeliz para a pagina jsp
			req.getRequestDispatcher("ListaProcessos.jsp").forward(req, resp);
			
			
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao =req.getParameter("acao");
		Connection conexao = null;
		try {
			conexao = new Conexao().getConnection("OPS$RM76824", "270298");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//recuperar todas as empresas cadastradas no banco

		List<Processo> lista = null;
		try {
			lista = ProcBO.l(conexao);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//mandar a lista pro nosso jsp
		req.setAttribute("procs", lista);
		//redirecionar o infeliz para a pagina jsp
		req.getRequestDispatcher("ListaProcessos.jsp").forward(req, resp);
		
		
	}
}