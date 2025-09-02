export interface Domande{
    id: number;
    listaRisposte : Risposta[];
  materia : string[];
    testoDomanda : string[];
    
}

export interface Risposta {
  id: number;
  risposta: string[];
  flag: boolean;
}




export interface Utente {
  id: number;
}


export interface RisposteSelezionate {
  id: number,
  flag: boolean,
  id_domanda : number;
}

export interface Utente2{
  id: number,
  data:Date,
  email: string,
  nome:string,
  numero:string,
  password:string,
  regione:string,
  DataRegistrazione:Date;

}

export interface Punteggio2{
  nome:string,
  punteggio:number,
  email:string;
}



export interface Punteggio{
  id:number,
  punteggio:number;
  id_utente:Utente2;
}