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
	
	private static int loadingQue = 0;
	
	private static String[] teamIds = {"T1","T2","T3"};
	
	public static void startQues(int quesId)
	{
		System.out.print(quesId);
		loadingQue = quesId;
		renderText(quesId);
	}
	
	public static void index() throws SQLException {
		int str =problemTBService.getProblemsCount();
        renderText(str);
    }
	
	public static void getProblem() throws SQLException {
		String str =problemTBService.getSingleProblemById(loadingQue);
        renderText(str);
    }
	
	public static void setTeamAnswerTime(int problemId,int teamId) throws SQLException {
		String str =problemTBService.setTeamTime(problemId, teamIds[teamId], System.currentTimeMillis());
        renderText(str);
    }
	
	public static void setTeamScore(int teamId,int plus) throws SQLException {
		String str =scoreTBService.setTeamScore(teamIds[teamId], scoreTBService.getTeamScore(teamIds[teamId])+plus);
		renderText(str);
    }
	
	public static void getTeamScore(int teamId) throws SQLException {
		long str = scoreTBService.getTeamScore(teamIds[teamId]);
		renderText(str);
    }
	
	public static void getTimeRanking(int no) throws SQLException {
		long[] score=new long[9];
		for(int i=0;i<9;i++)
		{
			score[i] = scoreTBService.getTeamScore(teamIds[i]); 
		}
		
    }
	

}
