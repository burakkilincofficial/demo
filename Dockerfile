FROM java:8-jre

LABEL maintainers="burakkilincofficial@gmail.com" \
	  image_description="demo-0.0.1-SNAPSHOT jar app" \
	  app_environment="dev" \
	  app_version='0.0.1-SNAPSHOT.jar"
	  
COPY ./target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar

EXPOSE 8080
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]