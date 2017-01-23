package br.com.fiap.beans;

public class Despesa {
	private int cdDespesa;
	private String tipoDespesa;
	
	public int getCdDespesa() {
		return cdDespesa;
	}
	public void setCdDespesa(int cdDespesa) {
		this.cdDespesa = cdDespesa;
	}
	public String getTipoDespesa() {
		return tipoDespesa;
	}
	public void setTipoDespesa(String tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
	
	public Despesa(int cdDespesa, String tipoDespesa) {
		this.cdDespesa = cdDespesa;
		this.tipoDespesa = tipoDespesa;
	}
	
	public Despesa(){}
	
	public Despesa(int cdDespesa) {
		
		this.cdDespesa = cdDespesa;
	}
	
	

}
