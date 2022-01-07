import {Food} from "./Food";
import {IOrders} from "./IOrders";

export interface IOrderDetail {
  order: IOrders;
  fad: Food;
  quantity: number;
  totalDetailCart: number; // total  nay la cua tung cart
  totalMoney:number; //  total cua tong card
}
