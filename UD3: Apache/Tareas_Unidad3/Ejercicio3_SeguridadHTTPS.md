
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

> ![1](https://github.com/user-attachments/assets/719a065c-4ff7-4f52-86f0-f81f3185d804)


### Paso 2: Generar el Certificado y la Llave

Vamos a crear nuestra propia "identidad" digital válida por 365 días.

```bash
sudo openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout /etc/ssl/private/apache-selfsigned.key -out /etc/ssl/certs/apache-selfsigned.crt

```

* **Importante:** Cuando te pregunte **"Common Name"**, pon la IP de tu servidor (`10.0.2.15`).

> ![2](https://github.com/user-attachments/assets/8257792a-0258-4847-94b6-29b33a0f68b1)


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

> ![3](https://github.com/user-attachments/assets/16114b10-f1de-4da1-b333-57074461f4c9)


### Paso 4: Activación final

Activamos el nuevo sitio seguro y recargamos Apache.

```bash
sudo a2ensite mi_primera_web-ssl.conf
sudo systemctl reload apache2

```

> ![4](https://github.com/user-attachments/assets/9c661884-e7d7-4db6-a589-179f2d939e8b)


### Paso 5: El Banco de Pruebas

Abre el navegador en Ubuntu y escribe: `https://10.0.2.15`

* **Aviso:** Te saldrá una advertencia de seguridad. Haz clic en **"Avanzado"** y luego en **"Aceptar el riesgo y continuar"**.

> ![5 1](https://github.com/user-attachments/assets/326b95f3-60f1-48d4-87f6-ffed6242368d)


![5 2](https://github.com/user-attachments/assets/791ecc3c-fc44-47f3-9f52-4d54b9a13ffb)

---

## 3. Problemas surgidos y Conclusiones

### 3.1. Problemas surgidos
A diferencia del ejercicio anterior, la configuración del VirtualHost para el puerto 443 fue fluida. No obstante, se detectaron los siguientes puntos a tener en cuenta:

Advertencia de Seguridad en el Navegador: Al acceder mediante https://, el navegador mostró un mensaje de advertencia indicando que la conexión no era privada. Esto no se debe a un error de configuración, sino a que estamos utilizando un certificado autofirmado que no está validado por una Autoridad de Certificación (CA) reconocida.

Persistencia del puerto 80: Se observó que si se entra por http:// (sin la S), la web sigue cargando de forma no segura. Para una implementación real, lo ideal sería configurar una redirección permanente (301) hacia HTTPS.

### 3.2. Conclusiones y Valoración Personal
La realización de esta práctica ha sido fundamental para comprender el ciclo de vida de un certificado SSL/TLS, desde su generación con openssl hasta su implementación en Apache.

Como futura desarrolladora web, considero imprescindible dominar estos conceptos, ya que hoy en día la seguridad no es una opción, sino un estándar (impulsado por el posicionamiento SEO y la protección de datos). Me ha resultado especialmente satisfactorio ver cómo, tras habilitar el puerto 443 y los módulos correspondientes, la web pasa a estar cifrada, garantizando la integridad de la información que viaja entre el cliente y mi servidor Ubuntu.

---
