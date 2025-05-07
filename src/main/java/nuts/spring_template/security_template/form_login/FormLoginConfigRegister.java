package nuts.spring_template.security_template.form_login;

import nuts.spring_template.security_template.annotation.EnableTestSecurityConfig;
import nuts.spring_template.security_template.test_pack.TestConfig;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class FormLoginConfigRegister implements ImportBeanDefinitionRegistrar {

    private static final String LOGIN_PAGE_ARGUMENT = "loginPage";
    private static final String LOGIN_PROCESS_URL_ARGUMENT = "loginProcessUrl";
    private static final String LOGIN_SUCCESS_URL_ARGUMENT = "loginSuccessUrl";
    private static final String FAILURE_URL_ARGUMENT = "failureUrl";
    private static final String USERNAME_PARAM_ARGUMENT = "usernameParameter";

    private static final String LOGOUT_URL_ARGUMENT = "logoutUrl";
    private static final String LOGOUT_SUCCESS_URL_ARGUMENT = "logoutSuccessUrl";
    private static final String DELETE_COOKIES_ARGUMENT = "deleteCookies";
    private static final String INVALIDATE_HTTP_SESSION_ARGUMENT = "invalidateHttpSession";


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(EnableFormLogin.class.getName());

        BeanDefinitionBuilder beanBuilder = createBeanBuilderFromAnnotationAttributes(attributes);



        String id = (String) attributes.get("id");

        BeanDefinitionBuilder builder = BeanDefinitionBuilder
                .rootBeanDefinition(TestConfig.class);

        builder.addPropertyValue("id", id);

        registry.registerBeanDefinition("testConfig", builder.getBeanDefinition());
    }

    private BeanDefinitionBuilder createBeanBuilderFromAnnotationAttributes(Map<String, Object> attributes) {



        return null;
    }
}
