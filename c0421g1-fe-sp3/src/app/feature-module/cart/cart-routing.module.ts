import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {CommonModule} from "@angular/common";
import {CartComponent} from "./cart.component";




const routes: Routes = [
  {path :"cart",component:CartComponent}
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes),

  ],
  exports: [RouterModule]
})
export class CartRoutingModule {
}
