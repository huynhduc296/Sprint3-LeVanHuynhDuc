import { Component, OnInit } from '@angular/core';
import {FoodService} from "../../core-module/food/food.service";
import {Food} from "../../entity/Food";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  listFoodTrend!: Food [];
  constructor(private foodService: FoodService) {

  }


  ngOnInit(): void {
    this.getAllTrend();
  }

  getAllTrend() {
    this.foodService.getListTrend().subscribe(next => {
      this.listFoodTrend = next;
      console.log(this.listFoodTrend);
    })
  }
}
