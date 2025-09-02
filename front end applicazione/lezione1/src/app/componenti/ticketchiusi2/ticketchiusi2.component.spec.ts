import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ticketchiusi2Component } from './ticketchiusi2.component';

describe('Ticketchiusi2Component', () => {
  let component: Ticketchiusi2Component;
  let fixture: ComponentFixture<Ticketchiusi2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ticketchiusi2Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ticketchiusi2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
