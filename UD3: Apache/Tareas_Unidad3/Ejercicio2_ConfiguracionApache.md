# Ejercicio 2: Configuración y Despliegue de Apache

## 1. Relación de Actividades Realizadas

En esta fase se ha procedido a la configuración técnica del servidor siguiendo la documentación oficial de Ubuntu.

### 1.1. Instalación del servidor

Se instaló el paquete `apache2` y se verificó que el servicio estuviera activo.

* **Comandos usados**:
```bash
sudo apt update
sudo apt install apache2

```



> ![1](https://github.com/user-attachments/assets/c100febf-4323-408c-b92e-f06fecb17d10)

### 1.2. Creación del sitio web personalizado

Siguiendo el paso 3 del tutorial, he creado un directorio específico para el proyecto y un archivo `index.html` con un toque personalizado por mí: Melody Rincón.

* **Comandos usados**:
```bash
sudo mkdir /var/www/mi_primera_web/
sudo nano /var/www/mi_primera_web/index.html

```



> ![2](https://github.com/user-attachments/assets/bd41f4fc-ff92-4b15-9816-6b4050a1202a)


### 1.3. Configuración del VirtualHost

Para que el servidor reconozca la nueva carpeta, se editó el archivo de configuración, añadiendo el correo de administrador y la ruta del sitio.

* **Comandos usados**:
```bash
cd /etc/apache2/sites-available/
sudo cp 000-default.conf mi_primera_web.conf
sudo nano mi_primera_web.conf

```


* **Directivas clave configuradas**:
* `ServerAdmin`: melodyabengozar@gmail.com
* `DocumentRoot`: `/var/www/mi_primera_web/`
* `ServerName`: `mi_primera_web.local`



> ![3](https://github.com/user-attachments/assets/0efc3340-899b-4d91-b71b-917af0222cfe)


---

## 2. Banco de Pruebas y Problemas Surgidos

Se han realizado pruebas sistemáticas para informar de los resultados obtenidos.

### 2.1. Resolución de incidencias

Durante el desarrollo surgieron los siguientes problemas:

* **Error de sintaxis**: Se detectó un fallo en la directiva `ServerName` mediante el comando `apache2ctl configtest`.
* **Codificación de caracteres**: Las tildes no se mostraban correctamente, error que se solucionó añadiendo la etiqueta meta UTF-8 en el HTML.
* **Nombre de archivo**: Se corrigió un error al guardar el archivo en nano que incluía caracteres especiales.

### 2.2. Verificación final

Tras activar el sitio con `sudo a2ensite mi_primera_web.conf` y reiniciar el servicio, se comprobó el acceso mediante el navegador.

> ![4](https://github.com/user-attachments/assets/3929ff9d-2998-4746-b7d2-25774985e37d)


---

## 3. Valoración de resultados

Una vez finalizado el trabajo, se confirma que el servidor es capaz de servir contenido de forma independiente al sitio por defecto. Personalmente, esta práctica ha sido muy útil para comprender la gestión de directorios y la importancia de las pruebas de errores en la administración de sistemas.

---
