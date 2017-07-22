//package com.Blog.Config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
//import org.springframework.security.crypto.password.StandardPasswordEncoder;
//
//import com.mchange.v2.c3p0.ComboPooledDataSource;
//
//@Configuration
//@EnableWebMvcSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//	{
//		System.out.println("security config start");
//	}
//	@Autowired
//	ComboPooledDataSource datasource;
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		// TODO Auto-generated method stub
//		super.configure(web);
//	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception{
//		
//		http.authorizeRequests().anyRequest().authenticated().and().httpBasic()
//		.and().requiresChannel().antMatchers("/Blog/Login").requiresSecure();
//	}
//	@Override
////	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
////		System.out.println(datasource.getUser());
////		auth.jdbcAuthentication().dataSource(datasource)
////		.usersByUsernameQuery("select username,password,status from user where username=?")
////		.authoritiesByUsernameQuery("select username,authority from user where username=?")
////		.passwordEncoder(new  StandardPasswordEncoder("53cr3t"));
////	}
//	
//}
