package com.dongnao.jack.spring.parse;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author gehaizhen
 * @desc reference 标签解析类
 */
public class ReferenceDefinitionParse implements BeanDefinitionParser {

    /**
     * reference
     */
    private Class<?> classBean;

    public ReferenceDefinitionParse(Class<?> classBean) {
        this.classBean = classBean;
    }

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        // spring 会把classBean进行实例化 beanDefinitionName??
        beanDefinition.setBeanClass(classBean);
        String id = element.getAttribute("id");
        String intf = element.getAttribute("interface");
        String protocol = element.getAttribute("protocol");

        if (id == null || "".equals(id)) {
            throw new RuntimeException("reference id 不能为空！");
        }
        if (intf != null || "".equals(intf)) {
            throw new RuntimeException("reference inteface 不能为空！");
        }
        if (protocol != null || "".equals(protocol)) {
            throw new RuntimeException("reference protocol 不能为空！");
        }

        beanDefinition.getPropertyValues().addPropertyValue("id", id);
        beanDefinition.getPropertyValues().addPropertyValue("intf", intf);
        beanDefinition.getPropertyValues().addPropertyValue("protocol", protocol);
        return beanDefinition;
    }
}
