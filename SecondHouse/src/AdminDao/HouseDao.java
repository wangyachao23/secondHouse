package AdminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import AdminsqlMod.SQLHouse;
import JDBC.StringUtil;

public class HouseDao {
	//查询房源信息
	public ResultSet HouseCheck(Connection con,SQLHouse sqlHouse)throws Exception {
		StringBuffer sql=new StringBuffer("select * from Houseinfo");
		if(StringUtil.isNotEmpty(sqlHouse.getH_no())) {
			sql.append(" and H_no like '%"+sqlHouse.getH_no()+"%'");
		}
		PreparedStatement ps2=con.prepareStatement(sql.toString().replaceFirst("and","where"));
		return ps2.executeQuery();
	}
	
	//删除房源信息
	public int HouseDelete(Connection con,String H_no)throws Exception {
		String sql1="delete from Houseinfo where H_no=?";
		PreparedStatement ps=con.prepareStatement(sql1);
		ps.setString(1, H_no);
		return ps.executeUpdate();
	}

}
