# Utiliza la imagen base de PostgreSQL
FROM postgres:latest

# Copia el archivo SQL dentro del contenedor
COPY ./init.sql /docker-entrypoint-initdb.d/

# Establece las variables de entorno para la base de datos
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=6yM*sample
ENV POSTGRES_DB=gym
