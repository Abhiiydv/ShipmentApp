import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShipmentRegisterationComponent } from './shipment-registeration.component';

describe('ShipmentRegisterationComponent', () => {
  let component: ShipmentRegisterationComponent;
  let fixture: ComponentFixture<ShipmentRegisterationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShipmentRegisterationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShipmentRegisterationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
