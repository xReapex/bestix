import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-league-card',
  templateUrl: './league-card.component.html',
  styleUrls: ['./league-card.component.css']
})
export class LeagueCardComponent implements OnInit {

  @Input()
  leagueName: string | undefined;
  @Input()
  nbPlayers: string | undefined;

  constructor() { }

  ngOnInit(): void {
  }

}
