# Actividad 9: Uso del navegador como cliente FTP

En esta actividad se analiza el comportamiento del servidor cuando se utiliza un navegador web como cliente de acceso, comparando su eficacia frente a aplicaciones dedicadas.

## 🌐 1. Prueba de Acceso
Se ha utilizado el navegador para acceder a la dirección `ftp://127.0.0.1/`. Como se observa en la evidencia, el navegador establece una conexión automática bajo el perfil de usuario **"anonymous"**, permitiendo visualizar el índice del directorio raíz de forma inmediata sin necesidad de introducir credenciales manualmente.

## 📊 2. Ventajas y Desventajas observadas

| Ventajas | Desventajas |
| :--- | :--- |
| **Simplicidad**: Permite consultar y descargar archivos públicos sin necesidad de instalar o configurar software adicional. | **Unidireccionalidad**: El navegador actúa principalmente como cliente de descarga; no permite subir archivos ni crear carpetas. |
| **Inmediatez**: Ideal para usuarios externos que solo requieren acceso de lectura a repositorios públicos de archivos. | **Limitación de Protocolos**: No gestiona correctamente las políticas de seguridad estrictas (como el FTPS configurado para usuarios privados). |
| **Interfaz Familiar**: La navegación se realiza mediante hipervínculos, de forma idéntica a una página web estándar. | **Falta de información técnica**: No ofrece visibilidad sobre los comandos enviados (CWD, LIST, RETR) ni sobre el estado de la red. |

## 📝 3. Conclusión técnica
El navegador es un cliente útil únicamente para la **distribución pasiva** de información. Sin embargo, para tareas de administración, mantenimiento o transferencia segura de archivos (bidireccionalidad), es totalmente insuficiente, siendo necesario recurrir a clientes profesionales.

> **📸 CAPTURA 9.1: Acceso desde navegador y registro de sesión anónima en el log**
>
> ![1](https://github.com/user-attachments/assets/092ee1f3-8d2d-420c-a3de-9b114c82c5f3)
>
> ![2](https://github.com/user-attachments/assets/d9ab3735-dd88-4c9a-bda4-85db4ab6f908)
