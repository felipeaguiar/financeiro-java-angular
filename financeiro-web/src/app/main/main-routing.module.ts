import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './main.component';

const routes: Routes = [
  {
    path: 'main',
    component: MainComponent,
    children: [
      { path: '', loadChildren: './home/home.module#HomeModule' },
      { path: 'lancamento', loadChildren: './lancamento/lancamento.module#LancamentoModule' }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainRoutingModule {}
