// import {Component, OnInit} from '@angular/core';
//
// import {Router} from '@angular/router';
//
// import {ToastrService} from 'ngx-toastr';
// import {Cart} from '../../entity/Cart';
// import {CartService} from '../../core-module/cart/cart.service';
// import {FoodService} from '../../core-module/food/food.service';
// import {TokenStorageServiceService} from '../../core-module/token-storage-service.service';
//
//
// @Component({
//   selector: 'app-comfirm-paypal',
//   templateUrl: './comfirm-paypal.component.html',
//   styleUrls: ['./comfirm-paypal.component.css']
// })
// export class ComfirmPaypalComponent implements OnInit {
//   username: any;
//   carts: Cart[] = [];
//   totalMoney: number = 0;
//
//   constructor(private cartService: CartService,
//               private router: Router,
//               private foodService: FoodService,
//               private tokenStorage: TokenStorageServiceService,
//               private toast: ToastrService
//   ) {
//   }
//
//   ngOnInit(): void {
//     this.getCart();
//     this.totalMoneyOfFood();
//     this.sendNumberOfCartToHeader();
//     this.username = this.tokenStorage.getUser().username;
//     console.log('aaaaaaaaa=  ' + this.username);
//   }
//
//
//   sendNumberOfCartToHeader() {
//     this.cartService.changeNumberCart(this.carts.length);
//   }
//
//   // confirm() {
//   //   this.toast.success('Thanh Toán Thành Công');
//   //   localStorage.clear();
//   //   this.router.navigateByUrl('');
//   // }
//
//   getCart() {
//     this.carts = this.cartService.getItems();
//     console.log('get cart localSto' + this.carts);
//   }
//
//   totalMoneyOfFood() {
//     console.log(this.carts);
//     for (let i = 0; i < this.carts.length; i++) {
//       this.totalMoney += this.carts[i].price * this.carts[i].count;
//     }
//   }
//
//   // create(carts: Cart[]) {
//   //   this.foodService.CreateTransaction(carts, this.username).subscribe(data => {
//   //     this.toast.success('tao moi thanh cong');
//   //   });
//   // }
//
//   confirm(carts: Cart[]) {
//     console.log(carts);
//     console.log('confirm= ' + this.username);
//     this.foodService.CreateOrders(carts, this.username).subscribe(data => {
//       this.toast.success('Shipper Sẽ Nhanh Chóng Giao Hàng Cho Bạn ');
//       localStorage.clear();
//       this.router.navigateByUrl('');
//     }, error => (
//       this.toast.error('Tạo mới thất bại')
//     ));
//   }
// }
