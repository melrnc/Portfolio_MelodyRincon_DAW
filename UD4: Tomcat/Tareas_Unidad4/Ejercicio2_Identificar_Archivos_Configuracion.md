# Ejercicio 2. Instalación de Tomcat 10 y Análisis de Archivos Clave

Para abordar esta tarea, he decidido realizar una instalación manual de Apache Tomcat 10 en mi máquina virtual Ubuntu. Esto me ha permitido no solo localizar los archivos de configuración que pide el enunciado, sino entender cómo interactúan con el sistema operativo.

## 1. Proceso de Instalación y Configuración

### 🛠️ Paso 1: Entorno Java
Tomcat requiere el Java Development Kit (JDK). He instalado la versión por defecto y verificado su funcionamiento.

> ![1](https://github.com/user-attachments/assets/8c4baeb3-a0eb-4774-bac6-f42afa1a8df2)

### 📂 Paso 2: Despliegue y Permisos
He descargado el binario de Tomcat 10.1.34, lo he extraído en `/opt/tomcat` y he configurado un usuario específico para el servicio por seguridad.

> ![2](https://github.com/user-attachments/assets/18e424ab-5ab0-4b1a-9224-4808649a4996)

### ⚙️ Paso 3: Creación del Servicio (Systemd)
Para que Tomcat arranque automáticamente, he creado el archivo de unidad en `/etc/systemd/system/tomcat.service`.

![3](https://github.com/user-attachments/assets/69afeac2-c458-4b05-bffe-65f3a43f0a17)

### 🚀 Paso 4: Arranque y Verificación
Finalmente, he recargado el demonio de sistema y arrancado el motor de aplicaciones.

> ![4](https://github.com/user-attachments/assets/9fb5a0f0-1175-4412-a834-5f14fd7066b1)

---

## 2. Archivos Clave de Configuración

Una vez el servidor está operativo, he localizado en la carpeta `/opt/tomcat/conf` los cuatro archivos fundamentales que solicita la actividad:

> ![5](https://github.com/user-attachments/assets/442f2704-182b-4d65-aef0-d3167d60a32b)

| Archivo | Función Principal | Elementos Configurables |
| :--- | :--- | :--- |
| **server.xml** | El archivo "maestro". Configura el motor del servidor. | Puertos (8080), conectores, Hosts Virtuales y protocolos. |
| **web.xml** | Configuración global para todas las apps web. | Servlets por defecto, tipos MIME y tiempos de expiración de sesión. |
| **tomcat-users.xml** | Gestión de seguridad y accesos. | Definición de usuarios, contraseñas y roles (manager, admin). |
| **context.xml** | Parámetros comunes a las aplicaciones. | Conexiones a bases de datos (JNDI) y recarga automática de apps. |

---

## 3. Mapa Visual de Dependencias

Para cumplir con el análisis de dependencias, he diseñado el siguiente esquema jerárquico. En Tomcat, la configuración no es aislada, sino que los archivos dependen unos de otros para que el flujo de datos sea posible:

* **[server.xml] → La Raíz (Cimiento)**
    * Es el nivel superior. Define el "Engine" (Catalina) y el puerto de escucha de "Coyote". Sin este archivo, el servidor no existe para la red.
* **[context.xml] → El Entorno (Configuración compartida)**
    * Se sitúa jerárquicamente bajo el servidor. Define parámetros y recursos (como BD) que las aplicaciones heredarán. Depende de que el servidor lo cargue al arrancar.
* **[web.xml] → El Estándar (Lógica)**
    * Establece las reglas de procesamiento para los Servlets. Depende de que el motor (server.xml) le pase las peticiones HTTP interceptadas.
* **[tomcat-users.xml] → El Control (Seguridad)**
    * Es la capa de acceso. Aunque el motor funcione, si los roles no están aquí vinculados a las aplicaciones de gestión, el acceso queda bloqueado.

> **Esquema de flujo de dependencia:** > Petición HTTP ⮕ **server.xml** (Acepta) ⮕ **web.xml** (Procesa) ⮕ **tomcat-users.xml** (Autoriza) ⮕ Aplicación.

---

## 4. Comprobación Final

Como prueba definitiva de que la arquitectura y los conectores funcionan, accedo a la interfaz web por el puerto 8080.

> <img width="619" height="513" alt="image" src="https://github.com/user-attachments/assets/89f344e1-319c-44f0-99e1-906609eb00a7" />
