
# Ejercicio 3. Seguridad HTTPS

## 1. Investigación Teórica

Antes de la ejecución técnica, es fundamental comprender los protocolos y herramientas que garantizan la seguridad en la web.

### 1.1. ¿Qué es HTTPS y por qué es importante?

HTTPS (**HyperText Transfer Protocol Secure**) es la versión segura del protocolo HTTP. Su función principal es cifrar los datos que viajan entre el cliente (navegador) y el servidor (Apache) utilizando el protocolo **SSL/TLS**.

Es vital por tres razones:

1. **Cifrado (Confidencialidad):** Nadie puede "espiar" la comunicación.
2. **Integridad:** Los datos no pueden ser alterados durante el trayecto.
3. **Autenticidad:** Garantiza que el sitio web es legítimo y no una suplantación.

### 1.2. Tipos de Certificados

Para que HTTPS funcione, el servidor necesita un certificado digital:

* **Certificado Autofirmado:** Es el que generamos nosotros. Cifra la conexión igual de bien que uno profesional, pero el navegador mostrará una advertencia porque no está validado por una entidad externa. Es el estándar para entornos de desarrollo y prácticas escolares.
* **Certificado de CA Confiable (Let's Encrypt):** Emitido por una Autoridad de Certificación reconocida. Los navegadores confían en él automáticamente y muestran el candado verde/gris sin advertencias.

### 1.3. Módulos necesarios en Apache

Para implementar esta seguridad, en Ubuntu debemos trabajar con:

* **mod_ssl:** Proporciona las capacidades de criptografía fuertes para Apache.
* **mod_headers:** Permite manipular las cabeceras de respuesta HTTP, necesario para configurar políticas de seguridad avanzadas.

---

## 2. Ejecución Técnica (Guía paso a paso)

Sigue estos comandos en tu terminal de Ubuntu y recuerda realizar las capturas indicadas:

### Paso 1: Activar el motor de seguridad (SSL)

Apache necesita cargar el módulo específico para gestionar conexiones seguras.

```bash
sudo a2enmod ssl
sudo systemctl restart apache2

```

> **📸 CAPTURA 1:** Terminal confirmando que el módulo `ssl` se ha habilitado y el servicio se ha reiniciado.

### Paso 2: Generar el Certificado y la Llave

Vamos a crear nuestra propia "identidad" digital válida por 365 días.

```bash
sudo openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout /etc/ssl/private/apache-selfsigned.key -out /etc/ssl/certs/apache-selfsigned.crt

```

* **Importante:** Cuando te pregunte **"Common Name"**, pon la IP de tu servidor (`10.0.2.15`).

> **📸 CAPTURA 2:** Proceso donde rellenas los datos (Country, City, etc.) en la terminal.

### Paso 3: Configurar el VirtualHost Seguro

Editamos el archivo de configuración para adaptarlo al puerto 443 (HTTPS).

```bash
sudo nano /etc/apache2/sites-available/mi_primera_web-ssl.conf

```

Dentro del archivo, pega este bloque (asegúrate de que el `DocumentRoot` coincida con el del Ejercicio 2):

```apache
<VirtualHost *:443>
    ServerAdmin MelodyRincon@ejemplo.com
    DocumentRoot /var/www/mi_primera_web
    ServerName mi_primera_web.local

    SSLEngine on
    SSLCertificateFile /etc/ssl/certs/apache-selfsigned.crt
    SSLCertificateKeyFile /etc/ssl/private/apache-selfsigned.key
</VirtualHost>

```

> **📸 CAPTURA 3:** Editor `nano` mostrando la configuración del puerto 443 y las rutas de los certificados.

### Paso 4: Activación final

Activamos el nuevo sitio seguro y recargamos Apache.

```bash
sudo a2ensite mi_primera_web-ssl.conf
sudo systemctl reload apache2

```

> **📸 CAPTURA 4:** Confirmación de que el sitio SSL está activo en la terminal.

### Paso 5: El Banco de Pruebas

Abre el navegador en Ubuntu y escribe: `https://10.0.2.15`

* **Aviso:** Te saldrá una advertencia de seguridad. Haz clic en **"Avanzado"** y luego en **"Aceptar el riesgo y continuar"**.

> **📸 CAPTURA 5:** Mi web visualizándose con el protocolo **https://**.

---

## 3. Problemas surgidos y Conclusiones

*(Añadir aquí si tuve que corregir alguna ruta o el aviso del navegador).*

---
