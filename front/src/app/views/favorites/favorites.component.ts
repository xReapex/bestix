import { Component, OnInit } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { PlayerServiceService } from 'src/app/services/player-service.service';
import { ApiService } from 'src/app/services/api-service';
import { response } from 'express';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.css']
})
export class FavoritesComponent implements OnInit {

  public playersListData: any = [];
  public favoritesIdList: any = [];
  public favoritesList: any = [];
  public searchedFavorites: any = [];

    /** Current value of the input box */
    currentPlayerNameToSearch = '';

    searchPlayersByNameInput = new FormControl();

  constructor(private playerService: PlayerServiceService, private apiService: ApiService) { }

  ngOnInit(): void {
    this.getFavoritesByUserId('0');
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


  getFavoritesByUserId(id: string)
  {
    this.favoritesIdList.length = 0;
    this.favoritesList.length = 0;

    this.apiService.getFavoritesByUserId(id).subscribe(response =>
      {
        this.favoritesIdList.push(response);

        for(let i = 0; i < this.favoritesIdList[0].length; i++)
        {
          console.log(this.favoritesIdList[0][0]);
          this.apiService.getPlayerInfos(this.favoritesIdList[0][i]).subscribe(response =>
            {
              this.favoritesList.push(response);
              console.log(this.favoritesList);
            });
        }

      });
  }

  searchFavoriteByName(name: string)
  {
    console.log("name : " + name);
    this.searchedFavorites.length = 0;

    for(let i = 0; i < this.favoritesList.length; i++)
    {
      let favoriteName = this.favoritesList[i]['players'][0]['strPlayer'];

      if( favoriteName.includes(name))
      {
        this.searchedFavorites.push(this.favoritesList[i]);
        console.log(this.searchedFavorites);
      }
    }

  }
}
