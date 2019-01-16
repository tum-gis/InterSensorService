# InterSensorservice Dockerfile ###############################################
#   Official website    http://www.intersensorservice.org/
#   GitHub              https://github.com/tum-gis/InterSensorService
###############################################################################
# Base image
ARG baseimage_tag='8-jdk-alpine'
FROM openjdk:${baseimage_tag}


# Labels ######################################################################
LABEL maintainer="Bruno Willenborg"
LABEL maintainer.email="b.willenborg(at)tum.de"
LABEL maintainer.organization="Chair of Geoinformatics, Technical University of Munich (TUM)"
LABEL source.repo="https://github.com/tum-gis/InterSensorService"

# Setup InterSensorService
ARG intersensorservice_version='master'
ENV INTERSENSORSERVICE_VERSION=${intersensorservice_version}

# Build deps
RUN set -ex && \
 apk update && \
 apk add --no-cache --virtual .fetch-deps openssl git

# Setup build deps
RUN set -ex && \  
  apk add --no-cache --virtual .build-deps \
  maven

# Clone InterSensorService
RUN set -x && \
  git clone -b "${INTERSENSORSERVICE_VERSION}" --depth 1 https://github.com/tum-gis/InterSensorService.git build_tmp
  
RUN set -x && \
  java -version

# Install InterSensorService
RUN set -x && \
  cd build_tmp && \
  mvn clean install

# Install InterSensorService
RUN set -x && \
  ls -lA && \
  mkdir -p /intersensorservice/config && \
  mv build_tmp/target/*.jar /intersensorservice/intersensorservice.jar && \
  chmod -R ugo+rwx /intersensorservice && \
  ls -lA /intersensorservice

COPY entrypoint.sh /usr/local/bin/entrypoint.sh
RUN ln -s /usr/local/bin/entrypoint.sh / # backwards compat
RUN chmod u+x /usr/local/bin/entrypoint.sh


RUN set -x && \
  ls -lA && \
  ls -lA /intersensorservice

EXPOSE 8080
ENTRYPOINT [ "entrypoint.sh" ]
