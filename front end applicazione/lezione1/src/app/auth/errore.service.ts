import { Injectable } from '@angular/core';
import { authGuard } from './authguard.guard';
import { AuthserviceService } from './authservice.service';

@Injectable({
  providedIn: 'root'
})
export class ErroreService {


  messaggioErrore!:string ;

  constructor(private service:AuthserviceService) { }


  erroreMessaggio(){
    if(this.service.isLoggedIn === false){
      this.messaggioErrore = "Devi effettuare prima il login"

      console.log(this.messaggioErrore)
    }
  }


}
