# Ejercicio 11: Disponibilidad y buenas prácticas 

Para asegurar que el servidor FTP sea un servicio confiable en un entorno de producción, se han definido y aplicado las siguientes recomendaciones basadas en estándares de seguridad y disponibilidad.

## 🛡️ 1. Recomendaciones de Seguridad y Rendimiento
* **Gestión de Logs y Auditoría**: Es fundamental mantener un registro detallado de quién accede y qué archivos se modifican. Esto permite detectar intentos de intrusión y depurar errores de conexión.
* **Límites de Conexión**: Se deben configurar límites de tiempo de espera (timeouts) y un máximo de conexiones por IP para evitar el abuso de recursos o ataques de denegación de servicio (DoS).
* **Control de Puertos (Firewall/NAT)**: El servidor debe operar tras un firewall que solo permita el tráfico en los puertos 21 (control) y el rango pasivo, evitando exponer servicios innecesarios.
* **Copias de Seguridad**: Implementar backups periódicos de la configuración del servidor (`settings.xml`) y de los datos alojados en las carpetas de usuario para garantizar la recuperación ante desastres.

## ⚙️ 2. Implementación de Auditoría
Se ha configurado el servidor para que genere archivos de registro automáticos con una política de rotación. Esto evita que el almacenamiento se sature, manteniendo únicamente los logs necesarios para la supervisión.

> **📸 CAPTURA 11.1: Configuración de Logs y política de rotación en FileZilla Server**
>
> En la imagen se observa la activación del volcado a archivo y el límite de retención de registros para optimizar el espacio en disco.
>
> ![Practica11](https://github.com/user-attachments/assets/5d661ff8-8368-436a-ba56-a0a713db377d)

