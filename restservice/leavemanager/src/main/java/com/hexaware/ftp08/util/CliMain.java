package com.hexaware.ftp08.util;
import java.util.Scanner;

import com.hexaware.ftp08.model.Employee;
import com.hexaware.ftp08.model.LeaveDetails;
import java.text.ParseException;

/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  private void mainMenu() throws ParseException {
    System.out.println("Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Apply for Leave");
    System.out.println("4. Show leave history");
    System.out.println("5. View pending leave applications");
    System.out.println("6. Approve or Deny Application");
    System.out.println("7. Exit");
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    mainMenuDetails(menuOption);
  }
  private void mainMenuDetails(final int selectedOption) throws ParseException {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        listEmployeeDetail();
        break;
      case 3:
        apply();
        break;
      case 4:
        showHistory();
        break;
      case 5:
        showPending();
        break;
      case 6:
        approveDeny();
        break;
      case 7:
        // halt since normal exit throws a stacktrace due to jdbc threads not responding
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose either 1, 2 or 3");
    }
    mainMenu();
  }
  private void listEmployeeDetail() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      System.out.println(employee.getEmpId() + " " + employee.getEmpName() + " " + employee.getEmpEmail() + " "
              + employee.getEmpMobNo() + " " + employee.getEmpDptName() + " "
              + employee.getEmpMgrId() + " " + employee.getEmpLeaveBalance());
    }
  }
  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    for (Employee e : employee) {
      System.out.println(e.getEmpId() + " " + e.getEmpName() + " " + e.getEmpEmail() + " "
              + e.getEmpMobNo() + " " + e.getEmpDptName() + " "
              + e.getEmpMgrId() + " " + e.getEmpLeaveBalance());
    }
  }

  private void apply() throws ParseException {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();

    Employee employee = Employee.listById(empId);

    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      if (employee.getEmpLeaveBalance() > 0) {
        //System.out.println(employee.getEmpLeaveBalance());
        System.out.println("Enter Start Date");
        String startDate = option.next();
        System.out.println("Enter End Date");
        String endDate = option.next();
        System.out.println("Enter the Reason");
        String reason1 = option.nextLine();
        String reason2 = option.nextLine();
        String reason = reason1 + reason2;
        System.out.println("Enter the number of Days");
        int noOfDays = option.nextInt();

        Employee.applyLeave(startDate, endDate, reason, empId, noOfDays);

      }
    }
  }

  private void showHistory() {
    System.out.println("Enter your emp id");
    int empId = option.nextInt();

    Employee employee = Employee.listById(empId);

    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      LeaveDetails[] leaDetails = LeaveDetails.listLeaveDetails(empId);

      for (LeaveDetails ld : leaDetails) {
        System.out.println(ld.getLeaId() + " " + ld.getLeaStartDate() + " " + ld.getLeaEndDate() + " "
                + ld.getLeaNoOfDays() + " " + ld.getLeaAppliedOn() + " " + ld.getLeaReason()
                + " " + ld.getLeaType() + " " + ld.getLeaMgrComments() + " " + ld.getLeaStatus());
      }
    }


  }

  private void showPending() {
    System.out.println("Enter your Manager Id");
    int empId = option.nextInt();

    Employee employee = Employee.listById(empId);

    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      LeaveDetails[] leaDetails = LeaveDetails.listPendingApplications(empId);

      for (LeaveDetails ld : leaDetails) {

        System.out.println(ld.toString());
        System.out.println("-----------------------------------------------------");
      }
    }
  }

  private void approveDeny() throws ParseException {
    System.out.println("Enter your Manager Id");
    int empId = option.nextInt();

    Employee employee = Employee.listById(empId);

    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      LeaveDetails[] leaDetails = LeaveDetails.listPendingApplications(empId);

      for (LeaveDetails ld : leaDetails) {
        System.out.println(ld.toString());
      }

      System.out.println("1. Approve the application ");
      System.out.println("2. Deny the Application");
      int menuOption = option.nextInt();
      menuDetails(menuOption);

    }
  }

  private void menuDetails(final int menuOption) throws ParseException {
    switch (menuOption) {
      case 1:
        approve();
        break;
      case 2:
        deny();
        break;
      default:
        System.out.println("Choose either 1, 2");
    }

    mainMenu();
  }

  private void approve() {
    System.out.println("Enter the Leave id of the application you want to approve");
    int leaId = option.nextInt();

    LeaveDetails l = LeaveDetails.listByLeaveId(leaId);
    if (l == null) {
      System.out.println("Sorry, No Such Leave Application exists");
    } else {
      System.out.println("Enter your comments here");
      String mgrComments1 = option.nextLine();
      String mgrComments2 = option.nextLine();
      String mgrComments = mgrComments1 + mgrComments2;
      LeaveDetails.approveLeave(mgrComments, leaId);
    }
  }

  private void deny() {
    System.out.println("Enter the Leave id of the application you want to deny");
    int leaId = option.nextInt();

    LeaveDetails l = LeaveDetails.listByLeaveId(leaId);
    if (l == null) {
      System.out.println("Sorry, No Such Leave Application exists");
    } else {
      System.out.println("Enter your comments here");
      String mgrComments1 = option.nextLine();
      String mgrComments2 = option.nextLine();
      String mgrComments = mgrComments1 + mgrComments2;
      LeaveDetails.denyLeave(mgrComments, leaId);
    }



  }

  /**
   * The main entry point.
   * @param ar the list of arguments
   * @throws ParseException which throws Exception
   */
  public static void main(final String[] ar) throws ParseException {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}