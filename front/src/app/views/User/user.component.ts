import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
@Component({
  selector: 'user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

//PUT - Change User name by Id
currentPutUserId = '';
currentPutUserPassword = '';

  //PUT user 
  putUserPasswordByIdInput = new FormControl();



  constructor(private  httpClient: HttpClient) { }
  public UserPassword: string | undefined;


  ngOnInit(): void {
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
    console.log("[EVENT] Button PUT Player pressed");
  }

}
