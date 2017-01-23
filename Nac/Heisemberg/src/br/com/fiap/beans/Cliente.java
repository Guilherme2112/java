package br.com.fiap.beans;

import java.util.List;

public class Cliente extends Pessoa{
	private String rzSocial;
	private long cnpj;
	private long inscrEstadual;
	private String email;
	private String password;
	private List<Processo> processos;
	
	//getters e setters
	public String getRzSocial() {
		return rzSocial;
	}
	public void setRzSocial(String rzSocial) {
		this.rzSocial = rzSocial;
	}
	public long getCnpj() {
		return cnpj;
	}
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	public long getInscrEstadual() {
		return inscrEstadual;
	}
	public void setInscrEstadual(long inscrEstadual) {
		this.inscrEstadual = inscrEstadual;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Processo> getProcessos() {
		return processos;
	}
	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}
	//construtores
	public Cliente(String rzSocial, long cnpj, long inscrEstadual, String email, String password,
			List<Processo> processos) {
		this.rzSocial = rzSocial;
		this.cnpj = cnpj;
		this.inscrEstadual = inscrEstadual;
		this.email = email;
		this.password = password;
		this.processos = processos;
	}
	public Cliente(String nome, int cdPessoa, String rzSocial, long cnpj, long inscrEstadual, String email,
			String password, List<Processo> processos) {
		super(nome, cdPessoa);
		this.rzSocial = rzSocial;
		this.cnpj = cnpj;
		this.inscrEstadual = inscrEstadual;
		this.email = email;
		this.password = password;
		this.processos = processos;
	}
	public Cliente(String nome, int cdPessoa) {
		super(nome, cdPessoa);
	}
	public Cliente() {
		super();
	}
	

}
