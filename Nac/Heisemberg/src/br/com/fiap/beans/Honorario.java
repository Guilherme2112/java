package br.com.fiap.beans;

public class Honorario {
	private int cdHonorario;
	private String tipoHonorario;
	
	public int getCdHonorario() {
		return cdHonorario;
	}
	public void setCdHonorario(int cdHonorario) {
		this.cdHonorario = cdHonorario;
	}
	public String getTipoHonorario() {
		return tipoHonorario;
	}
	public void setTipoHonorario(String tipoHonorario) {
		this.tipoHonorario = tipoHonorario;
	}
	
	public Honorario(int cdHonorario, String tipoHonorario) {
		this.cdHonorario = cdHonorario;
		this.tipoHonorario = tipoHonorario;
	}
	
	public Honorario(){}
	
	public Honorario(int cdHonorario) {
		
		this.cdHonorario = cdHonorario;
	}
	
	

}
