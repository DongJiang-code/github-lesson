package com.dongnao.jack.spring.parse;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author gehaizhen
 */
public class RegistryBeanDefinitionParse implements BeanDefinitionParser {

    /**
     * registry
     */
    private Class<?> beanClass;

    public RegistryBeanDefinitionParse(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        // spring 会把这个beanClass进行实力化 BeanDefinitionName??
        beanDefinition.setBeanClass(beanClass);
        String protocol = element.getAttribute("protocol");
        String address = element.getAttribute("address");

        if (protocol == null || "".equals(protocol)) {
            throw new RuntimeException("registry protocol 不能为空！");
        }
        if (address == null || "".equals(address)) {
            throw new RuntimeException("registry address 不能为空！");
        }
        beanDefinition.getPropertyValues().addPropertyValue("protocol", protocol);
        beanDefinition.getPropertyValues().addPropertyValue("address", address);
        return beanDefinition;
    }
}
