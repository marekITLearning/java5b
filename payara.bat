rmdir /s /q pmroot
C:/devel/jdk-11.0.12/bin/java.exe ^
-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8088 ^
-jar C:/devel/payara-micro-5.2021.2.jar ^
--deploy backend_parent/webservice/target/webapp.war ^
--port 8080 ^
--rootDir pmroot ^
--domainConfig domain.xml