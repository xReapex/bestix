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
  matchId: any;

  @Input()
  id1: any;

  @Input()
  id2: any;

  @Input()
  equipe1: any;
  @Input()
  equipe2: any;
  @Input()
  date: any;

  
  selectedTeam: any;
  radio1State: any;
  radio2State: any;

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
      const url = `http://localhost:8080/api/matchs/bet/matchId=` + this.matchId + `&selectedTeamId=`+ this.selectedTeam + `&userId=0`;
      console.log("matchId : " + this.matchId);
      alert(url);
    }
  }

  onItemChange(event: any){

    console.log(" Value is : ", event.target.id );
    this.selectedTeam = event.target.id;
 }
 
  

}
