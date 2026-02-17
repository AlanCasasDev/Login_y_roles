# 🔐 Sistema de Login y Gestión de Roles

Sistema básico de autenticación y gestión de roles desarrollado en Java.  
El proyecto implementa persistencia con JPA, base de datos SQL y una interfaz gráfica desarrollada con Java Swing.

---

## 📋 Descripción

Aplicación de escritorio que permite:

- Registro de usuarios
- Inicio de sesión
- Gestión de roles (por ejemplo: administrador, usuario)
- Control de acceso según rol
- Persistencia de datos en base de datos SQL mediante JPA

El objetivo del proyecto es aplicar conceptos de:

- Programación orientada a objetos
- Arquitectura en capas
- Persistencia con JPA
- Conexión a base de datos MySQL
- Interfaz gráfica con Swing

---

## 🏗 Arquitectura

El proyecto está organizado en capas:

- **IGU (Interfaz Gráfica)** → Pantallas Swing
- **Lógica** → Reglas de negocio
- **Persistencia** → Acceso a datos mediante JPA
- **Entidades** → Clases mapeadas a la base de datos

Se sigue una separación clara de responsabilidades para facilitar mantenimiento y escalabilidad.

---

## 🛠 Tecnologías Utilizadas

- Java
- Swing
- JPA (Java Persistence API)
- MySQL
- XAMPP (para entorno local)
- NetBeans (IDE)

---

## 🗄 Base de Datos

El sistema utiliza MySQL.

### Configuración:

1. Instalar XAMPP
2. Iniciar Apache y MySQL
3. Crear una base de datos llamada `sistema_gestion_roles`
4. Importar el archivo SQL incluido en la carpeta `/database`
5. Verificar usuario y contraseña en el archivo de configuración (`persistence.xml` o clase de conexión)

---

## ▶ Cómo Ejecutar el Proyecto

1. Clonar el repositorio:
2. Configurar la base de datos.
3. Abrir el proyecto en NetBeans.
4. Ejecutar la clase `Main`.
5. La base de datos tiene 2 usuarios cargados. El administrador (Usuario: MasterChief / Password: Abi123) y un usuario normal(Usuario: Abi / Password: Matecito98). Usar esas dos credenciales para testear inicialmente. Luego se pueden cargar mas.

---

## 🎯 Funcionalidades Principales

- Autenticación de usuario
- Validación de credenciales
- Control de acceso por rol
- Persistencia automática con JPA
- Interfaz amigable en entorno de escritorio

---

## 📚 Objetivo Académico

Este proyecto fue desarrollado con fines de aprendizaje para consolidar conocimientos en:

- JPA
- Arquitectura en capas
- Gestión de usuarios y roles
- Desarrollo de aplicaciones de escritorio en Java

---

## 👨‍💻 Autor

Alan Andrés Casas Fontana  
Desarrollador Java en formación.



