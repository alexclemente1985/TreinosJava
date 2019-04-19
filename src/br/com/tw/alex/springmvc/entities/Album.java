package br.com.tw.alex.springmvc.entities;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Album {
	
	@NotNull(message = "Nome é obrigatório!")
	@NotEmpty(message = "Nome é obrigatório!")
	@Size(min=4,max=10, message="O nome do álbum deve ter entre 4 e 10 caracteres!")
	private String nome;
	
	@NotNull(message="O ano é obrigatório!")
	@Min(value=1990, message="O ano mínimo é 1990!")
	@Max(value=2040, message="O ano máximo é 2040!")
	private int anoDeLancamento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public void setAnoDeLancamento(int anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}

}
