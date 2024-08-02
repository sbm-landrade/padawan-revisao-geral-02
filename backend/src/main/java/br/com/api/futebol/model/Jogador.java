package br.com.api.futebol.model;

public class Jogador {

	private Long id;
	private String nome;
	private String time;

	// Construtores
	public Jogador() {
	}

	public Jogador(String nome, String time) {
		this.nome = nome;
		this.time = time;
	}

	// Getters e Setters
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
