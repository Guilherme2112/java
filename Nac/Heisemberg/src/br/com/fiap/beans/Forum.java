package br.com.fiap.beans;

import java.util.List;

public class Forum extends Pessoa{
	private String descricao;
	private List<Processo> processos;
	//getters e setters
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Processo> getProcessos() {
		return processos;
	}
	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}
	//construtores
	public Forum(String nome, int cdPessoa, String descricao, List<Processo> processos) {
		super(nome, cdPessoa);
		this.descricao = descricao;
		this.processos = processos;
	}
	public Forum() {
	}

	public Forum(String descricao, List<Processo> processos) {
		this.descricao = descricao;
		this.processos = processos;
	}

	public Forum(String nome, int cdPessoa) {
		super(nome, cdPessoa);
	}

}
