package com.hexaware.ftp08.model;
import java.util.Objects;
import java.sql.Date;
import java.util.List;
import com.hexaware.ftp08.persistence.DbConnection;
import com.hexaware.ftp08.persistence.LeaveDetailsDAO;
/**
 * Leave Details class to store employee leave details.
 * @author hexware
 */
public class LeaveDetails {
    /**
     * leaId to store leave id.
     */
    private int leaId;
    /**
     * leaStartDate to store leave start date.
     */
    private Date leaStartDate;
    /**
     * leaEndDate to store leave end date.
     */
    private Date leaEndDate;
    /**
     * noOfDays to store number of days.
     */
    private int leaNoOfDays;
    /**
     * leaReason to store employee leave reason.
     */
    private String leaReason;
    /**
     * leaType to store employee leave type.
     */
    private LeaveType leaType;
    /**
     * leaAppliedOn to store employee leave applied on.
     */
    private Date leaAppliedOn;
    /**
     * leaMgrComments to store employee leave manager comments.
     */
    private String leaMgrComments;
    /**
     * leaStatus to store employee leave status.
     */
    private LeaveStatus leaStatus;
    @Override
    public final boolean equals(final Object ob) {
        if (ob == null) {
            return false;
        }
        if (getClass() != ob.getClass()) {
            return false;
        }
        LeaveDetails lea = (LeaveDetails) ob;
        if (Objects.equals(leaId, lea.leaId)) {
            return true;
        }
        return false;
    }
    @Override
    public final int hashCode() {
        return Objects.hash(leaId);
    }

    @Override
    public final String toString() {
        return "leave id" + leaId + "start date" + leaStartDate + "end date" + leaEndDate + "number of days" + leaNoOfDays
                + "leave reason" + leaReason + "leave type" + leaType + "leave applied on" + leaAppliedOn
                + "manager comments" + leaMgrComments + "leave status" + leaStatus + "leave reason" + leaReason;
    }
    /**
     * @param argLeaId to initialize leave id.
     * @param argLeaStartDate to initialize leave start date.
     * @param argLeaEndDate to initialize leave end date.
     * @param argLeaNoOfDays to initialize leave number of days.
     * @param argLeaReason to initialize leave reason.
     * @param argLeaType to initialize leave type.
     * @param argLeaAppliedOn to initialize leave applied on.
     * @param argLeaMgrComments to initialize leave manager comments.
     * @param argLeaStatus to initialize leave status.
     */
    public LeaveDetails(final int argLeaId, final Date argLeaStartDate, final Date argLeaEndDate,
                        final int argLeaNoOfDays, final String argLeaReason, final LeaveType argLeaType,
                        final Date argLeaAppliedOn, final String argLeaMgrComments, final LeaveStatus argLeaStatus) {
        this.leaId = argLeaId;
        this.leaStartDate = argLeaStartDate;
        this.leaEndDate = argLeaEndDate;
        this.leaNoOfDays = argLeaNoOfDays;
        this.leaReason = argLeaReason;
        this.leaType = argLeaType;
        this.leaAppliedOn = argLeaAppliedOn;
        this.leaMgrComments = argLeaMgrComments;
        this.leaStatus = argLeaStatus;
    }
    /**
     * The dao for Leave details.
     */
    private static LeaveDetailsDAO dao() {
        DbConnection db = new DbConnection();
        return db.getConnect().onDemand(LeaveDetailsDAO.class);
    }
    /**
     * list employee details by id.
     * @param empID id to get leave details.
     * @return LeaveDetails
     */
    /**
     * Gets the Leave Id.
     * @return this Employee's ID.
     */
    public final int getLeaId() {
        return leaId;
    }
    /**
     *
     * @param argLeaId to set leave id.
     */
    public final void setLeaId(final int argLeaId) {
        this.leaId = argLeaId;
    }
    /**
     * Gets the start date.
     * @return this start date.
     */
    public final Date getLeaStartDate() {
        return leaStartDate;
    }
    /**
     *
     * @param argLeaStartDate to set leave start date.
     */
    public final void setLeaStartDate(final Date argLeaStartDate) {
        this.leaStartDate = argLeaStartDate;
    }
    /**
     * Gets the Leave End Date.
     * @return this Leave End Date.
     */
    public final Date getLeaEndDate() {
        return leaEndDate;
    }
    /**
     *
     * @param argLeaEndDate to set leave end date.
     */
    public final void setLeaEndDate(final Date argLeaEndDate) {
        this.leaEndDate = argLeaEndDate;
    }
    /**
     * Gets the Leave Id.
     * @return this Employee's ID.
     */
    public final int getLeaNoOfDays() {
        return leaNoOfDays;
    }
    /**
     *
     * @param argLeaNoOfDays to set leave id.
     */
    public final void setLeaNoOfDays(final int argLeaNoOfDays) {
        this.leaNoOfDays = argLeaNoOfDays;
    }
    /**
     * Gets the Leave Reason.
     * @return this Reason for Leave.
     */
    public final String getLeaReason() {
        return leaReason;
    }
    /**
     *
     * @param argLeaReason to set leave reason.
     */
    public final void setLeaReason(final String argLeaReason) {
        this.leaReason = argLeaReason;
    }
    /**
     * Gets the Leave type.
     * @return this Leave Type.
     */
    public final LeaveType getLeaType() {
        return leaType;
    }
    /**
     *
     * @param argLeaType to set Leave Type.
     */
    public final void setLeaType(final LeaveType argLeaType) {
        this.leaType = argLeaType;
    }
    /**
     * Gets the Leave Applied on.
     * @return this Leave Applied on.
     */
    public final Date getLeaAppliedOn() {
        return leaAppliedOn;
    }
    /**
     *
     * @param argLeaAppliedOn to set Leave Applied on.
     */
    public final void setLeaAppliedOn(final Date argLeaAppliedOn) {
        this.leaAppliedOn = argLeaAppliedOn;
    }
    /**
     * Gets the Manager comments on leave.
     * @return this Manager comments on leave.
     */
    public final String getLeaMgrComments() {
        return leaMgrComments;
    }
    /**
     *
     * @param argLeaMgrComments to set manager comments.
     */
    public final void setLeaMgrComments(final String argLeaMgrComments) {
        this.leaMgrComments = argLeaMgrComments;
    }
    /**
     * Gets the leave staus.
     * @return this leave status.
     */
    public final LeaveStatus getLeaStatus() {
        return leaStatus;
    }
    /**
     *
     * @param argLeaStatus to set leave status.
     */
    public final void setLeaStatus(final LeaveStatus argLeaStatus) {
        this.leaStatus = argLeaStatus;
    }
    /**
     * list all leave details.
     * @param empId for emp id
     * @return all leave details
     */
    public static LeaveDetails[] listLeaveDetails(final int empId) {

        List<LeaveDetails> ls = dao().lis(empId);
        return ls.toArray(new LeaveDetails[ls.size()]);
    }

    /**
     * list all pending details.
     * @param empId for emp id
     * @return all pending details
     */
    public static LeaveDetails[] listPendingApplications(final int empId) {
        List<LeaveDetails> ls2 = dao().finds(empId);
        return ls2.toArray(new LeaveDetails[ls2.size()]);
    }

    /**
     * list leave details by id.
     * @param leaId id to get employee details.
     * @return Employee
     */
    public static LeaveDetails listByLeaveId(final int leaId) {
        return dao().send(leaId);
    }

    /**
     * approve the leave application.
     * @param leaId id to get leave details.
     * @param mgrComments id to update manager comments.
     */
    public static void approveLeave(final String mgrComments, final int leaId) {
        String status = "APPROVED";
        dao().approve(mgrComments, status, leaId);
    }

    /**
     * deny the leave application.
     * @param leaId id to get leave details.
     * @param mgrComments id to update manager comments.
     */
    public static void denyLeave(final String mgrComments, final int leaId) {
        String status = "DENIED";
        dao().deny(mgrComments, status, leaId);
    }
}