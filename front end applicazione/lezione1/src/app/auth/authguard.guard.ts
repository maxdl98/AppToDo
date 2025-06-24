import { ActivatedRouteSnapshot, CanActivate, CanActivateFn, GuardResult, MaybeAsync, Router, RouterStateSnapshot } from '@angular/router';
import { AuthserviceService } from './authservice.service';
import { Injectable } from '@angular/core';




@Injectable({ providedIn: 'root' })
export class authGuard implements CanActivate{

  constructor(private authservice:AuthserviceService, private router:Router){
    
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): any {

    const GestisciTicketRoute = state.url.includes('gestisciticket')

   
if (this.authservice.isAdmin) {
  this.router.navigate(['gestisciticket']);
  return false;
}

    

    if(state.url.includes('loginAdmin')){
      return true
    }


    if(GestisciTicketRoute && !this.authservice.isAdmin){
      this.router.navigate(['loginAdmin']);
      return false;
    }

  
  
    
    if(this.authservice.isLoggedIn){
      return true;
    } else{
      this.router.navigate(['login'])
    
      
    }

    return true;

    



  }


}


