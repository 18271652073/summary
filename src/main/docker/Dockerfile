FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD summary-0.0.1-SNAPSHOT.jar summary-0.0.1-SNAPSHOT.jar
# CMD java -Xms2048M -Xmx2048M -Xmn1024M -Xss256k -XX:PermSize=512M -XX:MaxPermSize=512M -XX:+UseParallelOldGC -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/usr/dump -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:/usr/dump/heap_trace.txt   -Djava.security.egd=file:/dev/./urandom -jar   /b2b-deli-pcweb-sysback.jar
CMD -Djava.security.egd=file:/dev/./urandom -jar /summary-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone