import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Temporizator } from './temporizator';

describe('Temporizator', () => {
  let component: Temporizator;
  let fixture: ComponentFixture<Temporizator>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Temporizator]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Temporizator);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
