package services;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by it4omanHamza on 02/06/2016.
 */
public class ServiceClass {

    //assertTrue(true);
    private static InterServices service;

    static{

        ClassPathXmlApplicationContext app=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        service=(InterServices) app.getBean("service");


    }

    public static InterServices getService() {

        return service;
    }


}
