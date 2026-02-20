# Ejercicio 2: Instalación y configuración inicial del servidor

En esta actividad se realiza la implementación de FileZilla Server 1.12.3 en un entorno Windows, asegurando el cumplimiento de los requisitos de servicio y conectividad.

---

## 🛠️ 1. Proceso de Instalación e Inicio Automático
Se ha ejecutado el asistente de instalación configurando el servidor como un servicio del sistema. Se ha seleccionado la opción por defecto que permite que el motor del servidor se inicie automáticamente con Windows, garantizando la disponibilidad del servicio FTP sin intervención manual.

> **📸 CAPTURA 1: Configuración del tipo de servicio**
> 
> ![1](https://github.com/user-attachments/assets/19e4bd74-d868-47c1-a0fb-6932a5928f4d)

---

## 🔑 2. Seguridad y Puerto de Administración
Durante el despliegue, se ha definido el puerto **14148** para la interfaz de administración local. Asimismo, se ha establecido una contraseña de acceso para asegurar que solo el administrador pueda realizar cambios en la configuración del servidor.

> **📸 CAPTURA 2: Definición de puerto y contraseña administrativa**
> 
> ![2](https://github.com/user-attachments/assets/2696f3b2-1b0b-4f2c-93a4-994d863cfc61)

---

## 🖥️ 3. Acceso a la Interfaz de Gestión
Una vez finalizada la instalación, se procede al login en la consola de administración conectando al host local (**127.0.0.1**). Esta separación entre el servicio y la interfaz permite una gestión centralizada y segura.

> **📸 CAPTURA 3: Ventana de login a la consola**
> 
> ![3](https://github.com/user-attachments/assets/51367cf3-7be8-41ef-978e-49cebb443ab6)

---

## ⚙️ 4. Configuración de Listeners (Puerto 21 e IP)
Para que el servidor sea accesible, se ha configurado un "Listener" en el puerto estándar **21**. Se ha utilizado la dirección IP **0.0.0.0**, lo que indica que el servidor escuchará peticiones en todas las interfaces de red IPv4 disponibles en la máquina.

> **📸 CAPTURA 4: Configuración de Server Listeners**
> 
> ![4](https://github.com/user-attachments/assets/08877d6f-129f-4d7b-a4a4-3ef1483c269d)

---

## ✅ 5. Verificación del Servicio Activo
Tras aplicar los cambios, se verifica el correcto funcionamiento a través del log de eventos. El registro confirma que el servidor ha comenzado a escuchar en la dirección y puerto asignados (**0.0.0.0:21**), mostrando un estado de conexión exitosa en la barra inferior.

> **📸 CAPTURA 5: Verificación final del servidor en funcionamiento**
> 
> ![5](https://github.com/user-attachments/assets/fa6d65a6-a552-455c-a59d-e690eef06bdd)

---

## 📝 Conclusión de la Actividad
El servidor FileZilla ha sido instalado y parametrizado correctamente. Cumple con los requisitos de inicio automático como servicio y está habilitado para recibir conexiones externas a través del puerto 21, quedando listo para la fase de gestión de usuarios.
