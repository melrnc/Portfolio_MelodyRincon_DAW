# Actividad 1: Introducción y Arquitectura de FileZilla Server

Esta actividad establece la base teórica necesaria para la implementación de un servidor de transferencia de archivos, analizando protocolos, arquitectura de red y gestión de puertos.

---

## 1. Fundamentos: FTP, FTPS y SFTP
Es fundamental distinguir estos tres protocolos, ya que sus requerimientos de seguridad y puertos son distintos:

| Protocolo | Seguridad | Descripción | Puerto |
| :--- | :--- | :--- | :--- |
| **FTP** | **Nula** | Envía datos y contraseñas en texto plano. Vulnerable a ataques de escucha. | 21 |
| **FTPS** | **Alta** | FTP estándar protegido por una capa de cifrado **SSL/TLS**. | 21 / 990 |
| **SFTP** | **Alta** | Protocolo de transferencia basado en **SSH**. No es FTP, aunque sirve para lo mismo. | 22 |

---

## 2. Arquitectura Cliente–Servidor
FileZilla Server utiliza una arquitectura de **doble canal**, lo que lo diferencia de protocolos como HTTP:

1.  **Canal de Control (Puerto 21):** Se mantiene abierto durante toda la sesión para enviar comandos (ej. `LIST`, `RETR`, `DELE`) y gestionar la autenticación.
2.  **Canal de Datos (Puerto 20 o Rango Pasivo):** Se abre y cierra dinámicamente cada vez que se solicita una transferencia de archivos o el listado de un directorio.



---

## 3. Diferencias entre Modo Activo y Pasivo
El correcto funcionamiento de FileZilla Server tras un firewall depende de entender estos dos flujos:

### A. Modo Activo (El Servidor inicia la conexión)
El cliente abre un puerto y "espera" a que el servidor se conecte a él para enviarle los datos.
* **Problema:** Los firewalls modernos suelen bloquear estas conexiones entrantes al cliente, provocando fallos en la transferencia.

### B. Modo Pasivo (El Cliente inicia la conexión - Recomendado)
El servidor informa al cliente de un puerto aleatorio dentro de su **Rango Pasivo** y el cliente se conecta a dicho puerto.
* **Ventaja:** Es la configuración estándar en entornos profesionales, ya que es compatible con NAT y firewalls de usuario.



---

## 🛠️ Tarea: Esquema de Flujo de Conexión (Modo Pasivo)

A continuación, se representa el flujo de comunicación que implementaremos en las siguientes prácticas utilizando el modo pasivo:

```text
       CLIENTE                                            SERVIDOR (FileZilla)
          |                                                     |
  [CANAL DE CONTROL]                                            |
          |------- [1] Petición conexión (Puerto 21) ---------->|
          |<------ [2] Respuesta: Solicitar Auth ---------------|
          |------- [3] USER/PASS ------------------------------>|
          |------- [4] Comando: PASV (Modo Pasivo) ----------->|
          |                                                     |
  [CANAL DE DATOS]                                              |
          |<------ [5] "Puerto disponible: 50001" --------------|
          |------- [6] Conexión de datos al 50001 ------------->|
          |            (Envío/Recepción de archivos)            |
          |                                                     |

```

> **📸 CAPTURA 1: Esquema de Arquitectura y Flujo de Datos**
> Se adjunta el esquema del flujo de conexión detallando la interacción entre el cliente y el servidor en los canales de control y datos.

---

## 🔍 4. Verificación de Puertos Implicados

Antes de proceder con la instalación de **FileZilla Server**, es fundamental verificar si el puerto estándar **21** (control) está siendo utilizado por otro servicio de red. Esto evita conflictos de socket que impedirían el arranque del servidor.

* **Comando ejecutado:** `netstat -an | grep 21` (en Linux) o `netstat -an | findstr 21` (en Windows).

> **📸 CAPTURA 2: Estado inicial de los puertos en el sistema**
> Se adjunta captura de la terminal demostrando la disponibilidad de los puertos antes de la instalación.

---

## 📝 Conclusiones de la Actividad

La arquitectura de **FileZilla Server** requiere una gestión precisa y diferenciada de los canales de comunicación. Tras el análisis realizado, se concluye que:

* **Separación de Canales:** La independencia entre el canal de control y el de datos es la base de la seguridad y eficiencia del protocolo FTP.
* **Superioridad del Modo Pasivo:** La configuración del Modo Pasivo, junto con un rango de puertos específicos, será la clave técnica para garantizar que el servidor sea accesible desde redes externas, superando las restricciones típicas de los firewalls y el NAT.
* **Seguridad:** Aunque el protocolo base es FTP, la arquitectura estudiada permite la evolución hacia **FTPS**, aprovechando certificados SSL/TLS para proteger la fase de autenticación y transferencia.
