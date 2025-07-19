FROM ubuntu:latest
LABEL authors="cgtec"

ENTRYPOINT ["top", "-b"]