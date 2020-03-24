package com.trining.design.observer.mouseevent;


import com.trining.design.observer.mouseevent.handler.Mouse;
import com.trining.design.observer.mouseevent.handler.MouseEventLisenter;
import com.trining.design.observer.mouseevent.handler.MouseEventType;

public class Test {
    public static void main(String[] args) {
        MouseEventLisenter lisenter = new MouseEventLisenter();

        Mouse mouse = new Mouse();
        mouse.addLisenter(MouseEventType.ON_CLICK,lisenter);
        mouse.addLisenter(MouseEventType.ON_MOVE,lisenter);

        mouse.click();
        mouse.move();
    }
}
