import { HttpClientModule } from '@angular/common/http';
import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CarCard } from './features/cars/car-card/car-card';
import { CarDetail } from './features/cars/car-detail/car-detail';
import { CarFilter } from './features/cars/car-filter/car-filter';
import { CarsList } from './features/cars/cars-list/cars-list';

@Component({
  selector: 'app-root',
  imports: [
    RouterOutlet,
    CarCard,
    CarFilter,
    CarsList,
    CarDetail,
    HttpClientModule
  ],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App {
  protected readonly title = signal('FrontWeb');
}
