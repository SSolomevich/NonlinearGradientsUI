package nonlineargradientsui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Main frame of the application
 * 
 * @author Luminita Moruz
 */

public class MainFrame extends javax.swing.JFrame implements ActionListener {

    /**
     * Constructor 
     */
    public MainFrame() {
        this.setTitle("Gradient Optimizer");
        this.typePanel = new GradientTypePanel(this);
        this.insilicoPanel = new InsilicoDistributionPanel();
        this.ms1Panel = new MS1DistributionPanel();
        this.customPanel = new CustomDistributionPanel();
        this.optionsPanel = new GradientOptionsPanel();
        this.optionsPanel.setDefaultValues("", "", "", "", "", "1.0", 
                "1", "", "", "\t");
        this.optionsPanel.setDefaultValues("10", "250", "2", "40", "6.2", "1.0", 
                "1", "", "", "\t");
        
        c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        c1.weighty = 0;
        c1.weightx = 0;
        
        c2 = new GridBagConstraints();
        c2.gridx = 0;
        c2.gridy = 1;
        c2.anchor = GridBagConstraints.WEST;
        c2.weighty = 0;
        c2.weightx = 0;
        
        c3 = new GridBagConstraints();     
        c3.gridx = 0;
        c3.gridy = 2;
        c3.weighty = 0;
        c3.weightx = 0;
        
        this.calculateGradientButton = new javax.swing.JButton();
        this.calculateGradientButton.setText("Calculate gradient");
        this.calculateGradientButton.setActionCommand("CalculateGradient");
        this.calculateGradientButton.addActionListener(this);
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel tmp = new JPanel();
        tmp.add(calculateGradientButton);
        tmp.setVisible(true);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weighty = 0;
        gbc.weightx = 0;
        
        panelFiller = new JPanel();
        GridBagConstraints c4 = new GridBagConstraints();     
        c4.gridx = 0;
        c4.gridy = 4;
        c4.weighty = 1;
        
        initComponents();
        this.setPreferredSize(new Dimension(600, 730));
        this.add(this.typePanel, c1);   
        this.add(this.insilicoPanel, c2);
        this.add(optionsPanel, c3); 
        this.add(tmp, gbc);    
        this.add(panelFiller, c4); 
        
        this.gradientCalculator = new GradientCalculator();
        this.linearGradient = new GradientFunction();
        this.resultWindow = new ResultWindow();
        this.mzResultWindow = new MzResultWindow();

        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0};
        layout.rowHeights = new int[] {0};
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeResultsWindows() {
        if (this.resultWindow.isVisible()) {
            this.resultWindow.setVisible(false);
        }
        if (this.mzResultWindow.isVisible()) {
            this.mzResultWindow.setVisible(false);
        }         
    }
    
    /**
     * Display the given panel in the main frame
     * @param panel panel to be displayed 
     */
    private void displayCustomPanel(JPanel panel) {
        if (this.insilicoPanel.isDisplayable()) {
            this.remove(this.insilicoPanel);
            this.insilicoPanel.resetRTs();        
        }
        if (this.ms1Panel.isDisplayable()) {
            this.remove(this.ms1Panel);
            this.ms1Panel.resetRTs();
        }
        if (this.customPanel.isDisplayable()) {
            this.remove(this.customPanel);
            this.customPanel.resetRTs();
        }
        closeResultsWindows();
        this.add(panel, c2);
        this.validate();
        this.repaint();
    }
    
    /**
     * Get the retention times that are to be optimized 
     * @return a list of retention times 
     * @throws ValidationException 
     */
    private List<Float> getRT() throws ValidationException {
        if (this.customPanel.isDisplayable()) {
           return this.customPanel.getRT();
        } 
        if (this.ms1Panel.isDisplayable()) {
           return this.ms1Panel.getRT();
        } 
        return this.insilicoPanel.getRT();    
    }
    
    /**
     * Perform data validations for the linear gradient; raise an exception if 
     * an error is found. 
     * 
     * @param startTime start time of linear gradient 
     * @param endTime end time of linear gradient 
     * @param startB start %B of linear gradient 
     * @param endB end %B of linear gradient 
     * @param timeStep the time step when calculating the optimized gradient 
     * @param decimals number of decimals for %B
     * @throws ValidationException 
     */
    private void checkLinearGradientOptions(Float startTime, Float endTime, 
            Float startB, Float endB, Float timeStep, int decimals) throws ValidationException {
        if (startTime >= endTime) {
            String message = "The linear's gradient start time needs to be "
                    + "lower that its end time. ";
            throw new ValidationException(message, "BAD_PARAMETERS");
        }                
        if (startB >= endB) {
            String message = "The linear's gradient start %B needs to be "
                   + "lower that its end %B. ";
            throw new ValidationException(message, "BAD_PARAMETERS");
        }                
        if (timeStep <= 0) {
            String message = "The time step needs to be a positive number. ";
            throw new ValidationException(message, "BAD_PARAMETERS");
        }
        if (decimals < 0) {
            String message = "The number of decimals needs to be a positibe integer. ";
            throw new ValidationException(message, "BAD_PARAMETERS");
        }        
    }
    
    /**
     * Function that makes sure the appropriate panel is displayed according to the 
     * type of gradient selected. Also, it calculates the optimized gradient 
     * when the user chooses so. 
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        // handles the event when the user select a different gradient 
        if (action.equals("Custom"))  {
            displayCustomPanel(this.customPanel);            
        }         
        if (action.equals("MS1")) {
            displayCustomPanel(this.ms1Panel);
        }        
        if (action.equals("Insilico")) {
            displayCustomPanel(this.insilicoPanel);
        }
        // handles the event when the user chooses to calculate the optimized gradient
        if (action.equals("CalculateGradient")) {
            try {
                // get the retention time from the corresponding panel 
                List<Float> rts = this.getRT(); 
                if (rts.isEmpty()) {
                    return;
                }
                // get the user options 
                Float startTime = this.optionsPanel.getStartGradientTime();
                Float endTime = this.optionsPanel.getEndGradientTime();
                Float startB = this.optionsPanel.getStartB();
                Float endB = this.optionsPanel.getEndB();
                Float lagTime = this.optionsPanel.getLagTime();
                Float timeStep = this.optionsPanel.getTimeStep();
                int decimals = this.optionsPanel.getDecimals();
                // check that the values make sense
                checkLinearGradientOptions(startTime, endTime, startB, endB, timeStep,
                        decimals);               
                // get the information about how to display the optimized gradient 
                String before = this.optionsPanel.getBefore();
                String after = this.optionsPanel.getAfter();
                String separator = this.optionsPanel.getSeparator();                
                
                        
                // initialize the GradientCalculator object 
                List<Float> linRT = new ArrayList<>();
                linRT.add(startTime);
                linRT.add(endTime);
                List<Float> linB = new ArrayList<>();
                linB.add(startB);
                linB.add(endB);        
                this.linearGradient.setVariables(linRT, linB);
                this.gradientCalculator.setVariables(this.linearGradient, lagTime, rts, 
                timeStep);
        
                // calculate the optimized gradient
                GradientFunction optimized_gradient = this.gradientCalculator.computeOptimizedGradient();
                if (optimized_gradient == null) {
                    String message = "Error when calculation the optimized gradient. " + 
                            "This usually happens if you have a small gradient step," +
                            " and few retention times to optimize. \n Please " + 
                            " try to adjust these values and try again.";
                    throw new ValidationException(message, "BAD_PARAMETERS");
                }
                
                // display the result
                int nTimeDecimals;
                String[] splitter = this.optionsPanel.getStringTimeStep().split("\\.");           
                if (splitter.length == 1) {
                    nTimeDecimals = 0;
                } else {
                    nTimeDecimals = splitter[1].length();
                }                 
                this.resultWindow.setVariables(optimized_gradient, linearGradient, 
                        decimals, before, separator, after, nTimeDecimals);                
                if (!this.resultWindow.isVisible()) {
                    this.resultWindow.setLocationRelativeTo(this);        
                    this.resultWindow.setVisible(true);
                }
                
                // run the DIA m/z optimization 
                if (this.ms1Panel.isDisplayable() && this.ms1Panel.mzOptimization()) {
                    runDiaOptimization(lagTime, linearGradient, optimized_gradient,
                            nTimeDecimals);
                }
            } 
            catch (ValidationException ve) {
                System.out.println("ValidationException");
                JOptionPane.showMessageDialog(this, ve.getMessage(), "ERROR", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }   

    /**
     * Optimize DIA windows 
     * @param lagTime - difference between LC times and raw file times
     * @param linGradient - the linear gradient used to generated the data
     * @param optGradient - the optimized gradient 
     * @param nTimeDecimals - number of time decimals
     */
    public void runDiaOptimization(float lagTime, GradientFunction linGradient, 
            GradientFunction optGradient, int nTimeDecimals) {                       
        try {
            // get the input data 
            int nTimePoints = this.ms1Panel.getDiaNTimePoints();
            int nMzWindows = this.ms1Panel.getDiaNMzWindows();
            double minMz = this.ms1Panel.getDiaMinMz();
            double maxMz = this.ms1Panel.getDiaMaxMz();
            List<NFeaturesRT> rtDistrib = this.ms1Panel.getRtDistrib();
            
            // very simple validations of the input data 
            if (rtDistrib.isEmpty()) {
                throw new ValidationException("No MS1-features were loaded, no"
                        + " m/z optimization can be carried out.", "BAD_INPUT");
            } 
            if (minMz >= maxMz) {
                throw new ValidationException("The minimum m/z must be smaller than the "
                        + "maximum m/z for DIA m/z optimization", "BAD_INPUT");
            
            }
           
            // Calculate the optimized m/z windows 
            System.out.println(GeneralUtilities.NEWLINE + 
                    "Running optimization of DIA windows ");        
            MzOptimizer mzOpt = new MzOptimizer(lagTime, linGradient, optGradient, 
                    nTimePoints, nMzWindows, minMz, maxMz, rtDistrib); 
            List<RtMzWindows> result = mzOpt.getOptimizedMzWindows();
            
            // display the result
            this.mzResultWindow.setVariables(result, nTimeDecimals);
            if (!this.mzResultWindow.isVisible()) {
                //this.mzResultWindow.setLocationRelativeTo(this);       
                this.mzResultWindow.setVisible(true);
            }           
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", 
                        JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    JPanel panelFiller;
    // the panel for the retention time distribution to be optimized 
    GradientTypePanel typePanel;
    // the three types of panels
    InsilicoDistributionPanel insilicoPanel;
    CustomDistributionPanel customPanel;
    MS1DistributionPanel ms1Panel;
    // the panel storing the options of the linear and optimized gradient 
    GradientOptionsPanel optionsPanel;
    // constraints used for the three panels included in this window
    GridBagConstraints c1, c2, c3;
    javax.swing.JButton calculateGradientButton;
    // results windows 
    ResultWindow resultWindow;
    MzResultWindow mzResultWindow;
    // gradient functions 
    GradientFunction linearGradient;
    GradientCalculator gradientCalculator;
}
