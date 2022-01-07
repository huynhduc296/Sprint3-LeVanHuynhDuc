import {Food} from './Food';

export interface ProductInCart {
  food:Food;
  quantity:number;
  totalDetailCart:number;
}
