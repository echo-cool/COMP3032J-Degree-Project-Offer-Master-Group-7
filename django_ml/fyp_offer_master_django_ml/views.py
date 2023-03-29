import time

from django.http import HttpResponse
from django.shortcuts import render


# Create your views here.
def ping(request):
    # Get datetime, format yyyy-mm-dd hh:mm:ss
    currentTime = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())
    return HttpResponse("pong | " + currentTime)
