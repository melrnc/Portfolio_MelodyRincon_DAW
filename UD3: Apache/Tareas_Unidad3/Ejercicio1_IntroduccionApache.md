# Ejercicio 1: Introducción al Servidor Web Apache

## 1. Resumen
En esta primera fase del proyecto se establece la base teórica y el contexto necesario para el despliegue de un servidor web. Se analiza qué es Apache HTTP Server, su importancia histórica en el desarrollo de la web moderna y por qué sigue siendo una de las opciones más robustas para entornos Linux. Además, se definen los objetivos del proyecto y se comparan diversas alternativas existentes en el mercado actual para entender mejor el ecosistema de servidores web.

## 2. Palabras Clave
* Apache2
* Servidor Web
* Open Source
* Ubuntu Server
* Protocolo HTTP

---

## 3. Introducción

### 3.1. Contexto
Este proyecto se realiza en el marco de la Unidad 3 de la asignatura de Implantación de Aplicaciones Web, en el centro de estudios. El entorno de trabajo consiste en una máquina virtual con **Ubuntu Server**, donde se llevará a cabo la instalación y configuración del servidor. 

Para este despliegue utilizaremos **Apache**, un servidor web de código abierto. Apache (oficialmente llamado *Apache HTTP Server*) es el software que recibe las peticiones de los navegadores y les entrega los archivos necesarios (HTML, imágenes, etc.) para que podamos visualizar una web. Es mantenido por la Apache Software Foundation y ha sido, durante décadas, el servidor más utilizado en el mundo debido a su modularidad y estabilidad.

### 3.2. Alternativas en el mercado
Aunque Apache es una opción excelente, existen otros servidores web con diferentes enfoques:
* **Nginx:** Su principal rival. Es conocido por ser extremadamente ligero y manejar muy bien un alto volumen de conexiones simultáneas. Se usa mucho como proxy inverso.
* **Microsoft IIS (Internet Information Services):** La opción propietaria de Microsoft, integrada en entornos Windows Server.
* **LiteSpeed:** Un servidor comercial que promete mucha velocidad y es compatible con las configuraciones de Apache.

### 3.3. Motivación
La motivación principal de esta práctica es aprender a administrar un servidor web desde cero en un entorno real de Linux. Basándonos en Apache, el objetivo es entender cómo se gestionan las peticiones de red, cómo organizar el contenido web y, lo más importante, cómo asegurar el tráfico de datos. Queremos conseguir un servidor funcional, personalizado y preparado para trabajar de forma segura bajo el protocolo HTTPS, aplicando configuraciones de control de acceso y certificados digitales.

---

## 4. Índice de la Práctica
1. Introducción y Contexto (Completado)
2. Instalación y Configuración Básica de Apache
3. Personalización de sitio web y Control de Acceso
4. Implementación de Seguridad mediante HTTPS
5. Banco de pruebas, Conclusiones y Bibliografía
