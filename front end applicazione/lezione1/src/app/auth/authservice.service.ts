import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserModule } from '../modelli/user/user.module';
import { Router, RouterStateSnapshot } from '@angular/router';
import { OAuthService } from 'angular-oauth2-oidc';
import {jwtDecode} from 'jwt-decode';
import { Observable } from 'rxjs';

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

  urlQuiz = "http://localhost:8080/api/v1/quiz"
  
  urlExcel = "http://localhost:8080/api/tickets/exportExcel"

  urlSignIn = "http://localhost:8080/api/utenti/uti"

  urlLogin= "http://localhost:8080/api/utenti/login/ut"

  urlEmail = "http://localhost:8080/api/utenti/sendHtmlEmail"


  urlTickets = "http://localhost:8080/api/tickets/submit"

  urlTicketsGetAll = "http://localhost:8081/api/tickets/getAllEmail"

  urlTickets2 = "http://localhost:8082/api/formatore/invioMail"

  urlFormatori = "http://localhost:8082/api/formatore/getFormatori2";

  urlLoginAdmin = "http://localhost:8080/api/v1/login"

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


