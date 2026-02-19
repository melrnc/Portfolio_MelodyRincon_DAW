# 📘 Documentación Final: Despliegue y Administración de Servidores Apache Tomcat

Este documento técnico detalla la arquitectura, configuración, blindaje y modernización del servidor de aplicaciones Apache Tomcat, cubriendo desde el despliegue nativo hasta la infraestructura basada en contenedores.

---

## 🏗️ 1. Arquitectura Básica de Tomcat
La arquitectura implementada se basa en el motor de servlets de código abierto, estructurado en tres componentes críticos:

* **Coyote (Connector):** El punto de entrada que gestiona las comunicaciones HTTP/S y el protocolo AJP.
* **Catalina (Engine):** El contenedor de servlets que procesa la lógica de las aplicaciones.
* **Jasper (JSP Engine):** El motor encargado de compilar y renderizar las páginas JavaServer Pages.

---

## ⚙️ 2. Configuración y Despliegue del Servidor
Se ha establecido un entorno basado en **Tomcat 10** sobre una distribución Linux (Ubuntu).
* **Gestión de aplicaciones:** Se ha configurado el despliegue dinámico mediante archivos `.WAR`.
* **Estructura de directorios:** Se han definido rutas seguras para la instalación (`/opt/tomcat`) y se han otorgado permisos específicos al usuario del sistema encargado del servicio para minimizar riesgos.

---

## 🔗 3. Integración con Servidor Web (Proxy Inverso)
Para mejorar la seguridad perimetral y la gestión del tráfico, se ha integrado Tomcat con **Apache HTTP Server**.
* **Módulo:** `mod_proxy`.
* **Arquitectura:** Apache actúa como puerta de enlace en el puerto 80, redirigiendo el tráfico interno hacia el puerto 8080 de Tomcat. Esto permite ocultar la estructura interna del servidor de aplicaciones al cliente final.

---

## 🛡️ 4. Seguridad Aplicada (Hardening)
Se han aplicado tres niveles de seguridad para garantizar la integridad del sistema:
1.  **Cifrado SSL/TLS:** Implementación de HTTPS en el puerto 8443 mediante la generación de un *Keystore* con `keytool`.
2.  **Control de Acceso (RBAC):** Configuración de `tomcat-users.xml` limitando el acceso a las interfaces de gestión (`manager-gui`, `admin-gui`) mediante credenciales robustas.
3.  **Aislamiento de red:** Restricción de acceso a las consolas de administración solo para tráfico local o IP autorizadas.

---

## 🚀 5. Pruebas de Rendimiento y Tuning
Mediante la herramienta **ApacheBench**, se ha realizado una sintonización (*tuning*) del servidor:
* **Ajuste de hilos:** Incremento de `maxThreads` a 500 para soportar mayores picos de tráfico.
* **Resultados:** Tras la optimización, se logró una mejora del **43% en la tasa de peticiones por segundo (rps)** y una reducción significativa de la latencia media.

---

## 🐳 6. Despliegue en Contenedores (Docker)
Como paso hacia la modernización de la infraestructura, se ha implementado el despliegue mediante **Docker**:
* **Portabilidad:** Uso de imágenes oficiales que garantizan un entorno inmutable.
* **Eficiencia:** El uso de volúmenes para inyectar aplicaciones permite separar el software (Tomcat) de los datos (la App).
* **Mapeo de puertos:** El contenedor opera en el puerto 8888, permitiendo la coexistencia con el servidor nativo.

---

## 📋 7. Recomendaciones de Administración
Como buenas prácticas para el mantenimiento futuro del servidor, se sugiere:
1.  **Monitorización constante:** Revisar periódicamente los logs en `/opt/tomcat/logs` para detectar errores de despliegue o intentos de intrusión.
2.  **Limpieza de temporales:** Vaciar la carpeta `work/Catalina` en caso de comportamientos anómalos tras una actualización de la aplicación.
3.  **Actualización de imágenes:** En el entorno Docker, programar la revisión de nuevas versiones de la imagen oficial para aplicar parches de seguridad de Java.
4.  **Mínimos privilegios:** Nunca ejecutar el servicio Tomcat como usuario `root`.

---

**Elaborado por:** [Tu Nombre]  
**Fecha:** Febrero 2026  
**Proyecto:** Despliegue de Aplicaciones Web (DAW)
