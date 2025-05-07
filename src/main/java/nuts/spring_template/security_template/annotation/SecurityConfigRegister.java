package nuts.spring_template.security_template.annotation;

import nuts.spring_template.security_template.test_pack.AuthenticationTester;
import nuts.spring_template.security_template.test_pack.TestConfig;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class SecurityConfigRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(EnableTestSecurityConfig.class.getName());

        String id = (String) attributes.get("id");

        BeanDefinitionBuilder builder = BeanDefinitionBuilder
                .rootBeanDefinition(TestConfig.class);

        builder.addPropertyValue("id", id);

        registry.registerBeanDefinition("testConfig", builder.getBeanDefinition());

    }
}
