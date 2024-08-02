package br.com.api.futebol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.futebol.model.Jogador;
import br.com.api.futebol.service.JogadorService;

@RestController
@RequestMapping("/api/jogadores")
public class JogadorController {
	@Autowired
    private JogadorService jogadorService;
	
	@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Jogador> getAllJogadores() {
        return jogadorService.findAll();
    }

    @GetMapping("/{id}")
    public Jogador getJogadorById(@PathVariable Long id) {
        return jogadorService.findById(id);
    }

    @PostMapping
    public int createJogador(@RequestBody Jogador jogador) {
        return jogadorService.save(jogador);
    }

    @PutMapping("/{id}")
    public int updateJogador(@PathVariable Long id, @RequestBody Jogador jogador) {
        jogador.setId(id);
        return jogadorService.update(jogador);
    }

    @DeleteMapping("/{id}")
    public int deleteJogador(@PathVariable Long id) {
        return jogadorService.deleteById(id);
    }
}