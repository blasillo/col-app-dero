

FROM openjdk:8-jdk-slim

RUN apt-get update && apt-get install -y iputils-ping && rm -rf /var/lib/apt/lists/*

# Variables de entorno Java
ENV JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk
ENV PATH=$JAVA_HOME/bin:$PATH

# Crear usuario no root
RUN groupadd -r appuser && useradd -r -g appuser appuser

# Directorio de trabajo
WORKDIR /app

# Copiar WAR y otros archivos
COPY target/col*app*.war /app/colapp.war
COPY flag.txt /app/flag/flag.txt

# Cambiar propietario a appuser
RUN chown -R appuser:appuser /app

# Exponer puerto
EXPOSE 8080

# Ejecutar como usuario no root
USER appuser

# Comando para ejecutar la app
ENTRYPOINT ["java","-jar","/app/colapp.war"]