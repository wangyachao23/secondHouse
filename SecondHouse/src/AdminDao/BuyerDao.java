package AdminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import AdminsqlMod.SQLBuyer;
import JDBC.StringUtil;

public class BuyerDao {
	

	/*public ResultSet BuyerLookList(Connection con)throws Exception{
		String sql="select * from Buyer";
		PreparedStatement ps7=con.prepareStatement(sql);
		return ps7.executeQuery();
	}*/
	
	public ResultSet BuyerLookList(Connection con,SQLBuyer sqlBuyer)throws Exception{
		StringBuffer sql=new StringBuffer("select * from Buyer");
		if(StringUtil.isNotEmpty(sqlBuyer.getB_no())) {
			sql.append(" and b_no like '%"+sqlBuyer.getB_no()+"%'");
		}
		PreparedStatement ps7=con.prepareStatement(sql.toString().replaceFirst("and","where"));
		return ps7.executeQuery();
		
		/*if(StringUtil.isEmpty(sqlBuyer.getB_no())) {
			PreparedStatement pstmt=con.prepareStatement("select * from Buyer");
			return pstmt.executeQuery();
		}
		PreparedStatement pstmt=con.prepareStatement("select * from Seller where B_no=?");
		pstmt.setString(1,sqlBuyer.getB_no());
		return pstmt.executeQuery();*/

	}
	
	//删除选中的行
	public int Buyerdele(Connection con,String B_no)throws Exception {
		String sql="delete from Buyer where B_no=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, B_no);
		return pst.executeUpdate();
	}
}
