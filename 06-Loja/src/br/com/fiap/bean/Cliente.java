package br.com.fiap.bean;

public class Cliente {
	private long codigo;
	private String nome;
	private String endereco;
	private int idade;
	private String sexo;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Cliente(long codigo, String nome, String endereco, int idade, String sexo) {
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.idade = idade;
		this.sexo = sexo;
	}
	public Cliente() {}	
}
