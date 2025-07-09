import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpeedDisplay } from './speed-display';

describe('SpeedDisplay', () => {
  let component: SpeedDisplay;
  let fixture: ComponentFixture<SpeedDisplay>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SpeedDisplay]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SpeedDisplay);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
