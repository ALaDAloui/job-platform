import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntrepriseCandidatureComponent } from './entreprise-candidature.component';

describe('EntrepriseCandidatureComponent', () => {
  let component: EntrepriseCandidatureComponent;
  let fixture: ComponentFixture<EntrepriseCandidatureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EntrepriseCandidatureComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EntrepriseCandidatureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
