#  Proyecto Contenido Audiovisual

Bienvenido al proyecto **Contenido Audiovisual**, una aplicación Java sencilla, construida especialmente para consola. Fue desarrollada como parte del curso de *Programación Orientada a Objetos* en la Universidad Politécnica Salesiana, y tiene como objetivo ayudarte a gestionar películas de forma organizada y práctica.

---

## ¿Qué contiene este proyecto?

```
ContenidoAudiovisual/
├── src/
│   ├── Modelo/           # Clases que representan las entidades del sistema (Película, ContenidoAudiovisual)
│   ├── Controller/       # Lógica de control y conexión entre vista y modelo
│   ├── Vista/            # Interfaz de texto que interactúa con el usuario
│   └── App.java          # Punto de inicio del programa
├── test/                 # Pruebas automáticas con JUnit para asegurar calidad
│   ├── Modelo/
│   ├── Controller/
│   ├── Vista/
│   └── AppTest.java
├── datos/                # Archivo CSV con películas precargadas
├── docs/                 # Diagrama UML del sistema
└── README.md             # Este archivo
```

---

##  ¿Qué necesitas para usarlo?

- Java 17 o superior
- IntelliJ IDEA (o cualquier IDE que soporte Java)
- JUnit 5 para correr las pruebas

---

##  ¿Cómo lo ejecuto?

### 1. Clona el repositorio

```bash
git clone https(https://github.com/Javired10/Unidad4.git
cd ContenidoAudiovisual
```

### 2. Corre el programa

Abre `App.java` en tu IDE y haz clic derecho sobre `main()` → selecciona **Run 'App.main()'**.

¡Listo! El menú aparecerá y podrás comenzar a trabajar con tu colección de películas.

---

##  ¿Cómo corro las pruebas?

Desde IntelliJ o tu IDE:

```
Haz clic derecho en la carpeta `test` y selecciona 'Run All Tests'
```

Incluye pruebas para:

- ✅ `PeliculaTest`: valida atributos y exportación CSV
- ✅ `ArchivoControllerTest`: lectura del archivo CSV
- ✅ `ConsolaVistaTest`: prueba de entrada/salida por consola
- ✅ `AppTest`: asegura que la aplicación arranca sin errores

---

##  Autor

**Javier Marca**\

 Curso: Programación Orientada a Objetos

---

Gracias por revisar este proyecto. ¡Espero que te sea útil y fácil de entender!

