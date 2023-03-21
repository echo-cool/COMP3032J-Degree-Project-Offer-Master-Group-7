git checkout main
git fetch --all
git reset --hard origin/main

docker pull ghcr.io/echo-cool/fyp/fyp_offer_master_springboot:latest
docker pull ghcr.io/echo-cool/fyp/fyp_offer_master_vue_user:latest
docker pull ghcr.io/echo-cool/fyp/fyp_offer_master_vue_admin:latest
docker pull ghcr.io/echo-cool/fyp/fyp_offer_master_springboot_admin:latest
docker-compose down
docker-compose up -d