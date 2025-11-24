### 1. Tarea 1: Protección de Datos Sensibles

El objetivo de esta tarea es garantizar que la información crítica del proyecto (como las claves de la API de Spotify y las configuraciones de entorno) se excluya del control de versiones. Esto se logra mediante la creación y configuración del archivo `.gitignore`.

#### 1.1 Configuración del Archivo `.gitignore`

El archivo `.gitignore` se colocó en la raíz del proyecto e incluye patrones específicos para las tres categorías de datos sensibles:

* **Secretos y Credenciales:** Excluye `.env`, `secrets.json`, `credentials.json`, `*.key`, etc.
* **Artefactos Generados:** Excluye `/node_modules`, `/dist`, `/build`, que son carpetas que se regeneran y no deben versionarse.
* **Configuraciones Locales:** Excluye `.vscode/` y archivos temporales para evitar conflictos entre desarrolladores.

A continuación, se muestra una captura de pantalla del contenido del archivo `.gitignore` en Visual Studio Code, justo antes de ser confirmado:

![1](https://github.com/user-attachments/assets/f00d5173-692f-43d3-8b34-a59152f9a60e)

#### 1.2 Justificación de la Exclusión en `SECURITY.md`

La justificación de la exclusión de estos archivos se encuentra detallada en el documento **`SECURITY.md`**, que también se subió al repositorio.

* **Razón principal:** Exponer archivos como **`.env`** (que contiene el `Client ID` y `Client Secret` de la API de Spotify) en un repositorio público o compartido es una **vulnerabilidad crítica** que comprometería la cuenta del desarrollador y el uso del servicio.
* **Gestión de Secretos:** Se establece que las credenciales deben cargarse en tiempo de ejecución o mediante sistemas de gestión de secretos, y no almacenarse en el repositorio.

### 2. Tarea 2: Accesibilidad del Repositorio y Gestión de Colaboradores

El objetivo fue configurar el repositorio para permitir el acceso a un compañero y documentar el proceso.

#### 2.1 Proceso de Configuración de Acceso

Se ha invitado al colaborador `PabloHuertasCastillo` a través de la sección **Settings > Manage access** del repositorio:

1.  **Inicio de la Invitación:**
    * Se accedió a la configuración y se pulsó **"Add people"** (Añadir personas).

> ![1](https://github.com/user-attachments/assets/cc993047-d2ff-4c7a-b2d3-8dc2dd6811b4)

> ![3](https://github.com/user-attachments/assets/f608b2c5-d4a2-4b58-b82e-79724561e74c)

2.  **Aceptación del Colaborador:**
    * El compañero aceptó la invitación, quedando listado en la sección de colaboradores con el rol de Colaborador.
      
> ![4](https://github.com/user-attachments/assets/6516db7a-1a48-4acc-9c22-0b9c5bf857dc)


#### 2.2 Roles Probados y Justificación

Debido a las limitaciones de la interfaz en una cuenta personal de GitHub (no Organización), solo se puede asignar explícitamente el rol de "Collaborator" (Escritura). A continuación, se justifican los tres niveles de acceso requeridos:

| Rol | Evidencia | Justificación |
| :--- | :--- | :--- |
| **Escritura (Write)** | **Collaborator** | Rol asignado. Permite al desarrollador hacer `push` a ramas y contribuir al código. |
| **Lectura (Read)** | Invitación al Repositorio Privado. | Se considera el acceso de lectura, que es el mínimo necesario para que el compañero pueda ver y clonar el código del repositorio privado. |
| **Administrador (Admin)** | Captura de **Transfer ownership** en Danger Zone. | Este nivel de control total solo se puede simular mediante la transferencia de la propiedad, siendo el Propietario (yo) el único Administrador. | 
> ![5](https://github.com/user-attachments/assets/46ffefb6-668a-4119-86f3-fb4ce5771f0e)
> ![6](https://github.com/user-attachments/assets/b60fbe55-fae8-4908-8308-27b4ea015ebd)







