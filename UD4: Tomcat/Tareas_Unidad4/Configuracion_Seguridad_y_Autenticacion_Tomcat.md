# Tarea 5. Acceso Autenticado y Seguridad SSL

En esta última fase, he blindado el servidor Tomcat configurando la autenticación de usuarios y cifrando las comunicaciones mediante el protocolo HTTPS.

### 🔐 1. Gestión de Usuarios y Roles
Para restringir el acceso a las herramientas de administración, he editado el archivo `tomcat-users.xml`. He definido los roles `manager-gui` y `admin-gui`, asignándolos a un usuario administrador con credenciales seguras. Sin este paso, las aplicaciones de gestión de Tomcat permanecen bloqueadas por seguridad.

> **📸 CAPTURA 1:** Definición de roles y usuarios en el archivo `tomcat-users.xml`.
> 
> ![1](https://github.com/user-attachments/assets/dd30c300-8c89-4e97-a8c7-1f64b1aa88db)

### 🔑 2. Configuración del Conector SSL (HTTPS)
He generado un certificado digital (Keystore) mediante la herramienta `keytool` y he habilitado el puerto **8443** en el archivo `server.xml`. Esta configuración permite que toda la información (especialmente las contraseñas de administración) viaje cifrada entre el cliente y el servidor.

> **📸 CAPTURA 2:** Configuración del conector SSL en `server.xml` vinculando el archivo `.keystore` y su contraseña.
> 
> ![2](https://github.com/user-attachments/assets/22ab0421-0563-43a0-bf7d-0a4084589d75)

### 🛰️ 3. Verificación técnica del puerto seguro
Antes de realizar la prueba en el navegador, he comprobado desde la terminal que el servicio Tomcat ha levantado correctamente el nuevo puerto de seguridad.

> **📸 CAPTURA 3:** Resultado del comando `ss -ant | grep 8443` mostrando el estado **LISTEN** en el puerto seguro.
> 
> ![3](https://github.com/user-attachments/assets/2355fd57-bcd7-4509-bdb5-0c101c3914f3)

### 🌍 4. Prueba de Acceso y Autenticación
Finalmente, he accedido a la **Manager App** a través de la URL segura (`https://localhost:8443/manager/html`). Tras aceptar el certificado autofirmado, el sistema ha solicitado las credenciales configuradas en el primer paso, permitiendo la gestión de aplicaciones solo tras una identificación exitosa.

> **📸 CAPTURA 4:** Navegador accediendo por HTTPS y panel de administración desbloqueado tras el login.
> ![4](https://github.com/user-attachments/assets/841c6523-197e-4024-94a9-b4f8e2d39e94)

---

# 🏁 Conclusión General del Proyecto

Tras completar las cinco tareas propuestas, se ha logrado desplegar un entorno de servidor de aplicaciones profesional y robusto sobre Ubuntu. Los hitos alcanzados han sido:

1.  **Comprensión de la Arquitectura:** Identificación de los componentes clave como **Catalina** (motor de servlets), **Jasper** (motor JSP) y **Coyote** (conector HTTP).
2.  **Configuración Modular:** Dominio de los archivos XML primordiales (`server.xml`, `web.xml`, `context.xml` y `tomcat-users.xml`) y sus dependencias jerárquicas.
3.  **Gestión de Aplicaciones:** Despliegue dinámico de paquetes **WAR**, observando el proceso de auto-deploy de Tomcat.
4.  **Optimización de Red:** Implementación de un **Proxy Inverso con Apache**, mejorando la escalabilidad y seguridad al centralizar el tráfico en el puerto 80.
5.  **Seguridad y Cifrado:** Blindaje del servidor mediante protocolos **SSL/TLS** y control de acceso basado en roles.

Este proyecto demuestra la capacidad para administrar un servidor de aplicaciones Java en un entorno de producción, garantizando su disponibilidad, eficiencia y seguridad.
