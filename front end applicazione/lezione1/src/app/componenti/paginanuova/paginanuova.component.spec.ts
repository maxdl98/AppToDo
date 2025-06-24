import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginanuovaComponent } from './paginanuova.component';

describe('PaginanuovaComponent', () => {
  let component: PaginanuovaComponent;
  let fixture: ComponentFixture<PaginanuovaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PaginanuovaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PaginanuovaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
