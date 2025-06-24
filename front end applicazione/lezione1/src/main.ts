import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { importProvidersFrom, Provider, APP_INITIALIZER } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { OAuthModule } from 'angular-oauth2-oidc';
import { bootstrapApplication } from '@angular/platform-browser';

import { KeycloakService } from 'keycloak-angular';
import { TokenInterceptor } from './app/interceptors/token.interceptor';

function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak
      .init({
        config: {
          url: 'http://localhost:8180',
          realm: 'AppToDo',
          clientId: 'AppToDo',
        },
        initOptions: {
          onLoad: 'login-required',
          checkLoginIframe: false,
          redirectUri: window.location.origin + '/dash',
        },
      })
      .then(() => console.log('Keycloak init successful'))
      .catch(err => console.error('Keycloak init failed', err));
}

const keycloakInitializerProvider: Provider = {
  provide: APP_INITIALIZER,
  useFactory: initializeKeycloak,
  multi: true,
  deps: [KeycloakService],
};

bootstrapApplication(AppComponent, {
  ...appConfig,
  providers: [
    ...(appConfig.providers ?? []),
    importProvidersFrom(HttpClientModule, RouterModule, OAuthModule.forRoot()),
    KeycloakService,
    keycloakInitializerProvider,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true,
    },
  ],
}).catch(err => console.error(err));
