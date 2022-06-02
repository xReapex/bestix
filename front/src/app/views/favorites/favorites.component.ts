import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { PlayerServiceService } from 'src/app/services/player-service.service';
import { ApiService } from 'src/app/services/api-service';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.css'],
})
export class FavoritesComponent implements OnInit {
  public playersListData: any = [];
  public favoritesIdList: any = [];
  public favoritesList: any = [];
  public searchedFavorites: any = [];

  /** Current value of the input box */
  currentPlayerNameToSearch = '';
  currentFavoritePlayerNameToSearch = '';

  searchPlayersByNameInput = new FormControl();
  searchFavoritePlayersByNameInput = new FormControl();

  constructor(
    private playerService: PlayerServiceService,
    private apiService: ApiService
  ) {}

  ngOnInit(): void {
    this.getFavoritesByUserId('0');
  }

  async searchPlayersByName() {
    this.playersListData.length = 0;
    this.playerService
      .getPlayersListByName(this.currentPlayerNameToSearch)
      .subscribe(async (response) => {
        this.playersListData.push(response.player);
      });
  }

  getFavoritesByUserId(id: string) {
    this.favoritesIdList.length = 0;
    this.favoritesList.length = 0;

    this.apiService.getFavoritesByUserId(id).subscribe((response) => {
      this.favoritesIdList.push(response);

      for (let i = 0; i < this.favoritesIdList[0].length; i++) {
        this.apiService
          .getPlayerInfos(this.favoritesIdList[0][i])
          .subscribe((response) => {
            this.favoritesList.push(response);
          });
      }
    });
  }

  searchFavoriteByName(name: string) {
    this.searchedFavorites.length = 0;

    for (let i = 0; i < this.favoritesList.length; i++) {
      let favoriteName = this.favoritesList[i]['players'][0]['strPlayer'];

      if (favoriteName.includes(name)) {
        this.searchedFavorites.push(this.favoritesList[i]);
      }
    }
  }
}
