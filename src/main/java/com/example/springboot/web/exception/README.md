异常处理流程
1.DispatcherServlet-》doDispatch(request, response);
    -》HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler()); 
    //执行目标方法，目标方法执行期间发生任何异常都会被捕获
    //catch (Exception ex) { dispatchException = ex; }并标志当前请求结束
        —》processDispatchResult(processedRequest, response, mappedHandler, mv, dispatchException);//视图解析流程
            -》mv = processHandlerException(request, response, handler, exception);// 如果不是视图解析异常，那么执行这个handler处理异常
                -》 遍历for (HandlerExceptionResolver resolver : this.handlerExceptionResolvers) //所有异常handler，看那个异常处理器能解析异常，
                    -》exMv = resolver.resolveException(request, response, handler, ex);//能解析的话mv被赋值之后返回
                    //1.第一个异常解析器：DefaultErrorAttributes将异常保存到request
                    //2.第二个handlerExceptionResolverComposite，是一个数组，
                    //包含三个：ExceptionHandlerExceptionResolver【 @ExceptionHandler】,ResponseStatusExceptionResolver,DefaultHandlerExceptionResolver                
                        -》都没法解决的话，抛出异常【springboot默认抛出异常】，并主动发起"/error"请求【BasicErrorController处理】
                            —》 BasicErrorController 中遍历所有ErrorViewResolver来解析【默认DefaultErrorViewResolver】
                            
                  