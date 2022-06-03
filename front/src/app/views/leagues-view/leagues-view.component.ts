import { Component, OnInit } from '@angular/core';
import { response } from 'express';
import { ApiService } from 'src/app/services/api-service';

@Component({
  selector: 'app-leagues-view',
  templateUrl: './leagues-view.component.html',
  styleUrls: ['./leagues-view.component.css']
})
export class LeaguesViewComponent implements OnInit {

  public leaguesList: any = [];

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.getLeaguesList();
  }

  getLeaguesList()
  {
    this.apiService.getLeaguesList().subscribe((response) =>
    {
      this.leaguesList.push(response);
      console.log(this.leaguesList);
    });
  }

}
