package controllers;

import play.mvc.Controller;

public class ItHome extends Controller {
	
	private static int doingQue = 0;
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
	
	public static void startQues(int quesId)
	{
		System.out.print(quesId);
		renderText(quesId);
		doingQue = quesId;
	}
	
	
	
	
}
