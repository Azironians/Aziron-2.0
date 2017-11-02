package Main;

import javafx.scene.text.Text;
import javax.swing.Timer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Clock {
    public static Timer launchTimer(Text textOutput){
         Timer ClockTimer = new javax.swing.Timer(500, e -> {
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.dd.MM");
            Text text = new Text();
            text.setText(sdf.format(d));
            DateFormat df = new SimpleDateFormat("HH:mm");
            Date times = Calendar.getInstance().getTime();
            String reportDate = df.format(times);
            textOutput.setText(reportDate); // FXML Text не позволяет сделать класс Clock static
        });
        return ClockTimer;
    }
}
