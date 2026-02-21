# Ejercicio 12: Documentación Final del Servidor FTP 

Este documento resume la implementación, configuración y despliegue del servidor FTP mediante **FileZilla Server**, detallando los hitos técnicos alcanzados durante la práctica.

## 🛠️ 1. Instalación y Configuración Inicial
Se ha procedido a la instalación de **FileZilla Server** en su versión más reciente, configurando el servicio para iniciarse automáticamente con el sistema. La administración se realiza mediante la interfaz local protegida por contraseña.

## ⚙️ 2. Gestión de Usuarios y Carpetas
* **Usuarios**: Se han creado perfiles específicos (como `usuario1`) para el acceso controlado.
* **Permisos**: Se han aplicado políticas de "Carpeta de Grupo" con permisos de lectura, escritura y borrado, vinculando rutas físicas del disco duro con puntos de montaje virtuales en el FTP.

## 🔒 3. Seguridad y Protocolos (FTPS)
Se ha securizado el servidor mediante la implementación de **FTP sobre TLS (FTPS)**:
* Creación de un certificado digital auto-firmado.
* Deshabilitación de conexiones en texto plano para proteger las credenciales de los usuarios.

## 📡 4. Modos de Conexión
* **Modo Activo**: El servidor inicia la conexión de datos hacia el cliente.
* **Modo Pasivo**: El servidor indica al cliente a qué puerto debe conectarse para la transferencia de datos. Se ha configurado el rango de puertos efímeros para garantizar la compatibilidad con firewalls.

## 🌐 5. Clientes e Integración Web
Se han validado diferentes métodos de acceso:
* **Clientes**: Uso de FileZilla Client (seguro) y Explorador de Windows (tradicional).
* **Flujo Web**: Se ha integrado el servidor como método de publicación, demostrando que archivos `index.html` subidos por FTP son renderizables por cualquier navegador estándar.

## 📝 6. Recomendaciones de Administración
Para el mantenimiento en entornos de producción, se recomienda:
1. Activar la **rotación de logs** para auditoría sin saturar el disco.
2. Limitar las **conexiones por IP** para mitigar ataques DoS.
3. Mantener el software actualizado y realizar **backups periódicos** de la configuración.
