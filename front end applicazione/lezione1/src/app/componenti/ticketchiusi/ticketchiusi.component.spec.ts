import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketchiusiComponent } from './ticketchiusi.component';

describe('TicketchiusiComponent', () => {
  let component: TicketchiusiComponent;
  let fixture: ComponentFixture<TicketchiusiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TicketchiusiComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TicketchiusiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
