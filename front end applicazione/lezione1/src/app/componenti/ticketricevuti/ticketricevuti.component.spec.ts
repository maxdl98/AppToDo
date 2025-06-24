import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketricevutiComponent } from './ticketricevuti.component';

describe('TicketricevutiComponent', () => {
  let component: TicketricevutiComponent;
  let fixture: ComponentFixture<TicketricevutiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TicketricevutiComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TicketricevutiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
