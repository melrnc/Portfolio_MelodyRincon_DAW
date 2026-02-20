# Ejercicio 4: Configuración de acceso anónimo 

En esta fase se ha habilitado un punto de acceso público al servidor para permitir la consulta de archivos generales sin necesidad de gestionar credenciales individuales.

## 🛠️ 1. Configuración del perfil "anonymous"
Se ha creado un usuario con el nombre reservado **"anonymous"**. En la sección de autenticación, se ha configurado el método **"Do not require authentication"**, lo que permite el ingreso al sistema sin solicitar una contraseña al cliente.

> **📸 CAPTURA 1: Configuración del usuario anónimo y permisos**
>
> ![1](https://github.com/user-attachments/assets/619940bb-173d-428f-8e40-eb2b32fa0c53)

## 📂 2. Restricción de Directorio y Permisos
Para proteger la integridad del servidor, el usuario anónimo ha sido limitado exclusivamente a la carpeta `/` vinculada a la ruta local `Desktop\Publico_Anonimo`. Se ha establecido el modo de acceso como **"Read only"** (Solo lectura), impidiendo cualquier intento de carga o modificación de archivos por parte de usuarios no identificados.

---

## ⚙️ 3. Ajuste de Seguridad del Listener (Protocolo)
Debido a que el cliente FTP nativo de Windows (CMD) no soporta el cifrado TLS moderno por defecto, se ha modificado el Listener del puerto 21. Se ha configurado el protocolo como **"Insecure plain FTP"**, permitiendo así la compatibilidad con clientes legacy para validar el acceso anónimo.

> **📸 CAPTURA 2: Configuración del protocolo de escucha**
> 
> ![2](https://github.com/user-attachments/assets/8fbc52c4-947d-41d1-ba5e-359e001af11a)

---

## 🌐 4. Verificación de Conexión Exitosa
Se ha validado el acceso mediante la consola de comandos de Windows (CMD). Tras conectar al host local e identificarse como "anonymous", el servidor ha permitido el ingreso exitoso con el mensaje **"230 Login successful"**, confirmando que la configuración es operativa.

> **📸 CAPTURA 4.3: Prueba de éxito en el CMD**
>
> ![3](https://github.com/user-attachments/assets/a26b8c3a-76a9-4177-96bb-efa8a7326fb5)

---

## 📝 Documentación del resultado
El acceso anónimo ha quedado implementado bajo los siguientes estándares de seguridad:
1. **Aislamiento**: Solo tiene acceso a la carpeta pública.
2. **Integridad**: Al carecer de permisos de escritura, el contenido del servidor permanece inalterable ante accesos externos.
3. **Compatibilidad**: La habilitación del modo "plain FTP" asegura que el servicio sea accesible desde herramientas básicas de diagnóstico.
