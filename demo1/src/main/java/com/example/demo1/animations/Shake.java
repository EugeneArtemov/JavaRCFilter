package com.example.demo1.animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node; // любой обьект на нашем окне
import javafx.util.Duration;

public class Shake {
    private TranslateTransition tt;

    public Shake(Node node) {
        tt = new TranslateTransition(Duration.millis(70), node);
        tt.setFromX(0f);
        tt.setByX(10f);
        tt.setCycleCount(3);
        tt.setAutoReverse(true);

    }

    public void playAnim(){
        tt.playFromStart();
    }
}
