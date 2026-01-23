# Diario de Aprendizaje - Unidad 4: Tomcat

En esta unidad hemos pasado del servidor web estático (Apache) al servidor de aplicaciones Java, explorando el ecosistema de **Apache Tomcat**.

## 1. Qué he aprendido

A lo largo de esta unidad, he adquirido conocimientos técnicos sobre:

* **Fundamentos y Despliegue:** La investigación inicial sobre qué es Tomcat y cómo realizar el despliegue simple de una aplicación web.
* **Configuración Estructurada:** Identificación de los archivos de configuración críticos del servidor para personalizar su comportamiento.
* **Administración Avanzada:** El uso de las herramientas **Manager** y **Host Manager** para gestionar aplicaciones en tiempo real.
* **Seguridad e Integración:** Implementación de capas de seguridad en Tomcat y su integración con servidores web para mejorar el rendimiento.
* **Optimización y Modernización:** Realización de pruebas de funcionamiento/rendimiento y el despliegue de Tomcat mediante **contenedores Docker**.

## 2. Qué no entiendo

* **Afinamiento de Rendimiento:** Aunque hemos hecho pruebas de rendimiento, todavía me resulta complejo entender cómo ajustar los parámetros exactos (como el *thread pool*) para cargas de tráfico muy elevadas.
* **Persistencia en Contenedores:** En la parte de Docker, me genera dudas cómo gestionar correctamente los volúmenes para que los logs y aplicaciones de Tomcat no se pierdan al reiniciar el contenedor.

## 3. Qué es lo que más me ha gustado y qué es lo que menos

* **Lo que más:** Ver la potencia de Tomcat al desplegar aplicaciones dinámicas y, sobre todo, la parte de **Docker**. Ver cómo podemos "empaquetar" el servidor y que funcione igual en cualquier sitio es impresionante.
* **Lo que menos:** La configuración manual de los archivos XML. A veces un pequeño error de sintaxis en el `tomcat-users.xml` o el `server.xml` hace que el servidor no arranque, y el *debug* puede ser un poco tedioso.

## 4. Qué más me gustaría saber relacionado con la Unidad

* **Balanceo de Carga:** Me gustaría profundizar en cómo conectar un servidor Apache con varios nodos de Tomcat para repartir el tráfico (Clustering).
* **Seguridad Avanzada:** Cómo implementar certificados SSL directamente en Tomcat o mediante un "Reverse Proxy" de forma más profesional.

---
