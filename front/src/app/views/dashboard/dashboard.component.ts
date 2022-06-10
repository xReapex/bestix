import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api-service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  public matchsList: any = [];

  constructor(private appService: ApiService ) {
  }

  ngOnInit(): void {
    this.appService.getMatchListFromBack().subscribe(matchs => {
      this.matchsList.push(matchs);
      console.log(this.matchsList)

      console.log(this.matchsList[0][4].id);
    })

    /*this.appService.getPredictions().subscribe(matchs => {
      this.matchsList.push(matchs);
      console.log(this.matchsList)
    })*/
  }

}
