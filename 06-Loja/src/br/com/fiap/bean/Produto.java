package br.com.fiap.bean;

public class Produto {
	private long codigo;
	private String titulo;
	private String descricao;
	private double valor;
	private String fabricante;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public Produto(long codigo, String titulo, String descricao, double valor, String fabricante) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.valor = valor;
		this.fabricante = fabricante;
	}
	public Produto() {}
}