import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EsercizioComponent } from './EsercizioComponent';

describe('EsercizioComponent', () => {
  let component: EsercizioComponent;
  let fixture: ComponentFixture<EsercizioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EsercizioComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EsercizioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
