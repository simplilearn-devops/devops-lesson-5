FROM centos:latest
RUN yum install -y which
RUN yum install -y wget
RUN yum install -y net-tools
RUN cd /tmp; wget -q --no-check-certificate --no-cookies \
   --header "Cookie: oraclelicense=accept-securebackup-cookie" \
   http://download.oracle.com/otn-pub/java/jdk/8u102-b14/jdk-8u102-linux-x64.rpm
RUN rpm -i /tmp/jdk*linux-x64.rpm
ENV JAVA_HOME=/usr/java/latest
RUN rm /tmp/jdk*linux-x64.rpm
ADD run_camel /opt/
ADD target /opt/target
WORKDIR /opt
CMD /opt/run_camel

