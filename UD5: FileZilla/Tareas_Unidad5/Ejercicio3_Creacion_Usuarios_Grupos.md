# Ejercicio 3: Creación de usuarios y grupos 

En esta fase se configura la seguridad lógica del servidor mediante la jerarquía de grupos y el control de acceso individual.

## 👥 1. Grupo y Directorio Raíz
Se ha creado el grupo **"Grupo_Limitado"** definiendo su directorio raíz en una carpeta local del escritorio. Para cumplir con el requisito de seguridad, se ha establecido el modo de acceso en **"Read only"** (Solo lectura), impidiendo que cualquier miembro del grupo borre o modifique archivos.

> **📸 CAPTURA 1: Configuración del grupo y permisos de lectura**
>
> ![1](https://github.com/user-attachments/assets/aa86b926-68cb-4182-90b1-c683d263ab16)

## 👤 2. Usuarios y Asociación
Se han desplegado dos cuentas de usuario (**usuario1** y **usuario2**) protegidas por contraseña. Ambas han sido vinculadas al grupo anteriormente creado, heredando de forma automática sus permisos y su directorio raíz.

> **📸 CAPTURA 2: Usuarios vinculados al grupo**
>
> ![2](https://github.com/user-attachments/assets/9498f8d6-2ccb-40e2-ada4-932f8190d65c)

## ⏳ 3. Límites de Conexión
Se ha establecido un límite de **2 conexiones concurrentes** a nivel de grupo para garantizar la estabilidad del servicio y evitar la saturación del servidor.

> **📸 CAPTURA 3.3: Configuración de límites de sesiones**
>
> ![3](https://github.com/user-attachments/assets/e88f57d1-ebde-4eb1-a98d-5e3e5ea654a8)

---

## 📚 Diferencias entre permisos de usuario y permisos de grupo

Para la entrega de esta tarea, se definen las siguientes diferencias clave:

1. **Eficiencia administrativa:** Los permisos de grupo permiten aplicar una política de seguridad (como el modo "Solo lectura") a múltiples usuarios de una sola vez. Si mañana decidimos permitir la escritura, solo editamos el grupo y no cada cuenta individual.
2. **Herencia y prioridad:** En FileZilla, el usuario hereda la configuración del grupo por defecto. Sin embargo, los permisos de usuario permiten crear excepciones personalizadas (por ejemplo, dar permiso de escritura a un usuario específico dentro de un grupo de lectura).
3. **Organización de recursos:** El grupo centraliza el "Mount Point" (directorio raíz), mientras que el usuario gestiona la identidad y las credenciales de acceso personales.
