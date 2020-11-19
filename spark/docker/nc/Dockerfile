FROM ubuntu:latest
RUN apt-get update && apt-get install -y netcat-openbsd
CMD ["/bin/nc", "-vlk", "9999"]
