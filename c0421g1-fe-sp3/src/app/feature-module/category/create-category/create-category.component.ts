import {Component, OnInit} from '@angular/core';
import {CategoryService} from "../../../core-module/category/category.service";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-create-category',
  templateUrl: './create-category.component.html',
  styleUrls: ['./create-category.component.css']
})
export class CreateCategoryComponent implements OnInit {
  category: FormGroup = new FormGroup({
    categoryName: new FormControl(),
    categoryCode: new FormControl()
  });

  constructor(private categoryService: CategoryService) {
  }

  ngOnInit(): void {
  }

  createCategory() {
    this.categoryService.createCategory(this.category.value).subscribe(data => {
      console.log(data);
      console.log(this.category.value);
      window.location.reload();
    })
  }
}
