package br.com.phelipe.model;

import java.util.List;

public class ModelSampleDataVO {

	private String nome;
	private String valor;
	private List<ModelSubRelatorioData> lista1;

	public ModelSampleDataVO(String nome, String valor, List<ModelSubRelatorioData> list) {
		this.nome = nome;
		this.valor = valor;
		this.lista1 = list;
	}

	public String getNome() {
		return nome;
	}

	public String getValor() {
		return valor;
	}

	public List<ModelSubRelatorioData> getLista1() {
		return lista1;
	}

}
