import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaprovaComponent } from './paginaprova.component';

describe('PaginaprovaComponent', () => {
  let component: PaginaprovaComponent;
  let fixture: ComponentFixture<PaginaprovaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PaginaprovaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PaginaprovaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
