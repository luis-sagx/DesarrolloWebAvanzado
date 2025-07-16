# Etapa 1: Construcción
FROM node:20-alpine AS builder

WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build -- --configuration production

# Etapa 2: Servidor Nginx
FROM nginx:alpine
COPY --from=builder /app/dist/Sagnay_Luis_Leccion2/browser /usr/share/nginx/html

COPY nginx.conf /etc/nginx/conf.d/default.conf
