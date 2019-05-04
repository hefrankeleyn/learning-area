package config;

import com.hef.spittr.controller.SpittleController;
import com.hef.spittr.jmx.SpittleControllerManagedOperations;
import com.hef.spittr.service.impl.SpittleNotifierImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.assembler.InterfaceBasedMBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MethodExclusionMBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MethodNameBasedMBeanInfoAssembler;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;

import javax.management.MalformedObjectNameException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2019-05-03
 * @Author lifei
 */
@Configuration
public class MBeanConfig {

    /**
     * 在Spring中声明一个 MBeanExporter， 将spittleController bean导出为一个模型MBean
     * @param spittleController
     * @return
     */
    /*@Bean
    public MBeanExporter mBeanExporter(SpittleController spittleController){
        MBeanExporter exporter = new MBeanExporter();
        Map<String, Object> beans = new HashMap<>();
        beans.put("spitter:name=SpittleController", spittleController);
        exporter.setBeans(beans);
        return exporter;
    }*/

    /**
     * 在Spring中声明一个 MBeanExporter， 将spittleController bean导出为一个模型MBean
     * 同时配置 MBeanInfoAssembler , 限制某些方法将在MBean上暴露
     * @param spittleController
     * @return
     */
    @Bean
    public MBeanExporter mBeanExporter(SpittleController spittleController, SpittleNotifierImpl spittleNotifier, MBeanInfoAssembler assembler){
        MBeanExporter exporter = new MBeanExporter();
        Map<String, Object> beans = new HashMap<>();
        beans.put("spittle:name=SpittleController", spittleController);
//        beans.put("spitter:name=SpitterNotifier", spittleNotifier);
        exporter.setBeans(beans);
        exporter.setAssembler(assembler);
        // 处理冲突
        exporter.setRegistrationPolicy(RegistrationPolicy.IGNORE_EXISTING);
        return exporter;
    }

    /**
     * 通过名称暴露方法，限制哪些方法和属性将在MBean上暴露
     * @return
     */
    /*@Bean
    public MethodNameBasedMBeanInfoAssembler assembler(){
        MethodNameBasedMBeanInfoAssembler assembler =
                new MethodNameBasedMBeanInfoAssembler();
        assembler.setManagedMethods(new String[]{
                "getSpittlesPerPage","setSpittlesPerPage"
        });
        return assembler;
    }*/

    /**
     * 与MethodNameBasedMBeanInfoAssembler 相反，指定不暴露的方法
     * @return
     */
    /*@Bean
    public MethodExclusionMBeanInfoAssembler assembler(){
        MethodExclusionMBeanInfoAssembler assembler =
                new MethodExclusionMBeanInfoAssembler();
        assembler.setIgnoredMethods(new String[]{
                "spittles", "findSomeSpittle"
        });
        return assembler;
    }*/

    /**
     * 使用接口管理要暴露的操作和属性
     * @return
     */
    @Bean
    public InterfaceBasedMBeanInfoAssembler assembler(){
        InterfaceBasedMBeanInfoAssembler assembler =
                new InterfaceBasedMBeanInfoAssembler();
        assembler.setManagedInterfaces(new Class<?>[]{SpittleControllerManagedOperations.class});
        return assembler;
    }

    /**
     * 是MBean导为远程对象
     * 最简单的一种方案：
     * @return
     */
    /*@Bean
    public ConnectorServerFactoryBean connectorServerFactoryBean(){
        return new ConnectorServerFactoryBean();
    }*/

    /**
     * 通过RmiRegigstryFactoryBean来启动一个RMI注册表
     * @return
     */
    @Bean
    public RmiRegistryFactoryBean rmiRegistryFactoryBean(){
        RmiRegistryFactoryBean rmiRegistryFactoryBean = new RmiRegistryFactoryBean();
        rmiRegistryFactoryBean.setPort(1199);
        return rmiRegistryFactoryBean;
    }

    /**
     * 是MBean导为远程对象
     * 使用RMI远程访问
     * 将ConnectorServerFactoryBean
     * @return
     */
    @Bean
    public ConnectorServerFactoryBean connectorServerFactoryBean(){
        ConnectorServerFactoryBean connectorServerFactoryBean = new ConnectorServerFactoryBean();
        connectorServerFactoryBean.setServiceUrl("service:jmx:rmi://localhost/jndi/rmi://localhost:1199/spittle");
        /*try {
            connectorServerFactoryBean.setObjectName("connector:name=rmi");
        } catch (MalformedObjectNameException e) {
            throw new RuntimeException(e);
        }*/
        return connectorServerFactoryBean;
    }


}
