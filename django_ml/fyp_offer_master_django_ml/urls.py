from django.shortcuts import redirect
from django.urls import path, reverse

from fyp_offer_master_django_ml.views import ping

app_name = 'user'
urlpatterns = [
    path('ping', ping, name='ping'),
]