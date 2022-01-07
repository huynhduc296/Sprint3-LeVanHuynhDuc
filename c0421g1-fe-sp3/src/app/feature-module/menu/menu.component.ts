import {Component, OnInit} from '@angular/core';
import {FoodService} from "../../core-module/food/food.service";
import {Food} from "../../entity/Food";
import {CategoryService} from "../../core-module/category/category.service";
import {ICategory} from "../../entity/ICategory";
import {CartService} from "../../core-module/cart/cart.service";
import {IOrderDetail} from "../../entity/IOrderDetail";
import {Cart} from '../../entity/Cart';
import {ToastrService} from 'ngx-toastr';
import {DataService} from '../../entity/data';
import {TokenStorageServiceService} from '../../core-module/token-storage-service.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  foods : Food[] = [];
  listFoodTrend!: Food [];
  category!: ICategory [];
  searchFood: any
  productList: any;
  //phan trang
  totalPrice: number = 0;
  totalLength: any;
  page: number = 1;
  id!: number;
  foodCart: Cart;
  cart: Cart[] = [];
  food: Food;
  obj!: IOrderDetail [];
  public cartItem: [] | any;
  public foodTest:Food[]=[];



  constructor(private foodService: FoodService,
              private categoryService: CategoryService,
              private cartService: CartService,
              private data: DataService,
              private toast : ToastrService,
              private token: TokenStorageServiceService,
  ) {
  }

  ngOnInit(): void {
    this.getCategory();
    this.getAllFood();
    this.getAllTrend();
    this.getCartFromLocalstorage();
    this.sendNumberOfCartToHeader();
    this.foodService.getAllFood().subscribe(data => {
      this.productList = data;
      this.productList.forEach((a: any) => {
        Object.assign(a, {quantity: 1, total: a.price});
      })
    })
  }

  getCategory() {
    this.categoryService.getAllCategory().subscribe(next => {
      this.category = next;
      // console.log(next);
    })
  }

  findFoodById(id: number) {
    this.foodService.getByIdFood(id).subscribe(data => {
      this.food = data
    }, error => {
      console.log(error)
    })
  }

  getAllFood() {
    this.foodService.getAllFood().subscribe(data => {
      this.foods = data
      console.log(this.foods)
    }, error => {
      console.log(error)
    })
  }

  getAllTrend() {
    this.foodService.getListTrend().subscribe(data => {
      this.listFoodTrend = data;
    })
  }

  getAllFoodFindCategory(id: number) {
    this.foodService.getFoodFinbyCategory(id).subscribe(data => {
      this.foods = data;
      // console.log(this.listFood);
    })
  }

  getSortAtoZ() {
    this.foodService.getSortAToZ().subscribe(data => {
      this.foods = data;
      // console.log(this.listFood);
    })
  }

  addToCart(id: number) {

    this.id = id;
    this.findFoodById(this.id);
    this.addFoodToLocalstorage(id);
    this.sendNumberOfCartToHeader();
  }

  // findFoodById(id: number) {
  //   this.foodService.findFoodById(id).s=(data => {
  //     this.food = data
  //   }, error => {
  //     console.log(error)
  //   })
  // }

  sendNumberOfCartToHeader() {
    this.data.changeNumber(this.cart.length);
  }

  getCartFromLocalstorage() {
    const value = JSON.parse(<string>localStorage.getItem('CART'))
    if(value){
      this.cart =value
    }
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
      this.foodCart = {id: id, total:1, count:1, price: 0,name:"", img: '',description:'',quantityPeopleOrder:''}
      this.cart.push(this.foodCart)
      this.toast.success("Thêm vào giỏ hàng thành công" , "Thông báo")
    }
    const cart = JSON.stringify(this.cart);
    localStorage.setItem('CART', cart);
  }

}

