import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MessaggioAutomaticoComponent } from './messaggio-automatico.component';

describe('MessaggioAutomaticoComponent', () => {
  let component: MessaggioAutomaticoComponent;
  let fixture: ComponentFixture<MessaggioAutomaticoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MessaggioAutomaticoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MessaggioAutomaticoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
