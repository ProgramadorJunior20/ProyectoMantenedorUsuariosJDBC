# Proyecto Mantenedor de Usuarios JDBC

## Descripción
Este proyecto es un sistema de gestión de usuarios que permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre una base de datos MySQL. Está desarrollado en Java utilizando JDBC.

## Funcionalidades
- **Crear usuario:** Permite agregar un nuevo usuario a la base de datos.
- **Listar usuarios:** Muestra todos los usuarios registrados.
- **Actualizar usuario:** Permite modificar los datos de un usuario existente.
- **Eliminar usuario:** Elimina un usuario de la base de datos.
- **Salir:** Cierra la conexión a la base de datos y finaliza el programa.

## Requisitos Previos
Antes de ejecutar el proyecto, asegúrate de tener instalado lo siguiente:
- **Java Development Kit (JDK):** Versión 8 o superior.
- **MySQL:** Servidor de base de datos MySQL instalado y en ejecución.
- **MySQL Connector/J:** El conector JDBC para MySQL. Puedes descargarlo [aquí](https://dev.mysql.com/downloads/connector/j/).
- **IDE:** Recomendamos usar IntelliJ IDEA, Eclipse o cualquier IDE que soporte Java.

## Configuración del Proyecto
1. **Base de Datos:**
   - Crea una base de datos en MySQL llamada `nombre_bd` (o el nombre que prefieras).
   - Ejecuta el siguiente script SQL para crear la tabla `usuarios`:
     ```sql
     CREATE TABLE usuarios (
         id int NOT NULL AUTO_INCREMENT,
         username varchar(12) DEFAULT NULL,
         password varchar(60) DEFAULT NULL,
         email varchar(45) DEFAULT NULL,
         PRIMARY KEY (id)
     ) ENGINE=InnoDB;
     ```

2. **Configuración de la Conexión:**
   - Abre el archivo `ConexionBaseDatos.java`.
   - Modifica las siguientes variables con tus credenciales de MySQL:
     ```java
     private static final String URL = "jdbc:mysql://localhost:3306/nombre_bd?serverTimezone=UTC";
     private static final String USER = "root"; // Cambia si es necesario
     private static final String PASSWORD = ""; // Cambia si es necesario
     ```

3. **Dependencias:**
   - Si estás usando Maven, agrega la siguiente dependencia en tu archivo `pom.xml`:
     ```xml
     <dependency>
         <groupId>mysql</groupId>
         <artifactId>mysql-connector-java</artifactId>
         <version>8.0.30</version>
     </dependency>
     ```
   - Si no usas Maven, asegúrate de agregar el archivo `.jar` de MySQL Connector/J al classpath de tu proyecto.

## Ejecución del Proyecto
1. Clona este repositorio o descarga el código fuente.
2. Abre el proyecto en tu IDE.
3. Asegúrate de que la base de datos esté configurada y en ejecución.
4. Ejecuta la clase `Principal.java`.
5. Sigue las instrucciones en los cuadros de diálogo para realizar las operaciones deseadas.

## Tecnologías Utilizadas
- **Java:** Lenguaje de programación principal.
- **JDBC:** API para la conexión y operaciones con la base de datos.
- **MySQL:** Sistema de gestión de bases de datos relacional.
- **JOptionPane:** Para la interfaz gráfica de usuario.

## Mejoras Futuras
- Implementar validación de campos (ej: formato de email, longitud de contraseña).
- Añadir autenticación de usuarios.
- Migrar a un framework de persistencia como Hibernate.
- Implementar pruebas unitarias con JUnit.

## Contribuciones
¡Las contribuciones son bienvenidas! Si deseas mejorar este proyecto, sigue estos pasos:
1. Haz un fork del repositorio.
2. Crea una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -m 'Añadir nueva funcionalidad'`).
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

## Licencia
Este proyecto está bajo la licencia MIT. Para más detalles, consulta el archivo LICENSE.

## Autor
- **Nombre:** [Jeferson Murillo]
- **Email:** [murillopalacioj@gmail.com]
- **GitHub:** [[Tu Perfil de GitHub](https://github.com/ProgramadorJunior20/ProyectoMantenedorUsuariosJDBC)]

¡Gracias por usar Proyecto Mantenedor de Usuarios JDBC! Si tienes alguna pregunta o sugerencia, no dudes en contactarme. 😊

## Notas Adicionales
- Si prefieres usar `Scanner` en lugar de `JOptionPane`, puedes modificar la clase `Principal.java` para usar entradas por consola.
- Asegúrate de que el servidor MySQL esté en ejecución antes de iniciar la aplicación.
