package cn.yanpeipan.ioc.container.overview;


import cn.yanpeipan.ioc.container.overview.annotation.Super;
import cn.yanpeipan.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 */
public class DepencyLookupDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");

        lookupByName(beanFactory);

        lookupByType(beanFactory);

        lookupCollectionByType(beanFactory);

        lookupByAnnotationType(beanFactory);

        lookupInLazy(beanFactory);
    }

    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> userObjectFactory = (ObjectFactory<User>) beanFactory.getBean("userFactory");
        User user = userObjectFactory.getObject();
        System.out.println("UserFactory: " + user);
    }

    private static void lookupByName(BeanFactory beanFactory) {
        User user = beanFactory.getBean("user", User.class);
        System.out.println("User by name: " + user);
    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> users = listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("Super User: " + users);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("Users: " + users);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("Primary User :" + user);
    }
}
