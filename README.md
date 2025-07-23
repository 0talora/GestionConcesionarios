# GestionConcesionarios

# 🚗 Gestión de Concesionarios

Este proyecto permite a concesionarios de automóviles gestionar su inventario de vehículos y mostrar su catálogo al público. Está dividido en varias partes, con funcionalidades en desarrollo y otras en uso.

> ⚠️ Proyecto en desarrollo activo. Actualmente se está construyendo la API con Spring Boot y se ha definido la base de datos junto a datos de prueba iniciales.

---

## 🧩 Componentes del proyecto

- 🧠 **API REST (Java 24 + Spring Boot)**  
  Backend encargado de la lógica de negocio, persistencia de datos, autenticación y autorización. Expone endpoints REST que son consumidos por la web.

- 🖥️ **Web interna (Angular 20)**  
  Interfaz de gestión para los empleados del concesionario: edición de inventario, gestión del estado de los vehículos y panel administrativo.

- 🌐 **Web pública (Angular 20)**  
  Sitio destinado a los clientes, donde podrán consultar el catálogo de vehículos disponibles con buscador y filtros.

- 📱 **App móvil (Kotlin Multiplatform)**  
  *Funcionalidad futura*: Aplicación multiplataforma (Android/iOS) que se conectará a la API REST para consultar el catálogo de vehículos desde dispositivos móviles.

- 👥 **Gestión de usuarios para empleados**  
  *Funcionalidad futura*: Los empleados podrán acceder mediante usuarios autenticados para gestionar el inventario.

- 🐬 **Base de datos (MySQL + Docker)**  
  La base de datos del sistema corre en un contenedor Docker con **MySQL**, permitiendo un entorno de desarrollo reproducible y portable.

---

## 🎯 Funcionalidades principales

- Registro y gestión de vehículos por concesionario  
- Gestión del estado del vehículo por empleados. Los estados disponibles son:  
  - `Disponible`  
  - `Reservado`  
  - `Revisión`  
  - `Vendido`  
- Búsqueda y filtrado por marca, modelo, año, precio, etc.  
- Panel administrativo con métricas clave  
- Catálogo público accesible desde web  
- *Futuro*: App móvil para usuarios finales  
- *Futuro*: Gestión de usuarios y autenticación para empleados  
- Contenedor Docker para la base de datos con datos de prueba

---

## ⚠️ Nota importante

Este proyecto es **personal** y forma parte del portfolio de desarrollo del autor. Aunque todas las funcionalidades estarán disponibles para que puedan probarse en un entorno local o de desarrollo, **no está pensado para ser publicado ni desplegado en producción**. Su objetivo principal es servir como demostración técnica y aprendizaje.

---

## 🛠️ Tecnologías utilizadas

### Backend  
- Java 24  
- Spring Boot 3.x  
- Spring Security  
- JPA (Hibernate)  
- MySQL (Docker)  
- Docker Compose (para desarrollo local)  
- Flyway (para migraciones, si aplica)  

### Web (Angular)  
- Angular 20  
- TypeScript  
- CSS (estilos básicos)  
- RxJS  

### App móvil  
- Kotlin Multiplatform (en desarrollo)  
- Jetpack Compose Multiplatform  
- Ktor Client (para conectarse a la API)  
- SQLDelight o Koin (según necesidad)  
- SQLite (si se requiere almacenamiento local opcional)  

---

## 📦 Estado actual

- [x] Estructura inicial del backend con Spring Boot  
- [x] Definición de modelos (`modelo`, `concesionario`, `inventario`)  
- [x] Generación de datos de prueba (100 vehículos aleatorios)  
- [x] Contenedor Docker funcional con MySQL  
- [ ] Implementación de endpoints REST  
- [ ] Inicio del desarrollo frontend interno (Angular)  
- [ ] Desarrollo de frontend público (Angular)  
- [ ] Gestión de usuarios para empleados (futuro)  
- [ ] App móvil multiplataforma (futuro)

## ✅ Leyenda del estado de desarrollo

Los siguientes símbolos indican el estado actual de cada funcionalidad:
- [x] Completado  
- [-] En proceso
- [ ] Pendiente

## 🚀 Cómo levantar la base de datos con Docker

La base de datos MySQL está configurada para ejecutarse dentro de un contenedor Docker usando Docker Compose, lo que facilita la puesta en marcha del entorno de desarrollo.

### Requisitos previos

- Tener instalado [Docker](https://docs.docker.com/get-docker/)  
- Tener instalado [Docker Compose](https://docs.docker.com/compose/install/) (en versiones recientes de Docker suele venir integrado)

### Pasos para levantar el contenedor

1. **Clona el repositorio (si no lo has hecho ya):**

```bash
git clone https://github.com/0talora/GestionConcesionarios.git
```
2. **Acceder a la carpeta del proyecto:**
   
```bash
cd GestionConcesionarios
```
3. **Levantar el contenedor Docker en segundo plano:**
   
```bash
docker-compose up -d
```
4. **Verificar que el contenedor está corriendo:**
   
```bash
docker ps
```
5. **Detener y eliminar el contenedor cuando ya no lo necesites:**
   
```bash
docker-compose down
```
