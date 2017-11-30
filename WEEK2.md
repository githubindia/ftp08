# Week #2: Course Materials


# Week #2: Workshop Day #1 - Create the development database, table and populate it
  * Create JIRAs for all the work to be done in Week #2 
    * Create a JIRA for changing the database design
    * Others?
  * Start the sprint
    
  * Database Design
  * Assign the jira to one of the team members  
  * Pull it to "In Progress"
  * `git checkout -b FTP08-<TicketNumber>-DDL`
  * Edit Database.ddl for two tables: EMPLOYEE and LEAVE_HISTORY
    * Use the "STANDARDS_AND_GUIDELINES.md" file for the naming conventions to be followed.
  * Edit Database.dml to insert data into the EMPLOYEE table; The LEAVE_HISTORY table can be blank to start with.
  * Run the ddls and dmls against your local mysql server
  * Push the changes to remote branch
    * `git add database/database.ddl`
    * `git add database/database.dml`
    * `git commit -m "ddl/dml changed for the leave application"`
    * `git push origin HEAD`
  * Now, the other team members can pull from branch and run the ddl/dml against their local databases
  * `git pull`
  * You should see that the branch just created is now available locally as well
  * `git checkout FTP08-<TicketNumber>-DDL`
  * You should be able to see the updated ddl and dml via VS Code
  * Run the ddl and dml against your local mysql server
  * Re-run the Cli, the Curl and the Browser UI to see the changed data in all three interfaces
  * When ready, create a Pull Request
    * Go to "https://github.com/HexaInnovLab/ftp08"
    * You may see a yellow box with your branch name, and with a button for creating a pull request.
      * If you don't see it, drop down the "Branch" dropdown, select your branch. Then click the "New Pull Request" button next to it.
      * Review your changes in the next screen. Lookout for typos, trailing whitespace etc. and fix them.
         * Go back to VS code, edit the files and commit/push the files to the branch again
       * Once happy, click the "Create pull request" button after correcting the description, comment etc.
     * Ask your facilitator to review the pull request.
     * The facilitator will and review and merge the pull request and delete the branch
     * At this point, you will update the integration and staging RDS databases with the DDL/DML that has been modified. For this,
       * For integration and staging
         * Get the hostname from the facilitator
         * Create a connection in the mysql workbench for the hostname:3306, username FTP08, password FTP08
         * As against the local mysql, run the ddl and the dml against each connection
   * Once merged, go to jenkins (ask the facilitator for the url) and watch the jobs
     * There will be a ftp08-10-unit, a ftp08-30-integration and a ftp08-50-staging jobs in that tab. The unit job will be triggered (within 5 minutes of the merge) and it will execute the unit tests etc. It then will trigger the integration job which will perform black box tests on the package. Since we have done only DDL/DML changes, none of these tests should fail and you should get a green pipeline.
     
     
# Reading material

## Must-Read

  * Typescript
    * Promises: https://basarat.gitbooks.io/typescript/docs/promise.html
  * Angular Intro
    * https://www.youtube.com/watch?v=KhzGSHNhnbI

## Nice-To-Read

## Go-Deep

  
