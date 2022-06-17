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
  public joinedLeagueList: any = [];
  public canJoin: string | undefined;

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.getLeaguesList();
    this.checkIfAlreadyInLeagues();
    this.canJoin = "true"; // ou = undefined
  }

  getLeaguesList()
  {
    this.apiService.getLeaguesList().subscribe((response) =>
    {
      this.leaguesList.push(response);
      console.log(this.leaguesList);
    });
  }

  checkIfAlreadyInLeagues()
  {
    let defaultUserId = '0';
    this.apiService.checkJoinedLeaguesByUserId(defaultUserId).subscribe((response) =>
    {
      console.log("already in league" + response);
      this.joinedLeagueList.push(response);
      console.log("joinedLeagueList :");
      console.log(this.joinedLeagueList);
    });
  }

}
