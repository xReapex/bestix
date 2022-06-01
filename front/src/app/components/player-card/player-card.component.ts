import { Component, Input, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api-service';
import { FavoritesComponent } from 'src/app/views/favorites/favorites.component';

@Component({
  selector: 'app-player-card',
  templateUrl: './player-card.component.html',
  styleUrls: ['./player-card.component.css']
})
export class PlayerCardComponent implements OnInit {

  @Input()
  alreadyInFavorites: string | undefined;
  @Input()
  playerId: string | undefined;
  @Input()
  playerName: string | undefined;
  @Input()
  playerDesc: string | undefined;
  @Input()
  playerImage: string | undefined;
  @Input()
  playerTeam: string | undefined;

  constructor(private apiService: ApiService, private favoritesComponent: FavoritesComponent) { }

  ngOnInit(): void {
    if(!this.playerDesc)
    {
      this.playerDesc = "No description available";
    }
    if(!this.playerImage)
    {
      this.playerImage = "https://pbs.twimg.com/profile_images/798356695860723712/-NpEsPw9_400x400.jpg";
    }
  }

  addClicked(event: any)
  {
    let playerId = event.target.id;
     this.apiService.savePlayerAsFavorite(playerId).subscribe(response =>
      {
      } )
      //this.favoritesComponent.moveCardToFavorites(playerId);

  }

   //TO FIX
  removeClicked(event: any)
  {
    let playerId = event.target.id;
    //alert("the button for player : " + playerId + " has been clicked");
    this.apiService.deleteFavorite(playerId).subscribe(response =>
      {
        //console.log(response);
      })

  }

}
