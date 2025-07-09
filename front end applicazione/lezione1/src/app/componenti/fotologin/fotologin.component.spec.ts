import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FotologinComponent } from './fotologin.component';

describe('FotologinComponent', () => {
  let component: FotologinComponent;
  let fixture: ComponentFixture<FotologinComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FotologinComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FotologinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
