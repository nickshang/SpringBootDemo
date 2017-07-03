package com.shang.springboot.readinglist.support;

import com.shang.springboot.readinglist.entity.Reader;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 自定义解析器-自定义解析器实现请求参数绑定方法参数
 */
@Component
public class ReaderHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return Reader.class.isAssignableFrom(parameter.getParameterType());
  }

  @Override
  public Object resolveArgument(MethodParameter parameter,
      ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
      WebDataBinderFactory binderFactory) throws Exception {

    Authentication auth = (Authentication) webRequest.getUserPrincipal();
    return auth != null && auth.getPrincipal() instanceof Reader ? auth.getPrincipal() : null;
    
  }

}
