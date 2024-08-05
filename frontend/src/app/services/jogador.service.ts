import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Jogador } from '../models/jogador';

@Injectable({
  providedIn: 'root'
})
export class JogadorService {

  private baseUrl = 'http://localhost:8080/api/jogadores';

  constructor (private http: HttpClient) { }

  getAllJogadores(): Observable<Jogador[]> {
    return this.http.get<Jogador[]>(this.baseUrl);
  }

}
