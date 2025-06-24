import { Injectable } from "@angular/core";
import { KeycloakService } from "keycloak-angular";

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private token: string | null = null;

  constructor(private keycloakService: KeycloakService) {}

  async init(): Promise<void> {
    this.token = await this.keycloakService.getToken();
    console.log('Token appena ottenuto:', this.token);
  }

   

  getToken(): Promise<string> {
    return this.keycloakService.getToken();
  }

  isLoggedIn(): Promise<boolean> {
    return Promise.resolve(this.keycloakService.getKeycloakInstance().authenticated ?? false);
  }

  logout(): void {
    this.keycloakService.logout(window.location.origin);
  }

  getUsername(): string | undefined {
    return this.keycloakService.getUsername();
  }
}
