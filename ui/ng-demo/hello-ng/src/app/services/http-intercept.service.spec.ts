import { TestBed } from '@angular/core/testing';

import { HttpInterceptService } from './http-intercept.service';

describe('HttpInterceptService', () => {
  let service: HttpInterceptService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpInterceptService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
