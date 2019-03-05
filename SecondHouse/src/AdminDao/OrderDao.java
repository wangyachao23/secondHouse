package AdminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDao {
	
	public ResultSet OrderList(Connection con)throws Exception{
		String sql="select * from B_order";
		PreparedStatement ps7=con.prepareStatement(sql);
		return ps7.executeQuery();
	}
}
