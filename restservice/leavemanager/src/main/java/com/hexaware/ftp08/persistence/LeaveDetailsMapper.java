package com.hexaware.ftp08.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.ftp08.model.LeaveDetails;
import com.hexaware.ftp08.model.LeaveStatus;
import com.hexaware.ftp08.model.LeaveType;
/**
 * Mapper class to map from result set to leave details object.
 */
public class LeaveDetailsMapper implements ResultSetMapper<LeaveDetails> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped employee object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
    public final LeaveDetails map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {

        String s = rs.getString("LEA_TYPE");
        LeaveType lt1 = LeaveType.valueOf(s);

        String s2 = rs.getString("LEA_STATUS");
        LeaveStatus lt2 = LeaveStatus.valueOf(s2);
        /**
         * @return LeaveDetails
         */
        return new LeaveDetails(rs.getInt("LEA_ID"), rs.getDate("LEA_START_DATE"), rs.getDate("LEA_END_DATE"),
                rs.getInt("LEA_NO_OF_DAYS"), rs.getString("LEA_REASON"),
                lt1, rs.getDate("LEA_APPLIED_ON"), rs.getString("LEA_MGR_COMMENTS"), lt2);

    }
}