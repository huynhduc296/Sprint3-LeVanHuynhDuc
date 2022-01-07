import {Component, DoCheck, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Food} from '../../entity/Food';
import {CartService} from '../../core-module/cart/cart.service';
import {IOrderDetail} from '../../entity/IOrderDetail';
import {FoodService} from '../../core-module/food/food.service';
import {Cart} from '../../entity/Cart';
import {DataService} from '../../entity/data';
import {TokenStorageServiceService} from '../../core-module/token-storage-service.service';
import {LoginComponent} from '../home/login/login.component';
import {MatDialog} from '@angular/material/dialog';
import {Router} from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit,DoCheck  {
  @ViewChild('paypalRef', {static: true})
  isLogin: boolean = false;
  productCart: any;
  listOrder!: IOrderDetail [];
  food!: Food [];
  public products: any;
  grandTotal: number;
  totalAll: number;
  totalUsd: number;
  cart: Cart[] = [];
  paymentGateway: any;

  constructor(private cartService: CartService, private foodService: FoodService, private data: DataService
    , private tokenStorageService: TokenStorageServiceService, private dialog: MatDialog,private paypalRef: ElementRef,
      private router:Router) {
  }



  ngOnInit(): void {
    this.getCartFromLocalstorage();
    this.sendNumberOfCartToHeader();
    this.cartService.getProduct().subscribe(data => {
      this.products = data;
      this.grandTotal = this.cartService.getTotalPrice();
    });
    this.getAllFood();
    this.checkToken();
  }

  setLocalStorage() {
    const value = JSON.stringify(this.cart);
    localStorage.setItem('CART', value);
  }

  paypal() {
    window.paypal.Buttons(
      {
        style: {
          layout: 'horizontal',
          size: 'small',
          color:  'blue',
          shape:  'pill',
          label:  'pay',
          height: 40,
          tagline: 'false'
        },
        funding: {
          allowed: [ paypal.FUNDING.CARD ],
          disallowed: [ paypal.FUNDING.CREDIT ]
        },
        createOrder:(data, actions) => {
          return actions.order.create({
            purchase_units: [
              {
                amount: {
                  value: 1000000-this.totalUsd,
                  currency_code: 'USD'
                }
              }
            ]
          });
        },
        onApprouve:(data, actions) => {
          return actions.order.capture().then(details => {
            alert('transaction completed');
          });
        },
        onError: error => {
          console.log(error);
        }
      }
    ).render(this.paypalRef.nativeElement,window.localStorage.removeItem('CART'));
  }

  getCartFromLocalstorage() {
    const value = JSON.parse(<string> localStorage.getItem('CART'));
    if (value) {
      this.cart = value;
    }
    this.getCart();
  }

  getAllFood() {
    this.foodService.getAllFood().subscribe(data => {
      this.food = data;
      this.getCartFromLocalstorage();
      // console.log(this.food)
    });
  }

  sendNumberOfCartToHeader() {
    this.data.changeNumber(this.cart.length);
  }

  removeCart(id: number) {
    for (let i = 0; i < this.cart.length; i++) {
      if (this.cart[i].id === id) {
        this.cart.splice(i, 1);
      }
    }
    this.setLocalStorage();
    this.getCart();
  }

  getCart() {
    this.totalAll = 0;
    for (let i = 0; i < this.cart.length; i++) {
      this.foodService.getByIdFood(this.cart[i].id).subscribe(data => {
        console.log(this.data);
        this.cart[i].name = data.fadName;
        this.cart[i].price = data.fadPrice;
        this.cart[i].img = data.fadImage;
        this.cart[i].description = data.description;
        this.cart[i].total = this.cart[i].price * this.cart[i].count;
        this.totalAll += this.cart[i].total;
        this.totalUsd =Math.floor(this.totalAll/23)
        console.log(this.totalUsd)
      }, error => {
      });
    }
  }

  checkToken() {
    if (this.tokenStorageService.getUser() == null) {
      this.isLogin = false;
      this.openDialog();
    } else {
      this.isLogin = true;
    }
  }
  openDialog() {
    const dialogRef = this.dialog.open(LoginComponent, {
      panelClass: 'my-bg',
      width: '500px'
    });
  }

  ngDoCheck(): void {
    this.totalAll;
  }

  totalAlls() {
    this.paypal();
  }
}
