import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ApiService } from 'src/app/services/api-service';

@Component({
  selector: 'app-form-league',
  templateUrl: './form-league.component.html',
  styleUrls: ['./form-league.component.css'],
})
export class FormLeagueComponent implements OnInit {
  successCreation: boolean = false;
  errorCreation: boolean = false;
  currentChampionnat = Number ([1]) ;
  currentLeagueName = '';
  currentNbPlayers = '';

  currentPassword = '';

  getLeagueInfos = new FormControl();

  public leaguesAvailable: any = [];

  constructor(private httpClient: HttpClient, private apiService: ApiService) {
    this.leaguesAvailable = [
      {
        id: 0,
        code: 'FL1',
        name: 'Ligue 1',
      },
      {
        id : 1,
        code: 'FL2',
        name: 'Ligue 2',
      },
      {
        id : 2,
        code: 'ABL',
        name: 'Bundesliga',
      },
      {
        id : 3,
        code: 'BEL',
        name: 'Coupe de Belgique',
      },
    ];
  }

  ngOnInit(): void {
    this.apiService.getLeaguesList().subscribe((response) => {
      console.log(response);
    });
  }

  createLeague() {
    console.log('Name = ' + this.currentLeagueName);
    console.log('NbPlayers = ' + this.currentNbPlayers);
    console.log('Championnat = ' + this.currentChampionnat);
    console.log('Password = ' + this.currentPassword);

    if (
      this.currentLeagueName == '' ||
      this.currentNbPlayers == '' ||
      this.currentChampionnat == Number ('')||
      this.currentPassword == ''
    ) {
      this.errorCreation = true;
      this.successCreation = false;
    } else {
      let body = {};
      let url =
        '/api/league/name=' +
        this.currentLeagueName +
        '&nbPlayers=' +
        this.currentNbPlayers +
        '&championnat=' +
        this.currentChampionnat+
        '&password=' +
        this.currentPassword;

      this.httpClient.post(url, body).subscribe(
        (response) => {
          console.log('[POST] from back : ', response);
          this.successCreation = true;
          this.errorCreation = false;
        },
        (error) => {
          console.log('[POST] Erreur', error);
        }
      );
    }
  }

  /*addClicked(event: any)
  {
    console.log('ok '+ this.currentChampionnat);

  }*/

  changeClient(event:any) {
    console.log(this.currentChampionnat);
}

}
