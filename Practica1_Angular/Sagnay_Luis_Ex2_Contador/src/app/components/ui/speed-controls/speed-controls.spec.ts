import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpeedControls } from './speed-controls';

describe('SpeedControls', () => {
  let component: SpeedControls;
  let fixture: ComponentFixture<SpeedControls>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SpeedControls]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SpeedControls);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
