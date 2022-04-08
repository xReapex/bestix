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


  constructor() { }

  ngOnInit(): void {
    console.log(this.playerDesc);

    if(!this.playerDesc)
    {
      this.playerDesc = "No description available";
    }
    if(!this.playerImage)
    {
      this.playerImage = "https://pbs.twimg.com/profile_images/798356695860723712/-NpEsPw9_400x400.jpg";
    }
  }

}
