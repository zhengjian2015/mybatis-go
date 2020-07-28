package com.example.demo;

import javafx.scene.control.TextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    public TextArea txtBase64;
    public TextArea txtSource;

    @Autowired
    private Base64Service base64Service;

    public void initialize(){
        this.txtSource.textProperty().addListener((observable,oldValue,newValue)->{
            this.txtBase64.setText(parseBase64(newValue));
        });
    }

    private String parseBase64(String s) {
        if(s.length() == 0) {
            return "";
        }
        return this.base64Service.parse(s);
    }
}
