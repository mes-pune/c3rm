- cd to c3rm directory
- git clone https://github.com/spotify/docker-client.git 
- cd docker-client
- mvn clean install -DskipTests 
This will take some time

- cd ..
- cd rm
- mvn clean install
- run AppTestMain with uri set to=  http://127.0.0.1:2375

Note: In case you recived an error, please check docker daemon running on 2375 port or run
docker -H tcp://127.0.0.1:2375 -H unix:///var/run/docker.sock -d

To start the web server
1. In STS add the server follow http://www.programmingforliving.com/2012/08/vmware-vfabric-tc-server-setup-in.html
2. Make sure you select "res-web" project to start the resource manager web-server
3. Page: ListContainers => add => remove container =>start/stop container

The sample is just to demonstrate the micro-service manager

Some helpful GIT commands:-

1. git status
   Gives the status of the local branch

2. git add <file path1, file path2>
   This is the preferred way to add files to staging area rather than the below 

   git add -u
   Add the files to the staging area (adds all files, be careful)

3. git commit -m "message"
   Commits the files with the given commit message

4. git commit --amend
   To amend the last commit 

5. git push
   Pushes the file(s) to the repo:https://github.com/mes-pune/c3rm

6. git pull
   Pulls the latest files from repo
   
Please refer to GIT tutorial on-line   


