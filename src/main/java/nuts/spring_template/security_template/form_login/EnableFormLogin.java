package nuts.spring_template.security_template.form_login;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableFormLogin {
    String loginPage() default "/login";
    String loginProcessUrl() default "/login";
    String loginSuccessUrl() default "/";
    String failureUrl() default "/login?error";
    String usernameParameter() default "username";
    String passwordParameter() default "password";

    String logoutUrl() default "/logout";
    String logoutSuccessUrl() default "/login?logout";
    String deleteCookies() default "JSESSIONID";
    String invalidateHttpSession() default "true";
}
