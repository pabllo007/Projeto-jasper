package br.com.phelipe.model;

public class ModelSubRelatorioData {

	private String CPF;
	private String idade;

	public ModelSubRelatorioData(String cpf, String idade) {
		this.CPF = cpf;
		this.idade = idade;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

}
