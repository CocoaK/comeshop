//package com.eshop.serviceapp.common.annotation;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.util.HashMap;
//import java.util.Map;
//
//@Aspect //AOP 切面
//@Component
//public class DecryptAspect {
//
//    //日志记录对象
//    private final static Logger log = LogManager.getLogger(DecryptAspect.class);
//
//    public DecryptAspect(){
////        log.debug("构造方法");
//    }
//
////    //Service层切点
////    @Pointcut("@annotation(com.eshop.serviceapp.common.annotation.Decrypt)")
////    public  void serviceAspect() {
////    }
////
////    //controller层切点 com.kuaixin.crm.crm_tsale_kx_service.service.anno.SystemServiceType可以指定另外定义的注释接口
////    @Pointcut("@annotation(ccom.eshop.serviceapp.common.annotation.Decrypt)")
////    public  void controllerAspect() {
//
//    //@Pointcut(value = "execution(@Decrypt * *.*(..))")
//    //切入点
//   @Pointcut(value = "@annotation(com.eshop.serviceapp.common.annotation.Decrypt)")
//    private void serviceAspect() {
//        System.out.println("++++执行了serviceAspect方法++++");
//    }
//
//    @Before("serviceAspect()")
//    public void paramCheck(JoinPoint joinPoint) throws Exception {
//        System.out.println("++++执行了Before方法++++");
//    }
//    /**
//     * 在方法执行前后
//     *
//     * @param point
//     * @return
//     */
////    @Around(value = "@annotation(com.eshop.serviceapp.common.annotation.Decrypt)")
//    @Around("serviceAspect() && @annotation(decrypt)")
//    public Object around(ProceedingJoinPoint point,Decrypt decrypt) {
//        Map<String, Object> result = new HashMap<String, Object>();
//        result.put("message", "验证通过");
//        result.put("result", true);
////        Class<?> cls = decrypt.clazz();
////
////        // 检测field是否存在
////        try {
////            // 获取实体字段集合
////            Field[] fields = cls.getDeclaredFields();
////            for (Field f : fields) {
////                // 通过反射获取该属性对应的值
////                f.setAccessible(true);
////                // 获取字段值
//////                Object value = f.get();
////                // 获取字段上的注解集合
////                //Object value = f.get();
////                Annotation[] arrayAno = f.getAnnotations();
////                for (Annotation annotation : arrayAno) {
////                    if(annotation.annotationType().equals(decrypt.annotationType())){
////                        // 获取注解类型（注解类的Class）
//////                        Class<?> clazz = annotation.annotationType();
////                        // 获取注解类中的方法集合
//////                        Method[] methodArray = clazz.getDeclaredMethods();
//////                        for (Method method : methodArray) {
//////                            // 获取方法名
//////                            String methodName = method.getName();
//////                            // 过滤错误提示方法的调用
//////                            if(methodName.equals("message")) {
//////                                continue;
//////                            }
////                            // 初始化注解验证的方法处理类 （我的处理方法卸载本类中）
////                            //Object obj = AnnotationDealUtil.class.newInstance();
////                            // 获取方法
////                            try {
////                                // 根据方法名获取该方法
//////                                Method m = cls.getDeclaredMethod(f.getName(), Object.class, Field.class);
////                                // 调用该方法
//////                            result = (Map<String, Object>)m.invoke(obj, value, f);
//////                            cls.
////                                /* 验证结果 有一处失败则退出 */
////                                if(result.get("result").equals(false)) {
////                                    return result;
////                                }
////                            } catch (Exception e) {
////                                e.printStackTrace();
//////                                log.info("找不到该方法:"+methodName);
////                            }
//////                        }
////                    }
////
////                }
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////            log.info("验证出错");
////        }
////        return result;
//
//
//
//
////        decrypt.name();
//        System.out.println("++++执行了around方法++++");
//
//        //拦截的类名
//        Class clazz = point.getTarget().getClass();
//        //拦截的方法
//        Method method = ((MethodSignature) point.getSignature()).getMethod();
//
//        System.out.println("执行了 类:" + clazz + " 方法:" + method );
//        try {
//            return point.proceed(); //执行程序
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            return throwable.getMessage();
//        }
//    }
//
//    /**
//     * 方法执行后
//     *
//     * @param joinPoint
////     * @param decrypt
//     * @param result
//     * @return
//     */
//    @AfterReturning(value = "serviceAspect()", returning = "result")
//    public Object afterReturning(JoinPoint joinPoint, Object result) {
//
////        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
////        HttpSession session = request.getSession();
//
//        System.out.println("++++执行了afterReturning方法++++");
//        System.out.println("执行结果：" + result);
//
//        return result;
//    }
//
//    /**
//     * 方法执行后 并抛出异常
//     *
//     * @param joinPoint
////     * @param decrypt
//     * @param ex
//     */
//    @AfterThrowing(value = "serviceAspect()", throwing = "ex")
//    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
//        System.out.println("++++执行了afterThrowing方法++++");
//    }
//
//}
