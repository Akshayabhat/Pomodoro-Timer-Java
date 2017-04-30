
package pomodoro;

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
    int pomodoroNo; //keeps track of the number of pomodoro intervals completed
    
    public PomodoroTimer() 
    {
        initComponents();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pomodoroTimeLabel = new javax.swing.JLabel();
        shortBreakLabel = new javax.swing.JLabel();
        longBreakLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        timeElapsed = new javax.swing.JLabel();
        pomodoroTime = new javax.swing.JTextField();
        shortBreak = new javax.swing.JTextField();
        longBreak = new javax.swing.JTextField();
        start = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setToolTipText("");

        pomodoroTimeLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        pomodoroTimeLabel.setForeground(new java.awt.Color(204, 0, 0));
        pomodoroTimeLabel.setText("Pomodoro Time: ");

        shortBreakLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        shortBreakLabel.setForeground(new java.awt.Color(204, 0, 51));
        shortBreakLabel.setText("Short Break Time: ");

        longBreakLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        longBreakLabel.setForeground(new java.awt.Color(204, 0, 51));
        longBreakLabel.setText("Long Break Time:");

        jButton1.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        jButton1.setText("Pause");

        jButton2.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        jButton2.setText("Reset");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Timer: ");

        timeElapsed.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        pomodoroTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pomodoroTime.setText("0:25:00");
        pomodoroTime.setAlignmentY(0.6F);
        pomodoroTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pomodoroTimeActionPerformed(evt);
            }
        });

        shortBreak.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        shortBreak.setText("0:05:00");
        shortBreak.setAlignmentY(0.6F);

        longBreak.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        longBreak.setText("0:30:00");
        longBreak.setAlignmentY(0.6F);

        start.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        start.setText("Start");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pomodoroTimeLabel)
                                    .addComponent(longBreakLabel)
                                    .addComponent(shortBreakLabel))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(longBreak, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(shortBreak, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                        .addComponent(pomodoroTime, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(timeElapsed)
                                .addGap(65, 65, 65)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 17, Short.MAX_VALUE)
                        .addComponent(start)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pomodoroTimeLabel)
                    .addComponent(pomodoroTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shortBreakLabel)
                    .addComponent(shortBreak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(longBreakLabel)
                    .addComponent(longBreak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(timeElapsed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(start))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
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
        @Override
        public void run()
            {   
                ++counter;
                setTime(counter);
                if(counter == 25*60 && pomodoroNo < 4) //if less than 4 pomodoros are complete, take a short break
                    {   
                       timer.cancel();
                       JOptionPane.showConfirmDialog(null,"You have completed a pomodoro! Take a short break!", "Break time",JOptionPane.YES_NO_OPTION);
                       shortBreakTimer();
                       pomodoroNo ++;
                    }
           
                else if (counter == 25*60 && pomodoroNo == 4) //if 4 pomodoros are complete, take a long break
                    {
                        timer.cancel();
                        JOptionPane.showConfirmDialog(null,"You have completed 4 pomodoros! Take a long break!", "Break time",JOptionPane.YES_NO_OPTION);
                        longBreakTimer();
                    }
            }},0,1000);
    }

    public void shortBreakTimer() //runs for short-break time
    {   
        timer = new Timer();
        timer.schedule(new TimerTask()  {
        int counter = 0;
        @Override
        public void run()
            {   ++counter;
                setTime(counter);
                if(counter == 5*60) 
                    {  timer.cancel();
                       JOptionPane.showConfirmDialog(null,"Time up!", "Break time",JOptionPane.YES_NO_OPTION);
                       pomodoroTimer();
                    }
            }},0,1000); 
    }
    
    public void longBreakTimer() //runs for long break time
    {
        timer = new Timer();
        timer.schedule(new TimerTask()  {
        int counter = 0;
        @Override
        public void run()
            {  
                ++counter;
                setTime(counter);
                if(counter == 15*60) 
                {   
                    timer.cancel();
                    JOptionPane.showConfirmDialog(null,"Time up!", "Break time",JOptionPane.YES_NO_OPTION);
                    pomodoroNo = 1;
                    pomodoroTimer();
                }
            }},0,1000);
    } 
    
    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
      
       pomodoroTimer();
       pomodoroNo = 1;
   
    }//GEN-LAST:event_startActionPerformed

    private void pomodoroTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pomodoroTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pomodoroTimeActionPerformed

  
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField longBreak;
    private javax.swing.JLabel longBreakLabel;
    private javax.swing.JTextField pomodoroTime;
    private javax.swing.JLabel pomodoroTimeLabel;
    private javax.swing.JTextField shortBreak;
    private javax.swing.JLabel shortBreakLabel;
    private javax.swing.JButton start;
    private javax.swing.JLabel timeElapsed;
    // End of variables declaration//GEN-END:variables
}
