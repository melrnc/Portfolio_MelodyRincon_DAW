# Ejercicio 8: Configuración de FTP seguro - FTPS 

En esta actividad se ha procedido a securizar el servidor mediante el uso de certificados **TLS (Transport Layer Security)**, garantizando que tanto las credenciales de acceso como los datos transferidos viajen de forma cifrada por la red.

## 🔒 1. Generación de Certificado TLS
Se ha generado un certificado X.509 auto-firmado directamente desde la consola de administración de **FileZilla Server**. Este certificado actúa como la "llave" de identidad del servidor, permitiendo establecer túneles seguros con los clientes compatibles.

## 🛡️ 2. Aplicación de la Política de Seguridad Obligatoria
Para cumplir con el requisito de obligatoriedad, se ha modificado la **Protocol Policy** del perfil del `usuario1`. Se ha configurado el parámetro **FTP authentication (insecure)** en modo **Disallowed**. 

Esta configuración es crítica: el servidor ya no permite el "paso" a ninguna conexión que no utilice **FTPS (FTP over TLS)**, eliminando la posibilidad de ataques por escucha de red (sniffing).

## ✅ 3. Verificación y Evidencias
Para validar la configuración, se ha intentado un acceso mediante el Explorador de Windows (cliente que no soporta cifrado explícito):

* **Resultado en el Cliente:** El sistema muestra una ventana de error de inicio de sesión persistente, ya que el servidor rechaza la negociación en texto plano.
* **Resultado en el Servidor (Log):** El log registra el intento fallido con el mensaje en rojo: `Realm ftp is disabled for user usuario1. Authentication cannot continue.`, confirmando que la política de seguridad está activa y funcionando.

> **📸 CAPTURA 1: Bloqueo de sesión insegura y evidencia del log del servidor**
> 
> ![1](https://github.com/user-attachments/assets/1e30cc67-39b4-4b19-906c-86e0496fcbc2)
>
> ![2](https://github.com/user-attachments/assets/f8b8eb31-b3cf-4eac-b159-3bd7ad7d0834)
