# Diario de Aprendizaje - Unidad 5: Servidor de Transferencia de Archivos (FTP)

En esta unidad he explorado el protocolo FTP mediante el uso de **FileZilla Server**, aprendiendo a gestionar el almacenamiento y la distribución de archivos de forma eficiente y segura.

## 1. Qué he aprendido

A través de las 12 actividades de la unidad, he consolidado los siguientes conocimientos:

* **Arquitectura y Despliegue:** Comprendo la arquitectura de FileZilla Server y cómo realizar una instalación y configuración inicial sólida.
* **Gestión de Accesos:** He aprendido a administrar la seguridad mediante la creación de **usuarios y grupos**, incluyendo la configuración de accesos anónimos controlados.
* **Modos de Conexión:** He diferenciado y probado el funcionamiento de los modos **Activo y Pasivo**, entendiendo cómo influyen los puertos y el firewall en la conexión.
* **Variedad de Clientes:** He realizado pruebas de conectividad desde múltiples entornos: línea de comandos, clientes gráficos (FileZilla Client) y navegadores web.
* **Seguridad (FTPS):** Implementación de **FTP Seguro** mediante el uso de certificados para cifrar la transmisión de datos.
* **Integración y Buenas Prácticas:** He integrado el servicio FTP con servidores web y aplicado criterios de disponibilidad y seguridad profesional.

## 2. Qué no entiendo

* **Configuración de Puertos en Modo Pasivo:** A veces me resulta confuso el rango de puertos que hay que abrir en el router/firewall para que el modo pasivo funcione correctamente en redes externas (NAT).
* **FTPS vs SFTP:** Aunque hemos configurado FTPS (FTP sobre SSL), me gustaría entender mejor la diferencia técnica real frente a SFTP (que usa SSH), ya que a veces se confunden en entornos laborales.

## 3. Qué es lo que más me ha gustado y qué es lo que menos

* **Lo que más:** Ver la diferencia real entre el modo activo y el pasivo al realizar las pruebas. También me ha gustado mucho la **Actividad 10**, al ver cómo el FTP se convierte en la herramienta real para subir contenido a un servidor web.
* **Lo que menos:** Las pruebas con clientes de **línea de comandos**. Aunque son necesarias para entender el protocolo, resultan mucho más áridas y menos intuitivas que usar un cliente gráfico.

## 4. Qué más me gustaría saber relacionado con la Unidad

* **Automatización:** Me gustaría saber cómo programar scripts para que se realicen copias de seguridad automáticas de una base de datos y se suban solas al servidor FTP cada noche.
* **Cuotas de Disco:** Profundizar en cómo limitar el espacio que cada usuario puede ocupar en el servidor para evitar que un solo cliente llene todo el almacenamiento.

---
