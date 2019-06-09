package templatemethod.jdbcwithoutinheritance;

import templatemethod.jdbctemplate.Member;
import templatemethod.jdbctemplate.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberQueryExecutor implements QueryExecutor {
    public DataSource dataSource;
    PreparedStatement pstm;
    Connection con;

    public List<?> selectAll() throws Exception {
        String sql = "select * from t_member";

        PreparedStatement pstm = this.createPrepareStatement(con, sql);

        ResultSet rs = this.executeQuery(pstm, null);

        List<?> result = this.parsesResultSet(rs, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setAge(rs.getInt("age"));
                member.setAddr(rs.getString("addr"));
                return member;
            }
        });

        this.closeResultSet(rs);
        return result;
    }

    @Override
    public PreparedStatement createPrepareStatement(Connection con, String sql) throws Exception {
        return con.prepareStatement(sql);
    }

    @Override
    public List<?> parsesResultSet(ResultSet rs, RowMapper<Member> memberRowMapper) throws Exception {
        List<Object> result = new ArrayList<Object>();
        int rowNum = 1;

        while (rs.next()) {
            result.add(memberRowMapper.mapRow(rs, rowNum++));
        }

        return result;
    }

    public void closeResultSet(ResultSet rs) throws Exception {
        rs.close();
    }

    private List<?> executeQuery(String sql, RowMapper<Member> memberRowMapper, Object[] values) throws Exception {
        PreparedStatement pstm = this.createPrepareStatement(con, sql);

        ResultSet rs = this.executeQuery(pstm, values);

        List<?> result = this.parsesResultSet(rs, memberRowMapper);
        return result;
    }

    private ResultSet executeQuery(PreparedStatement pstm, Object[] values) throws Exception {
        for (int i = 0; i < values.length; i++) {
            pstm.setObject(i, values[i]);
        }
        return pstm.executeQuery();
    }

}
