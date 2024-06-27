# Conversor de Moneda

## Descripción
Este proyecto es un Conversor de Moneda implementado en Java. Permite a los usuarios realizar conversiones entre diferentes monedas utilizando tasas de cambio en tiempo real obtenidas a través de una API externa.

## Características
- Conversión entre múltiples monedas (USD, EUR, ARS, BRL, COP)
- Interfaz de usuario en consola con colores y diseño mejorado
- Obtención de tasas de cambio en tiempo real a través de una API
- Historial de las últimas 10 conversiones realizadas
- Registro de fecha y hora para cada conversión
- Manejo de errores y validación de entrada del usuario

## Tecnologías Utilizadas
- Java
- Gson (para el manejo de JSON)
- HttpClient (para realizar peticiones HTTP)

## Configuración del Proyecto
1. Clona el repositorio.
2. Asegúrate de tener Java JDK 11 o superior instalado.
3. Importa el proyecto en tu IDE favorito (Eclipse, IntelliJ IDEA, etc.).
4. Configura la clave de API en la clase `ExchangeRateService` (si es necesario).

## Uso
1. Ejecuta la clase principal `Main`.
2. Sigue las instrucciones en la consola para realizar conversiones.
3. Utiliza la opción del menú para ver el historial de conversiones.

## Estructura del Proyecto
- `Main.java`: Punto de entrada de la aplicación
- `UserInterface.java`: Maneja la interacción con el usuario
- `ExchangeRateService.java`: Gestiona la obtención de tasas de cambio
- `CurrencyConversionService.java`: Realiza las conversiones de moneda
- `ConversionHistory.java`: Mantiene un registro de las conversiones realizadas
- `ConversionRecord.java`: Representa una única conversión con su marca de tiempo
- `Currency.java`: Enum que define las monedas soportadas

## Contribuir
Las contribuciones son bienvenidas. Por favor, abre un issue para discutir cambios mayores antes de hacer un pull request.

## Licencia
[MIT License](https://opensource.org/licenses/MIT)

## Contacto
Daniel Duran - ld.duran.x@gmail.com

Enlace del Proyecto: 
