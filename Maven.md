Maven Installation Steps
go to https://maven.apache.org/download.cgi

look for Binary tar.gz archive --> copy the address link
come to CLI unter /opt create Maven diretoty change to maven directory and type wget <copiedlink>
you can see zip file we need to extract the zip file for that we will run
tar -zxvf apache-maven-3.6.3-bin.tar.gz

you can see bin folder in /opt/maven/apache-maven-3.6.3

Now we need to set Maven_Home

goto .bash_profile

M2_HOME=/opt/maven/apache-maven-3.6.3
M2=$M2_HOME/bin
PATH=$PATH:$HOME/bin:$M2_HOME:$M2

open duplicate CLI and type echo $PATH

adding Maven path in jenkins 

download maven invoker plugin and add MAVEN_HOME path /opt/maven/apache-maven-3.6.3
save 


