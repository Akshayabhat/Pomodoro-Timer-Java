
package pomodoro;

import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.util.Duration.millis;
import javax.swing.JOptionPane;

/**
 *
 * @author akshs
 */

public class PomodoroTimer extends javax.swing.JFrame {
    Timer timer;
    int pomodoroNo;
    boolean paused;//keeps track of the number of pomodoro intervals completed
    
    public PomodoroTimer() 
    {   
        initComponents();
        
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pomodoroPanel = new javax.swing.JPanel();
        pomodoroTimeLabel = new javax.swing.JLabel();
        shortBreakLabel = new javax.swing.JLabel();
        longBreakLabel = new javax.swing.JLabel();
        pause = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        timerLabel = new javax.swing.JLabel();
        timeElapsed = new javax.swing.JLabel();
        pomodoroTime = new javax.swing.JTextField();
        shortBreakTime = new javax.swing.JTextField();
        longBreakTime = new javax.swing.JTextField();
        start = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pomodoroPanel.setBackground(new java.awt.Color(204, 204, 204));
        pomodoroPanel.setToolTipText("");

        pomodoroTimeLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        pomodoroTimeLabel.setForeground(new java.awt.Color(204, 0, 0));
        pomodoroTimeLabel.setText("Pomodoro Time: ");

        shortBreakLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        shortBreakLabel.setForeground(new java.awt.Color(204, 0, 51));
        shortBreakLabel.setText("Short Break Time: ");

        longBreakLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        longBreakLabel.setForeground(new java.awt.Color(204, 0, 51));
        longBreakLabel.setText("Long Break Time:");

        pause.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        pause.setText("Pause");
        pause.setDoubleBuffered(true);
        pause.setEnabled(false);
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        reset.setText("Reset");
        reset.setEnabled(false);
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        timerLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        timerLabel.setText("Timer: ");

        timeElapsed.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        timeElapsed.setText("0:00:00");

        pomodoroTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pomodoroTime.setText("0:25:00");
        pomodoroTime.setAlignmentY(0.6F);
        pomodoroTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pomodoroTimeActionPerformed(evt);
            }
        });

        shortBreakTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        shortBreakTime.setText("0:05:00");
        shortBreakTime.setAlignmentY(0.6F);

        longBreakTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        longBreakTime.setText("0:30:00");
        longBreakTime.setAlignmentY(0.6F);

        start.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        start.setText("Start");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pomodoroPanelLayout = new javax.swing.GroupLayout(pomodoroPanel);
        pomodoroPanel.setLayout(pomodoroPanelLayout);
        pomodoroPanelLayout.setHorizontalGroup(
            pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pomodoroPanelLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pomodoroPanelLayout.createSequentialGroup()
                        .addGroup(pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pomodoroPanelLayout.createSequentialGroup()
                                .addGroup(pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pomodoroTimeLabel)
                                    .addComponent(longBreakLabel)
                                    .addComponent(shortBreakLabel))
                                .addGap(30, 30, 30)
                                .addGroup(pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(longBreakTime, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(shortBreakTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                        .addComponent(pomodoroTime, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addGroup(pomodoroPanelLayout.createSequentialGroup()
                                .addComponent(timerLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timeElapsed)
                                .addGap(60, 60, 60)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pomodoroPanelLayout.createSequentialGroup()
                        .addGap(0, 17, Short.MAX_VALUE)
                        .addComponent(start)
                        .addGap(18, 18, 18)
                        .addComponent(pause)
                        .addGap(18, 18, 18)
                        .addComponent(reset)
                        .addGap(25, 25, 25))))
        );
        pomodoroPanelLayout.setVerticalGroup(
            pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pomodoroPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pomodoroTimeLabel)
                    .addComponent(pomodoroTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shortBreakLabel)
                    .addComponent(shortBreakTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(longBreakLabel)
                    .addComponent(longBreakTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timerLabel)
                    .addComponent(timeElapsed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset)
                    .addComponent(pause)
                    .addComponent(start))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(pomodoroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(pomodoroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void setTime(int time) //function to display timer
    {   
            
            long timeNow = 1000*time;
            long second = (timeNow / 1000) % 60;
            long minute = (timeNow / (1000 * 60)) % 60;
            long hour = (timeNow / (1000 * 60 * 60)) % 24;
            timeElapsed.setText(String.format("%02d:%02d:%02d", hour, minute, second));
    }
    public void pomodoroTimer() //runs for pomodoro time
    {  
        timer = new Timer();
        timer.schedule(new TimerTask()  {
        int counter = 0;
        String [] customTime = pomodoroTime.getText().split(":");
        int counterLimit = Integer.parseInt(customTime[0])*60*60 + Integer.parseInt(customTime[1])*60+
                 Integer.parseInt(customTime[2]);
        
        @Override
        public void run()
            {   
                if(!paused)
                { 
                ++counter;
                setTime(counter);
                if(counter == counterLimit && pomodoroNo < 4) //if less than 4 pomodoros are complete, take a short break
                    {   
                       timer.cancel();
                       Toolkit.getDefaultToolkit().beep();
                       JOptionPane.showMessageDialog(null,"You have completed a pomodoro! Take a short break!");
                       shortBreakTimer();
                       pomodoroNo ++;
                    }
           
                else if (counter == counterLimit && pomodoroNo == 4) //if 4 pomodoros are complete, take a long break
                    {
                        timer.cancel();
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null,"You have completed 4 pomodoros! Take a long break!");
                        longBreakTimer();
                    }
                }   }},0,1000);
            
    }

    public void shortBreakTimer() //runs for short-break time
    {   
        timer = new Timer();
        timer.schedule(new TimerTask()  {
        int counter = 0;
        String [] customTime = shortBreakTime.getText().split(":");
        int counterLimit = Integer.parseInt(customTime[0])*60*60 + Integer.parseInt(customTime[1])*60+
                 Integer.parseInt(customTime[2]);
       
        @Override
        public void run()
            {   
                if (!paused)
                {
                ++counter;
                setTime(counter);
                if(counter == counterLimit) 
                    {  timer.cancel();
                       Toolkit.getDefaultToolkit().beep();
                       JOptionPane.showMessageDialog(null,"Time up! Resume work.");
                       pomodoroTimer();
                       
                    }
                }}},0,1000); 
    }
    
    public void longBreakTimer() //runs for long break time
    {
        timer = new Timer();
        timer.schedule(new TimerTask()  {
        int counter = 0;
        String [] customTime = longBreakTime.getText().split(":");
        int counterLimit = Integer.parseInt(customTime[0])*60*60 + Integer.parseInt(customTime[1])*60+
                 Integer.parseInt(customTime[2]);
        @Override
        public void run()
            {  
               if(!paused)
               {
                ++counter;
                setTime(counter);
                if(counter == counterLimit) 
                {   
                    timer.cancel();
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null,"Time up! Resume work.");
                    pomodoroNo = 1;
                    pomodoroTimer();
                }
               }}},0,1000);
    } 
    
    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
       pause.setEnabled(true);
       reset.setEnabled(true);
       pomodoroTimer();
       pomodoroNo = 1;
       paused = false;
   
    }//GEN-LAST:event_startActionPerformed

    private void pomodoroTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pomodoroTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pomodoroTimeActionPerformed

    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseActionPerformed
      
        if(!paused)
        {
            paused = true;
            pause.setText("Unpause");
            reset.setEnabled(false);
        }
     
        else
        {
            paused = false;
            pause.setText("Pause");
            reset.setEnabled(true);
        }
    }//GEN-LAST:event_pauseActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
    
        timer.cancel();
        timeElapsed.setText("00:00:00");
        pause.setEnabled(false);
        reset.setEnabled(false);
        
    }//GEN-LAST:event_resetActionPerformed

  
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PomodoroTimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PomodoroTimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PomodoroTimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PomodoroTimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PomodoroTimer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel longBreakLabel;
    private javax.swing.JTextField longBreakTime;
    private javax.swing.JButton pause;
    private javax.swing.JPanel pomodoroPanel;
    private javax.swing.JTextField pomodoroTime;
    private javax.swing.JLabel pomodoroTimeLabel;
    private javax.swing.JButton reset;
    private javax.swing.JLabel shortBreakLabel;
    private javax.swing.JTextField shortBreakTime;
    private javax.swing.JButton start;
    private javax.swing.JLabel timeElapsed;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables
}
