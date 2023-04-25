FROM python:3.9-slim-buster
# Set the working directory to /app
WORKDIR /app
# Copy the current directory contents into the container at /app
COPY . /app

# Install any needed packages specified in requirements.txt
RUN apt update
RUN apt install gcc g++ -y
RUN pip install rasa

RUN rm -rf models
RUN rm -rf .rasa

RUN rasa train

EXPOSE 18888
EXPOSE 18889
RUN chmod 777 entrypoint.sh
CMD ["./entrypoint.sh"]