docker build -t countries-api-img .
docker run -d --rm -p 8282:8080 --name countries-api-app --link countries-pg-db-app:pgdb countries-api-img