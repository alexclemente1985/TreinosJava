package br.com.tw.struts2.controllers;

import com.opensymphony.xwork2.ActionSupport;

import br.com.tw.struts2.entidades.Pessoa;

public class PessoaController extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4038184956713497500L;
	private Pessoa pessoa;
	
	public String inserirPessoa() {
		return "OK";
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
