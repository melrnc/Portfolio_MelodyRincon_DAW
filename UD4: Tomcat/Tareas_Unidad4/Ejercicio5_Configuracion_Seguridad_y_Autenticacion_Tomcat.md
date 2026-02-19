# Tarea 5. Hardening: Configuración de Seguridad y Autenticación en Tomcat

En esta fase final, he realizado un proceso de **hardening** sobre el servidor para blindar el acceso administrativo y garantizar la confidencialidad de los datos transmitidos.

### 🛡️ 1. Control de Acceso Basado en Roles (RBAC)
La primera línea de defensa ha consistido en restringir el acceso a las herramientas de gestión. Para ello, he editado `tomcat-users.xml` definiendo una política de roles estricta. He habilitado los roles `manager-gui` y `admin-gui` y los he vinculado a un usuario administrador con una política de contraseñas robusta.

> **📸 CAPTURA 1:** Definición de la política de seguridad y usuarios en `tomcat-users.xml`.
>
> ![1](https://github.com/user-attachments/assets/5f02bdbd-2c91-4171-bcd3-c2b59f40350a)

### 🔑 2. Cifrado de la Comunicación (Implementación de SSL/TLS)
Para proteger la **confidencialidad** de las credenciales, he configurado un certificado digital (Keystore) generado mediante `keytool`. Posteriormente, he habilitado un conector seguro en el puerto **8443** dentro de `server.xml`, asegurando que toda la comunicación entre el cliente y el servidor viaje cifrada bajo el protocolo HTTPS.

> **📸 CAPTURA 2:** Configuración del conector SSL en `server.xml` referenciando el almacén de claves.
>
> ![2](https://github.com/user-attachments/assets/1b910e40-3836-4189-b69b-2e19d6ba9a7e)

### 🛰️ 3. Auditoría del Servicio Seguro
Tras reiniciar el servicio, he auditado la apertura del puerto seguro desde la terminal. El estado **LISTEN** en el puerto 8443 confirma que la capa de transporte seguro está operativa y lista para recibir conexiones.

> **📸 CAPTURA 3:** Verificación técnica mediante `ss -ant | grep 8443` confirmando el servicio activo.
>
> ![3](https://github.com/user-attachments/assets/05a369a3-ae07-4486-beec-9742947fc61d)

### 🌍 4. Validación de la Integridad y Acceso Autenticado
Finalmente, he realizado una prueba de acceso real a través de la URL segura (`https://localhost:8443/manager/html`). Tras validar la identidad del servidor (aceptando el certificado autofirmado), el sistema ha forzado el desafío de autenticación, permitiendo el acceso al panel de gestión únicamente tras introducir las credenciales autorizadas.

> **📸 CAPTURA 4:** Acceso exitoso al panel de administración bajo protocolo HTTPS.
>
> ![4](https://github.com/user-attachments/assets/a14bb146-28e1-4ceb-934d-fa7fdb16a81c)

---

# 🏁 Conclusión General del Proyecto

Tras completar este despliegue, el servidor ha quedado configurado bajo estándares profesionales de administración de sistemas:

1.  **Arquitectura Segmentada:** Uso de los motores **Catalina**, **Jasper** y el conector **Coyote**.
2.  **Gestión Dinámica:** Despliegue de aplicaciones mediante paquetes **WAR** con monitorización de **Auto-deploy**.
3.  **Optimización de Red:** Implementación de un **Proxy Inverso con Apache**, mejorando la seguridad perimetral al centralizar el tráfico en el puerto 80.
4.  **Capa de Seguridad Avanzada:** Aplicación de técnicas de **Hardening**, cifrado SSL/TLS y control de acceso basado en roles para proteger la integridad del entorno.
