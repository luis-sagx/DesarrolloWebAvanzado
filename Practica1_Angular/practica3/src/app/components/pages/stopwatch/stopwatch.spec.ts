import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Stopwatch } from './stopwatch';

describe('Stopwatch', () => {
  let component: Stopwatch;
  let fixture: ComponentFixture<Stopwatch>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Stopwatch]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Stopwatch);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
