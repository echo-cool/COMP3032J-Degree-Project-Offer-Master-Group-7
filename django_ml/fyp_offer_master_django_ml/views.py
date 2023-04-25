import time

import requests
from asgiref.sync import sync_to_async
from django.http import HttpResponse, JsonResponse
from django.shortcuts import render
from django.views.decorators.csrf import csrf_exempt


# Create your views here.
def ping(request):
    # Get datetime, format yyyy-mm-dd hh:mm:ss
    currentTime = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())
    return HttpResponse("pong | " + currentTime)


action_list = {
    "GET_ORDER_LIST": lambda x: JsonResponse([{"test": "test"}], safe=False, json_dumps_params={'ensure_ascii': False}),
}


@csrf_exempt
def _rasa_chat(request):
    if request.method == "POST":
        message = request.POST.get('message')
        message: str = str(message)
        print(message)
        url = 'http://fyp_offer_master_rasa:5005/webhooks/rest/webhook'
        data = {
            'sender': 'Anonymous_' + request.get_host(),
            'message': message
        }
        print(data)
        try:
            response = requests.post(url, json=data, timeout=15)
            print(response.text)
            print(response.json())
            action = response.json()[0]['text']
            print(action)
            # time.sleep(0.8)
            if action in action_list.keys():
                return action_list[action](request)
            return JsonResponse(response.json(), safe=False, json_dumps_params={'ensure_ascii': False})
        except Exception as e:
            print(e)
            print("RASA NOT STARTED")
            data = [{
                "recipient_id": 'Anonymous_' + request.get_host(),
                "text": "RASA NOT STARTED!",
                "e": str(e)
            }]
            return JsonResponse(data, safe=False, json_dumps_params={'ensure_ascii': False})
    return JsonResponse([{
        "error": "Please send a POST request"
    }], safe=False, json_dumps_params={'ensure_ascii': False})


rasa_chat = sync_to_async(_rasa_chat)
