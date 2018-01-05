FROM anapsix/alpine-java

MAINTAINER  dkubicki
VOLUME /tmp
EXPOSE 9010

ENV USER_NAME configclient
ENV APP_HOME /home/$USER_NAME/app

RUN adduser -S $USER_NAME
RUN mkdir $APP_HOME
RUN chown $USER_NAME $APP_HOME
RUN mkdir $APP_HOME/logs
RUN chown $USER_NAME $APP_HOME/logs

ADD build/libs/configclient-*.jar $APP_HOME/app.jar
RUN chown $USER_NAME $APP_HOME/app.jar

USER $USER_NAME
WORKDIR $APP_HOME
RUN sh -c 'touch app.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]