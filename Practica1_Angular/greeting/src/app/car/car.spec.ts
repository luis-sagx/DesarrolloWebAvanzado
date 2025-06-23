import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Car } from './car';

describe('Car', () => {
  let component: Car;
  let fixture: ComponentFixture<Car>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Car]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Car);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
