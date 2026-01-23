# Diario de Aprendizaje - Unidad 2: Virtualización y Contenedores

En esta unidad he explorado las tecnologías de aislamiento de procesos y sistemas, comparando la robustez de las **Máquinas Virtuales** frente a la agilidad y eficiencia de los **Contenedores Docker**.

## 1. Qué he aprendido

A lo largo de las sesiones, he consolidado las bases del despliegue moderno de aplicaciones:

* **Virtualización nativa (VM):** He aprendido a configurar entornos aislados mediante **VirtualBox**, gestionando la creación de máquinas virtuales e instalando sistemas operativos como Ubuntu desde cero.
* **Tecnología de Contenedores:** Instalación y configuración de **Docker Desktop** en Linux, entendiendo el concepto de imagen y contenedor.
* **Despliegue de servicios:** Uso de comandos esenciales como `docker run` para levantar servidores web (**Nginx**) y servidores de aplicaciones (**Tomcat**) de forma casi instantánea.
* **Gestión de puertos:** Implementación del mapeo de puertos (`-p`) para permitir la comunicación entre la máquina anfitrión y los servicios aislados del contenedor.

## 2. Qué no entiendo

* **Redes en Docker:** Me resulta complejo el funcionamiento interno de la infraestructura de red de Docker y cómo se gestiona la comunicación entre distintos contenedores (Bridge vs. Host).
* **Mapeo de puertos:** Persisten dudas sobre la lógica del mapeo específico (por ejemplo, por qué usar `8080:80` en lugar de `8080:8080`) en ciertos escenarios de red.
* **Persistencia:** Necesito clarificar los mecanismos de almacenamiento para evitar la pérdida de datos al eliminar un contenedor.

## 3. Qué es lo que más me ha gustado y qué es lo que menos

* **Lo que más:** La **rapidez y eficiencia** de Docker. Es sorprendente cómo en pocos segundos se pueden desplegar servicios complejos que antes requerían procesos largos de instalación. La **portabilidad** que ofrece es, sin duda, su mayor ventaja competitiva.
* **Lo que menos:** La **instalación inicial en Linux**. El proceso de añadir repositorios, claves GPG y dependencias manuales es muy secuencial y riguroso; cualquier pequeño descuido en los pasos iniciales puede detener toda la instalación.

## 4. Qué más me gustaría saber relacionado con la Unidad

* **Persistencia de Datos:** Profundizar en el uso de **volúmenes de Docker** para garantizar que los datos (como bases de datos) sobrevivan al ciclo de vida del contenedor.
* **Orquestación básica (Docker Compose):** Aprender a utilizar archivos `docker-compose.yml` para desplegar infraestructuras completas (web + app + BD) con un solo comando.

---
