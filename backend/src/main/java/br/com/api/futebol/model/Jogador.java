package br.com.api.futebol.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("jogador") // Nome da tabela no banco de dados
public class Jogador {

	@Id
	private Long id;
	private String nome;
	private String time;
	private int idade;
	private String posicao;

	// Construtores
	public Jogador() {
	}

	public Jogador(String nome, String time, int idade, String posicao) {
		this.nome = nome;
		this.time = time;
		this.idade = idade;
		this.posicao = posicao;
	}
	// Getters e Setters
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	
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
