package com.dongnao.jack.spring.parse;

import com.dongnao.jack.configBean.Reference;
import com.dongnao.jack.configBean.Registry;
import com.dongnao.jack.configBean.Service;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import redis.clients.jedis.Protocol;

/**
 * @author gehaizhen
 */
public class SOANamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        this.registerBeanDefinitionParser("registry", new RegistryBeanDefinitionParse(Registry.class));
        this.registerBeanDefinitionParser("Protocol", new ProtocolBeanDefinitionParse(Protocol.class));
        this.registerBeanDefinitionParser("service", new ServiceBeanDefinitionParse(Service.class));
        this.registerBeanDefinitionParser("reference", new ReferenceDefinitionParse(Reference.class));
    }

}
