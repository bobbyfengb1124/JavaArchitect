package templatemethod.jdbcwithoutinheritance;

import templatemethod.jdbctemplate.Member;
import templatemethod.jdbctemplate.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class QueryProxy implements QueryExecutor {
    MemberQueryExecutor memberQueryExecutor;

    public QueryProxy(MemberQueryExecutor memberQueryExecutor) {
        this.memberQueryExecutor = memberQueryExecutor;
    }

    @Override
    public List<?> selectAll() throws Exception {

        memberQueryExecutor.con = memberQueryExecutor.dataSource.getConnection();

        List<?> result = memberQueryExecutor.selectAll();

        this.closeStatement(memberQueryExecutor.pstm);

        this.closeConnection(memberQueryExecutor.con);
        return result;
    }

    private void closeStatement(PreparedStatement pstm) throws Exception {

        pstm.close();
    }

    private void closeConnection(Connection con) throws SQLException {
        con.close();
    }

    @Override
    public PreparedStatement createPrepareStatement(Connection con, String sql) throws Exception {
        return null;
    }

    @Override
    public List<?> parsesResultSet(ResultSet rs, RowMapper<Member> memberRowMapper) throws Exception {
        return null;
    }
}
