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

  constructor(private appService: ApiService) {
  }

  ngOnInit(): void {
    this.getMatchs();
  }

  getMatchs()
  {
    this.appService.getMatchListFromBack().subscribe(matchs => {
      console.log(matchs);
      this.matchsList.push(matchs);
    })
  }


}