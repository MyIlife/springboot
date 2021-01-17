**1.拦截器使用** 

`1.自定义拦截器实现HandlerInterceptor实现拦截方法` 

`2.定义配置类实现WebMvcConfigurer并将拦截器加入进去`

**2.拦截器原理**
1.DispatcherServlet-》doDispatch(request,response)
    ->getHandler() //包含能处理的处理器handler和interceptorList
        ->执行拦截器方法mappedHandler.applyPreHandle(processedRequest, response))
            -> 循环遍历拦截器，顺序执行interceptor.preHandle(request, response, this.handler)
            //如果拦截器的方法返回true就执行下一个拦截器
            //如果拦截器的方法返回为false，那么倒序执行拦截器的interceptor.afterCompletion(request, response, this.handler, ex);方法
                ->如果拦截器放行的话，执行目标方法mv = ha.handle(processedRequest, response, mappedHandler.getHandler());\
                    ->倒序执行拦截器的postHandle方法：mappedHandler.applyPostHandle(processedRequest, response, mv);
                        ->无论前面的处理是否异常都会处理triggerAfterCompletion(processedRequest, response, mappedHandler, ex);
                            ->即倒序执行interceptor.afterCompletion(request, response, this.handler, ex);