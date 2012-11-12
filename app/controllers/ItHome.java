package controllers;

import play.mvc.Controller;

public class ItHome extends Controller {
	
	
	public static void index()
	{
		render();
	}
	public static void maintab()
	{
		System.out.println(System.currentTimeMillis());
		render();
	}
	
	public static void login() {
		render();
	}
	
	public static void admin() {
		render();
	}
	
	public static void authenticate(String userName, String password)
	{
		renderText(userName+password);
	}
	

	
	
	
	
}
