import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  stringJson: any;
  stringObject: any;
  public matchsList: any = [];

  constructor(private appService: ApiService ) {
  }

  ngOnInit(): void {
    this.appService.getNextMatch().subscribe(matchs => {
      this.matchsList.push(matchs);
      this.stringJson = JSON.stringify(this.matchsList[0]['matches']);
      console.log("String json object :", this.stringJson);
      console.log("Type :", typeof this.stringJson);

      this.stringObject = JSON.parse(this.stringJson);
      console.log("JSON object -", this.stringObject);
   //   this.matchsList = this.matchsList[0]['matches']
     // console.log(this.matchsList)
    })

    /*this.appService.getPredictions().subscribe(matchs => {
      this.matchsList.push(matchs);
      console.log(this.matchsList)
    })*/
  }

}
