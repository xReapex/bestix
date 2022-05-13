import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  // Use HttpClient
  constructor(private http: HttpClient) {}

  private headers = new HttpHeaders().set(
    'X-Auth-Token',
    environment.match_api
  );

  public getNextMatch() {
    return this.http.get("http://api.football-data.org/v2/competitions/FL1/matches?status=SCHEDULED", {
      headers: this.headers,
    });
  }

  public getFavoritesByUserId(id: string)
  {

    return this.http.get("http://localhost:8080/api/Favorites/userId=" + id);
  }

  public getPlayerInfos(id: string)
  {
    return this.http.get("http://localhost:8080/api/external/players/" + id);
  }
}
