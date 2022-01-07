import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmPaypalComponent } from './confirm-paypal.component';

describe('ConfirmPaypalComponent', () => {
  let component: ConfirmPaypalComponent;
  let fixture: ComponentFixture<ConfirmPaypalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConfirmPaypalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfirmPaypalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
