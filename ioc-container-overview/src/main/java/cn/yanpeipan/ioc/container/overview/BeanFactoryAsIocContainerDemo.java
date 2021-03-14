package cn.yanpeipan.ioc.container.overview;

import cn.yanpeipan.ioc.container.overview.domain.User;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * {@link org.springframework.beans.factory.BeanFactory} 作为Ioc容器
 */
public class BeanFactoryAsIocContainerDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        int beanDefinitionsCount = reader.loadBeanDefinitions(location);
        System.out.println("Bean count: " + beanDefinitionsCount);

        lookupCollectionByType(beanFactory);
    }

    private static void lookupCollectionByType(DefaultListableBeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("Users: " + users);
        }
    }
}
