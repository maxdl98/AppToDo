export interface Domande{
    id: number[];
    listaRisposte : Risposta[];
  materia : string[];
    testoDomanda : string[];
    
}

export interface Risposta {
  risposta: string[];
  flag: boolean;
}




export interface Utente {
  id: number;
}