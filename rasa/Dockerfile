FROM rasa/rasa:3.5.5-full
# Set the working directory to /app
WORKDIR /app
# Copy the current directory contents into the container at /app
COPY --chown=1001 . /app

# Install any needed packages specified in requirements.txt
#RUN apt update
#RUN apt install gcc g++ -y
#RUN pip install rasa

RUN rm -rf models
RUN rm -rf .rasa
RUN python -m spacy download en_core_web_trf
RUN rasa train

EXPOSE 18888
EXPOSE 18889
RUN chmod 777 entrypoint.sh
CMD ["./entrypoint.sh"]