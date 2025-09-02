export class DomandeDto{

    constructor(public id:number,public testoDomanda : string[], public materia:string[], public listaRisposte:RispostaDto[]){
        this.id = id;
        this.testoDomanda = testoDomanda;
        this.materia = materia;
        this.listaRisposte = listaRisposte;
        

    }
}

export class RispostaDto{

    constructor(public id:number, public risposta:string[], public flag:boolean){
        this.id = id;
        this.risposta = risposta;
        this.flag = flag;
    }
}


export interface RispostaSelezionata{
  idDomanda : number;
   
}

