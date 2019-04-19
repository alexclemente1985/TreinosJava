package br.com.tw.alex.springmvc.entities;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Artista {
	@NotNull(message="Favor informar um nome!")
	@NotEmpty(message="Favor informar um nome!")
	@Size(max=30, message="Nome não pode ultrapassar 30 caracteres!")
	private String nome;
	@NotNull(message="Favor informar um estilo!")
	@NotEmpty(message="Favor informar um estilo!")
	private String estilo;
	@NotNull(message="Favor informar uma idade!")
	private int idade;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
}
