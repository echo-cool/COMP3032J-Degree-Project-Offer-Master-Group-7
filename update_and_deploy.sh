git checkout main
git fetch --all
git reset --hard origin/main

sudo docker-compose down --remove-orphans
sudo docker-compose pull
sudo docker-compose up -d --no-build --remove-orphans

#docker image prune -a --force