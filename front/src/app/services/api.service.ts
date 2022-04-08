import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  // Use HttpClient
  constructor(private http: HttpClient) {}

  // Api base url
  private baseUrl = "http://localhost:8080/api";

  // Request API with endpoint
  private requestAPI(endpoint: String)
  {
    return this.http.get(`${this.baseUrl}${endpoint}`);
  }

  getPlayersByName(name: string) {
    return this.requestAPI(`/players/${name}`)
  }

  sayHello() {
    return this.requestAPI('/hello')
  }

}
