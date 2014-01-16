package nonlineargradientsui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

/**
 * Class representing the panel corresponding to the custom distribution
 * 
 * @author Luminita Moruz
 */

public class CustomDistributionPanel extends javax.swing.JPanel implements RTPanel {

    /**
     * Constructor
     */
    public CustomDistributionPanel() {
        initComponents();
        this.fileChooser = new JFileChooser();
        this.inputFieldsChanged = true;
        this.rtTextArea.getDocument().addDocumentListener(new TextFieldListener(this));
        this.rtFileTextfield.getDocument().addDocumentListener(new TextFieldListener(this));      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rtTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        uploadButton = new javax.swing.JButton();
        rtFileTextfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Retention times to optimize"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        setMaximumSize(new java.awt.Dimension(570, 255));
        setMinimumSize(new java.awt.Dimension(570, 255));
        setPreferredSize(new java.awt.Dimension(570, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Retention times to optimize", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N
        jPanel2.setMaximumSize(new java.awt.Dimension(560, 240));
        jPanel2.setMinimumSize(new java.awt.Dimension(560, 240));
        jPanel2.setPreferredSize(new java.awt.Dimension(560, 240));

        rtTextArea.setColumns(20);
        rtTextArea.setRows(5);
        jScrollPane1.setViewportView(rtTextArea);

        jLabel1.setText("Paste the retention times to be optimized");

        uploadButton.setText("Upload file");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        rtFileTextfield.setText("/scratch/lumi_work/projects/gradient_design/GUI/NonlinearGradientsUI/data/custom/rts-identified-peptides.txt");

        jLabel2.setText("or");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(50, 50, 50)
                                .addComponent(uploadButton))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(rtFileTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uploadButton)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rtFileTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        int returnVal = this.fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            this.rtFileTextfield.setText(fileChooser.getSelectedFile().getAbsolutePath());
        } else {
            System.out.println("Open command cancelled by user.\n");
        }
    }//GEN-LAST:event_uploadButtonActionPerformed
    
    /**
     * Load the retention times from the text area 
     * @param text
     * @return text written by the user in the text area
     * @throws ValidationException 
     */
    private List<Float> getRetentionTimes(String text) throws ValidationException {
        List<Float> rts = new ArrayList<Float>();
        String separator = System.getProperty("line.separator");
               
        String[] lines = text.split(separator);        
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                try {        
                    rts.add(Float.parseFloat(line));
                } 
                catch (NumberFormatException e) {   
                    String message = "\"" + line + "\" cannot be parsed as a value\n"; 
                    throw new ValidationException(message, "BAD_NUMBER");
                }
            }
        }
        return rts;
    }
    
    /**
     * Load the retention times to be optimized from a file
     * @param filename name of the filename
     * @return list of retention times 
     * @throws ValidationException 
     */
    private List<Float> getRetentionTimesFile(String filename) throws ValidationException {
        List<Float> rts = new ArrayList<Float>();
        Float rt;        
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                i += 1;
                if (!line.isEmpty() && !line.startsWith("#")) {
                    try {
                         rt = Float.parseFloat(line);
                         rts.add(rt);			   
                    }
                    catch (NumberFormatException e) {
                        String message = "\"" + line + "\" at line " + i + 
                                " in " + filename + " cannot be parsed as a value\n"; 
                        throw new ValidationException(message, "BAD_NUMBER");
                     }			   
		 }
            }
            br.close();
        }
        catch (IOException e) {
            String message = "Could not load " + filename;
            throw new ValidationException(message, "BAD_FILENAME");
        }                
        return rts;
    }
    
    /**
     * Get the retention time distribution from the text area or the given file
     * @return List of retention times 
     * @throws ValidationException 
     */
    @Override
    public List<Float> getRT() throws ValidationException {
        List<Float> rts;      
        
        // try to get the rts from the text area
        String text = rtTextArea.getText().trim();       
        if (!text.isEmpty()) {
            rts = getRetentionTimes(text);
        } else {
            // try to load the rts from the file
            String filename = this.rtFileTextfield.getText().trim();
            if (filename.trim().isEmpty()) {
                String message = "No retention time distribution was specified";
                throw new ValidationException(message, "NO_RTS");
            }
            rts = getRetentionTimesFile(filename);
        }        
        // throw an exception if no retention times were found 
        if (rts.isEmpty()) {
            throw new ValidationException("No retention times were loaded. Please make sure that the "
                    + "text area/input file includes valid retention times.", "UNKNOWN_ERROR");
        }
        
        this.inputFieldsChanged = false;
        return rts; 
    }
    
    @Override
    public void setInputFieldsChanged(boolean b) {
        this.inputFieldsChanged = b;
    }    
    
    /**
     * Reset the retention time and flag that the input data has changed 
     */
    @Override
    public void resetRTs() {        
        this.inputFieldsChanged = true;      
    }
    
    /* whether the text fields were changed (and thus the rt distrib need to be 
    recalculated) */
    boolean inputFieldsChanged;
    /* used to choose a file from the disk*/
    final JFileChooser fileChooser;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField rtFileTextfield;
    private javax.swing.JTextArea rtTextArea;
    private javax.swing.JButton uploadButton;
    // End of variables declaration//GEN-END:variables
}
