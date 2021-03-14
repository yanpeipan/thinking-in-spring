package cn.yanpeipan.ioc.container.overview;

import cn.yanpeipan.ioc.container.overview.repository.UserRepository;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.context.WebApplicationContext;


/**
 * 依赖注入示例
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        UserRepository userRepository = applicationContext.getBean("userRepository", UserRepository.class);
        System.out.println("依赖来源：自定义bean " + userRepository.getUsers());

        System.out.println("依赖来源：内建依赖 " + userRepository.getBeanFactory());

        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println("依赖来源：容器内建 " + environment);

        ObjectFactory userFactory = userRepository.getObjectFactory();

        System.out.println(userFactory.getObject() == applicationContext);

        // applicationContext 组合 BeanFactory
        System.out.println(userRepository.getBeanFactory() == applicationContext);

    }
}
