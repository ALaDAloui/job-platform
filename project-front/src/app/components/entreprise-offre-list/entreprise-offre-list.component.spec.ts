import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntrepriseOffreListComponent } from './entreprise-offre-list.component';

describe('EntrepriseOffreListComponent', () => {
  let component: EntrepriseOffreListComponent;
  let fixture: ComponentFixture<EntrepriseOffreListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EntrepriseOffreListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EntrepriseOffreListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
