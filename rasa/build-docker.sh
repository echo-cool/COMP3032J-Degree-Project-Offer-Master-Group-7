git pull
docker build . -t echocool/fyp_offer_master_rasa:`git rev-parse --short HEAD`
docker push echocool/fyp_offer_master_rasa:`git rev-parse --short HEAD`
docker tag echocool/fyp_offer_master_rasa:`git rev-parse --short HEAD` echocool/fyp_offer_master_rasa:latest
docker push echocool/fyp_offer_master_rasa:latest
