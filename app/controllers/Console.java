package controllers;

import itagent.dao.IProblemTBService;
import itagent.dao.IScoreTBService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;

import play.mvc.Controller;

public class Console extends Controller {
	@Inject
	static IProblemTBService problemTBService;
	@Inject
	static IScoreTBService scoreTBService;
	public static void index() throws SQLException {
		int str =problemTBService.getProblemsCount();
        renderText(str);
    }
	
	public static void getProblem(int id) throws SQLException {
		int str =problemTBService.getProblemsCount();
        renderText(str);
    }
	
	private static int loadingQue = 0;
	
	public static void startQues(int quesId)
	{
		System.out.print(quesId);
		loadingQue = quesId;
		renderText(quesId);
	}
}
