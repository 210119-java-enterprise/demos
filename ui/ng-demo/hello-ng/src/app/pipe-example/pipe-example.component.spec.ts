import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PipeExampleComponent } from './pipe-example.component';

describe('PipeExampleComponent', () => {
  let component: PipeExampleComponent;
  let fixture: ComponentFixture<PipeExampleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PipeExampleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PipeExampleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
