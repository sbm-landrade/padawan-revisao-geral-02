package br.com.api.futebol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.futebol.model.Jogador;
import br.com.api.futebol.repository.JogadorRepository;

@Service
public class JogadorService {

	@Autowired
	private JogadorRepository jogadorRepository;

	public JogadorService(JogadorRepository jogadorRepository) {
		this.jogadorRepository = jogadorRepository;
	}

	public List<Jogador> findAll() {
		return jogadorRepository.findAll();
	}

	public Jogador findById(Long id) {
		return jogadorRepository.findById(id);
	}

	public int save(Jogador jogador) {
		return jogadorRepository.save(jogador);
	}

	public int update(Jogador jogador) {
		return jogadorRepository.update(jogador);
	}

	public int deleteById(Long id) {
		return jogadorRepository.deleteById(id);
	}
	
    public List<Jogador> findByPosicao(String posicao) {
        return jogadorRepository.findByPosicao(posicao);
    }

    public List<Jogador> findByIdade(int idade) {
        return jogadorRepository.findByIdade(idade);
    }

}
