import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

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
    return this.http.get("https://api.football-data.org/v2/competitions/FL1/matches?status=SCHEDULED", {
      headers: this.headers,
    });
  }

  public getFavoritesByUserId(id: string)
  {
    return this.http.get("https://45.147.98.151:8080/api/Favorites/userId=" + id);
  }

  public getPlayerInfos(id: string)
  {
    return this.http.get("https://45.147.98.151:8080/api/external/players/" + id);
  }

  public savePlayerAsFavorite(id: string)
  {
    let defaultUserIdForTests = 0;

    return this.http.post("https://45.147.98.151:8080/api/Favorites/playerId=" + id + "&userId=" + defaultUserIdForTests, null);
  }

  public deleteFavorite(id: string)
  {
    let defaultUserIdForTests = 0;
    return this.http.delete("https://45.147.98.151:8080/api/Favorites/playerId=" + id + "&userId=" + defaultUserIdForTests);
  }

  public getLeaguesList()
  {
    return this.http.get("https://45.147.98.151:8080/api/league/list");
  }

  public requestLeagueAccess(leagueId: string, password: string, userId: string)
  {
    return this.http.post("https://45.147.98.151:8080/api/league/" + leagueId + "/" + password + "/" + userId, null);
  }

  public checkJoinedLeaguesByUserId(userId: string)
   {
     return this.http.get("https://45.147.98.151:8080/api/league/" + userId);
   }

  public getLeagueUserList(leagueId: string)
  {
    return this.http.get("https://45.147.98.151:8080/api/league/" + leagueId + "/users");
  }

  public getMatchListFromBack()
  {
    return this.http.get("https://45.147.98.151:8080/api/matchs/scheduled");
  }

  public saveMatchBetByUserId(matchId: string, teamId: string, userId: string)
  {
    return this.http.post("https://45.147.98.151:8080/api/bet/matchId=" + matchId + "&teamId=" + teamId + "&userId=" + userId, null);
  }

  public getBetResultsByUserId(userId: string)
  {
    return this.http.get("https://45.147.98.151:8080/api/bet/userId=" + userId + "/results");
  }
}
