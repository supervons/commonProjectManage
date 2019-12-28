package com.supervons.cpj.Interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.supervons.cpj.entity.LoggerInfos;
import com.supervons.cpj.repository.LoggerInfosRepository;
import com.supervons.cpj.srcurity.JWTUtil;
import com.supervons.cpj.tools.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 拦截器类
 * Interceptor
 * 20181227 by supervons
 */
@Component
public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    private LoggerInfosRepository loggerInfosRepository;

    /**
     * 预处理回调方法，实现处理器的预处理
     * 返回值：true表示继续流程；false表示流程中断，不会继续调用其他的拦截器或处理器
     * Pre-processing callback method to achieve processor pre-processing
     * Return value: true means to continue the process; false means the process is interrupted
     * and will not continue to call other interceptors or processors
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        if(!url.contains("/user/loginAction") && !url.contains("/user/addUser") && !url.contains("swagger") && !url.contains("/images/")){
            String jwtToken = request.getHeader("jwtToken")==null?"":request.getHeader("jwtToken").toString();
            if(!JWTUtil.getAppUID(jwtToken)){
                throw new Exception("非法请求！");
            }
        }
        //请求日志存储
        LoggerInfos loggerInfos = new LoggerInfos();
        String paramData = JSON.toJSONString(request.getParameterMap(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);
        loggerInfos.setLoggerClientIp(request.getRemoteHost());
        loggerInfos.setLoggerParamDate(paramData);
        loggerInfos.setLoggerMethod(request.getMethod());
        loggerInfos.setLoggerUri(request.getRequestURI());
        loggerInfos.setLoggerTime(DateUtils.getStandardTime());
        loggerInfos.setLoggerHttpStatusCode(response.getStatus() + "");
        loggerInfosRepository.saveAndFlush(loggerInfos);
        //业务代码
        return true;
    }

    /**
     * 后处理回调方法，实现处理器（controller）的后处理，但在渲染视图之前
     * 此时我们可以通过modelAndView对模型数据进行处理或对视图进行处理
     * Post-processing callback methods to implement post-processing of the controller, but before rendering the view
     * At this point we can process the model data or process the view through modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }
    /**
     * 整个请求处理完毕回调方法，即在视图渲染完毕时回调，
     * 如性能监控中我们可以在此记录结束时间并输出消耗时间，
     * 还可以进行一些资源清理，类似于try-catch-finally中的finally，
     * 但仅调用处理器执行链中
     * The entire request processing callback method, that is, the callback when the view is rendered,
     * In performance monitoring, we can record the end time and output the consumption time.
     * Some resource cleanups can also be done, similar to finally in try-catch-finally.
     * but only call the processor in the execution chain
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }
}
