/**
 *
 */
package com.person.springboot.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author HS
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String KEY = "localhost:8086";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        http.authorizeRequests().antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll() //�����Է���
                .antMatchers("/h2-console/**").permitAll() //�����Է���
                .antMatchers("/admins/**").hasRole("ADMIN") //��Ҫ��Ӧ�Ľ�ɫ���ܷ���
                .and()
                .formLogin() //����Form����¼��֤
                .loginPage("/login").failureUrl("/login-error") //�Զ����¼ҳ��
                .and().rememberMe().key(KEY)    // ���� remember me
                .and().exceptionHandling().accessDeniedPage("/403"); // �����쳣���ܾ����ʾ��ض��� 403 ҳ��
        http.csrf().ignoringAntMatchers("/h2-console/**");  // ���� H2 ����̨�� CSRF ����
        http.headers().frameOptions().sameOrigin();    // ��������ͬһ��Դ��H2 ����̨������
    }

}
