import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-betting-card',
  templateUrl: './betting-card.component.html',
  styleUrls: ['./betting-card.component.css']
})
export class BettingCardComponent implements OnInit {

  @Input()
  team1: any | undefined;
  @Input()
  team2: any |undefined;
  @Input()
  utcDate: any | undefined;
  @Input()
  status: any | undefined;

  constructor() {}

  ngOnInit(): void {

  }

}
