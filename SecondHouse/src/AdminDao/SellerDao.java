package AdminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import AdminsqlMod.SQLSeller;
import JDBC.StringUtil;

public class SellerDao {
	//卖家信息查询
	public ResultSet SellerList(Connection con,SQLSeller sqlSeller)throws Exception{
		StringBuffer sql2=new StringBuffer("select * from Seller");
		if(StringUtil.isNotEmpty(sqlSeller.getS_no())) {
			sql2.append(" and s_no like '%"+sqlSeller.getS_no()+"%'");
		}
		PreparedStatement ps8=con.prepareStatement(sql2.toString().replaceFirst("and","where"));	
		return ps8.executeQuery();
	}
}
