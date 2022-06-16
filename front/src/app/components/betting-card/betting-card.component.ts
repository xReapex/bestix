import { Component, OnInit, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ApiService } from 'src/app/services/api-service';

@Component({
  selector: 'app-betting-card',
  templateUrl: './betting-card.component.html',
  styleUrls: ['./betting-card.component.css']
})
export class BettingCardComponent implements OnInit {

  public matchsList: any = [];

  @Input()
  match: any | undefined;
  @Input()
  team1Name: any | undefined;
  @Input()
  team2Name: any |undefined;
  @Input()
  utcDate: any | undefined;
  @Input()
  status: any | undefined;

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
      const url = `http://localhost:8080/api/matchs/bet/matchId=` + this.match + `&selectedTeamId=`+ choix + `&userId=0`;
      alert(url);
    }
  }
  

}
