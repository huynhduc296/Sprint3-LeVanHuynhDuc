import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {CommonModule} from "@angular/common";
import {MenuComponent} from "./menu.component";



const routes: Routes = [
  {path :"menu",component:MenuComponent}
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes),

  ],
  exports: [RouterModule]
})
export class MenuRoutingModule {
}
