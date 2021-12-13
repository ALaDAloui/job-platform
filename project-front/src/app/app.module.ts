import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { HeaderComponent } from './components/header/header.component';
import { LayoutComponent } from './components/layout/layout.component';
import { FooterComponent } from './components/footer/footer.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ListcandidatComponent } from './components/candidat-list/listcandidat.component';
import { CandidatDetailComponent } from './components/candidat-detail/candidat-detail.component';
import { CandidatProfilComponent } from './components/candidat-profil/candidat-profil.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { OffreListComponent } from './components/offre-list/offre-list.component';
import { OffreDetailComponent } from './components/offre-detail/offre-detail.component';
import { RegisterCandidatComponent } from './components/register-candidat/register-candidat.component';
import { RegisterEntrepriseComponent } from './components/register-entreprise/register-entreprise.component';
import { RecherchePipe } from './pipes/recherche.pipe';
import { RecherchetitlePipe } from './pipes/recherchetitle.pipe';
import { EntrepriseProfilComponent } from './components/entreprise-profil/entreprise-profil.component';
import { OffrePostulerComponent } from './components/offre-postuler/offre-postuler.component';
import { EntrepriseOffreListComponent } from './components/entreprise-offre-list/entreprise-offre-list.component';
import { EntrepriseCandidatureComponent } from './components/entreprise-candidature/entreprise-candidature.component';
import { EntrepriseProfilUpdateComponent } from './components/entreprise-profil-update/entreprise-profil-update.component';
import { AdminEntrepriseComponent } from './components/admin-entreprise/admin-entreprise.component';
import { CandidatCandidatureComponent } from './components/candidat-candidature/candidat-candidature.component';
import { CandidatListfavoriteComponent } from './components/candidat-listfavorite/candidat-listfavorite.component';
import { AddExamenComponent } from './components/examen/add-examen/add-examen.component';
import { ListExamenComponent } from './components/examen/list-examen/list-examen.component';
import { DetailExamenComponent } from './components/examen/detail-examen/detail-examen.component';
import { CandidatExamenComponent } from './components/examen/candidat-examen/candidat-examen.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { PdfViewerModule } from 'ng2-pdf-viewer';
import { PdfComponent } from './components/pdf/pdf.component';
import { CandidatEntretienComponent } from './components/candidat-entretien/candidat-entretien.component';
import { EntrepriseEntretienComponent } from './components/entreprise-entretien/entreprise-entretien.component';
import { SocialLoginModule, SocialAuthServiceConfig } from 'angularx-social-login';
import { GoogleLoginProvider, FacebookLoginProvider} from 'angularx-social-login';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    LayoutComponent,
    FooterComponent,
    LoginComponent,
    ListcandidatComponent,
    CandidatDetailComponent,
    CandidatProfilComponent,
    OffreListComponent,
    OffreDetailComponent,
    RegisterCandidatComponent,
    RegisterEntrepriseComponent,
    RecherchePipe,
    RecherchetitlePipe,
    EntrepriseProfilComponent,
    OffrePostulerComponent,
    EntrepriseOffreListComponent,
    EntrepriseCandidatureComponent,
    EntrepriseProfilUpdateComponent,
    AdminEntrepriseComponent,
    CandidatCandidatureComponent,
    CandidatListfavoriteComponent,
    AddExamenComponent,
    ListExamenComponent,
    DetailExamenComponent,
    CandidatExamenComponent,
    PdfComponent,
    CandidatEntretienComponent,
    EntrepriseEntretienComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule,
    NgxPaginationModule,
    PdfViewerModule,
    SocialLoginModule

  ],
  providers: [
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
