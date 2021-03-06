package com.dongnao.jack.spring.parse;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author gehaizhen
 * @desc protocol标签的解析类
 */
public class ProtocolBeanDefinitionParse implements BeanDefinitionParser {

    /**
     * protocol
     */
    private Class<?> beanClass;

    public ProtocolBeanDefinitionParse(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {

        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        // spring 会把这个beanClass 进行实例化 beanDefinitionName ??
        beanDefinition.setBeanClass(beanClass);
        String name = element.getAttribute("name");
        String host = element.getAttribute("host");
        String port = element.getAttribute("port");

        if (name == null || "".equals(name)) {
            throw new RuntimeException("protocol name 不能为空！");
        }
        if (host == null || "".equals(host)) {
            throw new RuntimeException("protocol host 不能为空！");
        }
        if (port == null || "".equals(port)) {
            throw new RuntimeException("protocol port 不能为空！");
        }
        beanDefinition.getPropertyValues().addPropertyValue("name", name);
        beanDefinition.getPropertyValues().addPropertyValue("host", host);
        beanDefinition.getPropertyValues().addPropertyValue("port", port);
        return beanDefinition;
    }
}
