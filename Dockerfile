FROM ubuntu:20.04

RUN apt-get update
RUN apt-get -y install openjdk-8-jdk
RUN apt-get -y install curl
RUN apt-get -y install maven
RUN apt-get -y install git

ARG SSH_PRIVATE_KEY
RUN mkdir /root/.ssh/
RUN echo "${SSH_PRIVATE_KEY}" >> ~/.ssh/id_rsa && chmod 600 ~/.ssh/id_rsa

RUN touch ~/.ssh/known_hosts
RUN ssh-keyscan -t rsa github.com >> ~/.ssh/known_hosts

WORKDIR /root

RUN git clone -b ver.db --single-branch git@github.com:SoftwareEngineering-Gotcha/MovieRecommendation.git
