# Ejercicio 2. Instalación y Archivos de Configuración

Antes de analizar las entrañas de Tomcat, he realizado la instalación en mi máquina virtual Ubuntu. A diferencia de Apache, Tomcat requiere un entorno de ejecución de Java (JRE/JDK).

### 🛠️ Paso previo: Instalación y Verificación
Para que Tomcat funcione, primero he instalado OpenJDK y luego he descargado el paquete de Tomcat 10.

> ![1](https://github.com/user-attachments/assets/13f4c400-13df-4b89-b14c-a7d1eae67852)

---

### 📂 Archivos Clave de Configuración
Una vez instalado en `/opt/tomcat` (o la ruta correspondiente), he localizado los cuatro archivos que controlan todo el servidor en la carpeta `/conf`:

1.  **server.xml:** Es el archivo principal. Aquí configuramos los **conectores** (por qué puerto escucha, como el 8080) y los **Hosts Virtuales**. Si queremos cambiar el puerto, es aquí.
2.  **web.xml:** Configuración global para todas las aplicaciones. Define cosas como los **servlets por defecto** o los tiempos de espera de las sesiones (session-timeout).
3.  **tomcat-users.xml:** Este es vital para nosotros. Aquí es donde **creamos los usuarios y asignamos roles** (como `manager-gui`) para poder entrar al panel de control.
4.  **context.xml:** Define configuraciones que afectan a las aplicaciones web, como el acceso a bases de datos (recursos JNDI) o parámetros que queremos que compartan todas las apps.

---

### 🗺️ Mapa Visual de Dependencias
Para entender cómo se relacionan entre ellos, he diseñado este esquema de jerarquía:

* **server.xml (El Jefe)**
    * Contiene el motor (Catalina).
    * Dentro de él vive el **context.xml** (que define cómo se portan las apps).
    * **web.xml** actúa como el manual de instrucciones para cualquier app que el motor decida arrancar.
    * **tomcat-users.xml** es el portero que decide quién entra a las apps de gestión definidas en el motor.

---

### 📝 Resumen del proceso de localización
He comprobado las rutas mediante el comando `ls -l /opt/tomcat/conf`. Es importante recordar que para editar cualquiera de estos archivos necesitamos permisos de superusuario (`sudo`), ya que una mala configuración aquí puede impedir que el servidor arranque.

> **📸 CAPTURA 2:** Un `ls` de la carpeta `conf` para demostrar que he localizado los archivos físicamente en el servidor.
