# Tarea 7. Pruebas de Funcionamiento y Rendimiento

En esta fase se ha evaluado la capacidad de respuesta del servidor bajo condiciones de estrés y se han aplicado optimizaciones en la configuración del conector.

### 📊 1. Test de Carga Inicial
He utilizado la herramienta **ApacheBench (ab)** para simular un escenario de 1000 peticiones totales con una concurrencia de 100 usuarios simultáneos.

* **Resultado inicial:** [Inserta aquí tus rps, ej: 150.23] requests/sec.
> **📸 CAPTURA 1:** Resultado del primer test de estrés con ApacheBench.



### ⚙️ 2. Optimización del Servidor (`server.xml`)
Para mejorar el rendimiento, he modificado el archivo de configuración de Tomcat aumentando el pool de hilos disponibles para el conector HTTP/S.

* **Ajustes realizados:**
    * `maxThreads`: Elevado a 500 para procesar más peticiones en paralelo.
    * `minSpareThreads`: Ajustado a 50 para reducir la latencia de creación de hilos.
    * `acceptCount`: Configurada una cola de 200 para evitar rechazos inmediatos de conexión.

> **📸 CAPTURA 2:** Fragmento del archivo `server.xml` con los nuevos parámetros de rendimiento.

### 🚀 3. Comparativa y Resultados Finales
Tras reiniciar el servicio y repetir la prueba de carga, se observa una mejora en la capacidad de procesamiento del servidor.

| Métrica | Antes del ajuste | Después del ajuste |
| :--- | :--- | :--- |
| **Requests per second** | [Dato 1] | [Dato 2] |
| **Time per request (mean)** | [Dato 3] ms | [Dato 4] ms |

**Conclusión:** El ajuste de los hilos permite que Tomcat aproveche mejor los recursos del sistema (CPU/RAM), reduciendo el tiempo de espera de los usuarios durante picos de tráfico.
