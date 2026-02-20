# Ejercicio 1: Introducción y Arquitectura de FileZilla Server

Esta actividad establece la base teórica necesaria para la implementación de un servidor de transferencia de archivos, analizando protocolos, arquitectura de red y gestión de puertos.

---

## 1. Fundamentos: FTP, FTPS y SFTP
Antes de comenzar con la arquitectura, es necesario distinguir los protocolos de transferencia disponibles y sus niveles de seguridad:

| Protocolo | Seguridad | Descripción | Puerto |
| :--- | :--- | :--- | :--- |
| **FTP** | **Nula** | Envía datos y contraseñas en texto plano. Inseguro. | 21 |
| **FTPS** | **Alta** | FTP protegido por una capa de cifrado **SSL/TLS**. | 21 / 990 |
| **SFTP** | **Alta** | Protocolo de transferencia basado en **SSH**. No es FTP. | 22 |

---

## 2. Arquitectura de Doble Canal
FileZilla Server utiliza una arquitectura donde la comunicación se divide en dos canales independientes para mayor eficiencia:

1.  **Canal de Control (Puerto 21):** Para comandos y autenticación.
2.  **Canal de Datos:** Para el envío real de los archivos.

> **📸 CAPTURA 1.1 y 1.2: Esquemas de los Canales de Control y Datos**
> En estas imágenes se detalla cómo el cliente y el servidor negocian la conexión y cómo se separan los flujos de información.
> 
> ![canal_control](https://github.com/user-attachments/assets/d8fd9d90-c942-4284-9cac-08ab412a464d)
>
> ![canal_datos](https://github.com/user-attachments/assets/336a3998-f8fe-43fb-b11f-7247f3b9753b)

---

## 3. Modos de Conexión: Activo vs Pasivo
La diferencia crítica reside en qué extremo de la comunicación inicia la conexión de datos.

* **Modo Activo:** El servidor intenta conectar al cliente (suele fallar por Firewalls).
* **Modo Pasivo:** El cliente conecta al servidor (método recomendado y más compatible).

> **📸 CAPTURA 1.3: Comparativa Activo vs Pasivo**
> Se analiza visualmente por qué el Modo Pasivo evita los bloqueos de seguridad en redes modernas.
> 
> ![modo_activo_pasivo](https://github.com/user-attachments/assets/5487f7d4-0e4b-48bc-ae62-9dd935b1363a)

---

## 🔍 4. Verificación de Puertos Implicados
Finalmente, se comprueba en la terminal que el puerto **21** no esté ocupado antes de instalar FileZilla Server.

* **Comando:** `netstat -an | grep 21` (Linux) o `netstat -an | findstr 21` (Windows).

> **📸 CAPTURA 2: Estado inicial de los puertos**
> ![Resultado Netstat](captura_terminal_netstat.png)

---

## 📝 Conclusiones de la Actividad
La arquitectura de doble canal y el uso del **Modo Pasivo** son los pilares para un despliegue exitoso de FileZilla Server. La separación de comandos y datos permite una gestión granular del tráfico y mayor compatibilidad con infraestructuras de red complejas.
