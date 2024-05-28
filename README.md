# Proyecto de Arquitectura de 3 Capas con Principios SOLID y Patrones de Diseño

## Descripción del Proyecto

Este proyecto implementa una arquitectura de 3 capas (Presentación, Negocio y Datos) utilizando principios SOLID y varios patrones de diseño (Builder, Decorator y Strategy). La aplicación permite registrar, obtener, eliminar y listar usuarios a través de una interfaz de usuario en consola.

## Requisitos Previos

- Java Development Kit (JDK) 8 o superior
- Git

## Pasos para Ejecutar el Proyecto

1. **Clonar el Repositorio**

   ```bash
   git clone https://github.com/tu-usuario/nombre-del-repositorio.git
   cd nombre-del-repositorio
2. **Abrir el Proyecto en IntelliJ IDEA**
     - Abre IntelliJ IDEA.
     - Selecciona File -> Open y navega hasta el directorio del proyecto clonado.
     - IntelliJ IDEA detectará el proyecto y sugerirá importar las dependencias de Maven. Acepta y permite que IntelliJ descargue todas las dependencias necesarias.
3. **Ejecutar la Aplicación**
     - En IntelliJ IDEA, abre la clase Main ubicada en src/main/java/presentation/Main.java.
     - Haz clic derecho en la clase Main y selecciona Run 'Main.main()'.

## Documentación del Proyecto

### Principios SOLID

1. **Single Responsibility Principle (SRP)**

     - Clase: User: Representar un usuario con sus atributos.
     - Clase: UserService: Contener la lógica de negocio relacionada con los usuarios.
     - Clase: UserRepositoryImpl: Manejar las operaciones de almacenamiento de datos de usuarios.
     - Clase: UserUI: Interactuar con el usuario y capturar los datos.
       
2. **Open/Closed Principle (OCP)**

     - Clase: RoRuDecorator: Extendido sin modificar: Añade registro de operaciones a las funciones del repositorio de usuarios.

3. **Liskov Substitution Principle (LSP)**

     - Interfaz: UserRepository
       - Implementaciones: UserRepositoryImpl, RoRuDecorator
         Las implementaciones pueden ser utilizadas indistintamente donde se espere la interfaz UserRepository.

4. **Interface Segregation Principle (ISP)**

    Aplicable a futuras expansiones donde se dividan interfaces más grandes en interfaces específicas y pequeñas.

5. **Dependency Inversion Principle (DIP)**

     - Clase: UserService
     - Dependencia: UserRepository (interfaz)
       Depende de una abstracción (UserRepository), no de una implementación concreta.
### Patrones de Diseño
1. **Builder (Patrón Creacional)**

     - Clases: UserBuilder, UserRepositoryBuilder
     - Propósito: Construcción de objetos User y UserRepositoryImpl de manera flexible.
       Ejemplo:
     ```java
     Copy code
     User usuario1 = new UserBuilder()
        .name("Jhonatan Encinas")
        .email("encinas.jhonatan.dev@gmail.com")
        .build();
     ```
2. **Decorator (Patrón Estructural)**

     - Clase: RoRuDecorator
     - Propósito: Añadir funcionalidades adicionales (registro de operaciones) a los objetos UserRepository.
       Ejemplo:
     ```java
      RoRuDecorator repoDecorado = new RoRuDecorator(repo);
     ```
3. **Strategy (Patrón de Comportamiento)**

     - Uso Implícito: Uso de interfaces y la inyección de dependencias sigue el mismo principio.
     - Propósito: Permitir que UserService interactúe con cualquier implementación de UserRepository sin conocer los detalles de la implementación.

### Arquitectura de 3 Capas
1. **Capa de Presentación (UI)**

     - Clase: UserUI: Manejar la interacción con el usuario y captura de datos.
   
2. **Capa de Negocio (Service)**
   
     - Clase: UserService: Contiene la lógica de negocio y actúa como intermediario entre la capa de presentación y la capa de datos.

3. **Capa de Datos (Repository)**

     - Clases: UserRepository, UserRepositoryImpl, RoRuDecorator: Manejar las operaciones de almacenamiento y recuperación de datos.

### Estructura de Archivos
```bash
src/
│
├── data/
│   ├── RoRuDecorator.java
│   ├── UserRepository.java
│   ├── UserRepositoryBuilder.java
│   └── UserRepositoryImpl.java
│
├── presentation/
│   ├── UtilsUser.java
│   └── UserUI.java
│
├── service/
│   ├──UserService.java
│   ├── User.java
│   └── UserBuilder.java
│ 
└── Main.java
```
