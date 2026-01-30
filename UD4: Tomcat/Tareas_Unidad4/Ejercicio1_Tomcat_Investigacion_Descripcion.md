# Ejercicio 1. Investigación: Arquitectura de Apache Tomcat

Para empezar con la Unidad 4, he investigado los componentes internos de Tomcat. A diferencia de Apache (que es un servidor web), Tomcat es un **contenedor de servlets** que funciona mediante varios módulos que trabajan en equipo:

### ⚙️ Componentes del motor

* **Catalina:** Es el "cerebro" de Tomcat. Es el contenedor de Servlets que se encarga de que las aplicaciones Java se ejecuten correctamente.
* **Coyote:** Es el conector. Su trabajo es escuchar las peticiones HTTP (normalmente por el puerto 8080) y pasárselas a Catalina.
* **Jasper:** Es el motor de JSP. Básicamente, "traduce" las páginas .jsp a código Java para que el servidor las entienda.
* **Manager y Host Manager:** Son aplicaciones web de administración. El **Manager** sirve para desplegar o quitar apps, y el **Host Manager** para gestionar los hosts virtuales.



### 📂 Estructura de directorios principal

* **/bin:** Contiene los scripts de control, como `startup.sh` (para arrancar) y `shutdown.sh` (para apagar).
* **/conf:** Aquí están los archivos de configuración. Los más importantes son el `server.xml` y el `tomcat-users.xml`.
* **/webapps:** Es la carpeta más importante para nosotros, donde subimos los archivos **.war** de nuestras aplicaciones.
* **/lib:** Donde se guardan todas las librerías necesarias para que las apps funcionen.
* **/logs:** Lugar donde consultaremos los errores si algo falla en el despliegue.

### 🔄 Flujo interno de funcionamiento

Cuando un usuario pide algo a nuestra web, el flujo es el siguiente:
1. **Coyote** recibe la petición por el puerto configurado (8080).
2. Se la pasa a **Catalina**, que busca qué aplicación dentro de la carpeta **webapps** debe responder.
3. Si la página es un JSP, entra en juego **Jasper** para compilarla.
4. El contenedor genera la respuesta y Coyote se la envía de vuelta al navegador.

> **Resumen personal:** Al principio parece complejo por los nombres, pero básicamente es como un Apache preparado para Java. Lo que más vamos a usar en las prácticas será la carpeta `/conf` para los usuarios y `/webapps` para subir nuestros proyectos.
