import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { PlayerServiceService } from 'src/app/services/player-service.service';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.css']
})
export class FavoritesComponent implements OnInit {

  public playerData: any = [];
  public playersListData: any = [];

    /** Current value of the input box */
    currentPlayerNameToSearch = '';

    searchPlayersByNameInput = new ReactiveFormsModule();

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
