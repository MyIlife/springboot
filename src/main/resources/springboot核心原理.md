1.springboot启动过程
    1.创建new SpringApplication(primarySources).run(args);
        去所有spring.factories中寻找所有的Bootstrapper、ApplicationContextInitializer、ApplicationListener
        并赋值给SpringApplication
        this.bootstrappers = new ArrayList<>(getSpringFactoriesInstances(Bootstrapper.class));
        this.initializers = new ArrayList<>(initializers);
        this.listeners = new ArrayList<>(listeners);
    2.运行new SpringApplication(primarySources).run(args);
        2.1 SpringApplicationRunListeners listeners = getRunListeners(args);
           	listeners.starting(bootstrapContext, this.mainApplicationClass); 
            获取所有的SpringApplicationRunListener【实现了这个接口的类】,并调用starting()方法，意味着我们的项目正在启动
        2.2 ConfigurableEnvironment environment = prepareEnvironment(listeners, bootstrapContext, applicationArguments);
            配置环境相关的一些参数，并通知SpringApplicationRunListener—》listener.environmentPrepared(bootstrapContext, environment));
            意味着项目环境准备完成
        2.3 prepareContext(bootstrapContext, context, environment, listeners, applicationArguments, printedBanner);
            准备容器，同时
            1）、遍历所有的this.initializers【ApplicationContextInitializer】调用initialize,表示容器初始化前的一些扩展
            2）、遍历所有listeners【SpringApplicationRunListener】，调用contextPrepared表示监听到容器创建就绪
            3）、load(context, sources.toArray(new Object[0]));加载上下文
            4）、调用listeners.contextLoaded(context);【SpringApplicationRunListener】通知容器上下文加载成
     3.刷新容器refreshContext(context);//底层调用spring的容器刷新refresh();
     4.afterRefresh(context, applicationArguments);
     5.listeners.started(context);【SpringApplicationRunListener】 通知项目已经成功启动
     6.获取容器中所有的runners【ApplicationRunner、CommandLineRunner，包含一些参数信息】，并调用run方法
     7.listeners.running(context);【SpringApplicationRunListener】 通知项目已经正常运行
     8.handleRunFailure(context, ex, null);—》listeners.failed(context, exception);
        全局异常捕获，如果出现异常那么调用所有listeners.failed(context, exception);通知容器启动失败  
            
            