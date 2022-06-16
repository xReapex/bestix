import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { debounceTime, scan, startWith, tap } from 'rxjs/operators';

@Component({
  selector: 'app-api-call-test',
  templateUrl: './api-call-test.component.html',
  styleUrls: ['./api-call-test.component.css']
})
export class ApiCallTestComponent implements OnInit {


  //GET
  /** Current value of the input box */
  currentPlayerId = '';
  currentPlayerIdSportsDB = '';

  //POST - Create a player
  currentPlayerName = '';

  //DELETE
  currentDeletePlayerId = '';

  //PUT - Change Player name by Id
  currentPutPlayerId = '';
  currentPutPlayerName = '';

//PUT - Change User name by Id
currentPutUserId = '';
currentPutUserPassword = '';

  /** 
   * Form control for input element where user types
   * Requires ngModule import of ReactiveFormsModule
   */

  //GET 
  getPlayerIdInput = new FormControl();
  getPlayerIdSportsDBInput = new FormControl();

  //POST
  postPlayerNameInput = new FormControl();

  //DELETE
  deletePlayerIdInput = new FormControl();

  //PUT
  putPlayerNameByIdInput = new FormControl();

 //PUT user 
  putUserPasswordByIdInput = new FormControl();


  /** Observable of array of accumulated user inputs */
  history$: Observable<string[]>;



  constructor(private httpClient: HttpClient) {
    this.history$ = this.getPlayerIdInput.valueChanges.pipe(
      debounceTime(500), // wait 1/2 sec until user stops
      startWith(this.currentPlayerId), // initial value
      // tap(t => console.log(t)),
      // Accumlate input values; clear when input is empty
      scan((acc, t) => t ? acc.concat(t) : [], [])
    );
  }

  public value1: string | undefined;
  public playerName: string | undefined;
  public UserPassword: string | undefined;

  ngOnInit(): void {
  }

  testHTTPGetToto() {
    this.httpClient.get('/api/toto').subscribe(response => {
      console.log("[GET] from back : ", response);
    }, error => {
      console.log("[GET] Erreur", error);
    })
    console.log("[EVENT] Button GET Toto pressed");
  }


  testHTTPPutToto() {
    let body = {
      value: 2,
      message: "Message de toto",
      date: new Date(),
      stringList: ["Croissant", "baguette du fromage"]

    }
    this.httpClient.post('/api/toto', body).subscribe(response => {
      console.log("[POST] from back : ", response);
    }, error => {
      console.log("[POST] Erreur", error);
    })
    console.log("[EVENT] Button POST Toto pressed");
  }

  /*
  Players
  */
  getPlayersList() {
    this.httpClient.get('/api/players/all').subscribe(response => {
      console.log("[GET] from back : ", response);
    }, error => {
      console.log("[GET] Erreur", error);
    })
    console.log("[EVENT] Button GET PlayersList pressed");
  }

  getPlayerById() {

    let id = this.currentPlayerId;

    this.httpClient.get('/api/players/' + id).subscribe(response => {
      console.log("[GET] from back : ", response);
    }, error => {
      console.log("[GET] Erreur", error);
    })
    console.log("[EVENT] Button GET Player by ID pressed");

  }

  getExternalPlayerById() {
    //ID Exemple : 34145937
    let id = this.currentPlayerIdSportsDB;

    this.httpClient.get('/api/external/players/' + id).subscribe(response => {
      console.log("[GET] from back : ", response);
    }, error => {
      console.log("[GET] Erreur", error);
    })
    console.log("[EVENT] Button GET Player external pressed");
  }

  postPlayerDefault() {
    let body = {
      playerName: "Franck"
    }


    this.httpClient.post('/api/players/add', body).subscribe(response => {
      console.log("[POST] from back : ", response);
    }, error => {
      console.log("[POST] Erreur", error);
    })
    console.log("[EVENT] Button POST Player pressed");
  }


  postPlayerCustomName() {
    let body = {
      playerName: this.currentPlayerName
    }


    this.httpClient.post('/api/players/add', body).subscribe(response => {
      console.log("[POST] from back : ", response);
    }, error => {
      console.log("[POST] Erreur", error);
    })
    console.log("[EVENT] Button POST Player Name pressed");
  }

  deletePlayerById() {
    let id = this.currentDeletePlayerId;

    this.httpClient.delete('/api/players/' + id).subscribe(response => {
      console.log("[DELETE] from back : ", response);
    }, error => {
      console.log("[DELETE] Erreur", error);
    })
    console.log("[EVENT] Button DELETE Player pressed");
  }

  putPlayerNameById() {
    let id = this.currentPutPlayerId;
    let name = this.currentPutPlayerName;
    let body = { name }

    this.httpClient.put('/api/players/' + id, name).subscribe(response => {
      console.log("[PUT] from back : ", response);
    }, error => {
      console.log("[PUT] Erreur", error);
    })
    console.log("[EVENT] Button PUT Player pressed");

  }

  putUserPasswordById() {
    let id = this.currentPutUserId;
    let password = this.currentPutUserPassword;
    let body = { password }

    this.httpClient.put('/api/user/' + id, password).subscribe(response => {
      console.log("[PUT] from back : ", response);
    }, error => {
      console.log("[PUT] Erreur", error);
    })
    console.log("[EVENT] Button PUT User pressed");
  }


}