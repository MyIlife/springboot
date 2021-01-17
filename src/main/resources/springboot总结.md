1.springboot默认会配置一些组件，但如果有用户配置了，那么自己就不配置了，使用的注解就是ConditionalOnMiss
2.为什么其他组件可以拿到application.properties 的内容并在对应的configuration里面完成相应组件的实例化？【比如JDBC】
    1.创建一个配置类xxxProperties.class
    2.类上加入注解：@ConfigurationProperties(prex = "xxx",ignoreUnkownFields = true)
    3.在主配置类xxxAutoConfiguration类上加入注解@EnableConfigurationProperties(value = xxx.class)
    4.需要注入容器的组件如果依赖该配置类xxxProperties.class的一些配置信息，那么可以直接在@Bean定义的方法上直接注入这个类作为参数使用
        可参考HttpEncodingAutoConfiguration主配置类的使用
3.springboot实践
    3.1 如果有相关场景的开发，可以看看官方网站是否已经提供相关starter，还可以查看做了哪些配置
        https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-starter
        https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html
    3.2 引用了starter之后查看哪些配置生效【哪些组件已经加入容器】
        application.properties 中加入 debug=true
    3.3 如果已有组件或者配置不满足我们需要，可以直接修改application.properties，以及直接修改组件如：
            		@Bean
            		@ConditionalOnBean(MultipartResolver.class)
            		@ConditionalOnMissingBean(name = DispatcherServlet.MULTIPART_RESOLVER_BEAN_NAME)
            		public MultipartResolver multipartResolver(MultipartResolver resolver) {
            			// 在这里我们可以对原有组件resolver做一些修改之后返回
            			//resolver.setXxx();
            			//resolver.setXxx();
            			//resolver.setXxx();
            			return resolver;
            		}
    3.4自定义器：xxxCustomer
4. 外部化配置
4.1 来源
    @Value("${JAVA_HOME}")可以获取
        properties、yaml、
        environments【系统环境变量如：JAVA_HOME】、
        ApplicationContext.getEnvironments()【系统环境变量、系统信息】、
        命令行中的启动参数
4.2 顺序以及覆盖行为【从上往下，后面的覆盖前面的】
    Default properties (specified by setting SpringApplication.setDefaultProperties).
    
    @PropertySource annotations on your @Configuration classes. Please note that such property sources are not added to the Environment until the application context is being refreshed. This is too late to configure certain properties such as logging.* and spring.main.* which are read before refresh begins.
    
    Config data (such as application.properties files)
    
    A RandomValuePropertySource that has properties only in random.*.
    
    OS environment variables.
    
    Java System properties (System.getProperties()).
    
    JNDI attributes from java:comp/env.
    
    ServletContext init parameters.
    
    ServletConfig init parameters.
    
    Properties from SPRING_APPLICATION_JSON (inline JSON embedded in an environment variable or system property).
    
    Command line arguments.
    
    properties attribute on your tests. Available on @SpringBootTest and the test annotations for testing a particular slice of your application.
    
    @TestPropertySource annotations on your tests.
    
    Devtools global settings properties in the $HOME/.config/spring-boot directory when devtools is active.
4.3 加载properties【yaml】的位置，从下往上覆盖
    The classpath root
    
    The classpath /config package
    
    The current directory
        在打好的jar包中的同级目录新建一个application.propertes,那么这个文件的配置会覆盖前面
    The /config subdirectory in the current directory
        在打好的jar包中的同级目录新建一个/config/application.propertes,那么这个文件的配置会覆盖前面    
    Immediate child directories of the /config subdirectory    
        录新建一个/config/v1/application.propertes,那么这个文件的配置会覆盖前面【Linux下可用】    
4.4 properties【yaml】加载顺序
    Application properties packaged inside your jar (application.properties and YAML variants).
    
    Profile-specific application properties packaged inside your jar (application-{profile}.properties and YAML variants).
    
    Application properties outside of your packaged jar (application.properties and YAML variants).
    引用外部jar会覆盖当前jar
    Profile-specific application properties outside of your packaged jar (application-{profile}.properties and YAML variants).    