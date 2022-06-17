import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form-league',
  templateUrl: './form-league.component.html',
  styleUrls: ['./form-league.component.css']
})
export class FormLeagueComponent implements OnInit {

  public leaguesAvailable: any = [];

  constructor() {
    this.leaguesAvailable = [
      {
        "code": "FL1",
        "name": "Ligue 1"
      },
      {
        "code": "FL2",
        "name": "Ligue 2"
      },
      {
        "code": "ABL",
        "name": "Bundesliga"
      },
      {
        "code": "BEL",
        "name": "Coupe de Belgique"
      },
    ]
  }

  ngOnInit(): void {
  }

}
