package ftn.graduatethesispolovniautomobili.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    public SecurityConfiguration(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void configureAuthentication(
            AuthenticationManagerBuilder authenticationManagerBuilder)
            throws Exception {

        authenticationManagerBuilder
                .userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthenticationTokenFilter authenticationTokenFilterBean()
            throws Exception {
        AuthenticationTokenFilter authenticationTokenFilter = new AuthenticationTokenFilter();
        authenticationTokenFilter
                .setAuthenticationManager(authenticationManagerBean());
        return authenticationTokenFilter;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.headers().cacheControl().disable();
        httpSecurity.cors();
        httpSecurity.headers().frameOptions().disable();
        httpSecurity.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                .antMatchers(HttpMethod.POST, "/api/auth/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/api/auth/verify-account").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/auth/change-password").permitAll()
                .antMatchers(HttpMethod.POST, "/api/ad/search").permitAll()
                .antMatchers(HttpMethod.GET, "/api/ad/all").permitAll()
                .antMatchers(HttpMethod.GET, "/api/ad/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/api/ad/active").permitAll()
                .antMatchers(HttpMethod.GET, "/api/ad/search").permitAll()
                .antMatchers(HttpMethod.PATCH, "/api/ad/{id}/change-status").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/ad/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/api/ad/{id}/follow").permitAll()
                .antMatchers(HttpMethod.POST, "/api/ad/create").permitAll()
                .antMatchers(HttpMethod.POST, "/api/upload-photos").permitAll()
                .antMatchers(HttpMethod.GET, "/api/report/all").permitAll()
                .antMatchers(HttpMethod.POST, "/api/report/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/api/report/all").permitAll()
                .antMatchers(HttpMethod.GET, "/api/user/myAds").permitAll()
                .antMatchers(HttpMethod.GET, "/api/user/followedAds").permitAll()
                .antMatchers(HttpMethod.GET, "/api/user/myProfile").permitAll()
                .anyRequest().authenticated();

        httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }
}
