package com.os.udemy.ejb.beans;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;

/**
 * Session Bean implementation class TestSessionBean
 */
@Stateless(mappedName = "bean/testMappingBean")
@LocalBean
public class TestSessionBean implements TestSessionBeanRemote {

    /**
     * Default constructor.
     */
    public TestSessionBean() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void sayHi(String name) {
        System.out.println("Hi " + name);

    }

    // TIMER
    @Resource
    SessionContext context;

    @Override
    public void createTimer(long miliseconds) {
        context.getTimerService().createTimer(miliseconds, "Welcome to the timer service");
    }

    @Timeout
    public void timeoutHandler(Timer timer) {
        System.out.println("timeoutHandler " + timer.getInfo());
    }
    
    // Dependency Injection
    @EJB
    DISessionBeanLocal diSession;
    
    @Override
    public void diMethod() {
        diSession.sessionMethod("KUBA", 98);
    }

}
