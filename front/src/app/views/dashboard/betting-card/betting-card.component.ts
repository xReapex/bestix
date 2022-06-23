import { Component, OnInit, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AnyCatcher } from 'rxjs/internal/AnyCatcher';
import { ApiService } from 'src/app/services/api-service';
import { DashboardComponent } from 'src/app/views/dashboard/dashboard.component'

@Component({
  selector: 'app-betting-card',
  templateUrl: './betting-card.component.html',
  styleUrls: ['./betting-card.component.css']
})
export class BettingCardComponent implements OnInit {

  //public matchs = matchsList;

  @Input() 
  matchsList: any;
  @Input()
  equipe1: any;
  @Input()
  equipe2: any;
  @Input()
  date: any;

  

  constructor( private appService: ApiService ) {}

  isSubmitted = false;

  ngOnInit(): void {

  }
  submitForm(form: NgForm): any {
    this.isSubmitted = true;
    if (!form.valid) {
      return false;
    } else {
      //alert(JSON.stringify( 'turl' + form.value))
      const choix = JSON.stringify(form.value)
      const url = `http://localhost:8080/api/matchs/bet/matchId=` + this.matchsList[0][0].id + `&selectedTeamId=`+ this.matchsList[0][0].firstTeamID+ `&userId=0`;
      alert(url);
    }
  }
  

}
