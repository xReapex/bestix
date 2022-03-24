import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { LandingComponent } from './landing/landing.component';
import { DashboardComponent } from './dashboard/dashboard.component';

const routes: Routes = [];

@NgModule({
  imports: [
    RouterModule.forRoot([
      {
        path: 'login',
        component: LoginComponent,
      },
      {
        path: 'dashboard',
        component: DashboardComponent
      },
      {
        path: '**',
        component: LandingComponent
      }
    ]),
  ],

  exports: [RouterModule],
})
export class AppRoutingModule {}
