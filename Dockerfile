FROM openjdk:8

EXPOSE 8080

ADD target/docker-onlineVegetableShopping.jar docker-onlineVegetableShopping.jar 

ENTRYPOINT ["java","-jar","/docker-onlineVegetableShopping.jar"]