import {Injectable} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";
import {ICategory} from "../../entity/ICategory";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private urlCategory = "http://localhost:8080/api/category/list";
  private urlCategoryCreate = "http://localhost:8080/api/category/create";
  private urlDeleteCategory = "http://localhost:8080/api/category/delete";
  private urlUpdateCategory = "http://localhost:8080/api/category/update";
  private urlFindByCategory = "http://localhost:8080/api/category/find";

  constructor(private http: HttpClient) {
  }

  getAllCategory(): Observable<ICategory | any> {
    return this.http.get(this.urlCategory);
  }

  createCategory(product: any): Observable<ICategory | any> {
    return this.http.post(this.urlCategoryCreate, product);
  }

  findById(id: number): Observable<ICategory | any> {
    return this.http.get(this.urlFindByCategory + "/" + id);
  }

  updateCategory(product: any): Observable<ICategory | any> {
    return this.http.patch(this.urlUpdateCategory, product);
  }

  deleteCategory(id: number, product: any): Observable<ICategory | any> {
    return this.http.patch(this.urlDeleteCategory + "/" + id, product);
  }
}
