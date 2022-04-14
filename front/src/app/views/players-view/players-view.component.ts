import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { response } from 'express';

import { PlayerServiceService } from 'src/app/services/player-service.service';

@Component({
  selector: 'app-players-view',
  templateUrl: './players-view.component.html',
  styleUrls: ['./players-view.component.css']
})
export class PlayersViewComponent implements OnInit {

  public playerData: any = [];
  public playersListData: any = [];

    /** Current value of the input box */
    currentPlayerNameToSearch = '';

    searchPlayersByNameInput = new FormControl();

  constructor(private playerService: PlayerServiceService) { }

  ngOnInit(): void {
        
    this.playerService.getPlayerDataById("34145934").subscribe(response => 
      {
        this.playerData.push(response);
      })

  }


  searchPlayersByName()
  {
    this.playersListData.length = 0;
    this.playerService.getPlayersListByName(this.currentPlayerNameToSearch).subscribe(response =>
      {
        this.playersListData.push(response);
        console.log(this.playersListData['0']['player']);
        console.log(this.playersListData['0']['player'].length);
      })
  }
}
