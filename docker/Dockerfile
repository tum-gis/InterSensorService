# InterSensorservice Dockerfile ###############################################
#   Official website    http://www.intersensorservice.org/
#   GitHub              https://github.com/tum-gis/InterSensorService
###############################################################################
# Base image
ARG baseimage_tag='8-jdk-stretch'
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
ARG BUILD_PACKAGES='maven'
RUN set -x && \
  apt-get update && \
  apt-get install -y --no-install-recommends $BUILD_PACKAGES

# Clone InterSensorService
RUN set -x && \
  git clone -b "${INTERSENSORSERVICE_VERSION}" --depth 1 https://github.com/tum-gis/InterSensorService.git build_tmp
  
RUN set -x && \
  java -version

# Install InterSensorService
RUN set -x && \
  cd build_tmp && \
  mvn clean install



