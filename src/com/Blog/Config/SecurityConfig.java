package com.Blog.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	{
		System.out.println("security config start");
	}
	@Autowired
	ComboPooledDataSource datasource;
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic()
		.and().requiresChannel().antMatchers("/springWEB/Login").requiresSecure();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(datasource)
		.usersByUsernameQuery("select username,password from user where username=?")
		.authoritiesByUsernameQuery("select username,authority from user where username=?");
	}
	
}
