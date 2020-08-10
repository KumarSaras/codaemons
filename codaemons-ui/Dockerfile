FROM node:latest as react_build 
#also say 
WORKDIR /app
#copy the react app to the container
COPY . /app/ 

# #prepare the contiainer for building react 
RUN npm install --silent 
RUN npm run build 

#prepare nginx
FROM nginx:latest

COPY --from=react_build /app/build/ /srv/www/static/
RUN rm /etc/nginx/conf.d/default.conf
COPY nginx/default.conf /etc/nginx/conf.d/default.conf
COPY nginx/codaemons-bundle.pem /etc/nginx/ssl/codaemons-bundle.pem
COPY nginx/server.key /etc/nginx/ssl/server.key

#fire up nginx
EXPOSE 443
CMD ["nginx","-g","daemon off;"]