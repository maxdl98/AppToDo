import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TabellaUtentiComponent } from './tabella-utenti.component';

describe('TabellaUtentiComponent', () => {
  let component: TabellaUtentiComponent;
  let fixture: ComponentFixture<TabellaUtentiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TabellaUtentiComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TabellaUtentiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
