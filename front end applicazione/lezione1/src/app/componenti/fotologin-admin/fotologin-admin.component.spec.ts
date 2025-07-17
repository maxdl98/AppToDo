import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FotologinAdminComponent } from './fotologin-admin.component';

describe('FotologinAdminComponent', () => {
  let component: FotologinAdminComponent;
  let fixture: ComponentFixture<FotologinAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FotologinAdminComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FotologinAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
