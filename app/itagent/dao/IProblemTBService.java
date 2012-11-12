package itagent.dao;

public interface IProblemTBService {
	public String getSingleProblemById(int Id);

	public String setTeamTime(int problemId, String teamId, Long Time);

	public long getTeamTime(int problemId, String teamId);
	
	public int getProblemsCount();
}
