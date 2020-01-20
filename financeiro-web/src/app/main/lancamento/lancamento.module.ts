import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LancamentoPesquisaComponent } from './lancamento-pesquisa/lancamento-pesquisa.component';
import { LancamentoCadastroComponent } from './lancamento-cadastro/lancamento-cadastro.component';
import { LancamentoRoutingModule } from './lancamento-routing.module';
import {InputTextModule} from 'primeng/inputtext';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  declarations: [
    LancamentoPesquisaComponent,
    LancamentoCadastroComponent
  ],
  imports: [
    CommonModule,
    LancamentoRoutingModule,
    InputTextModule,
    SharedModule
  ]
})
export class LancamentoModule { }
