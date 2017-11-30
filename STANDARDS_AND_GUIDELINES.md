# Database naming conventions

## Database schema conventions
  * ALL CAPS
  * underscores allowed
  * e.g., FTP01, FTP02
  
## Table naming conventions
  * ALL CAPS
  * underscores allowed
  * e.g., EMPLOYEE, LEAVE_HISTORY
  
## Column naming conventions
  * ALL CAPS
  * underscores allowed
  * Use a three character prefix derived from the table name for all the columns
  * e.g., EMP_ID, EMP_NAME
  * Except for foreign keys, where you will use the foreign key tables' prefix
  * e.g., in LEAVE_HISTORY table, use EMP_ID as the foreign key

