package com.wfei.daliy.core.event;

import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by feiwen on 2018/4/20.
 */
@Component
public class EventListenerMangerImpl implements EventListenerManger {
    //这里集合使用map集合可以将观察者进行分类，不同类别，同时拥有几个观察者
    private static Map<MyEventEnum, Vector<MyEventListener>> eventListeners=new EnumMap<MyEventEnum, Vector<MyEventListener>>(MyEventEnum.class);

    @Override
    public void registerListener(MyEventEnum myEventEnum,MyEventListener e) {
        Vector<MyEventListener> listeners=eventListeners.get(myEventEnum);
        if(listeners==null){
            listeners=new Vector<>();
        }else{
            for (MyEventListener listener:listeners){
                if(listener.getClass()==e.getClass()){
                    return;
                }
            }
        }
        listeners.add(e);
        eventListeners.put(myEventEnum,listeners);
    }


    @Override
    public void removeListener(MyEventEnum myEventEnum,MyEventListener e) {
        Vector<MyEventListener> listeners=eventListeners.get(myEventEnum);
        if(listeners!=null){
            listeners.remove(e);
        }
    }

    @Override
    public void fireEvent(MyEventEnum myEventEnum) {
        Vector<MyEventListener> listeners=eventListeners.get(myEventEnum);
        if(listeners!=null){
            for(MyEventListener listener:listeners){
                listener.fire();
            }
        }
    }
}
