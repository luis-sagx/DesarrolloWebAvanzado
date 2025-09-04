# Microservicios de Gestión Académica

Sistema de microservicios para gestión académica desarrollado con Spring Boot.

## 🏗️ Arquitectura

El sistema está compuesto por 4 microservicios:

- **API Gateway** (Puerto 8080): Punto de entrada único
- **Course Service** (Puerto 8081): Gestión de cursos
- **Student Service** (Puerto 8082): Gestión de estudiantes  
- **Grades Service** (Puerto 8083): Gestión de calificaciones

## 📋 Servicios

### Course Service
- **CRUD completo** de cursos
- **Atributos**: id, nombre, creditos
- **Endpoint**: `/api/courses`

### Student Service  
- **CRUD completo** de estudiantes
- **Atributos**: id, nombre, apellido, email (único)
- **Endpoint**: `/api/students`

### Grades Service
- **Gestión de calificaciones** estudiante-curso
- **Atributos**: id, studentId, courseId, nota
- **Endpoint**: `/api/grades`
- **Endpoint especial**: `/api/grades/student/{studentId}` - Todas las notas de un estudiante

## 🐳 Despliegue con Docker

### Subir imágenes a Docker Hub
```bash
# Hacer login en Docker Hub
docker login

# Ejecutar script de despliegue
./deploy-to-dockerhub.sh
```

### Ejecutar con Docker Compose
```bash
# Iniciar todos los servicios
docker-compose up -d

# Ver logs
docker-compose logs -f

# Detener servicios
docker-compose down
```

## 🗄️ Base de Datos

- **MySQL 8.0**
- **Base de datos**: `prueba-luis-sagnay`
- **Usuario**: `root`
- **Password**: `root`

## 🚀 Endpoints Principales

### A través del Gateway (Puerto 8080)
- **GET** `/api/info` - Información del gateway
- **GET** `/api/health` - Estado del gateway

### Estudiantes
- **GET** `/api/students` - Listar estudiantes
- **POST** `/api/students` - Crear estudiante
- **GET** `/api/students/{id}` - Obtener estudiante
- **PUT** `/api/students/{id}` - Actualizar estudiante
- **DELETE** `/api/students/{id}` - Eliminar estudiante

### Cursos
- **GET** `/api/courses` - Listar cursos
- **POST** `/api/courses` - Crear curso
- **GET** `/api/courses/{id}` - Obtener curso
- **PUT** `/api/courses/{id}` - Actualizar curso
- **DELETE** `/api/courses/{id}` - Eliminar curso

### Calificaciones
- **GET** `/api/grades` - Listar calificaciones
- **POST** `/api/grades` - Crear calificación
- **GET** `/api/grades/{id}` - Obtener calificación
- **GET** `/api/grades/student/{studentId}` - Calificaciones de un estudiante
- **PUT** `/api/grades/{id}` - Actualizar calificación
- **DELETE** `/api/grades/{id}` - Eliminar calificación

## 📝 Ejemplos de uso

### Crear un estudiante
```json
POST http://localhost:8080/api/students
{
  "nombre": "Juan",
  "apellido": "Pérez",
  "email": "juan.perez@email.com"
}
```

### Crear un curso
```json
POST http://localhost:8080/api/courses
{
  "nombre": "Programación Web Avanzada",
  "creditos": 4
}
```

### Crear una calificación
```json
POST http://localhost:8080/api/grades
{
  "studentId": 1,
  "courseId": 1,
  "nota": 8.5
}
```

## 🛠️ Desarrollo Local

### Prerrequisitos
- Java 17
- Maven
- Docker
- MySQL (o usar container)

### Iniciar servicios individualmente
```bash
# Course Service
cd course && ./mvnw spring-boot:run

# Student Service  
cd student && ./mvnw spring-boot:run

# Grades Service
cd grades && ./mvnw spring-boot:run

# Gateway
cd gateway && ./mvnw spring-boot:run
```

## 🐋 Imágenes Docker

Las imágenes están disponibles en Docker Hub:
- `luissagx/course:v1`
- `luissagx/student:v1`  
- `luissagx/grades:v1`
- `luissagx/gateway:v1`

## 👨‍💻 Autor
Luis Sagnay - ESPE Universidad
