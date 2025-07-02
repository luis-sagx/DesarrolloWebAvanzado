import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardTours } from './card-tours';

describe('CardTours', () => {
  let component: CardTours;
  let fixture: ComponentFixture<CardTours>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardTours]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardTours);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
