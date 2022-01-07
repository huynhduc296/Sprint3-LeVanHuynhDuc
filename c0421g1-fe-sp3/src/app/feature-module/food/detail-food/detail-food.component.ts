import {Component, OnInit} from '@angular/core';
import {FoodService} from "../../../core-module/food/food.service";
import {Food} from "../../../entity/Food";
import {ActivatedRoute} from "@angular/router";
import {Cart} from '../../../entity/Cart';
import {IOrderDetail} from '../../../entity/IOrderDetail';
import {CategoryService} from '../../../core-module/category/category.service';
import {CartService} from '../../../core-module/cart/cart.service';
import {DataService} from '../../../entity/data';
import {ToastrService} from 'ngx-toastr';
import {TokenStorageServiceService} from '../../../core-module/token-storage-service.service';

@Component({
  selector: 'app-detail-food',
  templateUrl: './detail-food.component.html',
  styleUrls: ['./detail-food.component.css']
})
export class DetailFoodComponent implements OnInit {
  detail!: Food;
  idParam!: number;
  foodRandome!: Food[];
  productList: any;
  page: number = 1;
  id!: number;
  foodCart: Cart;
  cart: Cart[] = [];
  food: Food;
  obj!: IOrderDetail [];
  foods : Food[] = [];
  constructor(private foodService: FoodService,
              private active: ActivatedRoute,
              private categoryService: CategoryService,
              private cartService: CartService,
              private data: DataService,
              private toast : ToastrService,
              private token: TokenStorageServiceService) {
  }

  ngOnInit(): void {
    this.getByIdDetail();
    this.sendNumberOfCartToHeader();
    this.foodService.getAllFood().subscribe(data => {
      this.productList = data;
      this.productList.forEach((a: any) => {
        Object.assign(a, {quantity: 1, total: a.price});
      })
    })
  }

  getByIdDetail() {
    this.active.params.subscribe(data => {
      this.idParam = data['id'];
      console.log(this.idParam);
      this.foodService.getByIdFood(this.idParam).subscribe(next => {
        this.detail = next;
        console.log(this.detail);
      })
    })
  }

  // getRandome() {
  //   this.foodService.getRandomeFour().subscribe(data => {
  //     this.foodRandome = data;
  //   })
  // }

  findFoodById(id: number) {
    this.foodService.getByIdFood(id).subscribe(data => {
      this.food = data
    }, error => {
      console.log(error)
    })
  }

  addToCart(id: number) {
    this.id = id;
    this.findFoodById(id);
    this.addFoodToLocalstorage(id)
    this.sendNumberOfCartToHeader()
  }

  sendNumberOfCartToHeader() {
    this.data.changeNumber(this.cart.length);
  }

  addFoodToLocalstorage(id: number) {
    console.log(id)
    let check = true;
    for (let i = 0; i < this.cart.length; i++) {
      if (this.cart[i].id === id) {
        this.cart[i].count += 1
        check = false;
        this.toast.success("Sản phẩm đã có trong giỏ hàng + 1" , "Thông báo")
      }
    }

    if (check) {
      this.foodCart = {id: id, total:1, count: 1, price: 0,name:"", img: '',description:'',quantityPeopleOrder:''}
      this.cart.push(this.foodCart)
      this.toast.success("Thêm vào giỏ hàng thành công" , "Thông báo")
    }
    const cart = JSON.stringify(this.cart);
    localStorage.setItem('CART', cart);
  }
}
