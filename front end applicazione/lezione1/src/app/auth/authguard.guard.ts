import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { AuthService } from '../token/auth.service';

@Injectable({ providedIn: 'root' })
export class authGuard implements CanActivate {

  constructor(private authservice: AuthService, private router: Router) {}

  async canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<boolean> {
    const isLoggedIn = await this.authservice.isLoggedIn();
    const isAdmin = this.authservice.isAdmin();

   

    if (state.url === '/login' && isAdmin) {
      this.router.navigate(['loginAdmin']);
      return false;
    }

     if (!isLoggedIn) {
      this.router.navigate(['login']);
      return false;
    }

    if (state.url.includes('gestisciticket') && !isAdmin) {
      this.router.navigate(['loginAdmin']);
      return false;
    }

    if (state.url.includes('loginAdmin') && !isAdmin) {
      this.router.navigate(['login']);
      return false;
    }

    return true;
  }
}
