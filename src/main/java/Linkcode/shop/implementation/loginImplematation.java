package Linkcode.shop.implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Linkcode.shop.login.model.Login;
import Linkcode.shop.connection.*;

public class loginImplematation implements LoginDao{
	

	public String validateUser(List<Linkcode.shop.login.model.Login> lst) {
		int i=0;

		ShopDB db=new ShopDB();
		Login log=lst.get(0);
		String msg=null;
		String str="select uname,spass from userinfo";
		try {
			Connection con=(Connection) db.getConnection();			
			java.sql.Statement state=con.createStatement();
			ResultSet rs=state.executeQuery(str);
			while(rs.next()) {
				if(rs.getString(1).equals(log.getUsername())){
					if(rs.getString(2).equals(log.getPassword())) {
					msg="valid";	
					}
					
				}
				else {
					msg="try again";
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;

}
}
