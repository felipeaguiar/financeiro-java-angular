import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LancamentoPesquisaComponent } from './lancamento-pesquisa/lancamento-pesquisa.component';

const routes: Routes = [
  { path: '', component: LancamentoPesquisaComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LancamentoRoutingModule { }
