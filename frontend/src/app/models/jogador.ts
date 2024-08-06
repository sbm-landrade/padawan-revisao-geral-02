//define a estrutura do objeto Jogadores, garantindo que os objetos jogadores funcionam de forma esperada

export class Jogador {
  id?: number;
  nome: string;
  time: string;
  idade: number;
  posicao: string;

  constructor() {
    this.nome = '';
    this.time = '';
    this.idade = 0;
    this.posicao = '';
  }
}
