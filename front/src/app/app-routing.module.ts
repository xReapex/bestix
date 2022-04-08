import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { LandingComponent } from './landing/landing.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ApiCallTestComponent } from './components/api-call-test/api-call-test.component';
import { PlayerCardComponent } from './player-card/player-card.component';
import { PlayersViewComponent } from './views/players-view/players-view.component';

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
        path: 'tests',
        component: ApiCallTestComponent
      },
      {
        path: 'player-card-test',
        component: PlayersViewComponent
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
