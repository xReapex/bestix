import { DatePipe } from '@angular/common';
import { Component, EventEmitter, Input, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiService } from 'src/app/services/api-service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

 matchsList: any = [];
 nextMatchList: any = [];
 prevMatchList: any = [];
 betResusltList: any = [];
 matchInfos: any = [];

  constructor(private appService: ApiService) {
  }

  ngOnInit(): void {
    this.getBetResults();
    this.getMatchs();
    this.changeFormat();

    //this.testDates();

  }

  getBetResults()
  {
    this.appService.getBetResultsByUserId("0").subscribe(results => {
      this.betResusltList.push(results);
      console.log("betResultList : ");
      console.log(this.betResusltList[0]);
    });
  }

  compareDatesForMatches()
  {
    for(let i = 0; i < this.matchsList[0].length; i++)
    {

      let date1 = new Date(this.matchsList[0][i].date);
      let date2 = new Date(this.changedDate);
      let hasWin = 0;

      if(date1 < date2)
      {


        if (this.betResusltList) {
          for(let j = 0; j <= this.betResusltList.length; j++)
          {
            if(this.betResusltList[0][j].idMatch == this.matchsList[0][i].id)
            {
              hasWin = this.betResusltList[0][j].hasWin;
            }

          }
        }


        //this.prevMatchList.push(this.matchsList[0][i]);

        this.matchInfos = {
          'matchId' : this.matchsList[0][i].id,
          'id1' : this.matchsList[0][i].firstTeamID,
          'id2' : this.matchsList[0][i].secondTeamID,
          'firstTeamName' : this.matchsList[0][i].firstTeamName,
          'secondTeamName' : this.matchsList[0][i].secondTeamName,
          'firstTeamScore' : this.matchsList[0][i].firstTeamScore,
          'secondTeamScore' : this.matchsList[0][i].secondTeamScore,
          'date' : this.matchsList[0][i].date,
          'hasWin' : hasWin,
          'betTeamName' : 0
        }

        this.prevMatchList.push(this.matchInfos);
      }
      else
      {
        this.nextMatchList.push(this.matchsList[0][i]);
      }
    }


    console.log("prevMatchList : ");
    console.log(this.prevMatchList);

    console.log("nextMatchList : ");
    console.log(this.nextMatchList);
  }

  //TESTS DATES
  today = new Date();
  changedDate = '';
  pipe = new DatePipe('en-US');
  ChangedFormat: any;

  changeFormat(){
    this.ChangedFormat = this.pipe.transform(this.today, 'MM/dd/YYYY');
    this.changedDate = this.ChangedFormat;
    console.log(this.changedDate);
  }


  testDates()
  {
    let date1 = new Date(this.changedDate);
    let date2 = new Date('12/30/2023');

    console.log("Date 1 : " + date1);
    console.log("Date 2 : " + date2);

    if (date1.getDate() === date2.getDate())
    {
      console.log("mm date");
    }
    else if(date1.getDate() > date2.getDate())
    {
      console.log("date 1 > date 2");
    }
    else if(date1.getDate() < date2.getDate())
    {
      console.log("date 1 < date 2");
    }
  }

  getMatchs()
  {
    this.appService.getMatchListFromBack().subscribe(matchs => {
      console.log(matchs);
      this.matchsList.push(matchs);
      this.compareDatesForMatches();
    })
  }


}
