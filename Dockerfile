FROM maven

RUN mkdir -p /usr/src/app

WORKDIR /usr/src/app

ADD . /usr/src/app

#RUN mvn install

EXPOSE 4567

#CMD ["mvn", "exec:java"]
