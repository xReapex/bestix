import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  // Use HttpClient
  constructor(private http: HttpClient) {}

  private matchs: any = [];

  private headersFootballData = new HttpHeaders({
    'X-Auth-Token': environment.match_api,
  });

  private headersPredictions = new HttpHeaders({
    'X-RapidAPI-Host': 'odds.p.rapidapi.com',
    'X-RapidAPI-Key': '48b2e07d1bmsh54c38c8a3e13663p10918ajsn989abe659ace',
  });

  public getNextMatch() {
    return this.http.get(
      'http://api.football-data.org/v2/competitions/FL1/matches?status=SCHEDULED',
      {
        headers: this.headersFootballData,
      }
    );
  }

  private getPredictions() {
    return this.http.get(
      'https://odds.p.rapidapi.com/v4/sports/soccer_france_ligue_one/odds',
      {
        headers: this.headersPredictions,
        params: {
          regions: 'eu',
          oddsFormat: 'decimal',
          markets: 'h2h,spreads',
          dateFormat: 'iso',
        },
      }
    );
  }
}
