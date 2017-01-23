/**
 * @authors Guilherme/Alexandre/Taize/Luis
 * 
 */
package br.com.fiap.beans;

import java.util.List;

public class Processo {
	private int numProc;
	private Cliente cliente;
	private Advogado advogado;
	private Forum forum;
	private TipoCausa causa;
	private String descricao;
	private String dtAbertura;
	private String dtFechamento;
	private short diaVencimento;
	private byte resultado;
	private byte situacao;
	private String observacao;
	private List<LancaHonorario> honorarios;
	private List<LancaDespesa> despesas;

	// getters e setters
	public int getNumProc() {
		return numProc;
	}

	public void setNumProc(int numProc) {
		this.numProc = numProc;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Advogado getAdvogado() {
		return advogado;
	}

	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public TipoCausa getCausa() {
		return causa;
	}

	public void setCausa(TipoCausa causa) {
		this.causa = causa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(String dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public String getDtFechamento() {
		return dtFechamento;
	}

	public void setDtFechamento(String dtFechamento) {
		this.dtFechamento = dtFechamento;
	}

	public short getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(short diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public byte getResultado() {
		return resultado;
	}

	public void setResultado(byte resultado) {
		this.resultado = resultado;
	}

	public byte getSituacao() {
		return situacao;
	}

	public void setSituacao(byte situacao) {
		this.situacao = situacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<LancaHonorario> getHonorarios() {
		return honorarios;
	}

	public void setHonorarios(List<LancaHonorario> honorarios) {
		this.honorarios = honorarios;
	}

	public List<LancaDespesa> getDespesas() {
		return despesas;
	}

	public void setDespesas(List<LancaDespesa> despesas) {
		this.despesas = despesas;
	}
	public String getTudo(){
		return "Numero: "+numProc +"\t"+"Descricao: "+descricao+"\t"+"Cliente:"+cliente.getNome()+"\t"+"Advogado: "+advogado.getNome()+"\t"+"Forum: "+forum.getNome()+"\t"+"Data Abert."+dtAbertura+"\t"+"Data Fech."+dtFechamento
				+"\t"+"Dia.Venc."+diaVencimento+"\t"+"Situação: "+situacao+"\t"+"Resultado: "+resultado+"\t"+"Observação: "+observacao;
	}

	// construtores
	public Processo(int numProc, Cliente cliente, Advogado advogado, Forum forum, TipoCausa causa, String descricao,
			String dtAbertura, String dtFechamento, short diaVencimento, byte resultado, byte situacao,
			String observacao, List<LancaHonorario> honorarios, List<LancaDespesa> despesas) {
		super();
		this.numProc = numProc;
		this.cliente = cliente;
		this.advogado = advogado;
		this.forum = forum;
		this.causa = causa;
		this.descricao = descricao;
		this.dtAbertura = dtAbertura;
		this.dtFechamento = dtFechamento;
		this.diaVencimento = diaVencimento;
		this.resultado = resultado;
		this.situacao = situacao;
		this.observacao = observacao;
		this.honorarios = honorarios;
		this.despesas = despesas;
	}

	public Processo() {
	}
	public Processo(int numProc){
		this.numProc = numProc;
	}


}
