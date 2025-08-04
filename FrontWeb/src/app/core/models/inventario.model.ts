// src/app/core/models/inventario.model.ts

export type Combustible = 'Gasolina' | 'Diésel' | 'Eléctrico' | 'Híbrido' | 'GNC' | 'GLP' | 'Hidrógeno';
export type Estado = 'Disponible' | 'Reservado' | 'Revisión' | 'Vendido';

export interface Inventario {
  id: number;
  modelo_id: number;
  color: string;
  anio: number;
  kilometraje: number;
  caballos: number;
  combustible: Combustible;
  cubicaje: number;
  concesionario_id: number;
  estado: Estado;
  duenos_previos: number;
  version?: string | null;
  matricula: string;
  pais_origen: string;
  precio_compra: number;
  precio_venta: number;
}
