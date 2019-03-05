package com.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.system.model.Houseinfo;
import com.system.util.StringUtil;

public class HouseinfoDao {
	public int houseinfoAdd(Connection con,Houseinfo houseinfo) throws Exception {
		String sql="insert into Houseinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, houseinfo.getH_no());
		pstmt.setString(2, houseinfo.getS_no());
		pstmt.setString(3, houseinfo.getH_name());
		pstmt.setString(4, houseinfo.getReg_ad());
		pstmt.setString(5, houseinfo.getItem_cop());
		pstmt.setString(6, houseinfo.getDir());
		pstmt.setString(7, houseinfo.getStru_na());
		pstmt.setString(8, houseinfo.getArea());
		pstmt.setString(9, houseinfo.getFloor());
		pstmt.setString(10, houseinfo.getUnit_no());
		pstmt.setString(11, houseinfo.getCararea());
		pstmt.setString(12, houseinfo.getFitment());
		pstmt.setString(13, houseinfo.getServerfee());
		pstmt.setString(14, houseinfo.getStatus());
		pstmt.setString(15, houseinfo.getMoney());
		
		return pstmt.executeUpdate();
}
	//空查询所有，否则查询指定房源编号的信息
	public ResultSet houseinfoList(Connection con,Houseinfo houseinfo) throws Exception {
		if(StringUtil.isEmpty(houseinfo.getH_no())) {
			PreparedStatement pstmt=con.prepareStatement("select * from Houseinfo");
			return pstmt.executeQuery();
		}
		PreparedStatement pstmt=con.prepareStatement("select * from Houseinfo where H_no=?");
		pstmt.setString(1,houseinfo.getH_no());
		return pstmt.executeQuery();
	}
}
