# Política de Seguridad del Repositorio - PracticaFinalCojali

Este documento establece las políticas y procedimientos para garantizar que el código fuente y la documentación del proyecto se gestionen de forma segura, cumpliendo con las buenas prácticas de la industria.

---

## 1. Protección de Datos Sensibles (Tarea 1)

Para evitar la exposición de credenciales y otros datos críticos, se ha implementado un archivo `.gitignore`. La regla fundamental es **no versionar nunca la información que permita el acceso a servicios externos**.

### 1.1 Justificación de Archivos Excluidos
Los siguientes archivos y directorios están excluidos del control de versiones por las siguientes razones:

| Archivo/Patrón | Categoría | Justificación de Seguridad |
| :--- | :--- | :--- |
| **`.env`, `secrets.json`** | Secretos/Credenciales | **CRÍTICO.** Contienen las claves de la API de Spotify (`Client ID`, `Client Secret`) u otras credenciales. Subir estos archivos es una vulnerabilidad mayor que expondría las credenciales públicamente, pudiendo resultar en el uso no autorizado de la API o la revocación de las claves. |
| **`/node_modules`** | Artefactos generados | Contiene todas las dependencias instaladas (librerías). Se puede restaurar con `npm install`. Excluirlo mantiene el repositorio pequeño y evita inconsistencias y ruido en el historial de Git. |
| **`/dist`, `/build`** | Artefactos generados | Archivos binarios o compilados listos para producción. Estos son generados a partir del código fuente y no deben versionarse. |
| **`.vscode/`, `.idea/`** | Configuraciones Locales | Contienen configuraciones específicas del editor/IDE del desarrollador. No son necesarios para el proyecto y pueden causar conflictos entre colaboradores. |

---

## 2. Gestión de Accesibilidad y Permisos (Tarea 2)

La asignación de permisos se basa en el principio de **mínimo privilegio**, garantizando que cada miembro del equipo solo tenga el acceso necesario para su rol, minimizando el riesgo de errores accidentales o malintencionados.

| Rol en el Equipo | Permiso Adecuado en GitHub | Justificación |
| :--- | :--- | :--- |
| **Desarrollador** (Contribuidor Activo) | **Write (Escritura)** | Permite hacer *push* a ramas de trabajo, crear *Pull Requests* (PRs) y participar en revisiones. Es el nivel estándar de contribución. |
| **Auditor/Revisor QA** | **Read (Lectura)** | Solo necesita clonar el código y revisarlo sin poder modificar el repositorio. |
| **Administrador/Líder Técnico** | **Admin (Administrador)** | Necesario para configurar las políticas de seguridad (ej. protección de ramas), gestionar permisos y modificar la configuración crítica del repositorio. |

**Conclusión:** Para un compañero que va a trabajar en el desarrollo del código, el nivel de permiso **"Write" (Escritura)** es el más adecuado, ya que le permite contribuir activamente sin tener la capacidad de cambiar la configuración de seguridad o borrar el repositorio.

---

## 3. Buenas Prácticas de Seguridad y Recuperación (Tarea 3)

Se implementan las siguientes medidas para proteger el código y la documentación contra errores y pérdidas de datos:

### 3.1 Protección de la Documentación y el Código Fuente

Para proteger la rama principal (`main` o `master`) que contiene el código final estable:

* **Uso de Ramas Protegidas (Branch Protection Rules):** La rama principal está configurada en GitHub para:
    * **Requerir Revisión de Pull Request:** Ningún código puede ser fusionado sin la aprobación de al menos un revisor. Esto es esencial para **detectar vulnerabilidades** y garantizar la calidad antes de la fusión.
    * **Restringir Pushes Directos:** Se prohíbe subir código directamente a la rama principal, forzando todo cambio a pasar por el flujo de *Pull Request*.

### 3.2 Garantía de Recuperación del Repositorio

La recuperación del repositorio en caso de pérdida de datos o errores graves (ej. borrado accidental en GitHub) se garantiza mediante una estrategia de redundancia:

* **Redundancia de Copias Locales:** Cada desarrollador mantiene una **copia local completa (*clone*)** del repositorio. En un escenario de pérdida total, el repositorio puede ser restaurado subiendo el contenido (incluyendo el historial) desde una de estas copias locales.
* **Respaldo del Proveedor:** Se confía en la infraestructura de GitHub que, por defecto, ofrece un alto nivel de redundancia y copias de seguridad de sus servidores.