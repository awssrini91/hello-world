Steps to follow simple CI/CD

1. log into the jenkins and create a new job

        follow the steps:
                        select the maven project
                In General section if you want to provide any descrption plese provide

                Source code management: (need to install git plugin)
                        Here we will provide the source code where it is located
                        in my senario I am using git hub "https://github.com/awssrini91/hello-world.git"
                        for privite repository you need to mention the credentials

                        Branches to build: here you can provide which branch of code you want to package (usually master branch)

        Build:(need to install maven invoker and maven integration plugin)
                Here we will provide the "pom.xml" file which contain all dependenices for the project
           Goals and options: usually we provide "clean install package"

                **To Build maven project you need to install "Maven invoker(to setup the environment variable) Maven integration(to create a maven project)

Save and trigger the build.

2. Deploy war file into tomcat server(need to install deploy to container plugin)

        Set up the tomcat credentials:
                Go to credentials(under the jenkins home page) --> there is option to jenkins selct that --> Global credentilas --> add credentials

                usually tomcat credentials will be in tomcat-user.xml file

        here there is a user called deployer
        If you want to deploy war with jenkins you should have manage-script role and permissions
        Now we need to add those credentials in tomcat --> save it

3.	Setting up for war deployment:: Goto project --> configure --> Post Build actions --> Deploy war/ear to a container 
		war/ear files --> **/*.war

	context path: if you want to provide the war file name you can provide here
	containers: Here choose the tomcat version(tomcat9x)
		It will ask the credentails please provide the credentials and provide the path
		Save and run the build now it will install the application on apache tomcat

4. Goto this path "/opt/apache-tomcat-9.0.38/webapps" you can see webapps folder got generated along with webapp.war 

<------------------------------------------------------------------------------------------------------------------------------------------------------------>

Now Make this process continiuoesly means Developer make some changes pushes into git hub. jenkins need to invoke the changes and deploy the process automaticaly 

Goto jenkins project --> build trigger --> select the poll scm
	give the cron job that when do you need to run the buiild. it will monitor the repository if any changes are pushed while monitoring it will invoke the changes and trigger the build.The cron job will be given as shown below: 

Indeed, Jenkins (two years later) will now throw the following warning Spread load evenly by using ‘H/2 * * * *’ rather than ‘*/2 * * * *’

I believe best practice these days is H/5 * * * *, which means every 5 minutes with a hashing factor to avoid all jobs starting at EXACTLY the same time.


save and make some changes in source and push to git hub

	 
	
