package br.com.fiap.beans;

public class LancaHonorario {
	private Processo processo;
	private int cdLancamento;
	private String data;
	private double qtHora;
	private String observacao;
	private Honorario hono;
	public String getData() {
		return data;
	}

	// getters e setters
	public void setData(String data) {
		this.data = data;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public double getQtHora() {
		return qtHora;
	}

	public void setQtHora(double qtHora) {
		this.qtHora = qtHora;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public int getCdLancamento() {
		return cdLancamento;
	}

	public void setCdLancamento(int cdLancamento) {
		this.cdLancamento = cdLancamento;
	}
	public Honorario getHono() {
		return hono;
	}

	public void setHono(Honorario hono) {
		this.hono = hono;
	}


	public void lancar(Honorario hono, Processo proc) {
		// adicionaHonorario
	}

	// Construtores
	public LancaHonorario(Processo processo,String data, double qtHora, String observacao,int cdLancamento,Honorario hono) {
		super();
		this.processo= processo;
		this.data = data;
		this.qtHora = qtHora;
		this.observacao = observacao;
		this.cdLancamento = cdLancamento;
		this.hono = hono;
	}
	public LancaHonorario() {
	}

}
