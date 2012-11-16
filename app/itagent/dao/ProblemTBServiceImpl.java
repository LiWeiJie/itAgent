package itagent.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import play.Logger;
import play.Play;

public class ProblemTBServiceImpl implements IProblemTBService {
	public final String PROBLEM_TB_NAME = Play.configuration
			.getProperty("PROBLEM_TB_NAME");

	@Override
	public String getSingleProblemById(int Id) {
		// TODO Auto-generated method stub
		String problemContent = "";
		Connection conn = play.db.DB.getConnection();
		String sql = "SELECT * FROM " + PROBLEM_TB_NAME + " WHERE PROBLEM_ID="
				+ Id;
		Logger.debug(sql);
		try {
			ResultSet rs = conn.prepareStatement(sql).executeQuery();
			rs.beforeFirst();
			while (rs.next())
				problemContent = rs.getString("Content");
			//conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return problemContent;
	}

	@Override
	public String setTeamTime(int problemId, String teamId, Long Time) {
		// TODO Auto-generated method stub
		Connection conn = play.db.DB.getConnection();
		String sql = "UPDATE " + PROBLEM_TB_NAME + " SET " + teamId + " = "
				+ Time + " WHERE PROBLEM_ID = " + problemId;
		Logger.debug(sql);
		try {
			conn.prepareStatement(sql).execute();
			//conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAILED";
		}
		return "SUCCESS";
	}

	@Override
	public long getTeamTime(int problemId, String teamId) {
		// TODO Auto-generated method stub
		long teamTime = -1;
		Connection conn = play.db.DB.getConnection();
		String sql = "SELECT * FROM " + PROBLEM_TB_NAME + " WHERE PROBLEM_ID="
				+ problemId;
		Logger.debug(sql);
		try {
			ResultSet rs = conn.prepareStatement(sql).executeQuery();
			rs.beforeFirst();
			while (rs.next()) {
				teamTime = rs.getLong(teamId);
				break;
			}
			//conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teamTime;
	}

	@Override
	public int getProblemsCount() {
		// TODO Auto-generated method stub

		int totalProblemCount = -1;
		Connection conn = play.db.DB.getConnection();
		String sql = "SELECT COUNT(*) FROM " + PROBLEM_TB_NAME;
		Logger.debug(sql);
		try {
			ResultSet rs = conn.prepareStatement(sql).executeQuery();
			rs.beforeFirst();
			while (rs.next()) {
				totalProblemCount = rs.getInt("COUNT(*)");
				break;
			}
			//conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalProblemCount;
	}

}
