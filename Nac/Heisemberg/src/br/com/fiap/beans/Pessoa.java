package br.com.fiap.beans;

public class Pessoa {
	private String nome;
	private int cdPessoa;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCdPessoa() {
		return cdPessoa;
	}
	public void setCdPessoa(int cdPessoa) {
		this.cdPessoa = cdPessoa;
	}
	public Pessoa(String nome, int cdPessoa) {
		super();
		this.nome = nome;
		this.cdPessoa = cdPessoa;
	}
	public Pessoa() {
		super();
	}
	
	

}
