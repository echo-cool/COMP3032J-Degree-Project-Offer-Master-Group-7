git pull
docker build . -t echocool/fyp_offer_master_rasa
docker push echocool/fyp_offer_master_rasa
docker tag echocool/fyp_offer_master_rasa:latest echocool/fyp_offer_master_rasa:`date +%Y%m%d%H%M%S`
docker push echocool/fyp_offer_master_rasa:`date +%Y%m%d%H%M%S`
