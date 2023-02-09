package Linkcode.shop.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Linkcode.shop.connection.ShopDB;
import Linkcode.shop.login.model.Registeration;


public class RegistrationImpl implements RegisterDao{
	public int create(List<Registeration> lst) {
int i=0;
		
		Connection con=ShopDB.getConnection();
		
		try {
			PreparedStatement pst=con.prepareStatement("insert into userinfo values(?,?,?,?,?,?)");
			Registeration u=lst.get(0);
			pst.setString(1, u.getName());
			pst.setString(2, u.getEmail());
			pst.setInt(3, u.getMobileno());
			pst.setString(4, u.getUsername());
			pst.setString(5, u.getPassword());
			pst.setString(6, u.getRepass());
			
			i=pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return i;
		
		
		
	}

}
