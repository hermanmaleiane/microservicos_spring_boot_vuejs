FROM java:8 as loginService

EXPOSE 8080
ADD ./target/microservices-login-0.0.1-SNAPSHOT microservices-login-0.0.1-SNAPSHOT
ENTRYPOINT ["java","-jar","microservices-login-0.0.1-SNAPSHOT"]