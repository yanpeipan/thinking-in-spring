package cn.yanpeipan.ioc.container.overview;

import cn.yanpeipan.ioc.container.overview.domain.User;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class AnnotationApplicationContextAsIocContainerDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationApplicationContextAsIocContainerDemo.class);
        // 启动应用上下文
        applicationContext.refresh();
        // 依赖查找集合对象
        lookupCollectionByType(applicationContext);

        applicationContext.close();
    }

    private static void lookupCollectionByType(AnnotationConfigApplicationContext applicationContext) {
        Map<String, User> users = applicationContext.getBeansOfType(User.class);
        System.out.println("Users: " + users);
    }

    @Bean
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("yanpeipan");
        return user;
    }
}
