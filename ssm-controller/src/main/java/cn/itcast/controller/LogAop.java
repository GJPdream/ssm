package cn.itcast.controller;

import cn.itcast.doamin.SysLog;
import cn.itcast.service.sysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {
    /*注入http*/
    @Autowired
    private HttpServletRequest request;
    /**
     * 注入service
     */
    @Autowired
   private sysLogService sysLogService;
    /*开始时间*/
    private Date startTime;
    /*访问的类*/
    private  Class clazz;
    /*访问的方法*/
    private Method method;

  /*  前置通知 是取开始时间，执行分类，执行分方法*/
    @Before("execution(* cn.itcast.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
       /* 当前的时间*/
        startTime=new Date();
        /*具体要访问的类*/
        clazz = jp.getTarget().getClass();
        /*获取访问的方法，这个只能获取名称*/
        String name = jp.getSignature().getName();
        /*把方法的参数拿出来*/
        Object[] args = jp.getArgs();
        /*获取具体得到方法*/
        if(args==null||args.length==0)
        {
        /*但是这个方法只能获取的是无参的法法*/
         method = clazz.getMethod(name);
        }
       /* 如果有参数我们就执行带参数的*/
        else {
            Class[] classes = new Class[args.length];
            for (int i=0;i<args.length;i++)
            {
                classes[i]=args[i].getClass();
            }
              clazz.getMethod(name, classes);
        }
    }

    @After("execution(* cn.itcast.controller.*.*(..))")
    public void doAfter(JoinPoint jp)throws NoSuchMethodException {
        String url ="";
        /*获取时间差*/
        long time=new Date().getTime()-startTime.getTime();
       /* 获取url 就是类名加方法名*/
        if (clazz!=null && method!=null && clazz!=LogAop.class){
            //获取类上的路径
            RequestMapping  clazzAnnotation = (RequestMapping)clazz.getAnnotation(RequestMapping.class);
            if (clazzAnnotation!=null)
            {
              /*  获取类名requestmapping 的值*/
               String [] classValue=clazzAnnotation.value();
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
               if (methodAnnotation!=null)
               {
                   String [] methodValue=methodAnnotation.value();
                   url = classValue[0] + methodValue[0];
                   /*获取ip*/
                   String ip = request.getRemoteAddr();

                   /*获取当前用户*/
                   SecurityContext context = SecurityContextHolder.getContext();
                   User principal =(User) context.getAuthentication().getPrincipal();
                   String username = principal.getUsername();
                   /**
                    * 都已经写完了开始封装操作了
                    */
                   SysLog sysLog=new SysLog();
                   sysLog.setExecutionTime(time);
                   sysLog.setIp(ip);
                   sysLog.setMethod("[类名] "+clazz.getName()+"[方法名] "+method.getName());
                   sysLog.setUrl(url);
                   sysLog.setUsername(username);
                   sysLog.setVisitTime(startTime);
                   /**
                    * 调用service完成操作
                    */
                   sysLogService.save(sysLog);

               }
            }
        }

    }

}
