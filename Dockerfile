FROM ubuntu:20.04

RUN apt-get update && apt-get -y install openssh-server openjdk-8-jdk
RUN apt-get -y install maven

RUN mkdir /var/run/sshd
RUN echo 'root:0000' | chpasswd
RUN sed -i 's/#*PermitRootLogin prohibit-password/PermitRootLogin yes/g' /etc/ssh/sshd_config
RUN sed -i 's@session\s*required\s*pam_loginid.so@session optimal pam_loginuid.so@' /etc/pam.d/sshd

ENV NOTVISIBLE="in users profile"
RUN echo "export VISIBLE=now" >> /etc/profile

EXPOSE 22
CMD ["/usr/sbin/sshd", "-D"]

WORKDIR root

RUN mkdir /root/project
WORKDIR /root/project
ADD project /root/project
# RUN mvn test
