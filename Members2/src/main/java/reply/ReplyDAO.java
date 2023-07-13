package reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCUtil;

//댓글 삽입, 조회, 수정, 삭제를 관리할 클래스
public class ReplyDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//댓글 목록 조회
	public ArrayList<Reply> getReplyList(int bnum){ //매개변수-게시글번호
		ArrayList<Reply> replyList = new ArrayList<>();
		
		conn = JDBCUtil.getConnection();
		String sql = "select * from t_reply where bnum = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bnum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Reply reply = new Reply();
				reply.setRno(rs.getInt("rno"));
				reply.setBnum(rs.getInt("bnum"));
				reply.setRcontent(rs.getString("rcontent"));
				reply.setReplyer(rs.getString("replyer"));
				reply.setRdate(rs.getTimestamp("rdate"));
				reply.setRupdate(rs.getTimestamp("rupdate"));
				replyList.add(reply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return replyList;
	}
	
	//댓글 등록
	public void addReply(Reply reply) {
		conn= JDBCUtil.getConnection();
		String sql = "insert into t_reply(bnum, rcontent, replyer) "
				+ "values(?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reply.getBnum());
			pstmt.setString(2, reply.getRcontent());
			pstmt.setString(3, reply.getReplyer());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
}











