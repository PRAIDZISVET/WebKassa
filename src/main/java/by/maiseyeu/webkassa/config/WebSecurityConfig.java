package by.maiseyeu.webkassa.config;

import by.maiseyeu.webkassa.service.UserServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@ComponentScan(basePackages = {"by.maiseyeu.webkassa.config"})
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    private UserServiceDAO userService;
//
//    @Autowired
//    public void setUserService(UserServiceDAO userService) {
//        this.userService = userService;
//    }

        private UserDetailsService userDetailsService;

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers( "/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                //.failureUrl("/login?error").defaultSuccessUrl("/myProfile")
                .loginPage("/login").permitAll()
                .and()
                .formLogin();
//                .and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/").deleteCookies("remember-me").permitAll();
    }

//    @Bean
//    protected PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder(12);
//    }

    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    public void setUserDetailsService(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .csrf()
//                .disable()
//                .authorizeRequests()
//                //Доступ только для не зарегистрированных пользователей
////                .antMatchers("/registration").not().fullyAuthenticated()
//                //Доступ только для пользователей с ролью Администратор
// //               .antMatchers("/admin/**").hasRole("ADMIN")
////                .antMatchers("/news").hasRole("USER")
//                //Доступ разрешен всем пользователей
//                //.antMatchers("/", "/resources/**").permitAll()
//                .antMatchers("/").permitAll()
//                //Все остальные страницы требуют аутентификации
////                .anyRequest().authenticated()
//                .and()
//                //Настройка для входа в систему
//                .formLogin()
//                .loginPage("/login")
//                //Перенарпавление на главную страницу после успешного входа
////                .defaultSuccessUrl("/")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .logoutSuccessUrl("/");
//    }
//
//    @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
//    }

}