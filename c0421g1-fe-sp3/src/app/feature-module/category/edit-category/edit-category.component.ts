import { Component, OnInit } from '@angular/core';
import {CategoryService} from "../../../core-module/category/category.service";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-edit-category',
  templateUrl: './edit-category.component.html',
  styleUrls: ['./edit-category.component.css']
})
export class EditCategoryComponent implements OnInit {

  constructor(private categoryService:CategoryService) { }
  category: FormGroup = new FormGroup({
    categoryName: new FormControl(),
    categoryCode: new FormControl()
  });
  ngOnInit(): void {
  }
  findBy(id:number){
    this.categoryService.findById(id).subscribe()
  }
  update(){}
}
