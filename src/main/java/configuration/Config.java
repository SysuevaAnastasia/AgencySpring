package configuration;

import controller.AgencyController;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repository.AgencyRepository;
import repository.KpopGroupRepository;
import repository.MemberRepository;
import service.AgencyService;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:config.properties")
@ComponentScan("controller")
public class Config {
    @Autowired
    private Environment environment;

    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("driver"));
        dataSource.setUrl(environment.getRequiredProperty("url"));
        dataSource.setUsername(environment.getRequiredProperty("dbuser"));
        dataSource.setPassword(environment.getRequiredProperty("dbpassword"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public AgencyRepository agencyRepository() {
        return new AgencyRepository(getJdbcTemplate());
    }

    @Bean
    public KpopGroupRepository kpopGroupRepository() {
        return new KpopGroupRepository(getJdbcTemplate());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepository(getJdbcTemplate());
    }

    @Bean(initMethod = "migrate", value = "flyway")
    public Flyway getFlyway() {
        ClassicConfiguration config = new ClassicConfiguration();
        config.setBaselineOnMigrate(true);
        config.setDataSource(dataSource());
        config.setLocationsAsStrings("classpath:db/migration");
        return new Flyway(config);
    }

    @Bean
    public AgencyService agencyService() {
        return new AgencyService(agencyRepository());
    }

    @Bean
    public AgencyController agencyController() {
        return new AgencyController(agencyService());
    }
}
