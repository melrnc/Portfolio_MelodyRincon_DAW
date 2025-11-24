## Informe Técnico: Iniciación a la Virtualización y Contenedores

Este informe documenta el proceso de instalación de una Máquina Virtual con Ubuntu, la configuración de Docker Desktop y el despliegue de contenedores de servidor web y de aplicaciones, según las especificaciones de la práctica.

---

### 1. Descripción del Proceso de Instalación de Ubuntu en VirtualBox

La **virtualización** es una tecnología que permite ejecutar varios sistemas operativos o entornos de software independientes en una misma máquina física, mediante el uso de hipervisores (como VirtualBox). Cada entorno virtual se denomina **máquina virtual (VM)**.

#### 1.1 Configuración de la Máquina Virtual

Se creó una nueva VM con las siguientes características: `Ubuntu-DAW2DAW`, **4096 MB** de RAM, **50 GB** de disco duro virtual, y **NAT** como tipo de red.

#### 1.2 Instalación del Sistema Operativo

1.  Se descargó la **Imagen ISO** de Ubuntu 24.04 LTS.
2.  La ISO se montó en la VM para iniciar la instalación.
3.  Se instalaron las *Guest Additions*.

A continuación, se muestra el escritorio de Ubuntu-DAW2DAW una vez completada la instalación:

![1](https://github.com/user-attachments/assets/58b3df11-8da5-432c-82ee-0cfc115d1570)

### 2. Pasos Seguidos para Instalar Docker Desktop

**Docker** utiliza **contenedores**, unidades de software que empaquetan código, dependencias y configuraciones necesarias para ejecutar una aplicación, compartiendo el *kernel* del sistema operativo, lo que los hace **más ligeros y rápidos** que las VMs.

#### 2.1 Comandos de Instalación

Los siguientes pasos y comandos se ejecutaron para configurar el repositorio e instalar Docker Desktop:

1.  **Actualización de Repositorios:** `sudo apt update && sudo apt upgrade -y`.
2.  **Instalación de Dependencias:** `sudo apt install ca-certificates curl gnupg -y`.
3.  **Adición del Repositorio e Instalación:** Se añadió el repositorio de Docker y se procedió a la instalación.

#### 2.2 Verificación de Funcionamiento

Se verificó la instalación y se ejecutó la imagen de prueba `hello-world` para comprobar que la instalación era correcta:

![6](https://github.com/user-attachments/assets/e57b839c-879d-4c33-9fc3-48fc05f241d5)

### 3. Comandos Usados para Crear y Ejecutar Contenedores

Se desplegaron un **Servidor Web** (Nginx) y un **Servidor de Aplicaciones** (Tomcat).

#### 3.1 Despliegue de Contenedores

* **Servidor Web (Nginx):**
    ```bash
    docker run -d -p 8080:80 --name webserver nginx
    ```
* **Servidor de Aplicaciones (Tomcat):**
    ```bash
    docker run -d -p 8081:8080 --name appserver tomcat
    ```

#### 3.2 Verificación de Contenedores y Pruebas de Funcionamiento

Se verificó que ambos contenedores estuvieran activos y en ejecución, y se realizaron las pruebas desde el navegador.

| Servicio | Comando de Verificación | Resultado de la Prueba |
| :--- | :--- | :--- |
| **Contenedores Activos** | `sudo docker ps` | Ambos contenedores (`webserver` y `appserver`) se muestran en estado **Up**. |
| **Servidor Web (Nginx)** | `http://localhost:8080` | Se muestra la página de bienvenida de Nginx. |
| **Servidor de Aplicaciones (Tomcat)** | `http://localhost:8081` | Se accede al servidor Tomcat (muestra el informe de error por falta de recurso, indicando que el servidor está activo). |

**Evidencia de Verificación (`docker ps`):**
![11](https://github.com/user-attachments/assets/adb15ceb-7467-482f-b38d-20025c065a1c)

**Evidencia de Pruebas de Servidores (Navegador):**

* **Nginx (Webserver):**
    ![12(https://github.com/user-attachments/assets/0768ad63-18ba-42db-ada4-9ff16457837b)

* **Tomcat (Appserver):**
    ![13](https://github.com/user-attachments/assets/a15faebf-fe5f-4a42-b4c5-f92328bffcf7)

---

### 4. Requerimientos Mínimos para Implantar una Aplicación Web

#### 4.1 Requisitos de Hardware y Software

La implantación requiere:
* **Hardware:** Recursos virtualizados como CPU, memoria RAM, almacenamiento y red.
* **Software:** Un Sistema Operativo base y una tecnología de **contenedores** (Docker) para garantizar la **portabilidad** y el **aislamiento** de la aplicación.

#### 4.2 Infraestructura de Red y Configuración

* **Servidor Web (Nginx):** Atiende peticiones externas y actúa como *front-end*.
* **Servidor de Aplicaciones (Tomcat):** Ejecuta la lógica de negocio.
* **Red:** Se requiere el mapeo de puertos (`-p`) para dirigir el tráfico del sistema anfitrión a los puertos internos de los contenedores (ej., `8080:80`).

#### 4.3 Seguridad y Mantenimiento

La seguridad y el mantenimiento son cruciales:
* **Seguridad:** Asegurar el *host* y el aislamiento de los contenedores.
* **Mantenimiento:** La **rapidez de despliegue** de Docker facilita las actualizaciones y el mantenimiento de las versiones de las imágenes.






