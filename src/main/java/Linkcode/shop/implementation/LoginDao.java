package Linkcode.shop.implementation;

import java.util.List;

import Linkcode.shop.login.model.Login;



public interface LoginDao {
	public String validateUser(List<Login> lst);
}
