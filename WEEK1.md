# Classroom material

## Structure of the program
  * Team
  * Product E2E
  * Agile/DevOps
  * Full stack
  * Cloud (little bit)

## Goals of the program
  * "Learning to learn"
    * Git, Jira, Jenkins, MySQL, SQL, JDBI, Java, Junit, Jmockit, Jersey, Maven, REST, Json, RestAssured, Javascript, HTML, CSS, Angular 4, Karma/Jasmine, Selenium
  * Productivity hacks
    * google
    * command line (+ simple IDE)
    * cheat sheets
    * bookmarks
    * check lists
    * REPL
    * tutorials
    * ...
  * Communication, teamwork, ...

## Multi-tier systems
  * Presentation, Business Logic, Persistence
    * Web, Mobile, Cli, Thick Client, ...
      * Web
        * Hybrid MVC vs Browser-side MVC
      * Mobile
        * Native vs Cross-Platform
    * Containers, REST API, EJB, ...
    * File system, RDBMS, NoSQL, BigData, DW, ...

 ## Software Development
   * Tools : source code control, ticket, IDE, build, test, execute
   * Iteration:
     * Assign to yourself
     * Checkout
     * branch
     * change
     * test
     * deploy/test
     * checkin
     * review
     * pipeline
     * close
     * delete branch   

## Unix command line basics
  * pwd
  * ls
  * cd
  * mkdir
  * Curl
  
## Source code control systems

## Git
  * workspace, staging, local, remote

## Editors, Build systems vs IDE

## Databases: concepts

## Databases: SQL/DML

## Agile basics
  * Sprint, Kanban
  * Product Backlog, Sprint Backlog
    * Epics, User Stories, Tasks, Bug
    * To Do, In Progress, Resolved, Accepted
  * Sprint Rituals
    * Planning
    * Standup
    * Review
    * Retrospective
  
# Workshop material - Day #1 - Git/VS Code
  * Setting up git
    * Open "https://github.com/HexaInnovLab" in your browser; bookmark this page in your browser
    * Click the signup on the top-right
    * In the following instructions, {hexawareid} is the part preceding @hexaware.com in your email address
    * your username is {hexawareid}-Hexaware, e.g., krishnakumar-Hexaware
    * Use hexaware email address as the email address
    * Select your own password
    * Tell the facilitator the username just created
    * You will get mail to verify your mail address; click the link to complete the verification
    * The facilitator will add you to the hexaware github organization and also give you access to the team's repository
    * You will get a mail inviting you to the HexaInnovLab organization. Please join the organization.
    * Open https://github.com/HexaInnovLab/ftp08, and look at the WEEK1.md
    * Follow the instructions as in https://help.github.com/articles/connecting-to-github-with-ssh/
      * Skip "Checking for existing SSH keys" as this is a fresh installation
      * Run the ssh-keygen command and save the private key in C:\users\Hvuser\.ssh\id_rsa. *Do not* use a passphrase in step #4 - just press enter twice.
      * Skip "Adding your SSH key to the ssh-agent" section as we do not use ssh-agent
      * Follow the instructions as in "https://help.github.com/articles/adding-a-new-ssh-key-to-your-github-account/" and "https://help.github.com/articles/testing-your-ssh-connection/" and test the setup

  * Command Line/Gitbash --  Open Gitbash
    
    * `pwd` -- Check and verify that the current working directory is C:\users\Hvuser
    * `cd workspace` -- change current working to workspace
    * `pwd` -- Check and verify that the current working directory is C:\users\Hvuser/workspace
        
  * Git (setup/checkout/clone/pull/push)
    * `git --version` // should be atleast 2.14+
    * `git config --global -l` // should throw an error
    * `git config --global user.name "<your name>"`
    * `git config --global user.email <your email>`
    * `git config --global -l`
    * Open https://github.com/HexaInnovLab/ftp08
      * look at source code organization
    * Go back to gitbash and clone the project
    * `git clone git@github.com:HexaInnovLab/ftp08.git`
    * `cd ftp08`
    * `git status`
  * open Visual Studio Code
    * Open folder c:\users\Hvuser\workspace\ftp08
    * Browse the directories to understand the repository structure

# Workshop material - Day #2 - MySQL Workbench/Cli/Curl/Browser to interact w/ application

  * Open MySQL Workbench
  * Open the localhost connection
    * Mac OS: `export PATH=$PATH:/Applications/MySQLWorkbench.app/Contents/MacOS` and then you can use the command line `mysql -u root -p hexawareftpdev`
  * `CREATE DATABASE FTP08;` and click the lightning button
  * `CREATE USER 'FTP08'@'localhost' IDENTIFIED BY 'FTP08';`
  * `GRANT ALL ON FTP08.* TO 'FTP08'@'localhost';`
  * Open database/database.ddl in VS code
  * Copy the entire contents to MySQL Workbench
  * Execute the ddl 
  * Click the table icon against the EMPLOYEE table in the right-hand side schemas section
  * Open database/database.dml in VS code
  * Copy the contents to MySQL Workbench
  * Execute the dml 
  * Click the table icon against the EMPLOYEE table in the right-hand side schemas section. You should see the data just inserted.
  * Play around with
    * SELECT with predicates
    * UPDATE statements with predicates
    * DELETE statements with predicates
    * At the end of all the playing around, leave the database with 5 records with ids (1000, 2001
    
  * Next, we will build and run the java code
  * go to gitbash, ensure you are in workspace/ftp08
  * `cd restservice/leavemanager`
  * `mvn compile`
  * `mvn exec:java -Dexec.mainClass=com.hexaware.ftp08.util.CliMain`
    * As expected, the cli displays only the employee id for the employee; we need to do some code changes before the other attributes such as name will start appearing in the cli. But before that we will test the application as a REST service.
    * Due to a bug in the database connection code, after exiting, there will be an error with a stack trace. Ignore this error.
  * Build the war file as follows:
    * `mvn package` -- This build a war (java web archive with the code for the REST service)
    * `cp target/ftp08-0.0.1-SNAPSHOT.war /D/FTP/apache-tomcat-8.5.16-windows-x64/apache-tomcat-8.5.16/webapps/ftp08.war`
    * start tomcat and tail its logs
      * `cd D/FTP/apache-tomcat-8.5.16-windows-x64/apache-tomcat-8.5.16`
      * `rm -rf logs/*`
      * `./bin/startup.sh`
      * `tail -f logs/*`
      * `curl -vvv http://localhost:8080/ftp08/api/employees | python -m json.tool`
      * `curl -vvv http://localhost:8080/ftp08/api/employees/2000 | python -m json.tool`
   * `cd ../../webui/lm-app/`
   * `npm install`
   * `ng build`
   * `cp ../../restservice/leavemanager/target/ftp08-0.0.1-SNAPSHOT.war ./ftp08.war`
   * `cd dist`
   * `jar -uvf ../ftp08.war *`
   * `cd ..`
   * `jar -tvf ftp08.war`
   * `cp ftp08.war /D/FTP/apache-tomcat-8.5.16-windows-x64/apache-tomcat-8.5.16/webapps/ftp08.war`
   * Notice that the tail terminal shows that the new version of the web application archive is now getting deployed
   * Open Chrome browser and navigate to http://localhost:8080/ftp08/
   * You should be able to see the employee ids as you have entered them in the local mysql database
      
# Workshop material - Day #3 - Setup Jira

  * signup for a jira id using your hexaware email address. Use the hexaware email address, the UI already selects the hexawareid as the username.
     * https://id.atlassian.com/signup
  * inform your facilitator that you have signed. s/he will add you to the required jira project.

# Reading material

## Must-Read
  * https://en.wikipedia.org/wiki/Multitier_architecture#Three-tier_architecture

## Nice-To-Read
  * https://git-scm.com/docs

## Go-Deep
  * https://git-scm.com/book/en/v2
