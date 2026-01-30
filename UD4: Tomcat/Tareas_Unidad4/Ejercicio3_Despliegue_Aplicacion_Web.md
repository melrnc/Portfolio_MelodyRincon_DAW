# Tarea 3. Despliegue de una Aplicación Web en Tomcat

En esta práctica he realizado el despliegue de una aplicación empaquetada en formato **WAR** para observar el comportamiento del servidor.

### 🚀 Proceso de Despliegue
He utilizado un archivo de ejemplo llamado `sample.war`. El proceso ha consistido en mover este archivo al directorio `/webapps` del servidor.

> **📸 CAPTURA 1:** Resultado de `ls -l /opt/tomcat/webapps` donde se aprecia el archivo .war y la carpeta extraída automáticamente.
> ![1](https://github.com/user-attachments/assets/2e5f5538-f829-4255-83e5-0b6d6f09df31)

### 🔄 ¿Qué ha pasado internamente? (Flujo de Tomcat)
Al copiar el archivo, Tomcat ha realizado los siguientes pasos de forma automática:
1.  **Auto-deploy:** El motor **Catalina** monitoriza constantemente la carpeta `webapps`. Al detectar un nuevo archivo `.war`, inicia el despliegue.
2.  **Descompresión:** Tomcat crea una carpeta con el mismo nombre que el archivo y extrae su contenido (servlets, JSPs, recursos).
3.  **Registro del contexto:** Se crea un nuevo "Contexto" de aplicación. A partir de ese momento, la app es accesible a través de la URL que coincide con el nombre del archivo.
4.  **Compilación (si procede):** Al acceder por primera vez, el motor **Jasper** compilará los archivos JSP que contenga la aplicación.

### 🌐 Acceso a la aplicación
Para verificar que el despliegue ha sido exitoso, accedo desde el navegador a la ruta: `http://localhost:8080/sample`

> **📸 CAPTURA 2:** Navegador mostrando la aplicación "Sample Application" funcionando correctamente.
> ![2](https://github.com/user-attachments/assets/f4fa027a-5c21-44d3-a910-6f8815ea9b4f)

---

### 📝 Observaciones finales
Tras acceder a la aplicación, he navegado por los enlaces de prueba que incluye (`To a JSP page` y `To a servlet`). 

Esta prueba es fundamental porque confirma dos cosas:
1. El enlace al **JSP** funciona, lo que significa que el motor **Jasper** está compilando correctamente el código Java embebido en la página.
2. El enlace al **Servlet** funciona, lo que demuestra que **Catalina** está gestionando el ciclo de vida de los servlets de forma adecuada.

Con esto doy por finalizado el despliegue, comprobando que Tomcat no solo sirve archivos estáticos, sino que gestiona contenido dinámico de forma transparente.
