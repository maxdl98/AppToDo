import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InformazioniComponent } from './informazioni.component';

describe('InformazioniComponent', () => {
  let component: InformazioniComponent;
  let fixture: ComponentFixture<InformazioniComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InformazioniComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InformazioniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
