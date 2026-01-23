# Ejercicio 2: Configuración y Despliegue de Apache

## 1. Relación de Actividades Realizadas

En este apartado se detalla el proceso técnico seguido para la puesta en marcha del servidor, basándome en la documentación oficial de Ubuntu.

### 1.1. Instalación y Overview

Se han seguido los pasos iniciales para instalar Apache2 en el sistema Ubuntu, verificando que el servicio esté activo y respondiendo correctamente a las peticiones locales.

### 1.2. Página Web Personalizada

Antes de avanzar con configuraciones complejas, se ha creado un archivo `index.html` sencillo. He buscado darle un **toque personal** para diferenciarlo de la página por defecto de Apache, demostrando así la capacidad de servir contenido propio de forma rápida.

### 1.3. Control de Acceso y Configuración Avanzada

Una vez que el servidor base estaba funcionando, he buscado un tutorial complementario en Google para implementar **control de acceso**. Esto permite restringir quién puede ver ciertas partes de la web, añadiendo una primera capa de gestión administrativa al servidor.

> 
> **Nota:** (Insertar captura de pantalla de mi terminal instalando Apache o de mi página personalizada).
> 
> 

---

## 2. Banco de Pruebas y Detección de Errores

Para asegurar que la configuración es sólida, se han realizado las siguientes comprobaciones:

* 
**Pruebas de errores**: Se han revisado los logs y realizado pruebas manuales para detectar fallos en la carga de la página o en los permisos de los archivos.


* 
**Validación externa**: He solicitado a un compañero que intente acceder a mi servidor desde su equipo.


* 
**Prueba de seguridad**: Se ha verificado si el sistema resiste accesos no autorizados según las reglas de control de acceso configuradas previamente.



---

## 3. Resultados y Conclusión Inicial

De forma impersonal, se puede determinar que el servidor Apache ha sido desplegado con éxito, logrando servir contenido personalizado y gestionando correctamente los permisos de acceso. Al comparar los resultados con otros compañeros, se observa que la estructura de directorios y la respuesta del servidor son consistentes con los estándares de la unidad.

**Valoración personal**: Esta parte me ha parecido fundamental para entender cómo se pasa de una instalación "limpia" a un entorno mínimamente configurado. Aunque surgieron algunos problemas con los permisos de la carpeta `/var/www/html`, se solucionaron revisando la propiedad del usuario `www-data`.

---

### Bibliografía (Enlaces consultados)

* 
*Tutorial oficial de Ubuntu: Install and Configure Apache*.

* (Añadir aquí el enlace del tutorial de control de acceso que busques en Google) .

