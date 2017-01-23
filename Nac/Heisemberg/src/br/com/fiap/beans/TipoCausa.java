package br.com.fiap.beans;

public class TipoCausa {
	private int cdTipo;
	private String descricao;
	
	
	//getters e setters
	public TipoCausa(int cdTipo, String descricao) {
		super();
		this.cdTipo = cdTipo;
		this.descricao = descricao;
	}
	public int getCdTipo() {
		return cdTipo;
	}
	public void setCdTipo(int cdTipo) {
		this.cdTipo = cdTipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	//construtores
	public TipoCausa() {
		super();
	}

}
