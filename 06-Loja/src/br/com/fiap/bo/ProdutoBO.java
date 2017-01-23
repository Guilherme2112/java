package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Produto;

public class ProdutoBO {
	
	private static List<Produto> produtos = new ArrayList<Produto>();
			
	public void cadastrar(Produto produto) {
		produto.setCodigo(produtos.size()+1);
		produtos.add(produto);
	}
	
	public List<Produto> listar() {
		return produtos;
	}
	
}
