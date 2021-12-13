import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntrepriseProfilComponent } from './entreprise-profil.component';

describe('EntrepriseProfilComponent', () => {
  let component: EntrepriseProfilComponent;
  let fixture: ComponentFixture<EntrepriseProfilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EntrepriseProfilComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EntrepriseProfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
