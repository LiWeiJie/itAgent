package itagent.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import play.Logger;
import play.Play;

public class ScoreTBServiceImpl implements IScoreTBService {
	public final String SCORE_TB_NAME = Play.configuration
			.getProperty("SCORE_TB_NAME");

	@Override
	public String setTeamScore(String teamId, int Score) {
		// TODO Auto-generated method stub
		Connection conn = play.db.DB.getConnection();
		String sql = "UPDATE " + SCORE_TB_NAME + " SET TEAM_SCORE=" + Score
				+ " WHERE TEAM_ID = '" + teamId+"';";
		Logger.debug(sql);
		try {
			conn.prepareStatement(sql).execute();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAILED";
		}
		return "SUCCESS";
	}

	@Override
	public int getTeamScore(String teamId) {
		// TODO Auto-generated method stub
		int teamScore = -1;
		Connection conn = play.db.DB.getConnection();
		String sql = "SELECT * FROM " + SCORE_TB_NAME + " WHERE TEAM_ID='"
				+ teamId + "';";
		System.out.println(sql);
		try {
			ResultSet rs = conn.prepareStatement(sql).executeQuery();
			rs.beforeFirst();
			while (rs.next()) {
				teamScore = rs.getInt("TEAM_SCORE");
				break;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teamScore;
	}

	@Override
	public String getTeamName(String teamId) {
		// TODO Auto-generated method stub
		String teamName = "";
		Connection conn = play.db.DB.getConnection();
		String sql = "SELECT * FROM " + SCORE_TB_NAME + " WHERE TEAM_ID='"
				+ teamId + "';";
		System.out.println(sql);
		try {
			ResultSet rs = conn.prepareStatement(sql).executeQuery();
			rs.beforeFirst();
			while (rs.next()) {
				teamName = rs.getString("TEAM_NAME");
				break;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teamName;
	}

}
