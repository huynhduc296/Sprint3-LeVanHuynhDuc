import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from "rxjs";
import {Food} from "../../entity/Food";
import {environment} from '../../../environments/environment';
import {TokenStorageServiceService} from '../token-storage-service.service';
import {Cart} from '../../entity/Cart';

const API_URl = `${environment.apiURL}`
@Injectable({
  providedIn: 'root'
})
export class FoodService {
  httpOptions: any;
  private  API_URL = 'http://localhost:8080/home';
  private urlTrend = "http://localhost:8080/api/food/listTrend";
  private urlList = "http://localhost:8080/api/food/list";
  private urlFindFoodCategory = "http://localhost:8080/api/food/food-category";
  private urlSortaToz = "http://localhost:8080/api/food/food/sort/a-z";
  private urlfindFood = "http://localhost:8080/api/food/find";
  private urlrandome = "http://localhost:8080/api/food/list/randome";

  constructor(private httpClient: HttpClient , private tokenStorage: TokenStorageServiceService) {
    this.httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json', Authorization: `Bearer ` + this.tokenStorage.getToken()})
      , 'Access-Control-Allow-Origin': 'http://localhost:4200',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
    }
  }

  getAllFood(): Observable<Food | any> {
    return this.httpClient.get(this.urlList);
  }

  getListTrend(): Observable<Food | any> {
    return this.httpClient.get(this.urlTrend);
  }

  getFoodFinbyCategory(id: number): Observable<| Food | any> {
    return this.httpClient.get(this.urlFindFoodCategory + "/" + id)
  }

  getSortAToZ(): Observable<Food | any> {
    return this.httpClient.get(this.urlSortaToz);
  }

  getByIdFood(id: number): Observable<Food | any> {
    return this.httpClient.get(this.urlfindFood + "/" + id);
  }

  CreateOrders(carts: Cart[], username: string): Observable<any> {
    console.log(carts);
    console.log(username);
    return this.httpClient.post<any>(this.API_URL + '/orders/' + username, {cartDtoList: carts}, this.httpOptions);
  }

}
