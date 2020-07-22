package com.example.demo.controller;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import org.springframework.stereotype.Component;

/**
 * https://www.it1352.com/548089.html
 *
 * http://www.itkeyword.com/doc/9122387463444846703/ui-javafx
 *
 *
 * javascript
 * https://blog.csdn.net/pengpeng2395/article/details/7920968
 *
 * https://blog.csdn.net/cdc_csdn/article/details/80710001
 */
@Component
public class LoginController {
    public Button someButton;

    public void initialize() {
        this.someButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("点击次数 :" + event.getClickCount());
                if (event.getButton().name().equals(MouseButton.PRIMARY.name())) {
                    System.out.println("左键 ");
                }
                if (event.getButton().name().equals(MouseButton.SECONDARY.name())) {
                    System.out.println("右键 ");
                }
                if (event.getButton().name().equals(MouseButton.MIDDLE.name())) {
                    System.out.println("滑轮键按下 ");
                }
            }
        });
    }
}
