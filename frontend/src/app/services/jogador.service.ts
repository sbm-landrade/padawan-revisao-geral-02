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

  constructor (private http: HttpClient) { }

  getAllJogadores(): Observable<Jogador[]> {
    return this.http.get<Jogador[]>(this.apiUrl);
  }

  getJogadorById(id: number): Observable<Jogador> {
    return this.http.get<Jogador>(`${this.apiUrl}/${id}`);
  }

  createJogador(jogador: Jogador): Observable<Jogador> {
    return this.http.post<Jogador>(this.apiUrl, jogador);
  }

  updateJogador(id: number, jogador: Jogador): Observable<Jogador> {
    return this.http.put<Jogador>(`${this.apiUrl}/${id}`, jogador);
  }

  deleteJogador(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  getJogadoresByFields(nome?: string, time?: string, idade?: number, posicao?: string): Observable<Jogador[]> {
    let params = new HttpParams();
    if (nome) params = params.set('nome', nome);
    if (time) params = params.set('time', time);
    if (idade) params = params.set('idade', idade.toString());
    if (posicao) params = params.set('posicao', posicao);
    return this.http.get<Jogador[]>(`${this.apiUrl}/search`, { params });
  }

}
