git checkout main
git fetch --all
git reset --hard origin/main


docker-compose pull
docker-compose down
docker-compose up -d --no-build --remove-orphans

#docker image prune -a --force