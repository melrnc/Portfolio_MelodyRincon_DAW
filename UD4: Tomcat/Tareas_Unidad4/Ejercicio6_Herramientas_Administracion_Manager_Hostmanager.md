# Ejercicio 6. Herramientas de Administración: Manager y Host Manager

En esta sección se exploran y documentan las dos interfaces gráficas de administración que proporciona Apache Tomcat, las cuales permiten gestionar el servidor de forma dinámica sin editar archivos de configuración manualmente.

---

## 🛠️ 1. Ficha Descriptiva: Manager App (Gestor de Aplicaciones)
Es la consola principal para el control de las aplicaciones web individuales. Permite administrar el ciclo de vida de los paquetes `.war` y monitorizar su estado.

* **Acceso:** `https://localhost:8443/manager/html`
* **Funciones principales:**
    * **Despliegue (Deploy):** Permite subir archivos WAR o directorios de aplicaciones directamente al servidor.
    * **Control de Estado:** Botones para **Arrancar (Start)**, **Parar (Stop)** y **Recargar (Reload)** aplicaciones en caliente.
    * **Undeploy:** Eliminación completa de aplicaciones instaladas.
    * **Monitorización:** Visualización de sesiones activas y diagnóstico de fugas de memoria.

> **📸 CAPTURAS 1 y 2: Evidencias del Manager App**
> Se documenta el acceso exitoso al encabezado del gestor y la tabla inferior donde se verifica que la aplicación `/sample` está desplegada y ejecutándose.
> 
> (![1 1](https://github.com/user-attachments/assets/8cc0a3e9-8ab8-4e09-84d9-5bee70c4037a)
>
> ![1 2](https://github.com/user-attachments/assets/50104d3f-e809-4ede-841f-c580705a23ca)

---

## 🏗️ 2. Ficha Descriptiva: Host Manager (Gestor de Hosts Virtuales)
Esta herramienta permite la administración de los **Virtual Hosts**, facilitando que una única instancia de Tomcat pueda alojar múltiples dominios independientes.

* **Acceso:** `https://localhost:8443/host-manager/html`
* **Funciones principales:**
    * **Gestión de Hosts:** Visualización de las máquinas virtuales activas (por defecto `localhost`).
    * **Añadir Máquina Virtual:** Formulario técnico para definir nuevos nombres de host y sus carpetas base (`appBase`).
    * **Configuración en caliente:** Modificación de parámetros como `autoDeploy` o `deployOnStartup` sin reiniciar el servicio.
    * **Información del Sistema:** Panel de consulta de versiones de JVM, Sistema Operativo y arquitectura del servidor.

> **📸 CAPTURAS 3 y 4: Evidencias del Host Manager**
> Se muestra la vista general de los hosts registrados y el formulario detallado para la creación de nuevos entornos virtuales junto con la información del sistema.
> 
> ![2 1](https://github.com/user-attachments/assets/2259a6af-6d88-469d-a928-b603c48a2292)
>
> ![2 2](https://github.com/user-attachments/assets/cbc24e1f-67e8-492b-944e-64f508adc445)

---

### 💡 Análisis Técnico de las Herramientas
Tras la investigación de ambas interfaces, se extraen las siguientes conclusiones:
1.  **Seguridad y Roles:** El acceso ha sido posible gracias a la configuración previa en `tomcat-users.xml`, donde se asignaron los roles `manager-gui` y `admin-gui`.
2.  **Operatividad:** Estas herramientas reducen el riesgo de errores humanos al evitar la edición manual de XML para tareas comunes como el despliegue de WARs o la parada de servicios específicos.
3.  **Monitorización:** La capacidad de ver las sesiones activas en tiempo real (como se observa en la captura de `/sample`) es vital para la administración de recursos en entornos de producción.
