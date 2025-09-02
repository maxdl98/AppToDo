import { Component, OnInit } from '@angular/core';
import { AuthserviceService } from '../../auth/authservice.service';
import { MatTableModule } from '@angular/material/table';
import { UtenteDto } from '../../interfacce/utenteDto';
import { DomandeDto, RispostaDto, RispostaSelezionata } from '../../interfacce/DomandeDto';
import { MatCardMdImage, MatCardModule } from '@angular/material/card';
import { MatChipsModule } from '@angular/material/chips';
import { CommonModule, NgFor, NgIf } from '@angular/common';
import { MatCheckbox, MatCheckboxChange, MatCheckboxModule } from "@angular/material/checkbox";
@Component({
  selector: 'app-tabella-utenti',
  imports: [MatTableModule, MatCardModule, MatChipsModule, NgFor, MatCheckboxModule,NgIf,CommonModule],
  standalone : true,
  templateUrl: './tabella-utenti.component.html',
  styleUrl: './tabella-utenti.component.css'
})
export class TabellaUtentiComponent implements OnInit{
onCheckboxChange(_t20: RispostaDto,arg1: DomandeDto,$event: MatCheckboxChange) {
throw new Error('Method not implemented.');
}
   displayedColumns : string[] = ['data','email','nome','numero','regione', 'dataRegistrazione']
   dataSource! : UtenteDto[];
   listaDomande : DomandeDto[] = [];
   currentIndex : number = 0;

   rispostaUtente : { [idDomanda: number] : number} = {}

   

  

constructor(private service:AuthserviceService){

}
  ngOnInit(): void {






    let miaMappa: Map<string, string> = new Map();

         let tabellaElementi : UtenteDto[] = []

    this.service.getUtenti2().
    subscribe({
      next : (response) =>{
        response.forEach((element,index) => {
         const tabella : UtenteDto = {
            id : element.id, data : element.data, email : element.email,
             nome : element.nome, numero : element.numero,
              password: element.password, regione : element.regione, 
              dataRegistrazione: element.dataRegistrazione
         }
                 tabellaElementi.push(tabella)


        

        });

        

        

       console.log(tabellaElementi)
      









      response.forEach((element, index) => {
        miaMappa.set(`valore ${index}`,element.email);
        
      }),
console.log(Array.from(miaMappa.entries()));
          this.dataSource  = tabellaElementi;

    
      }



      
    })
// finisce subscribe
 
this.service.randomQuestion()
.subscribe({
  next : (response) => {
    response.forEach(element => {
    

     const domande = {
      id : element.id,
      materia : element.materia,
      testoDomanda : element.testoDomanda,
      listaRisposte : element.listaRisposte
     }
      
     this.listaDomande.push(domande)


     

      
    });

    

    console.log(this.listaDomande);
    console.log(this.listaDomande.length)


    
    

   
  }


  


})






  
}

prossimaDomanda(){
  if(this.currentIndex < this.listaDomande.length){
    this.currentIndex++;
  }
}

domandaPrecedente(){
  if(this.currentIndex > 0){
    this.currentIndex--;
  }
}

isChecked(risposta:RispostaDto, domanda : DomandeDto){
return this.rispostaUtente[domanda.id] === risposta.id


}


onChangeBox(domanda:DomandeDto, risposta:RispostaDto,event:any): void{
    console.log(domanda.id);
  console.log(risposta.id);
  console.log(event.checked)
if(event.checked){
  this.rispostaUtente[domanda.id] = risposta.id
} else{
  delete this.rispostaUtente[domanda.id]
}
console.log(this.rispostaUtente);
}



  
}
