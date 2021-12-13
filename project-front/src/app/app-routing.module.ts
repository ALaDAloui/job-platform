import { CandidatExamenComponent } from './components/examen/candidat-examen/candidat-examen.component';
import { CandidatListfavoriteComponent } from './components/candidat-listfavorite/candidat-listfavorite.component';
import { CandidatCandidatureComponent } from './components/candidat-candidature/candidat-candidature.component';
import { EntrepriseOffreListComponent } from './components/entreprise-offre-list/entreprise-offre-list.component';
import { OffrePostulerComponent } from './components/offre-postuler/offre-postuler.component';
import { EntrepriseProfilComponent } from './components/entreprise-profil/entreprise-profil.component';
import { RegisterCandidatComponent } from './components/register-candidat/register-candidat.component';
import { RegisterEntrepriseComponent } from './components/register-entreprise/register-entreprise.component';
import { OffreDetailComponent } from './components/offre-detail/offre-detail.component';
import { CandidatProfilComponent } from './components/candidat-profil/candidat-profil.component';
import { CandidatService } from './services/candidat.service';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CandidatDetailComponent } from './components/candidat-detail/candidat-detail.component';
import { ListcandidatComponent } from './components/candidat-list/listcandidat.component';
import { HomeComponent } from './components/home/home.component';
import { LayoutComponent } from './components/layout/layout.component';
import { LoginComponent } from './components/login/login.component';
import { OffreListComponent } from './components/offre-list/offre-list.component';
import { EntrepriseCandidatureComponent } from './components/entreprise-candidature/entreprise-candidature.component';
import { EntrepriseProfilUpdateComponent } from './components/entreprise-profil-update/entreprise-profil-update.component';
import { AdminEntrepriseComponent } from './components/admin-entreprise/admin-entreprise.component';
import { AddExamenComponent } from './components/examen/add-examen/add-examen.component';
import { ListExamenComponent } from './components/examen/list-examen/list-examen.component';
import { DetailExamenComponent } from './components/examen/detail-examen/detail-examen.component';
import { AuthGuard } from './guards/auth.guard';
import { Auth1Guard } from './guards/auth1.guard';
import { PdfComponent } from './components/pdf/pdf.component';
import { CandidatEntretienComponent } from './components/candidat-entretien/candidat-entretien.component';
import { EntrepriseEntretienComponent } from './components/entreprise-entretien/entreprise-entretien.component';

const routes: Routes = [
  {path:'pdf/:id',component:PdfComponent},
  {path:'',component:HomeComponent, children:[
    {path:'',component:LayoutComponent},
    {path:'login',component:LoginComponent},
    {path:'list',component:ListcandidatComponent},
    {path:'detail/:id',component:CandidatDetailComponent},
    {path:'profil',canActivate:[Auth1Guard],component:CandidatProfilComponent},
    {path:'profilEntreprise',component:EntrepriseProfilComponent},
    {path:'listoffre',component:OffreListComponent},
    {path:'detailoffre/:id',component:OffreDetailComponent},
    {path:'registerE',component:RegisterEntrepriseComponent},
    {path:'registerC',component:RegisterCandidatComponent},
    {path:'postuloffre',canActivate:[AuthGuard],component:OffrePostulerComponent},
    {path:'entrepriseoffre',canActivate:[AuthGuard],component:EntrepriseOffreListComponent},
    {path:'listcandidature/:id',canActivate:[AuthGuard],component:EntrepriseCandidatureComponent},
    {path:'listentretien/:id',canActivate:[AuthGuard],component:EntrepriseEntretienComponent},
    {path:'profilEntrepriseUpdate',canActivate:[AuthGuard],component:EntrepriseProfilUpdateComponent},
    {path:'adminE',component:AdminEntrepriseComponent},
    {path:'candidatureC',canActivate:[Auth1Guard],component:CandidatCandidatureComponent},
    {path:'listfavorite',canActivate:[Auth1Guard],component:CandidatListfavoriteComponent},
    {path:'addexamen',canActivate:[AuthGuard],component:AddExamenComponent},
    {path:'listexamen/:id',canActivate:[AuthGuard],component:ListExamenComponent},
    {path:'detailexamen/:id',canActivate:[AuthGuard],component:DetailExamenComponent},
    {path:'candidatexamen/:id',canActivate:[Auth1Guard],component:CandidatExamenComponent},
    {path:'listentretienC',canActivate:[Auth1Guard],component:CandidatEntretienComponent},















  ]}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
