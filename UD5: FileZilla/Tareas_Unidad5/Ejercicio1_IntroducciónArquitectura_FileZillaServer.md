# Ejercicio 1: Introducción y Arquitectura de FileZilla Server

Esta actividad establece la base teórica necesaria para la implementación de un servidor de transferencia de archivos, analizando protocolos, arquitectura de red y gestión de puertos.

---

## 1. Fundamentos: FTP, FTPS y SFTP
Antes de analizar la arquitectura, es vital distinguir los protocolos de transferencia y sus niveles de seguridad:

| Protocolo | Seguridad | Descripción | Puerto |
| :--- | :--- | :--- | :--- |
| **FTP** | **Nula** | Envía datos y contraseñas en texto plano. Inseguro por naturaleza. | 21 |
| **FTPS** | **Alta** | FTP protegido por una capa de cifrado **SSL/TLS**. | 21 / 990 |
| **SFTP** | **Alta** | Protocolo de transferencia basado en **SSH**. No es realmente FTP. | 22 |

---

## 2. Arquitectura de Doble Canal
FileZilla Server utiliza una arquitectura de doble canal para separar las instrucciones del tráfico de archivos:

1.  **Canal de Control (Puerto 21):** Gestiona el saludo inicial, la autenticación del usuario y los comandos de navegación.
2.  **Canal de Datos:** Se abre de forma efímera para el envío de archivos o listados de directorios.

> **📸 CAPTURA 1.1: Esquema del Canal de Control**
> 
> ![canal_control](https://github.com/user-attachments/assets/dcf1a352-0079-485e-9d79-4ed62b2b33c8)
>
> **📸 CAPTURA 1.2: Esquema del Canal de Datos**
> 
> ![canal_datos](https://github.com/user-attachments/assets/5bbfdb14-70c4-4bbd-87b8-aaf5a3ce5312)

---

## 3. Diferencias entre Modo Activo y Pasivo
El éxito de la conexión depende de qué extremo inicie la transferencia de datos. El **Modo Pasivo** es el estándar recomendado para evitar bloqueos de firewall.

> **📸 CAPTURA 1.3: Comparativa Modo Activo vs Pasivo**
> 
> ![modo_activo_pasivo](https://github.com/user-attachments/assets/62172cc6-fd38-4a95-80d4-715a5f06172a)

---

## 🔍 4. Verificación de Puertos Implicados

Para realizar la auditoría de puertos, se procedió a la instalación del paquete `net-tools` en el sistema Ubuntu.

> **📸 CAPTURA 2.1: Verificación de instalación de net-tools**
> 
> Se utiliza el final del proceso de instalación para confirmar que el paquete se encuentra correctamente configurado en el sistema.
> 
> ![1 1](https://github.com/user-attachments/assets/d6cdc364-9aa5-45e7-a3a3-46ed186aabc2)

Una vez instalado, se ejecutó el comando de diagnóstico para el puerto **21**:
* **Comando:** `netstat -an | grep 21`

> **📸 CAPTURA 2.2: Estado de puertos antes de FileZilla**
> 
> Se observa actividad en sockets internos, pero se confirma que el puerto de red 21 está libre y disponible para el futuro servicio.
> 
> ![1 2](https://github.com/user-attachments/assets/0dc4443e-ac28-4add-aae4-ad1629086846)

---

## 📝 Conclusiones de la Actividad
La arquitectura de **FileZilla Server** requiere una gestión precisa de los canales. Se ha verificado que el sistema está preparado para la instalación y que el **Modo Pasivo** será la configuración óptima para garantizar la visibilidad del servidor tras firewalls y NAT.
