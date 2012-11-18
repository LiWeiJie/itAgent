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
	private static long startTime = 0;
	private static int teamsCount = 12;
	
	private static String[] teamIds = {"","T1","T2","T3","T4","T5","T6","T7","T8","T9","T10","T11","T12","T13"};
	private static String[] teamRanking ;
	private static int showAnswer = 0 ;

	
	public static void startQues(int quesId)
	{
		System.out.print(quesId);
		if(quesId==0) loadingQue=0;
		else loadingQue = quesId*2-1;
		startTime = System.currentTimeMillis();
		showAnswer = 0;
		renderText(quesId);
	}

	public static void showAns()
	{
		showAnswer = 1;
	}

	
	public static void index() throws SQLException {
		render();
    }

    public static void getProblemsCount() throws SQLException {
		int str =problemTBService.getProblemsCount()/2;
        renderText(str);
    }

    public static void getCurrentProblem() throws SQLException {
        renderText(loadingQue);
    }

    public static void getPercentage() throws SQLException {
    	int problemCount =problemTBService.getProblemsCount()/2;
    	int trueQue = (loadingQue+1)/2;
    	int percentage = trueQue*100/problemCount;
    	String str = trueQue+"/"+problemCount+"-"+percentage;
	    renderText(str);
    }
	
	public static void getProblem() throws SQLException {
		if (loadingQue==0) renderText("Waiting~");
		String str;
		if (showAnswer==0)
			str =problemTBService.getSingleProblemById(loadingQue);
		else 
			str =problemTBService.getSingleProblemById(loadingQue+1);
        renderText(str);
    }
	
	public static void setTeamAnswerTime(int teamId) throws SQLException {
		System.out.println(teamId);
		System.out.println(System.currentTimeMillis()-startTime);
		Long t = problemTBService.getTeamTime(loadingQue, teamIds[teamId]);
		Long zero = new Long(0);
		System.out.println(t);
		if (t.equals(zero))
		{
			System.out.println(t);
			System.out.println(teamIds[teamId]);
			String str =problemTBService.setTeamTime(loadingQue, teamIds[teamId], System.currentTimeMillis()-startTime);
			renderText(str);
		}
    }
	
	public static void setTeamScore(int teamId,int plus) throws SQLException {
		String str =scoreTBService.setTeamScore(teamIds[teamId], scoreTBService.getTeamScore(teamIds[teamId])+plus);
		renderText(str);
    }
	
	public static void getTeamScore(int teamId) throws SQLException {
		String str = teamId+"-"+scoreTBService.getTeamScore(teamIds[teamId]);
		renderText(str);
    }
	
	public static void getTeamTime(int teamId) throws SQLException {
		String str = teamId+"-"+problemTBService.getTeamTime(loadingQue, teamIds[teamId]);
		renderText(str);
    }

    public static void getTeamName(int teamId) throws SQLException {
		String str = scoreTBService.getTeamName(teamIds[teamId]);
		renderText(str);
    }

    public static void resetQues(int quesId) throws SQLException {
    	
    	Long t = new Long(0);
    	quesId = quesId*2-1;
    	for (int i=1;i<=teamsCount;i++)
    	{
    		problemTBService.setTeamTime(quesId, teamIds[i], t);
    		System.out.println(quesId+"+"+i);
    	}
    }

    public static void resetAllQues() throws SQLException {
    	int problemCount =problemTBService.getProblemsCount();
    	System.out.println(problemCount);
    	Long t = new Long(0);
    	for(int i=0;i<=problemCount;i++)
    	{
	    	for (int j=1;j<=teamsCount;j++)
			{
				problemTBService.setTeamTime(i, teamIds[j], t);
			}
    	}
    }

    public static void dominateScore(int teamId,int variation) throws SQLException {
    	int teamScore = scoreTBService.getTeamScore(teamIds[teamId]);
		String str = scoreTBService.setTeamScore(teamIds[teamId],teamScore+variation);
		renderText(str);
    }

    public static void resetScore(int variation) throws SQLException {
    	for (int i=1;i<=teamsCount;i++)
    	{
    		String str = scoreTBService.setTeamScore(teamIds[i],variation);
    	}
    }


    public static void maoPao(int[] x) {  
	  for (int i = 0; i < x.length; i++) {  
	   for (int j = i + 1; j < x.length; j++) {  
	    if (x[i] > x[j]) {
	     int temp = x[i];
	     x[i] = x[j];
	     x[j] = temp;
	    }  
	   }  
	  }

	 } 

}
