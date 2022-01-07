import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import {HomeModule} from "./feature-module/home/home.module";
import {HttpClientModule} from "@angular/common/http";
import {MenuModule} from "./feature-module/menu/menu.module";
import { CartComponent } from './feature-module/cart/cart.component';
import { CategoryComponent } from './feature-module/category/category.component';
import { CreateCategoryComponent } from './feature-module/category/create-category/create-category.component';
import { HeaderComponent } from './feature-module/header/header.component';
import { FooterComponent } from './feature-module/footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatDialog, MatDialogModule} from "@angular/material/dialog";
import { DeleteCategoryComponent } from './feature-module/category/delete-category/delete-category.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { EditCategoryComponent } from './feature-module/category/edit-category/edit-category.component';
import { FoodComponent } from './feature-module/food/food.component';
import { CreateFoodComponent } from './feature-module/food/create-food/create-food.component';
import { DeleteFoodComponent } from './feature-module/food/delete-food/delete-food.component';
import { EditFoodComponent } from './feature-module/food/edit-food/edit-food.component';
import { DetailFoodComponent } from './feature-module/food/detail-food/detail-food.component';
import {LoginComponent} from './feature-module/home/login/login.component';
import {ToastrModule} from 'ngx-toastr';





@NgModule({
  declarations: [
    AppComponent,
    CartComponent,
    CategoryComponent,

    CreateCategoryComponent,
     HeaderComponent,
     FooterComponent,
     DeleteCategoryComponent,
     EditCategoryComponent,
     FoodComponent,
     CreateFoodComponent,
     DeleteFoodComponent,
     EditFoodComponent,
     DetailFoodComponent,
      LoginComponent,

  ],
  imports: [

    BrowserModule,
    AppRoutingModule,
    HomeModule,
    MenuModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatDialogModule,
    MatSnackBarModule,
    FormsModule,
    ReactiveFormsModule,
    ToastrModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
