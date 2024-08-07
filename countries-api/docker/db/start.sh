docker build -t countries-pg-db-img .
docker run -d --rm -p 5434:5432 --name countries-pg-db-app countries-pg-db-img