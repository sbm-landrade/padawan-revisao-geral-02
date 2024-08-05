import { Component, OnInit } from '@angular/core';
import { JogadorService } from '../services/jogador.service';
import { Jogador } from '../models/jogador';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-jogador-list',
  templateUrl: './jogador-list.component.html',
  styleUrls: ['./jogador-list.component.css']
})
export class JogadorListComponent implements OnInit {
  jogadores: Jogador[] = [];
  nome: string = '';
  time: string = '';
  idade: number | undefined;
  posicao: string = '';

  constructor(private jogadorService: JogadorService, private http:HttpClient) { }

  ngOnInit(): void {
    this.loadJogadores();
  }

  loadJogadores(): void {
    this.jogadorService.getAllJogadores().subscribe(data => {
      this.jogadores = data;
    });
  }
    searchJogadores(): void {
      this.jogadorService.getJogadoresByFields(this.nome, this.time, this.idade, this.posicao).subscribe(data => {
        this.jogadores = data;
      });
    }
    editJogador(jogador: Jogador): void {
      // Implementar a lógica de edição aqui
      // Pode abrir um modal ou redirecionar para outra página com o formulário de edição
      console.log('Editando jogador', jogador);
    }
    deleteJogador(id: number) {
      const url = `http://localhost:8080/api/jogadores/${id}`;
    this.http.delete(url).subscribe(() => {
      this.searchJogadores(); // Recarrega a lista após deletar
    });
    }
}
