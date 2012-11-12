package itagent.dao;

public interface IScoreTBService {
	public String setTeamScore(String teamId, int Score);
	public int getTeamScore(String teamId);

}
