package br.com.fiap.beans;

public class LancaDespesa {
	private Processo processo;
	private int cdLancamento;
	private String data;
	private double vlHora;
	private String observacao;
	private Despesa desp;
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

	public double getVlHora() {
		return vlHora;
	}

	public void setVlHora(double vlHora) {
		this.vlHora = vlHora;
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
	public Despesa getDesp() {
		return desp;
	}

	public void setDesp(Despesa desp) {
		this.desp = desp;
	}


	public void lancar(Despesa desp, Processo proc) {
		// adicionaDespesa
	}

	// Construtores
	public LancaDespesa(Processo processo,String data, double vlHora, String observacao,int cdLancamento,Despesa desp) {
		super();
		this.processo= processo;
		this.data = data;
		this.vlHora = vlHora;
		this.observacao = observacao;
		this.cdLancamento = cdLancamento;
		this.desp = desp;
	}
	public LancaDespesa() {
	}

}
