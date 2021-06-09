FROM wnameless/oracle-xe-11g-r2

RUN apt-get update
RUN apt-get -y install curl
RUN apt-get -y install git

ARG SSH_PRIVATE_KEY
RUN mkdir ~/.ssh/
RUN echo "$SSH_PRIVATE_KEY" >> ~/.ssh/id_rsa && chmod 600 ~/.ssh/id_rsa

RUN touch ~/.ssh/known_hosts
RUN ssh-keyscan -t rsa github.com >> ~/.ssh/known_hosts

WORKDIR /root

RUN git clone git@github.com:SoftwareEngineering-Gotcha/MovieRecommendation.git

WORKDIR /root/MovieRecommendation/sql
RUN cp movies.sql /docker-entrypoint-initdb.d/
RUN cp ratings.sql /docker-entrypoint-initdb.d/
RUN cp user.sql /docker-entrypoint-initdb.d/
RUN cp mgs.sql /docker-entrypoint-initdb.d/
RUN cp init.bash /root/

RUN cp init_movies_seq.sql /docker-entrypoint-initdb.d/
RUN cp init_users_seq.sql /docker-entrypoint-initdb.d/
RUN cp init_ratings_seq.sql /docker-entrypoint-initdb.d/
RUN cp init_mgs_seq.sql /docker-entrypoint-initdb.d/

WORKDIR /root
RUN rm -r MovieRecommendation
