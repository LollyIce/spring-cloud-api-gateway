/*
package com.apigateway.filter;

import com.apigateway.constant.RedisConstant;
import com.apigateway.utils.CookieUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpServerConnection;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.net.HttpCookie;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

*/
/***
 * 权限拦截
 * 区分买家和卖家
 *//*

@Component
public class AuthFilter extends ZuulFilter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1 ;
    }

    @Override
    public boolean shouldFilter() {
        return true;

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        */
/***
         *  /order/create 只能买家访问(cookie里只有openid)
         *  /order/finish 只能卖家访问(cookie里只有token,并且redis中有对应的值)
         *  /product/list 都可访问
         *//*

        if("/order/order/create".equals(request.getRequestURI())){
            Cookie openid = CookieUtil.get(request, "openid");
            if(openid == null || StringUtils.isEmpty(openid.getValue())){
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            }
        }

        if("/order/order/finish".equals(request.getRequestURI())){
            Cookie token = CookieUtil.get(request, "token");
            if(token == null || StringUtils.isEmpty(token.getValue())
                             || StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE,token.getValue())))){
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            }
        }

        return null;
    }
}
*/
