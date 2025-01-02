package top.xym.springboot.configuration.loader;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.util.Properties;

@Configuration
// DefaultPropertySourceFactory 是进行配置文件加载的工厂类.
public class YamlPropertyLoader extends DefaultPropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(@Nullable String name, EncodedResource resource) throws IOException {
        String sourceName = name != null ? name : resource.getResource().getFilename();
        if (sourceName != null && (sourceName.endsWith(".yml") || sourceName.endsWith(".yaml"))) {
            Properties propertiesFromYaml = loadYml(resource);
            // 将 YML 配置转成 Properties 之后，再用 PropertiesPropertySource 绑定
            return new PropertiesPropertySource(sourceName, propertiesFromYaml);
        } else {
            return super.createPropertySource(name, resource);
        }
    }

    // 将 YML 格式的配置转成 Properties 配
    private Properties loadYml(EncodedResource resource) throws IOException {
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(resource.getResource());
        factory.afterPropertiesSet();
        return factory.getObject();
    }
}
