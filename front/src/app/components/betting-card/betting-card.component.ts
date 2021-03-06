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

  @Input()
  score1: any;
  @Input()
  score2: any;

  @Input()
  canBet: any;

  @Input()
  hasWin: any;

  selectedTeam: any;
  selectedTeamName: any;
  radio1State: any;
  radio2State: any;

  canBetOnCard:boolean=true;
  hasBet:boolean=false;

  betFunction() {
    this.canBetOnCard=false;
    this.hasBet=true;
  }

  constructor( private appService: ApiService ) {}

  isSubmitted = false;

  ngOnInit(): void {
    this.appService.getNextMatch().subscribe(matchs => {
      this.matchsList.push(matchs);
      this.matchsList = this.matchsList[0]['matches']
      //console.log(this.matchsList)
    })

  }



  submitForm(form: NgForm): any {
    this.isSubmitted = true;
    if (!form.valid) {
      return false;
    } else {
      const url = `http://localhost:8080/api/matchs/bet/matchId=` + this.matchId + `&selectedTeamId=`+ this.selectedTeam + `&userId=0`;
      console.log("matchId : " + this.matchId);
      //alert(url);

      let defaultUserId = "0";
      this.appService.saveMatchBetByUserId(this.matchId, this.selectedTeam, defaultUserId).subscribe(response => {
        console.log("POST BET");
      });
    }
  }

  onItemChange(event: any){

    console.log(" Value is : ", event.target.id );
    this.selectedTeam = event.target.id;
 }



}
