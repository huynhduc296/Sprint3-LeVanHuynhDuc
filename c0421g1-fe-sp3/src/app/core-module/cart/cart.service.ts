import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {Food} from "../../entity/Food";
import {HttpClient} from "@angular/common/http";
import {IOrderDetail} from "../../entity/IOrderDetail";
import {Cart} from '../../entity/Cart';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  cart: Cart;
  check: boolean = false
  public cartItemList: IOrderDetail | any = [];
  public productList = new BehaviorSubject<any>([]);
  private urlFindCustomer = "http://localhost:8080/api/order-detail/list/customer";
  private urlCreateCart = "http://localhost:8080/api/order-detail/create";
  // numberCart = new BehaviorSubject<number>(0);

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
  }

  getProduct() {
    return this.productList.asObservable();
  }

  getTotalPrice(): any {
    let grandTotal = 0;
    for (let i in this.cartItemList) {
      grandTotal += this.cartItemList[i].totalDetailCart;
    }

    console.log(grandTotal);
    return grandTotal;
  }

}
