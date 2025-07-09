# Sagnay_Luis_Ex2_Contador

Aplicación web desarrollada en **Angular 20** que simula un **velocímetro digital interactivo**. Permite al usuario acelerar, frenar y reiniciar la velocidad, con estilos visuales según el rango de velocidad alcanzado.

---

## Funcionalidades

- Incrementar velocidad (+5 km/h)
- Disminuir velocidad (-3 km/h, mínimo 0)
- Reiniciar velocidad a 0
- Rango visual según velocidad:
  - **Baja**: 0–30 km/h
  - **Media**: 31–70 km/h
  - **Alta**: 71–120 km/h
  - **Peligrosa**: >120 km/h (hasta un máximo de 400 km/h)

---

## Estructura básica del proyecto

Incluye los siguientes archivos importantes para contenerizar y desplegar la aplicación:

- `.dockerignore`
- `nginx.conf`
- `Dockerfile`
- `README.md`

---

## Docker: Construcción y despliegue

### 1. Crear archivo `.dockerignore`

```bash
node_modules
dist
.git
.gitignore
docker-compose.yml
README.md
```

### 2. Crear archivo nginx.conf
server {
  listen 80;
  server_name localhost;

  root /usr/share/nginx/html;
  index index.html;

  location ~* \.(js|mjs|css|json|ico|png|jpg|jpeg|gif|svg|woff|woff2|ttf|eot|otf)$ {
    try_files $uri =404;
    access_log off;
    add_header Cache-Control "public, max-age=31536000";
  }

  location / {
    try_files $uri $uri/ /index.html;
  }
}

### 3. Crear archivo Dockerfile

```Dockerfile
# Etapa 1: Construcción
FROM node:20-alpine AS builder
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build -- --configuration production

# Etapa 2: Servidor Nginx
FROM nginx:alpine
COPY --from=builder /app/dist /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf

```

### 4. Crear repositorio en Docker Hub
Ve a https://hub.docker.com/ y crea un nuevo repositorio público o privado. 


### 5. Construir la aplicación Angular localmente

```bash
npm install
ng build --configuration production

```

### 6. Construir la imagen Docker
```bash
docker build -t luisls/sagnay-contador .
```

### 7. Probar la imagen localmente
```bash
docker run -p 8080:80 luisls/sagnay-contador
``` 

Abrir en el navegador:
http://localhost:8080

### 8. Iniciar sesión en Docker Hub
```bash
docker login
```
### 9. Subir la imagen a Docker Hub
```bash
docker push luisls/sagnay-contador
```

### 10. Usar la imagen desde cualquier parte
```bash
docker pull luisls/sagnay-contador
docker run -p 80:80 luisls/sagnay-contador
```

---

## Requisitos
- Node.js y npm
- Angular CLI (npm install -g @angular/cli)
- Docker

## Autor
Luis Sagnay