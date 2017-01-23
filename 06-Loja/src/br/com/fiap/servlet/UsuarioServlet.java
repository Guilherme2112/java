package br.com.fiap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.Usuario;
import br.com.fiap.bo.UsuarioBO;

@WebServlet("/usuarioServlet")
public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsuarioBO bo = new UsuarioBO();
		List<Usuario> usuarios = bo.listar();
		req.setAttribute("usuarios", usuarios);
		req.getRequestDispatcher("/lista-usuario.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		String repita = req.getParameter("repita");
		
		Usuario usuario = new Usuario(nome, email, senha);
		UsuarioBO usuarioBO = new UsuarioBO();
		
		try {
			usuarioBO.cadastrar(usuario, repita);			
			req.setAttribute("mensagem", "Usuário Cadastrado!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("mensagem", e.getMessage());
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}		
	}
}
