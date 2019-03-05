package AdminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import AdminsqlMod.SQLNotice;
import JDBC.StringUtil;

public class NoticeDao {
	
	//��ӹ���
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
	//�����ѯ
	public ResultSet NoticeList(Connection con) throws Exception{
		 String sql1="select * from dbo.Notice";		
		 PreparedStatement pst=con.prepareStatement(sql1);
		return pst.executeQuery();
	}
	
	//ɾ������
	public int NoticeDelete(Connection con,String N_no)throws Exception {
		String sql2="delete from Notice where A_no=?";
		PreparedStatement ps=con.prepareStatement(sql2);
		ps.setString(1, N_no);
		return ps.executeUpdate();
	}
}
