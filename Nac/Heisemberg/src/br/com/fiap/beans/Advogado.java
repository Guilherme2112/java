package br.com.fiap.beans;

import java.util.List;

public class Advogado extends Pessoa{
	private long nrOAB;
	private long cpf;
	private String rg;
	private String senha;
	private List<Processo> processos;
	private TipoCausa[] causas;
	public long getNrOAB() {
		return nrOAB;
	}
	public void setNrOAB(long nrOAB) {
		this.nrOAB = nrOAB;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Processo> getProcessos() {
		return processos;
	}
	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}
	public TipoCausa[] getCausas() {
		return causas;
	}
	public void setCausas(TipoCausa[] causas) {
		this.causas = causas;
	}
	
	
	public Advogado(String nome, int cdPessoa, long nrOAB, long cpf, String rg, String senha, List<Processo> processos,
			TipoCausa[] causas) {
		super(nome, cdPessoa);
		this.nrOAB = nrOAB;
		this.cpf = cpf;
		this.rg = rg;
		this.senha = senha;
		this.processos = processos;
		this.causas = causas;
	}
	
	public Advogado(String nome, int cdPessoa) {
		super(nome, cdPessoa);
	}
	
	public Advogado() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
