import { Routes } from '@angular/router';
import { EsercizioComponent } from './componenti/esercizio/EsercizioComponent';
import { LoginComponent } from './componenti/login/login.component';
import { RegistrazioneComponent } from './componenti/registrazione/registrazione.component';
import { authGuard } from './auth/authguard.guard';
import { HomeComponent } from './componenti/home/home.component';
import { DashboardComponent } from './componenti/dashboard/dashboard.component';
import { Pagina1Component } from './componenti/pagina1/pagina1.component';
import { Pagina2Component } from './componenti/pagina2/pagina2.component';
import { Pagina3Component } from './componenti/pagina3/pagina3.component';
import { Pagina4Component } from './componenti/pagina4/pagina4.component';
import { Pagina5Component } from './componenti/pagina5/pagina5.component';
import { Pagina6Component } from './componenti/pagina6/pagina6.component';
import { Pagina7Component } from './componenti/pagina7/pagina7.component';
import { Pagina8Component } from './componenti/pagina8/pagina8.component';
import { Pagina9Component } from './componenti/pagina9/pagina9.component';
import { AllenamentoComponent } from './componenti/allenamento/allenamento.component';
import { TabellaGenericaComponent } from './componenti/tabella-generica/tabella-generica.component';
import { DialogComponent } from './componenti/dialog/dialog.component';
import { PaginanuovaComponent } from './componenti/paginanuova/paginanuova.component';
import { TicketComponent } from './componenti/ticket/ticket.component';
import { CreateticketComponent } from './componenti/createticket/createticket.component';
import { TicketricevutiComponent } from './componenti/ticketricevuti/ticketricevuti.component';
import { TicketchiusiComponent } from './componenti/ticketchiusi/ticketchiusi.component';
import { LoginAdminComponent } from './componenti/login-admin/login-admin.component';
import { NavComponent } from './componenti/nav/nav.component';
import { AppComponent } from './app.component';


export const routes: Routes = [
    {path: 'navigazione', component: NavComponent},
    {path:'loginAdmin', component:LoginAdminComponent},
    {path:'todo', canActivate: [authGuard], component : EsercizioComponent},
    {path: 'esercizio', component : EsercizioComponent},
    {path: 'allenamento', component : AllenamentoComponent},
    {path:'login', component : LoginComponent},
    {path: 'signin' , component: RegistrazioneComponent},
    {path:"listaUtenti", component : HomeComponent},
    {path:'ticket', component: TicketComponent},
    {path:'createticket', component: CreateticketComponent},
    {path: 'gestisciticket', canActivate: [authGuard], component: TicketricevutiComponent},
    {path:'ticketchiusi', component: TicketchiusiComponent},
    {path : 'dash', component : DashboardComponent, children : [
    {path: 'pagina1', component : Pagina1Component},
    {path: 'pagina2', component : Pagina2Component},
    {path : 'pagina3', component: Pagina3Component},
    {path : 'pagina4', component: Pagina4Component},
    {path : 'pagina5', component: Pagina5Component},
    {path : 'pagina6', component: Pagina6Component},
    {path : 'pagina7', component: Pagina7Component},
    {path : 'pagina8', component: Pagina8Component},
    {path : 'pagina9', component: Pagina9Component},
    {path: 'dialog', component: DialogComponent},
    {path: 'paginanuova', component : PaginanuovaComponent},

   ]} 

]
