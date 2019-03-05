package AdminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import AdminsqlMod.SQLAdmin;

public class AdmDao {
	//管理员信息查询
	public ResultSet AdminList(Connection con,String id) throws Exception{
		 String sql="select * from Admin where A_id=?";
		 PreparedStatement st=con.prepareStatement(sql);
		 st.setString(1,id);
		 return st.executeQuery();
	}
	
	//数据更新
	public int AdmUpdate(Connection con,SQLAdmin sqlAdmin)throws Exception {
		String sql2="update Admin set A_name=?,A_tel=?,A_password=? where A_id=?";
		PreparedStatement pst2=con.prepareStatement(sql2);
		pst2.setString(1,sqlAdmin.getName());
		pst2.setString(2, sqlAdmin.getTelphone());
		pst2.setString(3, sqlAdmin.getPassword());
		pst2.setString(4, sqlAdmin.getId());
		return pst2.executeUpdate();
	}
}