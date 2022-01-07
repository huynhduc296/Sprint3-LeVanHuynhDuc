import {Component, OnInit} from '@angular/core';
import {CategoryService} from "../../core-module/category/category.service";
import {ICategory} from "../../entity/ICategory";
import {MatDialog} from "@angular/material/dialog";
import {DeleteCategoryComponent} from "./delete-category/delete-category.component";
import {FoodService} from "../../core-module/food/food.service";
import {Food} from "../../entity/Food";
import {MatSnackBar} from "@angular/material/snack-bar";
import {CreateCategoryComponent} from "./create-category/create-category.component";
import {EditCategoryComponent} from "./edit-category/edit-category.component";

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  categoryList!: ICategory [];
  food!: Food [] | any;

  constructor(private categoryService: CategoryService, private dialog: MatDialog, private foodService: FoodService, private snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.categoryService.getAllCategory().subscribe(data => {
      this.categoryList = data;

    })
  }

  create() {
    this.dialog.open(CreateCategoryComponent);
  }

  edit(categoryId:number,categoryName:string,product:any) {
    this.dialog.open(EditCategoryComponent),{
      data: {
        id: categoryId,
        name: categoryName
      }
    };
  }

  delete(categoryId: number, categoryName: string, product: any) {
    let dialog = this.dialog.open(DeleteCategoryComponent, {
      data: {
        id: categoryId,
        name: categoryName
      }
    })
    dialog.afterClosed().subscribe(data => {
      this.foodService.getFoodFinbyCategory(categoryId).subscribe(data => {
        if (data == `true`) {

        }
        this.food = data;
        console.log(this.food);
        if (this.food === null) {
          this.categoryService.deleteCategory(categoryId, product).subscribe(data => {

          }, error => {
            console.log("hi")
            this.snackBar.open("Bạn đã xóa thành công " + categoryName, "", {duration: 4000})
            window.location.reload();
          })
        } else if (this.food != null) {

          this.snackBar.open("Loại này đã có food không thể xóa", "", {duration: 2000});
        } else {
          alert("hello")
        }
      })
    })
  }
}
