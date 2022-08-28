FROM java:8

EXPOSE 8091

ADD target/docker-onlineVegetableShopping.jar docker-onlineVegetableShopping.jar 

ENTRYPOINT ["java","-jar","docker-onlineVegetableShopping.jar"]