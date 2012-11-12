package config;

import itagent.dao.IProblemTBService;
import itagent.dao.IScoreTBService;
import itagent.dao.ProblemTBServiceImpl;
import itagent.dao.ScoreTBServiceImpl;
import play.Logger;

import com.google.inject.*;

public class GuicyDummyModel extends AbstractModule {
	public void configure() {
		Logger.debug("**********GuicyDummyModel**********");

		bind(IProblemTBService.class).to(ProblemTBServiceImpl.class);
		bind(IScoreTBService.class).to(ScoreTBServiceImpl.class);

	}
}