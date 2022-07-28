package web.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@EnableWebSecurity
@ComponentScan("web")
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        http.addFilterBefore(characterEncodingFilter, ChannelProcessingFilter.class);
        http.csrf().disable();
        http.sessionManagement().sessionFixation().changeSessionId();
        //http.sessionManagement().sessionFixation().migrateSession();
        http.authorizeHttpRequests(authorize ->
                        authorize.antMatchers("/registration").permitAll()
                                .antMatchers("/getRecords").hasRole("ADMIN")
                        .anyRequest().authenticated()
        )
        .formLogin((form) -> form
                .loginPage("/login").defaultSuccessUrl("/", true)
                .permitAll()
        )
        .logout();
        return http.build();
    }
}
