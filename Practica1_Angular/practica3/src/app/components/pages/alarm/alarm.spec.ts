import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Alarm } from './alarm';

describe('Alarm', () => {
  let component: Alarm;
  let fixture: ComponentFixture<Alarm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Alarm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Alarm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
