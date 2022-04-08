import { TestBed } from '@angular/core/testing';

<<<<<<< HEAD:front/src/app/services/api-service.spec.ts
import { ApiService } from './api-service';
=======
import { ApiServiceService } from './api.service';
>>>>>>> origin/main:front/src/app/services/api.service.spec.ts

describe('ApiServiceService', () => {
  let service: ApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
