# Ejercicio 5: Pruebas en modo activo y pasivo 

En esta actividad se ha configurado la gestión de los canales de datos del servidor y se ha analizado el comportamiento de los modos Activo y Pasivo frente a las restricciones de red.

## ⚙️ 1. Configuración de Puertos Pasivos
Se ha establecido un rango de puertos personalizados entre **50000 y 50100** en la sección de *Passive mode settings*. Esta configuración permite que el servidor asigne un puerto específico para la transferencia de datos cuando un cliente solicita el modo pasivo, evitando conflictos con otros servicios y facilitando el paso a través del firewall.

> **📸 CAPTURA 1: Definición del rango de puertos pasivos**
>
> ![1](https://github.com/user-attachments/assets/a0397022-8977-4a78-bd79-c654b81566f3)

---

## 🧪 2. Verificación de la conexión (Modo Activo)
Para validar el funcionamiento, se ha realizado una conexión desde la terminal de Windows. Al ejecutar un listado de directorios, se observa en el log del servidor el uso del comando **`PORT`**. Esto confirma que el cliente está operando en **Modo Activo**, enviando su dirección IP y puerto al servidor para que este inicie la conexión de datos. El servidor responde con un código `200`, validando el comando.

> **📸 CAPTURA 2: Registro de comandos PORT en el log del servidor**
>
> ![2](https://github.com/user-attachments/assets/60f71f75-432b-4cda-a25e-687d72397246)

---

## 📊 3. Tabla Comparativa: Activo vs. Pasivo

| Característica | Modo Activo (PORT) | Modo Pasivo (PASV) |
| :--- | :--- | :--- |
| **Iniciador de datos** | El Servidor conecta al Cliente | El Cliente conecta al Servidor |
| **Comando técnico** | Utiliza el comando `PORT` | Utiliza el comando `PASV` / `EPSV` |
| **Firewall (Cliente)** | Suele dar problemas (tráfico entrante) | Funciona sin problemas |
| **Uso recomendado** | Redes locales sin restricciones | Estándar para Internet y redes con NAT |

---

## 💡 4. Análisis: ¿Qué modo funciona mejor con Firewall?

Tras las pruebas y el análisis técnico, se concluye que el **Modo Pasivo** es el que mejor funciona en redes protegidas por firewall o que utilizan NAT (routers).

**Razón principal:** En el **Modo Activo**, el servidor intenta abrir una conexión hacia el PC del cliente. La mayoría de los firewalls modernos bloquean cualquier intento de conexión entrante no solicitada explícitamente, provocando que la transferencia de archivos falle. 

En cambio, en el **Modo Pasivo**, es el **cliente quien tiene la iniciativa** de conectar hacia el servidor en un puerto del rango configurado (50000-50100). Como se trata de tráfico de salida desde la perspectiva del cliente, los firewalls lo permiten por defecto, garantizando una conexión estable y exitosa.
