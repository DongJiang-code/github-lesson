package com.dongnao.jack.spring.parse;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author gehaizhen
 */
public class ServiceBeanDefinitionParse implements BeanDefinitionParser {

    /**
     * service
     */
    private Class<?> classBean;

    public ServiceBeanDefinitionParse(Class<?> classBean) {
        this.classBean = classBean;
    }


    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {

        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(classBean);
        String intf = element.getAttribute("interface");
        String ref = element.getAttribute("ref");
        String protocol = element.getAttribute("protocol");
        if (intf == null || "".equals(intf)) {
            throw new RuntimeException("service interface 不能为空！");
        }
        if (ref == null || "".equals(ref)) {
            throw new RuntimeException("service ref 不能为空！");
        }
        if (protocol == null || "".equals(protocol)) {
            throw new RuntimeException("service protocol 不能为空！");
        }
        beanDefinition.getPropertyValues().addPropertyValue("interface", intf);
        beanDefinition.getPropertyValues().addPropertyValue("ref", ref);
        beanDefinition.getPropertyValues().addPropertyValue("protocol", protocol);
        return beanDefinition;
    }
}
