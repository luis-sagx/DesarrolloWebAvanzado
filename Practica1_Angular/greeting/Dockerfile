# Etapa 1: Construcción
FROM node:20-alpine AS builder
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build -- --configuration production

# Etapa 2: Servidor Nginx
FROM nginx:alpine
COPY --from=builder /app/dist/greeting/browser /usr/share/nginx/html

#Usa este archivo para definir cómo responder a las peticiones que lleguen al servidor.
COPY nginx.conf /etc/nginx/conf.d/default.conf

#CMD ["nginx", "-g", "daemon off;"]