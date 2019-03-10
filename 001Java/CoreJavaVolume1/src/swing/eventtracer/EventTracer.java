package swing.eventtracer;

import java.awt.Component;
import java.awt.Container;
import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * EventTracer
 */
public class EventTracer {

    private InvocationHandler handler;

    public EventTracer(){
        // the handler for all event proxies
        handler = new InvocationHandler(){
        
            @Override
            public Object invoke(Object proxy, Method method, Object[] args){
                System.out.println(method + ":" + args[0]);
                return null;
            }
        };
    }

    public void add(Component c){
        try {
            // get all events to which this component can listen
            BeanInfo info = Introspector.getBeanInfo(c.getClass());

            EventSetDescriptor[] eventSets = info.getEventSetDescriptors();
            for(EventSetDescriptor eventSet: eventSets){
                addListener(c, eventSet);
            }
        } catch (IntrospectionException e) {
            //TODO: handle exception
        }

        if (c instanceof Container){
            for(Component comp: ((Container)c).getComponents()){
                add(comp);
            }
        }
    }

    public void addListener(Component c, EventSetDescriptor eventSet){
        // make proxy object for fthis listener type and route all calls to the handler
        Object proxy = Proxy.newProxyInstance(null, new Class[]{ eventSet.getListenerType()}, handler);

        // add the proxy as a listener to the component
        Method addListenerMethod = eventSet.getAddListenerMethod();
        try {
            addListenerMethod.invoke(c, proxy);
        } catch (ReflectiveOperationException e) {
            //TODO: handle exception
        }
        // ok not to add listener if exception is thrown
    }
}