import { FavoritesComponent } from './views/favorites/favorites.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './views/login/login.component';
import { LandingComponent } from './views/landing/landing.component';
import { DashboardComponent } from './views/dashboard/dashboard.component';
import { ApiCallTestComponent } from './components/api-call-test/api-call-test.component';
import { PlayerCardComponent } from './components/player-card/player-card.component';
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
        path: 'favorite',
        component: FavoritesComponent
      },
      {
        path: 'tests',
        component: ApiCallTestComponent
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
