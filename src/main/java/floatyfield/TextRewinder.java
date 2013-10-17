package floatyfield;

import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class TextRewinder {

    private final Timeline rewinder;
    
    public TextRewinder(final List<StringProperty> strings) {        
        rewinder = new Timeline(new KeyFrame(Duration.millis(10), new RewindHandler(strings)));
        rewinder.setCycleCount(Timeline.INDEFINITE);
    }
    
    public void rewind() {
        rewinder.play();
    }


    private class RewindHandler implements EventHandler<ActionEvent> {
        
        private final List<StringProperty> strings;

        private RewindHandler(List<StringProperty> strings) {
            this.strings = strings;
        }

        public void handle(ActionEvent event) {
            boolean allEmpty = false;
            
            for (StringProperty stringProperty : strings) {
                String text = stringProperty.get();
                int len = text.length();
                if(len > 0) {
                    stringProperty.set(text.substring(0, len - 1));
                    allEmpty = true;
                }
            }
            
            if(allEmpty == false) {
                rewinder.stop();
            }
        }
    }
}
