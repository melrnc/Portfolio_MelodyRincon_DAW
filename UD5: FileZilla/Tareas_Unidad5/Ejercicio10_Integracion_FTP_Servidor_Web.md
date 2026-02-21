# Ejercicio 10: Integración de FTP con servidor web 

En esta actividad se valida la utilidad del protocolo FTP como método de subida y despliegue de contenidos para un servidor web, vinculando el directorio compartido con el acceso mediante navegador.

## 🌐 1. Flujo de publicación web
El proceso de publicación seguido consta de los siguientes pasos técnicos:
1. **Creación**: Se genera un archivo `index.html` con etiquetas básicas de encabezado y párrafo.
2. **Transferencia**: Se utiliza el servidor FTP para alojar el archivo dentro del directorio raíz del grupo (**Carpeta_Grupo**).
3. **Verificación**: Se comprueba desde el lado del cliente que el archivo es accesible y que el navegador es capaz de interpretar el código HTML correctamente.

## 📊 2. Análisis del método
* **Eficiencia**: La actualización de la web es instantánea; en cuanto el archivo se deposita en la carpeta del servidor, el contenido queda disponible para los usuarios.
* **Seguridad de acceso**: Al usar cuentas de usuario específicas (como `usuario1`), se garantiza que solo el personal autorizado pueda modificar el contenido del sitio web.

> **📸 CAPTURA 1: Confirmación del archivo index.html en el servidor FTP**
> 
> Se observa la ruta `127.0.0.1 > Carpeta_Grupo` conteniendo el archivo web subido.
>
> ![1](https://github.com/user-attachments/assets/7fdd3102-2266-4b81-ae61-acae2c1847ac)

> **📸 CAPTURA 2: Visualización del resultado final en el navegador**
> 
> Se comprueba que el navegador renderiza el código HTML mostrando el mensaje de éxito.
> 
> ![2](https://github.com/user-attachments/assets/55547a9b-36cc-4fac-b001-9ad1a493223e)
