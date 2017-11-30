# git

## repository actions

### clone
  * ```git clone git@github.com:HexaInnovLab/ftp08.git```

### reset

## checkout/branch

## stash

## file actions

  * Checkout a previous version
    * `git checkout <commit> <filename>`
  * Undo changes in staging
    * `git reset HEAD <filename>`
  * Discard changes in workspace
    * `git checkout -- <filename>`

# maven

## check style
  * ```mvn -Dcheckstyle.consoleOutput=true checkstyle:check```
  * ```mvn checkstyle:checkstyle```
  * ```open target/site/checkstyle.html```

## Package
  * ```mvn package```

# tomcat

## Start/monitor logs

  * ```cd /path/to/apache-tomcat-9.0.0.M22```
  * ```rm -rf logs/*```
  * ```./bin/startup.sh```
  * ```tail -f logs/*```

## Deploy

  * Copy the war file to the webapps folder
    * ```cp target/<some>.war /path/to/apache-tomcat-9.0.0.M22/webapps/ftp08.war```

# angular

  * To serve from the working directory
    * ng serve --open
  * Build
    * ng build
  * Unit Test
    * ng test
    * npm test
  * Lint/Style check
    * ng lint --type-check
  * Generate new component
    * ng g component components/{name}
  * Generate new service
    * ng g service services/{name}


# Angular/Augury

  * ng is the angular instance
  * ng.probe($0).componentInstance where $0 is the selected component in the Elements tab
