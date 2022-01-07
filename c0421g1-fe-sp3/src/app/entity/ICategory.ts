import {Food} from './Food';

export interface ICategory {
  categoryId: number;
  categoryName: string;
  categoryCode: string;
  foodAndDrink: Food[];
  deleteFlag: boolean;
}
