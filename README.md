# Sistema de Administración de Citas IMSS

Sistema de consola en Java diseñado para llevar el control de registros médicos, gestionar doctores, pacientes y agendar citas sin conflictos de horario.

---

## Instalación y Configuración

### Requisitos previos
- Java JDK 11 o superior.
- Apache Maven (opcional para compilación).

### Pasos de instalación
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/TU_USUARIO/mi-proyecto.git
   ```
2. Navegar al directorio del proyecto:
   ```bash
   cd mi-proyecto
   ```
3. Compilar el proyecto usando Maven (Generar FAT JAR):
   ```bash
   mvn clean package
   ```
   *Esto descargará las dependencias necesarias y creará el ejecutable en la carpeta `target/`.*

---

## Uso del Programa

1. Ejecutar el programa desde el FAT JAR generado:
   ```bash
   java -jar target/sistema-citas-1.0-jar-with-dependencies.jar
   ```
2. Iniciar sesión usando las credenciales por defecto:
   - **ID Administrador:** admin
   - **Contraseña:** 1234
3. Navegar por las opciones del menú interactivo para dar de alta doctores, pacientes o generar nuevas citas médicas.

---

## Créditos

- **Carlos** - Desarrollo de la lógica, modelado de clases e implementación del proyecto.

---

## Licencia

Este proyecto está bajo la Licencia MIT.

```text
MIT License
Copyright (c) 2026 Carlos

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
```
