FROM rasa/rasa:3.5.5-full
# Set the working directory to /app
WORKDIR /app
# Copy the current directory contents into the container at /app
COPY . /app

# Install any needed packages specified in requirements.txt
#RUN apt update
#RUN apt install gcc g++ -y
#RUN pip install rasa

RUN rm -rf models
RUN rm -rf .rasa
# Change mode to 777
RUN chmod 777 -R /app
RUN rasa train

EXPOSE 18888
EXPOSE 18889
RUN chmod 777 entrypoint.sh
CMD ["./entrypoint.sh"]