import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
  }


testHTTPGet() {
  this.httpClient.get('/api/toto').subscribe(response => {
    console.log("[GET] from back : ", response);
    } , error => {
      console.log("ohhh", error);
    } )
console.log("coucou");
}


testHTTPPUT()
{
  let body = {
    value: 2,
    message: "Salut",
    date: new Date(),
    stringList: ["hello", "hello2"]

  }
  this.httpClient.post('/api/toto', body).subscribe(response => {
    console.log("[POST] from back : ", response);
    } , error => {
      console.log("ohhh", error);
    } )
console.log("coucou");
}


}
