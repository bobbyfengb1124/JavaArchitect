package templatemethod.jdbctemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) {
        try {
            Connection con = this.getConnection();

            PreparedStatement pstm = this.createPrepareStatement(con, sql);

            ResultSet rs = this.executeQuery(pstm, values);

            List<?> result = this.parsesResultSet(rs, rowMapper);

            this.closeResultSet(rs);

            this.closeStatement(pstm);

            this.closeConnection(con);

            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void closeConnection(Connection con) throws Exception {
        con.close();
    }

    private void closeStatement(PreparedStatement pstm) throws Exception {

        pstm.close();
    }

    private void closeResultSet(ResultSet rs) throws Exception {

        rs.close();
    }

    private List<?> parsesResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<Object>();
        int rowNum = 1;

        while (rs.next()) {
            result.add(rowMapper.mapRow(rs, rowNum++));
        }

        return result;
    }

    private PreparedStatement createPrepareStatement(Connection con, String sql) throws Exception {
        return con.prepareStatement(sql);
    }

    private Connection getConnection() throws Exception {
        return this.dataSource.getConnection();
    }

    protected ResultSet executeQuery(PreparedStatement pstm, Object[] values) throws Exception {
        for (int i = 0; i < values.length; i++) {
            pstm.setObject(i, values[i]);
        }
        return pstm.executeQuery();
    }
}
