git checkout main
git fetch --all
git reset --hard origin/main

docker-compose down -v --remove-orphans
docker-compose pull
docker-compose up -d --no-build --remove-orphans

docker image prune -a --force
docker container prune --force