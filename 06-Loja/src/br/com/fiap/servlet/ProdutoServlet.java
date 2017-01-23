package br.com.fiap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.Produto;
import br.com.fiap.bo.ProdutoBO;

public class ProdutoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProdutoBO bo = new ProdutoBO();
		List<Produto> produtos = bo.listar();
		req.setAttribute("produtos", produtos);
		req.getRequestDispatcher("/lista-produto.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titulo = req.getParameter("titulo");
		String descricao = req.getParameter("descricao");
		String fabricante = req.getParameter("fabricante");
		double valor = Double.parseDouble(req.getParameter("valor"));
		
		Produto produto = new Produto(0, titulo, descricao, valor, fabricante);
		
		ProdutoBO bo = new ProdutoBO();
		bo.cadastrar(produto);
		
		req.setAttribute("mensagem", "Produto cadastrado com sucesso!");
		req.getRequestDispatcher("cadastro-produto.jsp").forward(req, resp);
		
	}
}