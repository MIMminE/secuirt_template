package nuts.spring_template.security_template.annotation;


import nuts.spring_template.security_template.test_pack.AuthenticationTester;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({AuthenticationTester.class, SecurityConfigRegister.class})
public @interface EnableTestSecurityConfig {
    String id();
}
