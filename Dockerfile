FROM maven:onbuild

EXPOSE 4567

CMD ["mvn", "exec:java"]
