import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormLeagueComponent } from './form-league.component';

describe('FormLeagueComponent', () => {
  let component: FormLeagueComponent;
  let fixture: ComponentFixture<FormLeagueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormLeagueComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormLeagueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
