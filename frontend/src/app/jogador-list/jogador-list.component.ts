import { Component, OnInit } from '@angular/core';
import { JogadorService } from '../services/jogador.service';
import { Jogador } from '../models/jogador';

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

  isEditing: boolean = false;
  jogador: Jogador = new Jogador();

  constructor(private jogadorService: JogadorService) { }

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
      this.isEditing = true;
      this.jogador = { ...jogador };
    }

    createJogador(): void {
      this.isEditing = false;
      this.jogador = new Jogador();
    }

    onSubmit(): void {
      console.log('Jogador a ser enviado:', this.jogador);
      if (this.isEditing) {
        if (this.jogador.id !== undefined) {
          this.jogadorService.updateJogador(this.jogador.id, this.jogador).subscribe(() => {
            this.loadJogadores();
            this.resetForm();
          });
        } else {
          console.error('O ID do jogador não está definido.');
        }
      } else {
        this.jogadorService.createJogador(this.jogador).subscribe(() => {
          this.loadJogadores();
          this.resetForm();
        });
      }
    }

    deleteJogador(id: number): void {
      this.jogadorService.deleteJogador(id).subscribe(() => {
        this.searchJogadores();
      });
    }
    resetForm(): void {
      this.jogador = new Jogador();
      this.isEditing = false;
    }
}
