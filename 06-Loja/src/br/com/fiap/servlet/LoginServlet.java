package br.com.fiap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bo.UsuarioBO;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		UsuarioBO usuarioBO = new UsuarioBO();
		if( usuarioBO.logar(email, senha) ) {
			req.setAttribute("mensagem", "logou miseravel");
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		} else {
			req.setAttribute("mensagem", "login errado fiu");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
