import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './views/login/login.component';
import { LandingComponent } from './views/landing/landing.component';
import { DashboardComponent } from './views/dashboard/dashboard.component';
import { BettingCardComponent } from './components/betting-card/betting-card.component';
import { HttpClientModule } from '@angular/common/http';
import { ApiCallTestComponent } from './components/api-call-test/api-call-test.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PlayerCardComponent } from './components/player-card/player-card.component';
import { PlayersViewComponent } from './views/players-view/players-view.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LandingComponent,
    DashboardComponent,
    BettingCardComponent,
    ApiCallTestComponent,
    PlayerCardComponent,
    PlayersViewComponent,
    SidebarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }