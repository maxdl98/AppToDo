import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserModule } from '../modelli/user/user.module';
import { Router, RouterStateSnapshot } from '@angular/router';
import { OAuthService } from 'angular-oauth2-oidc';
import {jwtDecode} from 'jwt-decode';
import { Observable } from 'rxjs';
import { Domande, Punteggio, Punteggio2, Utente2 } from '../interfacce/interfacce';
import { UtenteDto } from '../interfacce/utenteDto';
import { DomandeDto } from '../interfacce/DomandeDto';
import { formatoreDto } from '../interfacce/formatoreDto';

export interface Page<T> {
    content: T[];
  totalElements: number;
  totalPages: number;
  number: number;        
  size: number;         
  numberOfElements: number;
}


@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {

  urlDeleteAllPunteggiUtenti = "http://localhost:8080/api/v1/deletePunteggi"

   urlInvioMailAutomatica = "http://localhost:8080/api/v1/invioMailAutomatica"

    urlTrovaUtente = "http://localhost:8080/api/v1/trovaUtente"



  urlAllUtenti = "http://localhost:8080/api/utenti/getAll"

  urlAllPunteggi = "http://localhost:8080/api/v1/getAllPunteggi"

  urlSavePunteggio = "http://localhost:8080/api/v1/save2"

  urlCambioPassword = "http://localhost:8080/api/v1/changePassword"

  urlQuiz = "http://localhost:8080/api/v1/quiz"
  
  urlExcel = "http://localhost:8080/api/tickets/exportExcel"

  urlSignIn = "http://localhost:8080/api/utenti/uti"

  urlLogin= "http://localhost:8080/api/utenti/login/ut"

  urlEmail = "http://localhost:8080/api/utenti/sendHtmlEmail"

  urlRandomQuestion = "http://localhost:8080/api/v1/randomQuestion"

  urlTickets = "http://localhost:8080/api/tickets/submit"

  urlTicketsGetAll = "http://localhost:8081/api/tickets/getAllEmail"

  urlTickets2 = "http://localhost:8082/api/formatore/invioMail"

  urlFormatori = "http://localhost:8082/api/formatore/getFormatori2";

  urlLoginAdmin = "http://localhost:8080/api/v1/login"

  urlClassificaDto = "http://localhost:8080/api/v1/classifica"

  urlDeletePunteggi = "http://localhost:8080/api/v1/deletePunteggi"

  urlFormatori2 = "http://localhost:8081/api/formatore/getFormatori"


   percorsi = ['todo','esercizio','allenamento','login','signin',"listaUtenti",'ticket'
      ,'createticket','ticketchiusi','dash','pagina1','pagina2','pagina3','pagina4','pagina5','pagina6','pagina7','pagina8','pagina9','dialog', 'paginanuova'
    ]
   
   user! : UserModule


   isAdmin : boolean = false

  private token: string | null = null;


  isLoggedIn : boolean = true

  constructor(private http: HttpClient, private router: Router) {
  if (typeof window !== 'undefined' && window.localStorage) {
    const adminFromStorage = localStorage.getItem('isAdmin');
    this.isAdmin = adminFromStorage === 'true';
  } else {
    this.isAdmin = false; // valore di default se non c'è localStorage
  }


}

 

   savePunteggio(body:{ punteggio: { utente: { id: number; }; }; id_domanda: number; flag: boolean; }) {
     return this.http.post(`${this.urlSavePunteggio}`, body)
   }


  trovaUtenti(id: number): Observable<string> {
  return this.http.get(`${this.urlTrovaUtente}/${id}`, { responseType: 'text' });
}



   getUtenti(): Observable<Utente2[]> {
  return this.http.get<Utente2[]>(`${this.urlAllUtenti}`);
}

getUtenti2(): Observable<UtenteDto[]> {
  return this.http.get<UtenteDto[]>(`${this.urlAllUtenti}`)
}


getPunteggio():Observable<Punteggio[]>{
  return this.http.get<Punteggio[]>(`${this.urlAllPunteggi}`)
}



invioMailAutomatica(): Observable<string> {
  return this.http.post(`${this.urlInvioMailAutomatica}`, {}, {
    responseType: 'text'
  });
}

classificaDto():Observable<Punteggio2[]>{
  return this.http.get<Punteggio2[]>(`${this.urlClassificaDto}`)
}

deleteAll(): Observable<string> {
  return this.http.delete(`${this.urlDeleteAllPunteggiUtenti}`, { responseType: 'text' });
}



  cambioPass(body:{}){
    return this.http.post(`${this.urlCambioPassword}`,body)
  }

 


 

  randomQuestion() : Observable<Domande[]>{
      return this.http.get<Domande[]>(`${this.urlRandomQuestion}`);

  }

  randomQuestion1() : Observable<DomandeDto[]>{
    return this.http.get<DomandeDto[]>(`${this.urlRandomQuestion}`)
  }




 
  invioMail2(email:string, body : {}){
    return this.http.post(`${this.urlTickets2}?email=${email}`, body)
    
  }

  downloadExcel(url:string){
   return this.http.get(url, {
  responseType: 'blob'
});

  }


  downloadPdf(url:string){
   return this.http.get(url,{
    responseType: 'blob'
   } )
  }

  downloadPdf1(url:string){
    return this.http.get(url,{
      responseType : 'blob'
    })
  }


  sendEmail(url : string, email : string){
   return this.http.get(`${this.urlEmail}?email=${email}`);
  }

   
  getDati(url : string){
   return  this.http.get(`${url}`)
  }


  getAllEmail(url:string){
    return this.http.get(`${url}`)
  }







  signUp(body:{}){
    return this.http.post(this.urlSignIn,body)
  }

   


  login(email:string, password:string){
    return this.http.post(this.urlLogin,{
       email: email,
       password : password,
      returnSecureToken: true
     
    })
    
  }


  loginAdmin(email:string,password:string){
    return this.http.get(`${this.urlLoginAdmin}?email=${email}&password=${password}`)

  }


   inviaQuiz(risposte : any) {
    return this.http.post<any>(this.urlQuiz, risposte);
  }

  createUser(email:string,id:string, token: string, nome : string ){
    this.user = new UserModule(email,id,token,nome)
  }

   
  getFormatori(page:number, size:number) : Observable<any>{
  const url = `${this.urlFormatori}?page=${page}&size=${size}`;
    return this.http.get<Page<any>>(url);
  }


  getFormatori2(page:number, size:number) :Observable<Page<formatoreDto>>{
    const url = `${this.urlFormatori2}?page=${page}&size=${size}`;
    return this.http.get<Page<formatoreDto>>(url);

  }

  


  submitTicketData(ticketData: {
    email : string,
    problematica : string,
    contenuto : string,
    file?:File;
  }) {
    const formData = new FormData();

    formData.append('email', ticketData.email);
    formData.append('problematica', ticketData.problematica);
    formData.append('contenuto', ticketData.contenuto);
    

    if(ticketData.file){
      formData.append('file', ticketData.file)
    }


    return this.http.post(this.urlTickets,formData);
  }

   


}


