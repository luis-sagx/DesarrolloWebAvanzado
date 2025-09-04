#!/bin/bash

# Script para construir y subir microservicios a Docker Hub
# Usuario Docker Hub: luissagx
# Tag: v1

# Colores para output
GREEN='\033[0;32m'
BLUE='\033[0;34m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

DOCKER_USER="luissagx"
TAG="v1"

echo -e "${BLUE}🐳 Iniciando proceso de construcción y subida de imágenes Docker...${NC}"

# Verificar si Docker está corriendo
if ! docker info > /dev/null 2>&1; then
    echo -e "${RED}❌ Docker no está corriendo. Por favor inicia Docker.${NC}"
    exit 1
fi

# Función para construir y subir un servicio
build_and_push_service() {
    SERVICE_NAME=$1
    SERVICE_PORT=$2
    
    echo -e "${YELLOW}📦 Procesando $SERVICE_NAME...${NC}"
    
    # Cambiar al directorio del servicio
    cd "/home/luis/Desktop/ESPE/Web Avanzado/3p/practica/$SERVICE_NAME"
    
    # Construir la imagen Docker (incluyendo compilación Maven)
    echo -e "${BLUE}🏗️  Construyendo imagen Docker para $SERVICE_NAME (incluye compilación)...${NC}"
    docker build -t "$DOCKER_USER/$SERVICE_NAME:$TAG" .
    
    if [ $? -ne 0 ]; then
        echo -e "${RED}❌ Error construyendo imagen Docker para $SERVICE_NAME${NC}"
        return 1
    fi
    
    # Subir la imagen a Docker Hub
    echo -e "${BLUE}☁️  Subiendo $SERVICE_NAME a Docker Hub...${NC}"
    docker push "$DOCKER_USER/$SERVICE_NAME:$TAG"
    
    if [ $? -ne 0 ]; then
        echo -e "${RED}❌ Error subiendo $SERVICE_NAME a Docker Hub${NC}"
        return 1
    fi
    
    echo -e "${GREEN}✅ $SERVICE_NAME procesado exitosamente${NC}"
    echo ""
}

# Verificar si el usuario está logueado en Docker Hub
echo -e "${BLUE}🔐 Verificando login en Docker Hub...${NC}"
if ! docker info | grep -q "Username: $DOCKER_USER"; then
    echo -e "${YELLOW}⚠️  No estás logueado en Docker Hub. Iniciando login...${NC}"
    docker login
    
    if [ $? -ne 0 ]; then
        echo -e "${RED}❌ Error en login de Docker Hub${NC}"
        exit 1
    fi
fi

echo -e "${GREEN}✅ Usuario logueado correctamente${NC}"
echo ""

# Construir y subir cada servicio
build_and_push_service "course" "8081"
build_and_push_service "student" "8082"
build_and_push_service "grades" "8083"
build_and_push_service "gateway" "8080"

echo -e "${GREEN}🎉 ¡Todas las imágenes han sido construidas y subidas exitosamente!${NC}"
echo ""
echo -e "${BLUE}📋 Imágenes disponibles en Docker Hub:${NC}"
echo "  🐳 $DOCKER_USER/course:$TAG"
echo "  🐳 $DOCKER_USER/student:$TAG"
echo "  🐳 $DOCKER_USER/grades:$TAG"
echo "  🐳 $DOCKER_USER/gateway:$TAG"
echo ""
echo -e "${BLUE}💡 Para usar las imágenes:${NC}"
echo "  docker pull $DOCKER_USER/course:$TAG"
echo "  docker pull $DOCKER_USER/student:$TAG"
echo "  docker pull $DOCKER_USER/grades:$TAG"
echo "  docker pull $DOCKER_USER/gateway:$TAG"
