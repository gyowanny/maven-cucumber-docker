FROM java:8

RUN apt-get update --fix-missing
RUN apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

EXPOSE 8080

ADD api*.jar /

CMD ["ls", "-lart"]
CMD echo $JAVA_OPTS
CMD java $JAVA_OPTS -jar /api*.jar