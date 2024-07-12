package bai8.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class UserConfiguration {
    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("select id , pw, active from accounts where id =?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select id, role from roles where id =? ");
        return  userDetailsManager;

    }

    // ------------- dùng bảng mặc dịnh --------------------------------------------
//        @Bean
//        @Autowired
//        public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
//            JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
//            userDetailsManager.setDataSource(dataSource);
//            return userDetailsManager;
//        }
//---------- Dung UserDetailManager de quan li -----------------
//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//        UserDetails hieu = User.withUsername("hieu").password("{noop}123").roles("teacher").build();
//        UserDetails ha = User.withUsername("ha").password("{noop}123").roles("student").build();
//        return new InMemoryUserDetailsManager(hieu,ha);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                configurer -> configurer
                            .requestMatchers(HttpMethod.GET, "/students").hasAnyRole("TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.GET, "/students/**").hasAnyRole("TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/students").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.PUT, "/students").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.DELETE, "/students/**").hasRole("TEACHER")

        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
    }

