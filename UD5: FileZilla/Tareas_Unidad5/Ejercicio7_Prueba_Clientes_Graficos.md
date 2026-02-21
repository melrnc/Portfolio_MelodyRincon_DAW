# Actividad 7: Pruebas con clientes gráficos 

Se ha validado la operatividad del servidor mediante un entorno gráfico, utilizando el Explorador de Archivos de Windows como cliente FTP. Esta prueba confirma que el servidor es accesible y funcional para usuarios finales sin experiencia en consola.

## 🚀 1. Verificación de descarga (RETR)
Se ha realizado una transferencia desde el servidor hacia el almacenamiento local. En los logs del servidor se observa el comando `RETR prueba.txt`, seguido del código de estado `226 Operation successful`, lo que confirma que la sesión se gestionó correctamente.

> **📸 CAPTURA 1: Log de transferencia y archivo descargado en Documentos**
> 
> ![1](https://github.com/user-attachments/assets/f760714a-f14e-4c6e-8581-f6155189dac3)

## 📝 2. Conclusiones de la prueba
La prueba gráfica demuestra la correcta configuración de los **Mount Points** (apuntando al Escritorio del sistema) y la efectividad de los permisos de lectura. La integración nativa con el Explorador de Windows valida que el servidor cumple con los estándares del protocolo FTP.
