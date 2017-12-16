package com.hexaware.ftp08.persistence;

import com.hexaware.ftp08.model.Employee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;
import java.util.Date;

/**
 * The DAO class for employee.
 */
public interface EmployeeDAO  {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEE")
  @Mapper(EmployeeMapper.class)
  List<Employee> list();

  /**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee find(@Bind("empID") int empID);

  /**
   * insert all the details of the employee.
   * @param sDate the start date of the employee
   * @param eDate the end date of the employee
   * @param days the number of days of the employee
   * @param appliedDate the applied date of the employee
   * @param reason the reason for applying.
   * @param empId the employee id of the employee
   */
  @SqlUpdate("insert into LEAVE_HISTORY "
          +
          "             (LEA_START_DATE, "
          +
          "              LEA_END_DATE, "
          +
          "              LEA_NO_OF_DAYS, "
          +
          "              LEA_APPLIED_ON, "
          +
          "              LEA_REASON, "
          +
          "              EMP_ID) "
          +
          "values       ( "
          +
          "              :sDate, "
          +
          "              :eDate, "
          +
          "              :days, "
          +
          "              :appliedDate, "
          +
          "              :reason, "
          +
          "              :empId)")
  void insert(@Bind("sDate") Date sDate,
              @Bind("eDate") Date eDate,
              @Bind("days") int days,
              @Bind("appliedDate") Date appliedDate,
              @Bind("reason") String reason,
              @Bind("empId") int empId);



  /**
   * close with no args is used to close the connection.
   */
  void close();
}