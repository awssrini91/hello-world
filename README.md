# maven-project

Simple Maven Project

Adding an exixting project to Github using command line

git remote add origin <URL>

verifiying the remote URL
git remote -v

pushing the changes 
git push origin master

<------------------------------------------------------------->

Java installation Steps

we need to install Java first

yum install java-1.8*

Confirm Java Version
Lets install java and set the java home

java -version
find /usr/lib/jvm/java-1.8* | head -n 3
#JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.191.b12-1.el7_6.x86_64
export JAVA_HOME
PATH=$PATH:$JAVA_HOME
# To set it permanently update your .bash_profile
source ~/.bash_profile
before running executing bash file please set the below path
PATH=$PATH:$JAVA_HOME:$HOME/bin

JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.252.b09-2.amzn2.0.1.x86_64



The output should be something like this,

[root@~]# java -version
openjdk version "1.8.0_151"
OpenJDK Runtime Environment (build 1.8.0_151-b12)
OpenJDK 64-Bit Server VM (build 25.151-b12, mixed mode)

<------------------------------------------------------------------------------------->
Jenkins Installtion Steps

sudo wget -O /etc/yum.repos.d/jenkins.repo \
    https://pkg.jenkins.io/redhat-stable/jenkins.repo
sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io.key
sudo yum upgrade
sudo yum install jenkins

-->To start jenkins systemctl start jenkins
-->To check the status systemctl status jenkins

Change admin password 
click on admin user -->configure --> there is a password section enter update the password

==>Setting java path in jenkins
Go to manage jenkins --> Global tool configuration --> find name JDK

Give the name in path come to command line and type find / -name javac

it will list all the java related paths copy the curret one that we kept for java_home and save

<------------------------------------------------------------------------->
Plugin's installed in Jenkins
Maven invoker 
maven integration

