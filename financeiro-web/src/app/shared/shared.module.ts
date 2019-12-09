import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TopbarHeaderComponent } from './theme/topbar-header/topbar-header.component';
import { LeftSidebarComponent } from './theme/left-sidebar/left-sidebar.component';
import { FooterComponent } from './theme/footer/footer.component';
import { BreadCrumbComponent } from './theme/bread-crumb/bread-crumb.component';
import { PageContainerComponent } from './theme/page-container/page-container.component';

@NgModule({
  declarations: [
    TopbarHeaderComponent,
    LeftSidebarComponent,
    FooterComponent,
    BreadCrumbComponent,
    PageContainerComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    TopbarHeaderComponent,
    LeftSidebarComponent,
    FooterComponent,
    BreadCrumbComponent,
    PageContainerComponent
  ]
})
export class SharedModule { }
