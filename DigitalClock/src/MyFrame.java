import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame
{
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;


    MyFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock WTF");
        this.setLayout(new FlowLayout());
        this.setSize(500,200);
        this.setResizable(false);

        timeFormat = new SimpleDateFormat("HH:mm:ss");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
        timeLabel.setForeground(Color.RED);
        //timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);

        time=timeFormat.format(Calendar.getInstance().getTime());
        timeLabel.setText(time);

        dayLabel= new JLabel();
        dayLabel.setFont(new Font("dayFont",Font.HANGING_BASELINE, 30));
        dayLabel.setForeground(Color.blue);
        dayLabel.setOpaque(true);

        day = timeFormat.format(Calendar.getInstance().getFirstDayOfWeek());

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Date font",Font.ITALIC,50));
        dateLabel.setForeground(Color.MAGENTA);
        dateLabel.setBackground(Color.CYAN);

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        setTime();
    }


    private void setTime() {
        while (true)
        {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);
            day =  dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);
            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
