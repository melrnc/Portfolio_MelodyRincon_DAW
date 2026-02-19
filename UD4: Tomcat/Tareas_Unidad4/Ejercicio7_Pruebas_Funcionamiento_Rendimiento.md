# Ejercicio 7. Pruebas de Funcionamiento y Rendimiento

En esta fase final, he sometido al servidor a pruebas de estrés para evaluar su comportamiento bajo carga y he aplicado ajustes técnicos en el pool de hilos para optimizar la capacidad de respuesta.

### 📊 1. Benchmarking Inicial (Configuración por defecto)
He utilizado **ApacheBench (ab)** para simular un escenario de alta concurrencia con **1000 peticiones** totales y un nivel de **100 usuarios simultáneos**.

* **Requests per second:** 85.24 [#/sec] (media).
* **Time per request:** 1173.222 [ms] (media).
* **Latencia máxima:** 3282 ms.

> **📸 CAPTURAS 1.1, 1.2 y 1.3: Resultados Pre-Optimización**
> Se documenta el inicio del test, el resumen de métricas de rendimiento y la tabla de porcentajes de servicio originales.
> 
> ![1 1](https://github.com/user-attachments/assets/38a5f54f-03eb-400a-a16c-745f3de6db9c)

> ![1 2](https://github.com/user-attachments/assets/72c34383-9a42-4a75-bfb5-6f0bc14f1c7b)

> ![1 3](https://github.com/user-attachments/assets/919aed66-24c3-44b2-a463-2741cc91d15f)

---

### ⚙️ 2. Optimización del Conector en `server.xml`
Para mejorar estos resultados, he modificado la configuración del conector en el archivo `server.xml`. El objetivo es permitir que Tomcat gestione un mayor volumen de peticiones paralelas mediante la ampliación del pool de hilos de ejecución (*threads*).

**Cambios aplicados:**
* `maxThreads="500"`: Aumento del límite de trabajadores simultáneos.
* `minSpareThreads="50"`: Mantenimiento de hilos en reserva para evitar latencia de creación.
* `acceptCount="200"`: Gestión de cola para peticiones en espera.

---

### 🚀 3. Benchmarking Final (Tras optimización)
Tras aplicar los cambios y reiniciar el servicio, he repetido la prueba bajo las mismas condiciones (1000 peticiones / 100 concurrentes). Los resultados muestran una optimización significativa del rendimiento.

> **📸 CAPTURAS 2.1, 2.2 y 2.3: Resultados Post-Optimización**
> Evidencia de la mejora en la tasa de transferencia y la reducción de tiempos de respuesta.
> 
> ![2 1](https://github.com/user-attachments/assets/a7c89578-c08b-4561-a875-925539b1b59a)

> ![2 2](https://github.com/user-attachments/assets/7aab2a41-cab0-44d0-8c93-25e5e08b8d29)

> ![2 3](https://github.com/user-attachments/assets/bd46bc9d-8e5a-4da5-8db7-b453ae73643e)


### 📈 Comparativa de Resultados

| Métrica | Estado Inicial | Tras Optimización | Mejora |
| :--- | :--- | :--- | :--- |
| **Peticiones por segundo** | 85.24 rps | **122.09 rps** | **+43.2%** |
| **Tiempo por petición (mean)** | 1173.22 ms | **819.09 ms** | **-30.1%** |
| **Tiempo total de ejecución** | 11.73 s | **8.19 s** | **3.54 s menos** |

**Conclusión:** La sintonización de los parámetros del conector ha permitido que el servidor procese un volumen de tráfico mucho mayor en menos tiempo, reduciendo la latencia media y optimizando el aprovechamiento de los recursos del sistema.
