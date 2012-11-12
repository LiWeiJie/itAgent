package config;

import play.modules.guice.GuiceSupport;

import com.google.inject.*;

public class GuicyDummy extends GuiceSupport {
        protected Injector configure() {
           return Guice.createInjector(new GuicyDummyModel());
        }
}
