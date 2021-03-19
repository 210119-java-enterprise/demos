import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnotherAppComponent } from './another-app.component';

describe('AnotherAppComponent', () => {
  let component: AnotherAppComponent;
  let fixture: ComponentFixture<AnotherAppComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnotherAppComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnotherAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
