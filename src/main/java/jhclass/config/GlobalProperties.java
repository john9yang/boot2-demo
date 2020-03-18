package jhclass.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:global-${envCode:dev}.properties")
public class GlobalProperties {
    @Value("${email}")
    public String email;
}
