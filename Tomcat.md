Tomcat Installation Steps
launch a aws EC2 Instance first, we need a separate instance becasue it's a Server Side

java should be install on that server
To configure java please refer README.md File 
Once the java setup is completed. Please fllow below steps 

1. Goto opt folder(if you want you can install where ever you want)

2. Download the package from Tomcat offical website
	wget http://www.gtlib.gatech.edu/pub/apache/tomcat/tomcat-9/v9.0.38/bin/apache-tomcat-9.0.38.tar.gz
3. Copy and extract Giz file under /opt/tomcat directory
	tar -zxvf apache-tomcat-9.0.38.tar.gz
4. Provide the tomcat execution permissions for all users
	cd apache-tomcat-9.0.38/bin/
	Check weather tomcat running or not 
	ps -ef | grep tomcat
	Check the permissions "ls -al"
	chmod +x startup.sh
	chmod +x shutdown.sh
	After giving the permissions please check again "ls -al"
	
5. Start Tomcat
	Make it easier to start and stop the server
	type echo $PATH
	it will list all paths
	also "pwd" to know the persent direcory 
	type the below command
	ln -s /opt/apache-tomcat-9.0.38/bin/startup.sh /usr/local/bin/tomcatserverup
	ln -s /opt/apache-tomcat-9.0.38/bin/shutdown.sh /usr/local/bin/tomcatserverdown
   Here we setuped tomcat easier way to start instaed of always going to bin folder
   we setuped in home it self 
	type tomcatserverup then enter It will start the tomcat 
	To check the status type "ps -ef | grep tomcat"
6. chaning port(required to change if jenkins and tomcat has the same port no)
	Goto "/opt/apache-tomcat-9.0.38/conf"
	Here you can find "server.xml" file Open that file

	 <Connector port="8090" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />
	Initinally it's 8080 I chnaged to 8090.
	Restart the tomcat.
7. Enabling inboubd rules in EC2 instance
	Goto security groups check for inbound open and click add --> CUSTOM TCP port no :8090 source to all --> Save
8. After ebabled the inbound rule you can type ec2IP:8090 Tomcat will open

<--------------------------------------------------------------------------------------------------------------------------------------->
9. make manager app settings
	By default the Manager is only accessible from a browser running on the same machine as Tomcat. If you wish to modify this restriction, you'll need to edit the Manager's context.xml file. Find for context.xml "find / -name context.xml"
	/opt/apache-tomcat-9.0.38/conf/context.xml
	/opt/apache-tomcat-9.0.38/webapps/host-manager/META-INF/context.xml
	/opt/apache-tomcat-9.0.38/webapps/manager/META-INF/context.xml
		It will show the files like above usually it's under webapp directory Open Two file paths which are under webapp 
	and comment out the below one 
	
	 <Valve className="org.apache.catalina.valves.RemoteAddrValve"
         allow="127\.\d+\.\d+\.\d+|::1|0:0:0:0:0:0:0:1" /> 

	Restart the tomcat and goback to the server and check it's ask for username and password
	we don't have any users so we need to create.
10. Crating user
	/opt/apache-tomcat-9.0.38/conf/tomcat-users.xml
Add below roles under tomcat user

	<role rolename="manager-gui"/>
	<role rolename="manager-script"/>
	<role rolename="manager-jmx"/>
	<role rolename="manager-status"/>
	<user username="admin" password="admin" roles="manager-gui, manager-script, manager-jmx, manager-status"/>
	<user username="deployer" password="deployer" roles="manager-script"/>
	<user username="tomcat" password="s3cret" roles="manager-gui"/>

Restart the tomcat and login with manager credentials 

