# Sistema de Venta para una bodega
Proyecto del curso de PCDS con el lenguaje de programación Java. Version 2.0.0.

## Instalación
Pasos para ejecutar correctamente este proyecto.

 1. **Clone** este repositorio o solamente descarguelo.
 2. Abra su IDE favorito. Se recomienda usar **Netbeans IDE 8.2**.
 3. Incluir los siguientes **JAR** al proyecto.
    * jCalendar-1.4 | [decargar](http://www.java2s.com/Code/Jar/j/Downloadjcalendar14jar.htm)
    * sqljdbc4-2.0 | [descargar](http://www.java2s.com/Code/Jar/s/Downloadsqljdbc420jar.htm)
    * AbsoluteLayout | [solución](https://www.youtube.com/watch?v=B0prYbtdKNI)
 4. Abrir **SQL Server 2014** y ejecutar el script del archivo **SV-BD.sql**.
 5. Por último, ejecute el proyecto desde la clase **Principal.java** del paquete principal.

## Requerimientos
 - Java 8 o superior.
 - SQL Server 2014.

## Uso

 1. Debe iniciar sesión con cualquiera de estos usuario.
    * admin - 12345
    * cajero - 12345
 2. Puede gestionar a los clientes, productos, vendedores o generar la venta.
 3. Para realizar la venta:
    * Seleccione un cliente.
    * Seleccione la fecha de venta.
    * Seleccione los productos con sus respectivas cantidades.
    * Registre.
 4. Los datos generados se registran en la base de datos.
 

## Créditos
* [@cbherit](https://github.com/cbherit) - Carlos Becerra
* [@](https://github.com/) - Anderson Bengolea
* [@](https://github.com/)- Anthony Carhuajulca
