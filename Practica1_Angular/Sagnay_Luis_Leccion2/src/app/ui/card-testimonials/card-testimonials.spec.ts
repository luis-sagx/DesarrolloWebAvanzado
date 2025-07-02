import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardTestimonials } from './card-testimonials';

describe('CardTestimonials', () => {
  let component: CardTestimonials;
  let fixture: ComponentFixture<CardTestimonials>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardTestimonials]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardTestimonials);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
