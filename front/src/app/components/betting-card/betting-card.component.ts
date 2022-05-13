import { Component, OnInit, Input } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-betting-card',
  templateUrl: './betting-card.component.html',
  styleUrls: ['./betting-card.component.css']
})
export class BettingCardComponent implements OnInit {

  testTeam1: string = "test";
  testTeam2: string = "test2";

  @Input()
  team1: any | undefined;
  @Input()
  team2: any | undefined;
  @Input()
  utcDate: any | undefined;
  @Input()
  status: any | undefined;

  constructor() { }

  isSubmitted = false;

  ngOnInit(): void {

  }

  submitForm(form: NgForm): any {
    this.isSubmitted = true;
    if(!form.valid) {
      return false;
    } else {
    alert(JSON.stringify(form.value))
    }
  }


  

}
