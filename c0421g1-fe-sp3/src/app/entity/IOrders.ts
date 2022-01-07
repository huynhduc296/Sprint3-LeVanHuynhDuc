import {IEmployee} from './IEmployee';
import {IOrderDetail} from './IOrderDetail';

export interface IOrders {
  orderId: number;
  orderCode: string;
  createDate: string;
  employee: IEmployee;
  orderDetails: IOrderDetail[];
}
