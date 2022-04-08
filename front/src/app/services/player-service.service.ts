import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlayerServiceService {

    // Base URL for TheSportsDB
    private baseUrlTheSportsDB = "https://www.thesportsdb.com/api/v1/json/2/lookupplayer.php?id=";

    // Base URL for Back-End API
    private baseUrlBackEndAPI= "https://api.themoviedb.org/3";

    public playerData:any = [];

  constructor(private http: HttpClient) { }


    // Request API with endpoint
    private requestAPI(endpoint: string)
    {
      return this.http.get(`${this.baseUrlTheSportsDB}${endpoint}`);
    }

    getPlayerDataById(id: string) : Observable<any>
    {
      return this.requestAPI(`${id}`);
    }

}
