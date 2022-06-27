import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ApiService } from 'src/app/services/api-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form-league',
  templateUrl: './form-league.component.html',
  styleUrls: ['./form-league.component.css'],
})
export class FormLeagueComponent implements OnInit {
  successCreation: boolean = false;
  errorCreation: boolean = false;

  currentLeagueName = '';
  currentNbPlayers = '';
  currentChampionnat = '';
  currentPassword = '';

  getLeagueInfos = new FormControl();

  public leaguesAvailable: any = [];

  constructor(private httpClient: HttpClient, private apiService: ApiService, private route:Router) {
    this.leaguesAvailable = [
      {
        code: 'FL1',
        name: 'Ligue 1',
      },
      {
        code: 'FL2',
        name: 'Ligue 2',
      },
      {
        code: 'ABL',
        name: 'Bundesliga',
      },
      {
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
      this.currentPassword == ''
    ) {
      this.errorCreation = true;
      this.successCreation = false;
    } else {
      let body = {};
      let url =
        'http://45.147.98.151:8080/api/league/name=' +
        this.currentLeagueName +
        '&nbPlayers=' +
        this.currentNbPlayers +
        '&championnat=' +
        0 +
        '&password=' +
        this.currentPassword;

      this.httpClient.post(url, body).subscribe(
        (response) => {
          console.log('[POST] from back : ', response);
          this.successCreation = true;
          this.errorCreation = false;
          this.route.navigate(['/leagues']);
        },
        (error) => {
          console.log('[POST] Erreur', error);
        }
      );
    }
  }
}
