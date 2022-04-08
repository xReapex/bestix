import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {

  // Use HttpClient
  constructor(private http: HttpClient) {}
}
