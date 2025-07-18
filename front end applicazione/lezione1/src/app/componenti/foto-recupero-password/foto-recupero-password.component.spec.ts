import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FotoRecuperoPasswordComponent } from './foto-recupero-password.component';

describe('FotoRecuperoPasswordComponent', () => {
  let component: FotoRecuperoPasswordComponent;
  let fixture: ComponentFixture<FotoRecuperoPasswordComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FotoRecuperoPasswordComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FotoRecuperoPasswordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
