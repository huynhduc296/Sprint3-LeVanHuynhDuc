import {ICategory} from './ICategory';
import {IOrderDetail} from './IOrderDetail';

export interface Food {
  totalDetailCart: string;
  fadId: number;
  fadName: string;
  fadImage: string;
  fadCode: string;
  fadPrice: number;
  deleteFlag: boolean;
  category: ICategory;
  quantityPeopleOrder:number;
  orderDetails: IOrderDetail[];
  description:string;
  count : number;
}
