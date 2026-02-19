# Ejercicio 8. Despliegue de Tomcat mediante Contenedores (Docker)

En esta fase se explora la modernización del despliegue utilizando contenedores, comparando la portabilidad y eficiencia de Docker frente a la instalación nativa realizada anteriormente.

### 🐳 1. Despliegue del Contenedor
He utilizado la imagen oficial de **Tomcat** del registro de Docker Hub. Para el despliegue, he realizado un **montaje de volumen** (bind mount) para inyectar la aplicación directamente en el directorio de despliegue del contenedor.

* **Comando utilizado:**
  `docker run -d -p 8888:8080 --name tomcat-container -v ~/tomcat-docker/sample.war:/usr/local/tomcat/webapps/sample.war tomcat:latest`

> **📸 CAPTURA 1:** Ejecución del comando `docker ps` y `docker pull`, mostrando el contenedor en ejecución.

---

### 🔍 2. Diferencias: Tomcat Nativo vs. Tomcat en Contenedor

| Característica | Tomcat Nativo (Ubuntu) | Tomcat en Contenedor (Docker) |
| :--- | :--- | :--- |
| **Instalación** | Manual (Java, usuarios, carpetas). | Automática (Imagen preconfigurada). |
| **Aislamiento** | Comparte recursos y librerías del SO. | Totalmente aislado en su propio entorno. |
| **Escalabilidad** | Difícil de replicar idénticamente. | Instantánea (basta con lanzar más copias). |
| **Actualización** | Requiere intervención en el servidor. | Se cambia la versión de la imagen y se reinicia. |
| **Persistencia** | Los cambios se quedan en el disco local. | Los datos se borran si no se usan volúmenes. |

---

### 🌍 3. Despliegue en la Nube (Opcional)
Para completar el ciclo de vida del proyecto, se ha analizado el despliegue en un entorno Cloud (**AWS EC2 / Azure VM**). 

* **Proceso:** Se ha instanciado una máquina virtual con una distribución Linux, instalado el motor de Docker y replicado el contenedor anterior. 
* **Ventaja:** La portabilidad de Docker garantiza que la aplicación funcione exactamente igual en mi máquina local que en el servidor de producción en la nube.

> **📸 CAPTURA 2:** Acceso a la aplicación mediante la IP pública del servidor cloud o navegador local en el puerto 8888.

---

### 🏁 Conclusión de la Unidad
Este bloque final demuestra que, aunque la configuración nativa es fundamental para entender el funcionamiento interno de Tomcat, el uso de **contenedores** es la solución estándar actual para lograr despliegues rápidos, seguros y fácilmente escalables en entornos profesionales de **DAW**.
