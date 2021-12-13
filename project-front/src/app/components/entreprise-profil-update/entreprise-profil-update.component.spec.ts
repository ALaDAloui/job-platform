import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntrepriseProfilUpdateComponent } from './entreprise-profil-update.component';

describe('EntrepriseProfilUpdateComponent', () => {
  let component: EntrepriseProfilUpdateComponent;
  let fixture: ComponentFixture<EntrepriseProfilUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EntrepriseProfilUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EntrepriseProfilUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
