FROM echocool/fyp-rasa-base:3.5.5
# Set the working directory to /app
USER root
WORKDIR /app
# Copy the current directory contents into the container at /app
COPY --chown=1001 . /app

# Install any needed packages specified in requirements.txt
#RUN apt update
#RUN apt install gcc g++ -y
#RUN pip install rasa

RUN rm -rf models
RUN rm -rf .rasa
RUN rasa train

EXPOSE 18888
EXPOSE 18889
#RUN chmod 777 entrypoint.sh
#CMD ["./entrypoint.sh"]