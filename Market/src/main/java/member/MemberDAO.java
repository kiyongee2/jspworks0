package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//회원 목록 보기
	public List<Member> getMemberList(){
		List<Member> memberList = new ArrayList<>();
		conn = JDBCUtil.getConnection();
		String sql = "select * from member order by regdate desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setMid(rs.getString("mid"));
				member.setPasswd(rs.getString("passwd"));
				member.setMname(rs.getString("mname"));
				member.setGender(rs.getString("gender"));
				member.setBirth(rs.getString("birth"));
				member.setPhone(rs.getString("phone"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setRegDate(rs.getTimestamp("regdate"));

				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return memberList;
	}
}
