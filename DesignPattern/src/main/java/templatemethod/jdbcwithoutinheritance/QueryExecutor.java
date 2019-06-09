package templatemethod.jdbcwithoutinheritance;

import templatemethod.jdbctemplate.Member;
import templatemethod.jdbctemplate.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface QueryExecutor {

    List<?> selectAll() throws Exception;

    PreparedStatement createPrepareStatement(Connection con, String sql) throws Exception;

    List<?> parsesResultSet(ResultSet rs, RowMapper<Member> memberRowMapper) throws Exception;

}
