# Reporte de Proyecto: Agenda Telefónica (AddressBook)

## Repositorio en Línea
El proyecto se encuentra alojado en el siguiente repositorio de GitHub:
[https://github.com/kdej94-coder/mi-proyecto/tree/develop/AddressBook](https://github.com/kdej94-coder/mi-proyecto/tree/develop/AddressBook)

## Solución Implementada

Se ha desarrollado una aplicación de consola en Java que permite gestionar una agenda telefónica. La solución se compone de dos clases principales:

1. **`AddressBook.java`**: Es la clase principal que maneja la lógica de negocio. Utiliza un `HashMap<String, String>` para almacenar los contactos en memoria, donde la llave es el número de teléfono y el valor es el nombre del contacto. Esto garantiza que no existan números duplicados y permite una búsqueda eficiente.
   - **`load()`**: Lee el archivo `contacts.csv` al iniciar la aplicación. Si el archivo existe, carga cada línea, la separa por comas y añade el contacto al `HashMap`.
   - **`save()`**: Escribe todos los contactos del `HashMap` en el archivo `contacts.csv` reescribiéndolo con el formato `Número,Nombre`.
   - **`list()`**: Itera sobre el `HashMap` y muestra los contactos guardados con el formato `{Número} : {Nombre}`.
   - **`create(numero, nombre)`**: Agrega un nuevo contacto al diccionario previa validación de que el número no exista.
   - **`delete(numero)`**: Elimina un contacto del diccionario utilizando su número telefónico como llave.

2. **`Main.java`**: Proporciona el menú interactivo al usuario. Utiliza un bucle `while` y la clase `Scanner` para capturar las opciones del usuario. Desde este menú es posible listar, crear y borrar contactos, además de guardar y salir del programa de forma segura para no perder la información modificada.

## Evidencia de Funcionamiento (Capturas de Consola)

A continuación, se presenta la salida en consola del programa durante su ejecución, demostrando las funcionalidades solicitadas:

### 1. Inicio y carga
```text
Archivo de contactos no encontrado. Se creará uno nuevo al guardar.

--- Agenda Telefónica ---
1. Mostrar contactos (list)
2. Crear nuevo contacto (create)
3. Borrar contacto (delete)
4. Guardar y Salir
Seleccione una opción: 
```

### 2. Creación de un contacto
```text
Seleccione una opción: 2
Ingrese el número telefónico: 5551234567
Ingrese el nombre del contacto: Juan Perez
Contacto creado exitosamente.
```

### 3. Listar contactos
```text
Seleccione una opción: 1
Contactos:
5551234567 : Juan Perez
```

### 4. Borrar un contacto
```text
Seleccione una opción: 3
Ingrese el número telefónico a eliminar: 5551234567
Contacto eliminado: 5551234567 : Juan Perez
```

### 5. Guardar y salir
```text
Seleccione una opción: 4
Cambios guardados exitosamente en el archivo.
Saliendo de la aplicación...
```

## Formato del Archivo (contacts.csv)
El sistema guarda los datos en texto plano respetando el formato CSV (valores separados por comas):
```csv
5551234567,Juan Perez
```
