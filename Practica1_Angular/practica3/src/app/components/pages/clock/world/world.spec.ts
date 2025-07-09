import { ComponentFixture, TestBed } from '@angular/core/testing';

import { World } from './world';

describe('World', () => {
  let component: World;
  let fixture: ComponentFixture<World>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [World]
    })
    .compileComponents();

    fixture = TestBed.createComponent(World);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
