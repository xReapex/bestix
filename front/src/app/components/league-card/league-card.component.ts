import { Component, Input, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ApiService } from 'src/app/services/api-service';

@Component({
  selector: 'app-league-card',
  templateUrl: './league-card.component.html',
  styleUrls: ['./league-card.component.css']
})
export class LeagueCardComponent implements OnInit {

  @Input()
  leagueId: string | undefined;
  @Input()
  leagueName: string | undefined;
  @Input()
  nbPlayers: string | undefined;
  @Input()
  championnat: string | undefined;
  @Input()
  showJoinInput: string | undefined;

  formLeaguePassword = new FormControl();
  textLeaguePassword = '';

  successJoin: boolean | undefined;
  errorJoin: boolean | undefined;
  hasUsers: boolean | undefined;

  public userList: any = [];

  //DEFAULT
  userId = "0";

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.getUserList();
  }


getUserList()
{
  let leagueId = (this.leagueId == undefined)?"empty":this.leagueId;
  console.log("League ID : " + leagueId);

  this.apiService.getLeagueUserList(leagueId).subscribe((response) =>
  {
    
    this.userList.push(response);
    console.log("userList size : " + this.userList[0].length);

    if(this.userList[0].length == 0)
    {
      this.userList[0].push("Aucun joueur n'a encore rejoins cette ligue.");
      this.hasUsers = false;
    }
    else
    {
      this.hasUsers = true;
    }

  });
}


joinLeague(event: any)
{
  let leagueId = event.target.id;
  console.log("leagueId : " + leagueId + " text : " + this.textLeaguePassword);

  this.apiService.requestLeagueAccess(leagueId, this.textLeaguePassword, this.userId).subscribe((response) =>
  {
    if(!response)
    {
      this.errorJoin = true;
      this.successJoin = false;
      setTimeout(() => {
        this.errorJoin = false;
        this.successJoin = false;
   }, 3000)
    }
    else
    {
      this.errorJoin = false;
      this.successJoin = true;
      setTimeout(() => {
        this.errorJoin = false;
        this.successJoin = false;
        window.location.reload();
   }, 3000)
    }

  });

}

}
