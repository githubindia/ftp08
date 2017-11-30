# This readme is for the administrators of the ftp program

## Pre Nov-20th

  * Sort the teams into 2 batches of 25, then into teams of 5 each
    * CS/Non-CS folks
    * Scores equally distributed
    * Gender distribution
  * Create Git repository for the 10 teams
    * Make sure that ftp-fork-me does not have any branches
    * Go to github.com
      * delete any existing repositories: ftp01 to ftp10
      * create a repository for each team : ftp01 to ftp10
      * create a team for each team : ftp01 to ftp10
      * Add FTP-Admins as a group w/ Admin access, and ftpnn team w/ R/W to these repositories
    * `git clone --bare git@github.com:HexaInnovLab/ftp-fork-me.git ftp08`
    * `cd ftp08`
    * For each team, nn = 01 to 10
      * `git push --mirror git@github.com:HexaInnovLab/ftpnn.git`
    * For each team, nn = 01 to 10
      * from the workspace
      * `git clone git@github.com:HexaInnovLab/ftpnn.git`
      * cd ftpnn
      * For windows
        * use VS Code, find/replace in files to do the following: replacing ftp08 -> ftpnn, FTP08 -> FTPnn
        * Rename directory restservice/leavemanager/src/main/java/com/hexaware/ftp08/ to restservice/leavemanager/src/main/java/com/hexaware/ftpnn/
      * For Mac OS
        * NOTE: replace nn with the team-id in the following three commands
        * `find . -type f -not -path '*/\.*' -not -path "*/node_modules/*" -exec sed -i '' -e 's/ftp08/ftpnn/g' {} \; -exec sed -i '' -e 's/FTP08/FTPnn/g' {} \;`
        * `mv restservice/leavemanager/src/main/java/com/hexaware/ftp08/ restservice/leavemanager/src/main/java/com/hexaware/ftpnn/`
      * `git add restservice/leavemanager/src/main/java/com/hexaware/ftpnn/`
      * `git commit -a -m "replacing xx with the team number"`
      * `git push origin HEAD`
      * `git clean -f`
      
    * Add the .pub key from jenkins home/.ssh directory for this team as the repository's deploy key
    * [TBD: This has to be done on day1] Add each team member to the team's git repository
  * Create Scrum teams corresponding to the 10 teams
    * Add each team member to the team's Jira group 
  * Staging and Integration ec2 instances
    * Use the instructions in JENKINS.md to spin up the instances, stop iptables, yum install and install jdk
    * Install tomcat
      * As centos, in /home/centos, wget "http://www-us.apache.org/dist/tomcat/tomcat-8/v8.5.23/bin/apache-tomcat-8.5.23.tar.gz", "tar -xvzf apache-tomcat-8.5.23"
      * Edit bin/startup.sh, add "export DB_CONNECTION=[rds-host]:3306"
      * Edit webapps/manager/META-INF/context.xml and comment out the valve which restricts access to localhost only
      * Edit conf/tomcat-users.xml and add roles manager-gui and manager-script, with a user "manager"/"manager" with access to both these roles 
  * Databases - 3 per team
    * Integration and Staging instances
      * `export PATH=$PATH:/Applications/MySQLWorkbench.app/Contents/MacOS`
      * `mysql -u root -po7Vb6H4bcrnC -h ftp-integration.c1jpaaszplju.us-east-1.rds.amazonaws.com`
      * 
    * `CREATE DATABASE FTP08;` -- XX from 01 to 10
    * `CREATE USER 'FTP08'@'%' IDENTIFIED BY 'FTP08';`
    * `GRANT ALL ON FTP08.* TO 'FTP08'@'%';`
    * `select Host, User, Password from mysql.user order by user;`
    * `select * from mysql.db order by Db;`
  * Jenkins jobs - 3 per team
    * FTP08-10-UNIT
    * FTP08-30-INTEGRATION
    * FTP08-50-STAGING
    * For each team, nn = 01 to 10
      * Create a tab FTPnn
      * Create New Item, for stage = 10-UNIT, 30-INTEGRATION, and 50-STAGING
        * Free Style Project
        * Copy from FTPnn-{stage}, "Add to current view" checked
        * Change all xx to nn in the job fields  
        * For the unit job, change the git repository as well; if the credentials are not yet added, you can add them now

# Week #1 Day #1
  * Go to https://github.com/orgs/HexaInnovLab/people, and click "Invite Member" and add them to the FTPnn team.

----- To be reviewed ---------

## Setup Jira

The users are added by invite: Site Administration/User Management. Use the hexaware email address, the UI already selects the hexawareid as the username.

Create a "FTP" group and add all the users from the ftp program.

Create a project, with shared configuration w/ StationMaster. Create a scrum board, fix the swimlanes and filters, and create the epics. Give developer access to FTP group.
