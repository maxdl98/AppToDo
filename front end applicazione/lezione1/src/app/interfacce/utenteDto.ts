export class UtenteDto{
 

    constructor(public id: number, public data:Date, public email:string,public nome:string,public numero:number,public password:string,public regione:string,public dataRegistrazione:Date){
        this.id = id;
        this.data = data;
        this.email = email;
        this.nome = nome;
        this.numero = numero;
        this.password = password;
        this.regione = regione; 
        this.dataRegistrazione = dataRegistrazione
    
    }

}