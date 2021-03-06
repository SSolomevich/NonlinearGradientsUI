package nonlineargradientsui;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.text.DecimalFormat;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * The result window displaying the optimized gradient
 *
 * @author Luminita Moruz
 */
public class ResultWindow extends javax.swing.JFrame {

    /**
     * Creates new form ResultWindow
     */
    public ResultWindow() {
        initVariables();
        initComponents();
        this.fileChooser = new JFileChooser();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gradientTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        imagePanel = new GradientFigure(this.linearGradient, this.optRTs, this.optBs);

        setTitle("Optimized gradient");
        setResizable(false);

        jButton1.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        gradientTextArea.setColumns(20);
        gradientTextArea.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        gradientTextArea.setRows(5);
        jScrollPane1.setViewportView(gradientTextArea);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel1.setText("Optimized gradient");

        jButton2.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jButton2.setText("Save gradient");
        jButton2.setActionCommand("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        imagePanel.setBackground(new java.awt.Color(255, 255, 255));
        imagePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imagePanel.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(315, 315, 315)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(280, 280, 280)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Initialization of the variables to default values
     */
    private void initVariables() {
        this.gradientFunction = new GradientFunction();
        this.textBeforeTime = null;
        this.textAfterB = null;
        this.separator = null;
        this.decimals = null;
        this.linearGradient = new GradientFunction();
        this.nTimeDecimals = 0;
        this.optBs = new ArrayList<>();
        this.optRTs = new ArrayList<>();
    }

    /**
     * Initialization of member variables
     *
     * @param gf optimized gradient
     * @param lg linear gradient
     * @param decimals number of decimals to display the %B
     * @param tBeforeTime string to be displayed before the retention time
     * @param sep string to be used as separator between retention times and %B
     * @param tAfterB string to be displayed after the %B
     * @param nTimeDecimals number of decimals when displaying retention times
     */
    public void setVariables(GradientFunction gf, GradientFunction lg, Integer decimals,
            String tBeforeTime, String sep, String tAfterB, int nTimeDecimals) {
        this.gradientFunction.setVariables(gf.getLcTimes(), gf.getPercB());
        this.linearGradient.setVariables(lg.getLcTimes(), lg.getPercB());
        this.decimals = decimals;
        this.textBeforeTime = tBeforeTime;
        this.separator = sep;
        this.textAfterB = tAfterB;
        this.nTimeDecimals = nTimeDecimals;
        initTextArea();
        this.imagePanel.repaint();
    }

    /**
     * Initialize the text area with the optimized gradient
     */
    private void initTextArea() {
        List<Float> times = this.gradientFunction.getLcTimes();
        List<Float> bs = this.gradientFunction.getPercB();
        List<String> text = new ArrayList<String>();
        String newline = System.getProperty("line.separator");
        char[] chars = new char[this.decimals];
        Arrays.fill(chars, '0');
        DecimalFormat df = new DecimalFormat("#." + new String(chars));
        char[] charsTime = new char[this.nTimeDecimals];
        Arrays.fill(charsTime, '0');
        DecimalFormat dfTime = new DecimalFormat("#." + new String(charsTime));
        Float tmp;
        String line;
        String b, prevB = "";

        this.optBs.clear();
        this.optRTs.clear();

        if (times.size() != bs.size()) {
            text.add("Error when calculating the optimzed gradient.");
        } else {
            text.add("Time(LC-time)\t%B" + newline);
            for (int i = 0; i < times.size(); ++i) {
                b = df.format(bs.get(i));
                if (this.decimals == 0) {
                    b = "" + Math.round(bs.get(i));
                }
                if (!b.equals(prevB)) {
                    tmp = times.get(i);
                    line = this.textBeforeTime + dfTime.format(tmp) + this.separator
                            + b + this.textAfterB + newline;
                    this.optBs.add(Float.parseFloat(b));
                    this.optRTs.add(tmp);

                    text.add(line);
                }
                prevB = b;
            }
        }

        this.gradientTextArea.setText(concatenateArrayList(text));
    }

    /**
     * Concatenate an list of strings as one string
     *
     * @param al list of strings to be concatenated
     * @return string obtained by concatenating the list
     */
    public static String concatenateArrayList(List<String> al) {
        String ret = "";
        for (String l : al) {
            ret += l;
        }
        return ret;
    }

    /**
     * When the user presses the close button, the window is made invisible
     *
     * @param evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        //System.out.println(this.gradientFunction);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Write the content of the text area to a file
     *
     * @param f File where to write the content of the text area
     * @return 0 if successful, 1 otherwise
     */
    private int writeToFile(File f) {
        FileWriter fileHandler;

        try {
            fileHandler = new FileWriter(f);
            String lines = this.gradientTextArea.getText();
            fileHandler.write(lines);
            fileHandler.close();
        } catch (IOException e) {
            return 1;
        }
        return 0;
    }

    /**
     * Function to handle the event when the user chooses to save the gradient
     * to an output file
     *
     * @param evt
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int returnVal = this.fileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File path = fileChooser.getSelectedFile();
            if (path.exists() && !path.isDirectory()) {
                int n = JOptionPane.showConfirmDialog(this, "File exists, are you sure you want "
                        + "to overwrite?", "Overwrite", JOptionPane.YES_NO_OPTION);
                if (n != JOptionPane.YES_OPTION) {
                    return;
                }
            }
            int ret = this.writeToFile(path);
            if (ret != 0) {
                JOptionPane.showMessageDialog(this, "ERROR: could not write to "
                        + path.getName() + ". Please make sure you have write permissions "
                        + "and that you provided a valid filename, then try again.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Gradient saved successfully to "
                        + path.getName(), "SAVED", JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            System.out.println("Save command cancelled by user.\n");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ResultWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultWindow().setVisible(true);
            }
        });
    }

    // the nonlinear gradient 
    GradientFunction gradientFunction;
    GradientFunction linearGradient;
    // the rts and the %b 
    List<Float> optRTs;
    List<Float> optBs;
    // output preferences 
    int nTimeDecimals;
    String textBeforeTime;
    String separator;
    String textAfterB;
    Integer decimals;
    final JFileChooser fileChooser;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JTextArea gradientTextArea;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
