import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MenuRoutingModule} from "./menu-routing.module";
import {MenuComponent} from "./menu.component";
import {NgxPaginationModule} from "ngx-pagination";
import {FormsModule} from "@angular/forms";
import {Ng2SearchPipeModule} from "ng2-search-filter";





@NgModule({
  declarations: [MenuComponent],
  imports: [
    MenuRoutingModule,
    CommonModule,
    NgxPaginationModule,
    FormsModule,

    Ng2SearchPipeModule,
    // ShareModule
  ]

})
export class MenuModule { }
