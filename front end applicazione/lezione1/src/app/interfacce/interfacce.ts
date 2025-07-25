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