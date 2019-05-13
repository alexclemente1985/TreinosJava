package br.com.tw.alex.springmvc.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "alb_albuns")
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "alb_id")
	private Long id;

	@NotNull(message = "Nome é obrigatório!")
	@NotEmpty(message = "Nome é obrigatório!")
	@Size(min = 4, max = 10, message = "O nome do álbum deve ter entre 4 e 10 caracteres!")
	@Column(name = "alb_nome", length = 10, nullable = false)
	private String nome;

	@NotNull(message = "O ano é obrigatório!")
	@Min(value = 1990, message = "O ano mínimo é 1990!")
	@Max(value = 2040, message = "O ano máximo é 2040!")
	@Column(name = "alb_ano_lanc", nullable = false)
	private int anoDeLancamento;
	
	@OneToMany(mappedBy="album", fetch=FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = true)
	private Set<Music> musics;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Set<Music> getMusics() {
		return musics;
	}

	public void setMusics(Set<Music> musics) {
		this.musics = musics;
	}

}
