FROM postgres
ENV POSTGRES_DB=countries
ENV POSTGRES_PASSWORD=postgres
COPY create-schema.sql /docker-entrypoint-initdb.d/
COPY insert-data.sql /docker-entrypoint-initdb.d/
EXPOSE 5432