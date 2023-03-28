#FROM node:16 as build-stage
#WORKDIR /app
#COPY . .
#RUN npm install -g npm@9.6.2
#RUN npm install
#RUN npm run build

# production stage
FROM nginx:stable-alpine as production-stage
LABEL org.opencontainers.image.source="https://github.com/echo-cool/COMP3032J-Degree-Project-Offer-Master-Group-7"
#COPY --from=build-stage /app/dist /usr/share/nginx/html
COPY /dist /usr/share/nginx/html
COPY prod_nginx.conf /etc/nginx/nginx.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
