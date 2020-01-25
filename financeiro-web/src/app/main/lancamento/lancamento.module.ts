import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LancamentoPesquisaComponent } from './lancamento-pesquisa/lancamento-pesquisa.component';
import { LancamentoCadastroComponent } from './lancamento-cadastro/lancamento-cadastro.component';
import { LancamentoRoutingModule } from './lancamento-routing.module';
import { SharedModule } from 'src/app/shared/shared.module';

import { InputTextModule } from 'primeng/inputtext';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import {TooltipModule} from 'primeng/tooltip';

@NgModule({
  declarations: [
    LancamentoPesquisaComponent,
    LancamentoCadastroComponent
  ],
  imports: [
    CommonModule,
    LancamentoRoutingModule,
    SharedModule,
    InputTextModule,
    TableModule,
    ButtonModule,
    TooltipModule
  ]
})
export class LancamentoModule { }
