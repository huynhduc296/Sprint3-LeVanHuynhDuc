import { Injectable } from '@angular/core';

import {environment} from "../../environments/environment";
import {HttpClient} from '@angular/common/http';

const API_URl = `${environment.apiURL}`
@Injectable({
  providedIn: 'root'
})
export class PromotionService {

  constructor(private httpClient : HttpClient) { }


}
