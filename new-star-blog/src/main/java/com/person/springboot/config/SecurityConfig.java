package com.person.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring Security 閰嶇疆绫�.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�3鏈�8鏃�
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 鍚敤鏂规硶瀹夊叏璁剧疆
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String KEY = "waylau.com";

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();   // 浣跨敤 BCrypt 鍔犲瘑
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder); // 璁剧疆瀵嗙爜鍔犲瘑鏂瑰紡
        return authenticationProvider;
    }

    /**
     * 鑷畾涔夐厤缃�
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll() // 閮藉彲浠ヨ闂�
                .antMatchers("/h2-console/**").permitAll() // 閮藉彲浠ヨ闂�
                .antMatchers("/admins/**").hasRole("ADMIN") // 闇�瑕佺浉搴旂殑瑙掕壊鎵嶈兘璁块棶
                .and()
                .formLogin()   //鍩轰簬 Form 琛ㄥ崟鐧诲綍楠岃瘉
                .loginPage("/login").failureUrl("/login-error") // 鑷畾涔夌櫥褰曠晫闈�
                .and().rememberMe().key(KEY) // 鍚敤 remember me
                .and().exceptionHandling().accessDeniedPage("/403");  // 澶勭悊寮傚父锛屾嫆缁濊闂氨閲嶅畾鍚戝埌 403 椤甸潰
        http.csrf().ignoringAntMatchers("/h2-console/**"); // 绂佺敤 H2 鎺у埗鍙扮殑 CSRF 闃叉姢
        http.headers().frameOptions().sameOrigin(); // 鍏佽鏉ヨ嚜鍚屼竴鏉ユ簮鐨凥2 鎺у埗鍙扮殑璇锋眰
    }

    /**
     * 璁よ瘉淇℃伅绠＄悊
     *
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }
}
