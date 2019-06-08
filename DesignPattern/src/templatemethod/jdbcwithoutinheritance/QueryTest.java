package templatemethod.jdbcwithoutinheritance;

import templatemethod.jdbctemplate.Member;

import java.util.List;

public class QueryTest {
    public static void main(String[] args) {
        QueryExecutor proxy = new QueryProxy(new MemberQueryExecutor());
        try {
            List<Member> memberList = (List<Member>) proxy.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
