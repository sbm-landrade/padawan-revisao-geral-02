//Serviço responsável por fazer chamadas HTTP para a API backend.
//Contém métodos para realizar operações CRUD (Create, Read, Update, Delete).
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Jogador } from '../models/jogador';



@Injectable({
  providedIn: 'root'
})
export class JogadorService {
  private apiUrl = 'http://localhost:8080/api/jogadores';

  constructor(private http: HttpClient) {}

  getAllJogadores(): Observable<Jogador[]> {
    return this.http.get<Jogador[]>(this.apiUrl);
  }

  getJogadoresByFields(nome: string, time: string, idade?: number, posicao?: string): Observable<Jogador[]> {
    let params = new HttpParams()
      .set('nome', nome || '')
      .set('time', time || '');

    if (idade !== null && idade !== undefined) {
      params = params.set('idade', idade.toString());
    }
    if (posicao) {
      params = params.set('posicao', posicao);
    }

    console.log('Requisição para URL:', `${this.apiUrl}/search`);
    console.log('Parâmetros:', params.toString());

    return this.http.get<Jogador[]>(`${this.apiUrl}/search`, { params });
  }

  createJogador(jogador: Jogador): Observable<Jogador> {
    return this.http.post<Jogador>(this.apiUrl, jogador);
  }

  updateJogador(id: number, jogador: Jogador): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/${id}`, jogador);
  }

  deleteJogador(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
