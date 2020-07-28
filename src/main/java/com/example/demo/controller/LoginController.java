package com.example.demo.controller;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

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
 *
 * map马上初始化
 * https://www.cnblogs.com/exmyth/p/8110942.html
 *
 */
@Component
public class LoginController {
    public Button someButton;

    public TextField txtAccount;
    public PasswordField passwordField;

    public Label labelAlert;

    private Map<String, String >  users = new HashMap<String, String>(){{
        put("bob", "bob123");
        put("alice", "alice123");
        put("tom", "tomcat");
    }};

    public void initialize() {
        this.someButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("点击次数 :" + event.getClickCount());
                if (event.getButton().name().equals(MouseButton.PRIMARY.name())) {
                    login();
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


    private void login() {
        System.out.println(txtAccount.getText());
        System.out.println(passwordField.getText());
        String expectedPassword = users.get(txtAccount.getText().toLowerCase());
        if(StringUtils.isEmpty(txtAccount.getText())) {
            labelAlert.setVisible(true);
            return;
        } else {
            labelAlert.setVisible(false);
        }
        if(StringUtils.isEmpty(passwordField.getText())) {
            labelAlert.setText("请输入密码");
            labelAlert.setVisible(true);
            return;
        } else {
            labelAlert.setVisible(false);
        }
        if (expectedPassword != null && expectedPassword.equals(passwordField.getText())) {
            System.out.println("密码正确");
        } else {
            System.out.println("密码错误");
        }
    }
}
