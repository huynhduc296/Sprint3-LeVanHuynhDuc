import {Injectable} from '@angular/core';
import {BehaviorSubject} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class DataService {
  private number = new BehaviorSubject<number>(0);
  currentNumber = this.number;

  constructor() {
  }

  changeNumber(num: number) {
    this.number.next(num);
  }

}
