git checkout main
git fetch --all
git reset --hard origin/main


/home/student/.local/bin/docker-compose pull
/home/student/.local/bin/docker-compose down
/home/student/.local/bin/docker-compose up -d --no-build --remove-orphans

#docker image prune -a --force