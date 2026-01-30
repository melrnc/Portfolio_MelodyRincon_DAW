# Tarea 4. Integración de Apache y Tomcat (Reverse Proxy)

En esta práctica he configurado **Apache HTTP Server** para que actúe como front-end de **Tomcat**, redirigiendo las peticiones mediante un proxy inverso.

### 🛠️ Configuración de módulos
Primero, he habilitado los módulos necesarios en Apache para que pueda reenviar tráfico HTTP a otro servidor.
> **📸 CAPTURA 1:** Habilitando `mod_proxy` y `mod_proxy_http`.
> ![1](https://github.com/user-attachments/assets/83752957-976e-4394-b663-5386072a73a4)

### ⚙️ Creación del VirtualHost
He creado un archivo de configuración en `/etc/apache2/sites-available/` para definir la redirección. La directiva `ProxyPass` indica que cualquier petición que llegue al puerto 80 con la ruta `/sample` debe ser enviada al puerto 8080 de Tomcat.
> **📸 CAPTURA 2:** Configuración del archivo `tomcat-proxy.conf`.
> ![2](https://github.com/user-attachments/assets/6c2a42db-72cf-4817-8695-87573078e5f5)

### 🌐 Verificación del funcionamiento
La prueba final consiste en acceder a la aplicación web a través del puerto estándar de HTTP (80), omitiendo el puerto 8080 en la URL.
> **📸 CAPTURA 3:** Acceso a `http://localhost/sample` funcionando a través de Apache.
> ![3](https://github.com/user-attachments/assets/ecd33f4e-12d8-4a65-956a-a55e04473b27)

🧠 Reflexión Técnica
Gracias a esta configuración de Proxy Inverso, hemos logrado los siguientes beneficios a nivel de arquitectura:

Seguridad: El puerto 8080 de Tomcat podría cerrarse en el firewall del servidor, dejando únicamente el puerto 80 (o 443) abierto al exterior. Esto reduce la superficie de ataque.

Transparencia: Para el usuario final, la aplicación es "invisible" en su ubicación real; parece estar alojada directamente en el servidor web principal, simplificando las URLs.

Flexibilidad: Apache actúa como una capa intermedia donde podríamos gestionar fácilmente certificados SSL, balanceo de carga o compresión de datos sin necesidad de tocar la configuración interna de la aplicación en Tomcat.
