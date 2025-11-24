# Diario de la asignatura Despliegue de Aplicaciones Web

## Unidad 2: Virtualización y Contenedores

## 1. Qué he aprendido
He aprendido los conceptos fundamentales de la **virtualización** y la **contenedores**, y la diferencia práctica entre ellos.
* **Virtualización (VM):** He aprendido a configurar y crear una Máquina Virtual con **VirtualBox** y a instalar un sistema operativo (Ubuntu). Entiendo que las VMs aíslan completamente los sistemas operativos, pero son más pesadas.
* **Contenedores (Docker):** He aprendido a instalar la herramienta **Docker Desktop** en un sistema Linux. Lo más importante es cómo utilizar los comandos `docker run` para desplegar servicios esenciales (como **Nginx** como servidor web y **Tomcat** como servidor de aplicaciones) y mapear los puertos (`-p 8080:80`) para hacerlos accesibles. 

## 2. Qué no entiendo
A pesar de haberlo puesto en práctica, todavía me resulta confuso comprender por completo la **infraestructura de red** de Docker, especialmente cómo se maneja la comunicación interna entre contenedores y por qué es necesario el mapeo de puertos específico (`8080:8080` vs. `8080:80`). También me gustaría entender mejor cómo persisten los datos si un contenedor se elimina.

## 3. Qué es lo que más me ha gustado y qué es lo que menos
* **Lo que más me ha gustado:** Descubrir la **rapidez y eficiencia** con la que Docker permite desplegar servicios. En pocos segundos, pude tener Nginx y Tomcat funcionando, algo que en una máquina virtual tradicional llevaría mucho más tiempo. La **portabilidad** es el punto más fuerte.
* **Lo que menos me ha gustado:** El proceso inicial de **instalación de Docker en Linux** es bastante secuencial y dependiente de la configuración manual de repositorios y claves (`gpg`), lo que lo hace propenso a errores si se salta un paso.

## 4. Qué más me gustaría saber relacionado con la Unidad
Me gustaría profundizar en:
* **Persistencia de Datos:** Cómo se utilizan los **volúmenes de Docker** para asegurar que los datos de una aplicación (ej. una base de datos) no se pierdan cuando el contenedor se reinicia o se elimina.
* **Docker Compose:** Aprender más sobre el despliegue de múltiples servicios (como un servidor web, una aplicación y una base de datos) utilizando un único archivo de configuración (`docker-compose.yml`).
