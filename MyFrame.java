import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame{
    // đây là cái frame để tạo app cho nó nhìn UI UX hơn!


    /*----------------time label----------------- */
    Calendar calendar;
    SimpleDateFormat timeformat;
    JLabel timeLabel;
    String time;
    String text;
    /*--------------------------------------------- */



    /*------------------------day label-------------------------- */
    SimpleDateFormat dayFormat;
    JLabel dayLabel;
    String day;
    MyFrame()
    {
        /* ----------------------Xây dựng frame để nhìn đồng hồ-----------------------------------------------*/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My clock app");
        //this.setLayout(new FlowLayout());
        this.setSize(500,500);
        this.setResizable(false); // khong cho resize
         /* ---------------------------------------------------------------------*/







        /* --------------------------Xây dựng thời gian cho hoàn chỉnh--------------------------------------------------------------------------------------------------------- */
        timeformat = new SimpleDateFormat("hh:mm:ss a"); // biểu diễn thời gian dưới dạng giờ phút giây
        timeLabel = new JLabel(); // class JLabel dùng để in ra màn hình frame cái thời gian mà mình mong muốn.
        // tuy nhiên hiện tại thời gian chỉ dừng lại. chúng ta cần thời gian chạy liên tục

        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        //timeLabel.setVerticalTextPosition(JLabel.TOP);

        // change font of our time
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,25));
        timeLabel.setForeground(new Color(0x00FF00));
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);
        //timeLabel.setBounds(300, 300, 500, 500);
        timeLabel.setBounds(0, 0, 500, 200);
        

        /* ----------------------------------------------------------------------------------------------------------------------------------- */



        

        /*--------------------------- set up day--------------------------- */
        // this thing can phai doc document!
        dayFormat = new SimpleDateFormat("MMMMM dd, EEEE");
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free", Font.BOLD, 15));
        //dayLabel.setText(day);
        dayLabel.setBackground(Color.CYAN);
        dayLabel.setBounds(500, 300, 500, 200);
        dayLabel.setHorizontalTextPosition(JLabel.CENTER);
        this.add(timeLabel);
        this.add(dayLabel);
        this.setVisible(true);
        

        setTime(); 
    }
    public void setTime()
    {
        // hàm settime này để setup thời gian và để nó chạy liên tục
        while(true) // update every second
        {
            time = timeformat.format(Calendar.getInstance().getTime()); // lấy thời gian thực tế ở trên máy tính
            timeLabel.setText(time);
            //System.out.println(time);
            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);
            try
            {
                Thread.sleep(100);// time in milisec
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            
        }
        
    }
}


