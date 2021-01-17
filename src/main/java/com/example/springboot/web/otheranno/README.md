前置条件：
    SpringbootApplication类加上注解@ServletComponentScan("com.example.springboot.web.servlet")

servlet组件注入
1.编写类继承HttpServlet，并加入注解@WebServlet(urlPatterns = {"/my"})
2.对应/my的请求交由自己定义的servlet处理【不经过spring拦截器，请看MyFilter】

Filter组件注入
1.编写类实现Filter，并加入注解@WebFilter(urlPatterns = "/my")
2.这样它会默认拦截/my

Listener注入
1.编写类实现ServletContextListener，并加入注解@WebListener

综合注入方法:见包otheranno1
源码分析以后再说