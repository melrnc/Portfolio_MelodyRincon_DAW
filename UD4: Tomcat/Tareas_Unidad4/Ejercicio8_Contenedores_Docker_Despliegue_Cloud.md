# Tarea 8. Despliegue de Tomcat mediante Contenedores (Docker)

En esta fase final de la unidad, se ha migrado la infraestructura de un modelo de instalación nativa a un modelo de **contenedorización**. El objetivo es aprovechar las ventajas de aislamiento, portabilidad y escalabilidad que ofrece Docker en los entornos de despliegue modernos.

---

### 🐳 1. Aislamiento y Configuración del Contenedor
Para este despliegue, se ha utilizado la imagen oficial de **Tomcat (latest)**. Se ha configurado un mapeo de puertos para evitar conflictos con la instancia nativa instalada en pasos anteriores, redirigiendo el tráfico del puerto **8888** del host al puerto **8080** interno del contenedor.

Además, se ha implementado un **volumen de datos** para inyectar la aplicación `sample.war` directamente en el directorio de despliegue del contenedor.

* **Comando ejecutado:**
  `sudo docker run -d -p 8888:8080 --name tomcat-container -v ~/tomcat-docker/sample.war:/usr/local/tomcat/webapps/sample.war tomcat:latest`

> **📸 CAPTURA 1: Verificación técnica del contenedor**
> 
> Evidencia del comando `docker ps` donde se observa el contenedor en estado **Up** y el correcto mapeo de puertos.
> 
> ![1](https://github.com/user-attachments/assets/2b1abaf8-7ec8-4ba2-9614-9f836700fd83)


---

### 🌍 2. Validación del Despliegue y Acceso Web
Se ha verificado el éxito de la operación accediendo a la aplicación a través del puerto seguro del host. La correcta visualización de la aplicación confirma que el motor Tomcat dentro del contenedor ha desplegado el paquete WAR satisfactoriamente.

* **URL de acceso:** `http://localhost:8888/sample/`

> **📸 CAPTURA 2: Aplicación operativa en Docker**
> 
> Navegador mostrando la aplicación en el puerto **8888**, confirmando el aislamiento y la disponibilidad del servicio.
> 
> ![2](https://github.com/user-attachments/assets/572cc026-9af1-46ee-8934-5a3efee2df71)

---

### 🔍 3. Comparativa: Tomcat Nativo vs. Tomcat en Contenedor

| Característica | Tomcat Nativo (Ubuntu) | Tomcat en Contenedor (Docker) |
| :--- | :--- | :--- |
| **Instalación** | Manual y dependiente del Sistema Operativo. | Basada en imágenes inmutables y portables. |
| **Aislamiento** | Comparte librerías y recursos con el host. | Entorno totalmente estanco y controlado. |
| **Mantenimiento** | Actualizaciones manuales complejas. | Sustitución rápida de la imagen por una superior. |
| **Escalabilidad** | Requiere configuración de réplicas manual. | Escalado horizontal inmediato mediante orquestadores. |

---

### 🏁 Conclusión Final del Proyecto de Despliegue
Tras la realización de las 8 tareas que componen esta unidad, se ha logrado una visión integral de la administración de servidores de aplicaciones:

1.  **Fundamentos:** Se ha comprendido la arquitectura interna de Tomcat (Catalina, Jasper, Coyote).
2.  **Seguridad:** Se han implementado protocolos **SSL/TLS** y control de acceso por roles (**Hardening**).
3.  **Optimización:** Se ha mejorado el rendimiento mediante el ajuste de hilos y se ha validado con pruebas de estrés (**ApacheBench**).
4.  **Modernización:** Se ha culminado con el despliegue en **Docker**, estableciendo las bases para entornos de producción en la nube.

Esta progresión desde lo nativo hasta lo contenedorizado representa el flujo de trabajo real en un entorno profesional de **Desarrollo de Aplicaciones Web (DAW)**.
