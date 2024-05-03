# Use a base image with necessary dependencies
FROM openjdk:11-slim

# Install necessary tools
RUN apt-get update && \
    apt-get install -y git protobuf-compiler curl gnupg2 && \
    echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | tee /etc/apt/sources.list.d/sbt.list && \
    echo "deb https://repo.scala-sbt.org/scalasbt/debian /" | tee /etc/apt/sources.list.d/sbt_old.list && \
    curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | apt-key add - && \
    apt-get update && \
    apt-get install -y sbt  && \
    rm -rf /var/lib/apt/lists/*

# Package binaries
WORKDIR /app/protoc-gen-uml
COPY . /app/protoc-gen-uml

RUN sbt universal:stage

# Make binaries available in PATH
ENV PATH="/app/protoc-gen-uml/target/universal/stage/bin:${PATH}"

ENTRYPOINT ["/app/protoc-gen-uml/entrypoint.sh"]
