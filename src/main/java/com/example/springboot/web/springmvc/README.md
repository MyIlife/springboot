1.参考官方文档：https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-spring-mvc-auto-configuration
    1.1 springboot对springmvc做了大多数的自动化配置：
        Inclusion of ContentNegotiatingViewResolver and BeanNameViewResolver beans.
        内容协商视图解析器和beanName视图解析器
        Support for serving static resources, including support for WebJars (covered later in this document)).
        静态资源
        Automatic registration of Converter, GenericConverter, and Formatter beans.
        数据转换器
        Support for HttpMessageConverters (covered later in this document).
        内容协商理解
        Automatic registration of MessageCodesResolver (covered later in this document).
        国际化
        Static index.html support.
        静态index.html支持
        Automatic use of a ConfigurableWebBindingInitializer bean (covered later in this document).
        数据绑定等
2.静态资源目录【/resources下，也就是说这些资源目录下我们可以直接通过文件名称访问对应的文件【http://localhost:8080/p1.jpg】
    /static,/public,/resources,/META-INF/resources
    2.1 修改默认的静态资源路径【默认 /**】,访问时必须带/recources/
        spring:
          mvc:
            static-path-pattern: /recources/**
    2.2 如果静态资源和动态资源【Controller】访问路径一致，那么先去动态资源找，然后再去静态资源找
 3.支持webjar，【https://www.webjars.org/】比如支持jquery.js，步骤：
    3.1 导入依赖
            <dependency>
                <groupId>org.webjars</groupId>
                <artifactId>jquery</artifactId>
                <version>3.5.1</version>
            </dependency>
     3.2 访问地址 【http://localhost:8080/webjars/jquery/3.5.1/jquery.js】
4.欢迎页面【用户直接访问根路径时的页面http://localhost:8080/，等同于http://localhost:8080/index.html】
    1.静态资源路径下放一个index.html
        1.1 注意 可以静态资源的路径，但不能修改静态资源的访问前缀 不然，会访问不到index.html
    2.controller处理/index的请求
5.Rest风格支持
    GettMapping、DeleteMapping。。。
6.请求映射原理【源码解读看有道云笔记】
    1.请求来到DispatcherServlet【springboot-web底层还是springmvc】
    2.ctrl+H显示继承树
    3.DispatcherServlet // 实现FrameworkServlet的doService(request, response);！！！
        //doService(request, response);-》doDispatch(request, response);
        -》mappedHandler = getHandler(processedRequest);//使用哪个Controller
        extends FrameworkServlet //实现HttpServlet【doGet/doPost...】
            //doGet/doPost...-》processRequest(request, response);-》doService(request, response);
            extends HttpServletBean 
                extends HttpServlet 
                implements EnvironmentCapable, EnvironmentAware
            implements ApplicationContextAware
    