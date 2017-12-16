package com.hexaware.ftp08.model;

import com.hexaware.ftp08.persistence.DbConnection;
import com.hexaware.ftp08.persistence.EmployeeDAO;

import java.util.Objects;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

  /**
   * empId to store employee id.
   */
  private int empId;

  /**
   * empName to store employee name.
   */

  private String empName;

  /**
   * empEmail to store employee email.
   */
  private String empEmail;

  /**
   * empMobNo to store employee mobile number.
   */
  private long empMobNo;

  /**
   * empDptName to store employee department name.
   */
  private String empDptName;

  /**
   * empDateJoined to store employee date of joining.
   */
  private String empDateJoined;

  /**
   * empMgrId to store employee manager id.
   */
  private int empMgrId;

  /**
   * empLeaveBalance to store employee leave balance.
   */
  private int empLeaveBalance;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId);
  }

  /**
   * @param argEmpId to initialize employee id.
   */
  public Employee(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   * @param argEmpId to initialize employee id.
   * @param argEmpName to initialize employee name.
   * @param argEmpEmail to initialize employee email.
   * @param argEmpMobNo to initialize employee mobile number.
   * @param argEmpDptName to initialize employee department name.
   * @param argEmpMgrId to initialize employee manager id.
   * @param argEmpLeaveBalance to initialize employee leave balance.
   */
  public Employee(final int argEmpId, final String argEmpName, final String argEmpEmail,
                  final long argEmpMobNo, final String argEmpDptName,
                  final int argEmpMgrId, final int argEmpLeaveBalance) {
    this.empId = argEmpId;
    this.empName = argEmpName;
    this.empEmail = argEmpEmail;
    this.empMobNo = argEmpMobNo;
    this.empDptName = argEmpDptName;
    this.empMgrId = argEmpMgrId;
    this.empLeaveBalance = argEmpLeaveBalance;

  }

  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   * Gets the EmployeeName.
   * @return this Employee's name.
   */
  public final String getEmpName() {
    return empName;
  }

  /**
   *
   * @param argEmpName to set employee name.
   */
  public final void setEmpName(final String argEmpName) {
    this.empName = argEmpName;
  }

  /**
   * Gets the EmployeeEmail.
   * @return this Employee's Email.
   */
  public final String getEmpEmail() {
    return empEmail;
  }

  /**
   *
   * @param argEmpEmail to set employee Email.
   */
  public final void setEmpEmail(final String argEmpEmail) {
    this.empEmail = argEmpEmail;
  }

  /**
   * Gets the EmployeeMobNo.
   * @return this Employee's Mobile number.
   */
  public final long getEmpMobNo() {
    return empMobNo;
  }

  /**
   *
   * @param argEmpMobNo to set employee mobile Number.
   */
  public final void setEmpMobNo(final long argEmpMobNo) {
    this.empMobNo = argEmpMobNo;
  }

  /**
   * Gets the EmployeeDptName.
   * @return this Employee's department Name.
   */
  public final String getEmpDptName() {
    return empDptName;
  }

  /**
   *
   * @param argEmpDptName to set employee Department Name.
   */
  public final void setEmpDptName(final String argEmpDptName) {
    this.empDptName = argEmpDptName;
  }

  /**
   * Gets the EmployeeDateJoined.
   * @return this Employee's Date Joined.
   */
  public final String getEmpDateJoined() {
    return empDateJoined;
  }

  /**
   *
   * @param argEmpDateJoined to set employee DateJoined.
   */
  public final void setEmpDateJoined(final String argEmpDateJoined) {
    this.empDateJoined = argEmpDateJoined;
  }

  /**
   * Gets the EmployeeMgrId.
   * @return this Employee's Manager Id.
   */
  public final int getEmpMgrId() {
    return empMgrId;
  }

  /**
   *
   * @param argEmpMgrId to set employee Manager Id.
   */
  public final void setEmpMgrId(final int argEmpMgrId) {
    this.empMgrId = argEmpMgrId;
  }

  /**
   * Gets the EmployeeLeaveBalance.
   * @return this Employee's Leave Balance.
   */
  public final int getEmpLeaveBalance() {
    return empLeaveBalance;
  }

  /**
   *
   * @param argEmpLeaveBalance to set employee Leave Balance.
   */
  public final void setEmpLeaveBalance(final int argEmpLeaveBalance) {
    this.empLeaveBalance = argEmpLeaveBalance;
  }

  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAll() {

    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }

  /**
   * list employee details by id.
   * @param leaId id to get employee details.
   * @return Employee
   */
  /*public static Employee listByLeaveId(final int leaId) {
    return dao().findLeave(leaId);
  }*/

  /**
   * insert employee leave details.
   * @param startDate to get employee details.
   * @param endDate to get employee details.
   * @param reason to get employee reason.
   * @param empId to get employee id.
   * @param days to get leave number of days.
   * appliedDate for inserting applied on Date
   * diff for calculating difference between dates
   * numberOfDays to store number of days
   * @throws ParseException throws Parse Exception
   */
  public static void applyLeave(final String startDate, final String endDate,
                                final String reason, final int empId, final int days) throws ParseException {
    java.util.Date dt1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
    java.sql.Date sDate = new java.sql.Date(dt1.getTime());
    java.util.Date dt2 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
    java.sql.Date eDate = new java.sql.Date(dt2.getTime());
    long diff = dt2.getTime() - dt1.getTime();
    int numberOfDays = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    java.sql.Date appliedDate = new java.sql.Date(new java.util.Date().getTime());
    if (days < (numberOfDays + 1)) {
      dao().insert(sDate, eDate, days, appliedDate, reason, empId);
    }
  }




}