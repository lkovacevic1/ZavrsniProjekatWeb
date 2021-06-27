package rs.raf.ZavrsniProjekat;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import rs.raf.ZavrsniProjekat.repositories.subject.MySqlRepository;
import rs.raf.ZavrsniProjekat.repositories.subject.NewsRepositorty;
import rs.raf.ZavrsniProjekat.services.AdminService;
import rs.raf.ZavrsniProjekat.services.CategoryService;
import rs.raf.ZavrsniProjekat.services.NewsService;
import rs.raf.ZavrsniProjekat.services.UserService;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class HelloApplication extends ResourceConfig {

    public HelloApplication() {
        // Ukljucujemo validaciju
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        // Definisemo implementacije u dependency container-u
        AbstractBinder binder = new AbstractBinder() {
            @Override
            protected void configure() {
                this.bind(MySqlRepository.class).to(NewsRepositorty.class).in(Singleton.class);

                this.bindAsContract(UserService.class);
                this.bindAsContract(CategoryService.class);
                this.bindAsContract(NewsService.class);
                this.bindAsContract(AdminService.class);
            }
        };
        register(binder);

        // Ucitavamo resurse
        packages("rs.raf.ZavrsniProjekat.resources");
    }
}