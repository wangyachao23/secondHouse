package com.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.system.model.Houseinfo;
import com.system.model.Seller;
import com.system.util.StringUtil;

public class SellerDao {
	//空查询所有，否则查询指定卖家号的信息
		public ResultSet sellerList(Connection con,Seller seller) throws Exception {
			if(StringUtil.isEmpty(seller.getS_no())) {
				PreparedStatement pstmt=con.prepareStatement("select * from Seller");
				return pstmt.executeQuery();
			}
			PreparedStatement pstmt=con.prepareStatement("select * from Seller where S_no=?");
			pstmt.setString(1,seller.getS_no());
			return pstmt.executeQuery();
		}
		public int sellerDelete(Connection con,String s_no) throws Exception {
		
			PreparedStatement pstmt=con.prepareStatement("delete  from Seller where S_no=?");
			pstmt.setString(1,s_no);
			return pstmt.executeUpdate();
		}
		public int sellerModify(Connection con,Seller seller)throws Exception {
			String sql="update Seller set S_id=?,S_name=?,S_password=?,S_email=?,S_add=?,S_tel=? where S_no=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,seller.getS_id());
			pstmt.setString(2,seller.getS_name());
			pstmt.setString(3,seller.getS_password());
			pstmt.setString(4,seller.getS_email());
			pstmt.setString(5,seller.getS_add());
			pstmt.setString(6,seller.getS_tel());
			pstmt.setString(7,seller.getS_no());
			return pstmt.executeUpdate();
		}
}
