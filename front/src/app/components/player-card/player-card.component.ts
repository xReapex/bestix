import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-player-card',
  templateUrl: './player-card.component.html',
  styleUrls: ['./player-card.component.css']
})
export class PlayerCardComponent implements OnInit {
  
  @Input()
  playerName: string | undefined;
  @Input()
  playerDesc: string | undefined;
  @Input()
  playerImage: string | undefined;

  public playerData: any = [];

  constructor() { }

  ngOnInit(): void {
  }

}
