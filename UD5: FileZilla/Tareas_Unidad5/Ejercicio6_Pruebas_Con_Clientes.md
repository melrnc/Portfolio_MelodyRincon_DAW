# Actividad 6: Pruebas con clientes en línea de comandos 

Se ha verificado la operatividad total del servidor FTP utilizando el cliente CLI nativo de Windows. Se ha realizado un flujo de trabajo completo para validar la gestión de archivos y permisos.

## 💻 1. Proceso de verificación CLI
Se ha utilizado el terminal de comandos situando el directorio activo en el Escritorio local (`cd Desktop`) para interactuar con los archivos de prueba. La sesión valida la autenticación, el listado de directorios y la bidireccionalidad de las transferencias (subida y descarga).

> **📸 CAPTURA 6.1: Sesión completa de operaciones FTP (Login, LS, GET y PUT)**
> 
> ![1](https://github.com/user-attachments/assets/f11d4645-709a-4195-8c8e-944e21dad77a)

## 📋 2. Comandos ejecutados y resultados

| Comando | Acción Realizada | Código de Respuesta |
| :--- | :--- | :--- |
| `ls` | Listado del contenido de Carpeta_Grupo. | `226 Directory send OK` |
| `get prueba.txt` | Descarga del archivo desde el servidor al PC. | `226 Transfer complete` |
| `put subida.txt` | Carga del archivo local hacia el servidor. | `226 Operation successful` |

## 📝 Documentación del resultado
La prueba ha resultado exitosa, confirmando que el servidor procesa correctamente las solicitudes de datos. La ejecución del comando `put` sin errores de acceso demuestra que la configuración de los **Mount Points** y los permisos de **Read/Write** para el grupo de usuarios son correctos y operativos.
