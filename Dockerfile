FROM ubuntu:20.04

RUN apt-get update && apt-get -y install openssh-server openjdk-8-jdk
RUN apt-get -y install maven
RUN apt-get -y install git


RUN mkdir /var/run/sshd
RUN echo 'root:0000' | chpasswd
RUN sed -i 's/#*PermitRootLogin prohibit-password/PermitRootLogin yes/g' /etc/ssh/sshd_config
RUN sed -i 's@session\s*required\s*pam_loginid.so@session optimal pam_loginuid.so@' /etc/pam.d/sshd

ENV NOTVISIBLE="in users profile"
RUN echo "export VISIBLE=now" >> /etc/profile

EXPOSE 22
CMD ["/usr/sbin/sshd", "-D"]

# github.com을 신뢰할 수 있는 사이트로 등록. 만약 안 하면, Dockerfile 상에서 clone이 불가능
RUN mkdir -p -m 0600 /root/.ssh \
    && ssh-keyscan github.com >> /root/.ssh/known_hosts

ADD id_rsa /root/.ssh/id_rsa
WORKDIR /root/.ssh
# chmod를 하는 이유 : Docker 실행환경이 Windows라, 복사되는 key file의 권한이 777로 되어있음
RUN chmod 600 id_rsa
# 같은 의미의 코드
# RUN chmod go-rwx id_rsa
# RUN chmod u-x id_rsa
WORKDIR /root

RUN git clone git@github.com:SoftwareEngineering-Gotcha/MovieRecommendation.git

#RUN mkdir /root/project
#WORKDIR /root/project
#ADD project /root/project
# RUN mvn test
