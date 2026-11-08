# Mediateca
Práctica de la UD3: trabajo en pareja con Git sobre parcelas
## Autores
- Personas: 
  - Daniel Díaz Campoy 
  - Mirian Gonzalez Rodríguez
## Endpoints disponibles
# Gestión de Parcelas

Aplicación web desarrollada con Spring Boot para gestionar parcelas agrícolas.

Permite:

- Listar parcelas ordenadas alfabéticamente por nombre.
- Consultar el detalle de una parcela.
- Crear, editar y eliminar parcelas.
- Filtrar parcelas por tipo de cultivo.
- Calcular la superficie total.

## Autores

- Daniel Díaz Campoy
- Mirian González Rodríguez

## Tecnologías

- Java 25
- Spring Boot
- Spring Data JPA
- Thymeleaf
- MariaDB
- Gradle
- Bootstrap

## Requisitos

Es necesario tener instalado:

- Java 25
- MariaDB

La conexión con tu base de datos se configura en `src/main/resources/application.yaml`.

Configuración actual:

```yaml
spring:
  datasource:
    url: jdbc:mariadb://localhost:3306/ejemplo //Dependiendo del puerto de tu DB
    username: usuario
    password: usuario
```

Si el usuario o la contraseña de MariaDB son diferentes, hay que modificarlos en `application.yaml`.
## Datos iniciales

El archivo `src/main/resources/data.sql` contiene varias parcelas de ejemplo.

Para cargarlas automáticamente al iniciar la aplicación, hay que añadir en `application.yaml`:

```yaml
sql:
  init:
    mode: always
```

Si no se quiere utilizar `data.sql`, las parcelas se pueden añadir manualmente desde IntelliJ o desde el formulario de la aplicación.

## Ejecución

Ejecutar la clase `ParcelasApplication` desde IntelliJ o utilizar Gradle:


Después, abrir en el navegador:  
`http://localhost:8080/parcelas`

## Endpoints

| Método | Ruta | Función |
| :--- | :--- | :--- |
| `GET` | `/parcelas` | Lista las parcelas ordenadas por nombre |
| `GET` | `/parcelas/{id}` | Muestra el detalle de una parcela |
| `GET` | `/parcelas/nueva` | Abre el formulario para crear una parcela |
| `POST` | `/parcelas` | Crea o actualiza una parcela |
| `POST` | `/parcelas/eliminar/{id}` | Elimina una parcela |
| `GET` | `/parcelas/cultivo/{tipo}` | Filtra por tipo de cultivo |
| `GET` | `/parcelas/{id}/editar` | Abre el formulario para editar una parcela |

## Fallos

- **Título del formulario al editar:** Al editar una parcela funciona todo correctamente pero el titulo pone *"Nueva Parcela"* no hemos sabido cambiarlo a *"Editar Parcela"*.

- **Uso de la función de filtrado:** Esto no es un fallo, pero por si alguien no sabe como usar el filtrar, no hay ningun boton ni nada para filtrar, simplemente en la url de nuestro navegador debemos filtrar a nuestro gusto ejemplo: `http://localhost:8080/parcelas/cultivo/OLIVAR`).

## Preguntas EXTRAS del profesor
- -----------------------------RESPONDE DANI-------------------------------
- **Explicad el recorrido completo de la petición GET /parcelas/2 , nombrando las clases y métodos por los que pasa.**
RESPUESTA: La petición GET /parcelas/2 llega al controlador ParcelaController, que tiene un método que se llma @GetMapping("/parcelas/{id}"). 
Este método luego llamaría al servicio ParcelaService para obtener la parcela con el id 2. 
El servicio utiliza el repositorio ParcelaRepository para tener acceso a la BD y de esa manera encuentra la parcela correspondiente. 
Por ultimo, el controlador devuelve la vista detalle.html con los datos de la parcela con el id que anteriormente le hayamos indicado.
- **¿Por qué el servicio tiene una interfaz y una implementación? ¿Por qué el controlador no usa directamente el repositorio?**
Porque el servicio es como si fuera un intermediario entre el controlador y el repositorio. La segunda pregunta no la respondo porque no la entiendo, lo siento.
- -----------------------------RESPONDE MIRIAN----------------------------
- **¿Por qué eliminar se hace con un formulario POST y no con un enlace?**
  Eliminar se hace con un formulario POST porque borra datos y modifica la base de datos. Un enlace utiliza GET, que debería servir solo para consultar información, no para eliminarla.

- **¿Qué pasaría si quitarais @Enumerated(EnumType.STRING) de la entidad?**
  Si quitamos @Enumerated(EnumType.STRING) el tipo de cultivo se guardaría como un número, esto puede causar errores y pegarnos un petardazo.

## Trabajo realizado

El proyecto se desarrolló en pareja utilizando GitHub y haciendo PR (pull request por cada commit and push que haciamos hacia el develop)

### Daniel Díaz Campoy

- **Modelos y Datos:**
  - Creación del enumerado `TipoCultivo` con etiquetas.
  - Definición de la entidad JPA `Parcela` con sus anotaciones.
  - Creación del script de datos iniciales `data.sql`.
  - Creación de la interfaz `ParcelaRepository`.
- **Controlador y Vistas:**
  - Métodos `GET` en `ParcelaController` para el listado (`/parcelas`) y el detalle (`/parcelas/{id}`).
  - Plantillas Thymeleaf `lista.html` y `detalle.html`.
- **Extras de ampliación 1 y 3:**
  - Cálculo de la superficie total (`calcularSuperficieTotal()` en servicio, controlador y vista).
  - Consulta y ordenación alfabética por nombre (`findAllByOrderByNombreAsc()`).

### Mirian González Rodríguez

- **Servicio:**
  - Definición de la interfaz `ParcelaService`.
  - Implementación en `ParcelaServiceImpl` (incluyendo gestión de excepciones 404).
- **Formulario y Borrado:**
  - Métodos `GET` y `POST` para la creación de parcelas (`/parcelas/nueva` y `/parcelas`).
  - Método `POST` para la eliminación de parcelas (`/parcelas/eliminar/{id}`).
  - Plantilla Thymeleaf `formulario.html` con desplegable de cultivos y botón de eliminación.
- **Extras de ampliación 2 y 4:**
  - Filtrado de parcelas por tipo de cultivo (`findByTipoCultivo()`, ruta `@GetMapping("/cultivo/{tipo}")` y botones de filtro).
  - Edición de parcelas existentes (`@GetMapping("/{id}/editar")` y campo oculto `id` en el formulario).
