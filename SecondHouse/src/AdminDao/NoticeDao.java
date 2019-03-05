package AdminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import AdminsqlMod.SQLNotice;
import JDBC.StringUtil;

public class NoticeDao {
	
	//添加公告
	public int Noticeadd(Connection con,SQLNotice sqlNotice) throws Exception {
		String sql="insert into dbo.Notice values(?,?,?,?,5,100,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, sqlNotice.getN_no());
		ps.setString(2, sqlNotice.getSubject());
		ps.setString(3, sqlNotice.getTime());
		ps.setString(4, sqlNotice.getContent());
		ps.setString(5, sqlNotice.getA_id());
		return ps.executeUpdate();
	}
	//公告查询
	public ResultSet NoticeList(Connection con) throws Exception{
		 String sql1="select * from dbo.Notice";		
		 PreparedStatement pst=con.prepareStatement(sql1);
		return pst.executeQuery();
	}
	
	//删除公告
	public int NoticeDelete(Connection con,String N_no)throws Exception {
		String sql2="delete from Notice where A_no=?";
		PreparedStatement ps=con.prepareStatement(sql2);
		ps.setString(1, N_no);
		return ps.executeUpdate();
	}
}
