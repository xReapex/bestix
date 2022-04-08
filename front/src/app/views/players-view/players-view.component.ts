import { Component, OnInit } from '@angular/core';
import { response } from 'express';

import { PlayerServiceService } from 'src/app/services/player-service.service';

@Component({
  selector: 'app-players-view',
  templateUrl: './players-view.component.html',
  styleUrls: ['./players-view.component.css']
})
export class PlayersViewComponent implements OnInit {

  public playerData: any = [];

  constructor(private playerService: PlayerServiceService) { }

  ngOnInit(): void {
        
    this.playerService.getPlayerDataById("34145934").subscribe(response => 
      {
        this.playerData.push(response);
      })

  }

}
