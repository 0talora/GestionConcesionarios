import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Inventario } from '../../../core/models/inventario.model';
import { InventarioService } from '../../../core/services/inventario.service';

@Component({
  selector: 'app-cars-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cars-list.html',
  styleUrl: './cars-list.css'
})
export class CarsList implements OnInit {
  inventario: Inventario[] = [];
  cargando = false;
  error = '';

  constructor(private inventarioService: InventarioService) {}

  ngOnInit(): void {
    this.cargando = true;
    this.inventarioService.getInventario().subscribe({
      next: (data) => {
        this.inventario = data;
        this.cargando = false;
      },
      error: (err) => {
        this.error = 'Error cargando inventario';
        console.error(err);
        this.cargando = false;
      }
    });
  }
}
