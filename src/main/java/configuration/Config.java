package configuration;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import repository.AgencyRepository;
import repository.KpopGroupRepository;
import repository.MemberRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@PropertySource("classpath:config.properties")
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
        config.setLocationsAsStrings("src/main/resources/db/migration/V1_init_tables.sql");
        return new Flyway(config);
    }
}
