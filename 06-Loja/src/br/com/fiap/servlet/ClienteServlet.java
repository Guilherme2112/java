package br.com.fiap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.Cliente;
import br.com.fiap.bo.ClienteBO;

public class ClienteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClienteBO clienteBO = new ClienteBO();
		List<Cliente> clientes = clienteBO.listar();
		req.setAttribute("clientes", clientes);
		req.getRequestDispatcher("lista-clientes.jsp").forward(req,  resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		int idade = Integer.parseInt(req.getParameter("idade"));
		String sexo = req.getParameter("sexo");
		
		Cliente cliente = new Cliente(0, nome, endereco, idade, sexo);
		
		ClienteBO bo = new ClienteBO();
		
		bo.cadastrar(cliente);
		
		req.setAttribute("mensagem", "Cliente cadastrado com sucesso!");
		req.getRequestDispatcher("/cadastro-cliente.jsp").forward(req, resp);;
		
		}
}
