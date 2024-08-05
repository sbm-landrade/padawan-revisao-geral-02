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

  constructor(private jogadorService: JogadorService) { }

  ngOnInit(): void {
    this.jogadorService.getAllJogadores().subscribe(data => {
      this.jogadores = data;
    });
  }

}
