# Exercise 5.3 Apache Camel File Transfer

This exercise will use the Apache Camel integration tool to copy files
from one directory to another. Apache Camel implements many of the
Enterprise Integration Patterns.

### Step 1

Connect to the Google Compute Engine virtual machine.

### Step 2

Clone the GitHub repository for the code.

`cd`  
`git clone https://github.com/simplilearn-devops/devops-lesson-5`  

See what got created.

`cd devops-lesson-5/lab-5.3`  
`ls -l `  
`find .`  

### Step 3

Check out the POM file using `less`. Type space to scroll down, b to scroll up and q to exit.

`less pom.xml`  

Build the code.

`~/maven/bin/mvn package`  

See what got created.  
`find .`  

Take a look inside the jar file.  
jar tf target/camel.jar

### Step 4

Use Maven to copy dependency jars.  
`~/maven/bin/mvn dependency:copy-dependencies`  

See what got copied.  
`find target`  

### Step 5

Check out the run_camel script.  
`cat run_camel`  

Run the script. Camel will run for 5 minutes.
`./run_camel`  

### Step 6

Open a second SSH terminal by pressing the SSH button again.

In the second terminal change directory to the exercise directory.  
`cd devops-lesson-5/lab-5.3`  

Check out the data directory and create files in the input directory. You
should see that the files get copied and moved.  
`find data`  
`echo "Message 1" > data/input/message1.txt`  
`find data`  
`echo "Message 2" > data/input/message2.txt`  
`find data`  

You can exit Camel using control-C.

## Step 7

We are now going to deploy the application into Docker. We need Java and the
application.

Check out the Dockerfile.  
`cat Dockerfile`  

Build the image.  
`docker build -t camel .`  
`docker images`  

### Step 7

We can now run the docker container.  
`docker run -d --name camel -v $PWD/data:/opt/data camel`  
`docker ps`  
`docker logs camel`  

Check out the data directory and create files in the input directory. You
should see that the files get copied and moved.  
`find data`  
`echo "Message 3" > data/input/message3.txt`  
`find data`  
`echo "Message 4" > data/input/message4.txt`  
`find data`  

### Step 8

Tidy up.  
`docker rm -f camel`  
`~/maven/bin/mvn clean`  


