git pull
docker pull echocool/fyp_offer_master_springboot:latest
docker pull echocool/fyp_offer_master_vue_user:latest
docker pull echocool/fyp_offer_master_vue_admin:latest
docker pull echocool/fyp_offer_master_springboot_admin:latest
docker-compose down
docker-compose up -d --no-build