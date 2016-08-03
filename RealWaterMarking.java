/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watermarking;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
 
/**
 *
 * @author NOFN3
 */

public class RealWaterMarking extends javax.swing.JFrame {

   

String Des,Sor;
    /**
     * Creates new form RealWaterMarking
     */
 public void addTextWatermark(String text, File sourceImageFile, File destImageFile) throws IOException{
 try 
 {
 BufferedImage sourceImage = ImageIO.read(sourceImageFile); 
 Graphics2D g2d = (Graphics2D) sourceImage.getGraphics(); 
 // initializes necessary graphic properties
 AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);
 g2d.setComposite(alphaChannel); 
 g2d.setColor(Color.RED);
 g2d.setFont(new Font("Arial", Font.ITALIC, 40));
 FontMetrics fontMetrics = g2d.getFontMetrics();
 Rectangle2D rect = (fontMetrics.getStringBounds(text, g2d)); // calculates the coordinate where the String is painted 
 int centerX = (int) ((int)(sourceImage.getWidth() - (int) rect.getWidth())*0.95);
 int centerY = (int) ((sourceImage.getHeight())*0.95) ; // paints the textual watermark 
 g2d.drawString(text, centerX, centerY); 

 JFrame parentFrame = new JFrame();
 JFileChooser fileChooser = new JFileChooser();
 fileChooser.setDialogTitle("Specify a file to save");

        FileFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
        fileChooser.addChoosableFileFilter(filter);
        filter= new FileNameExtensionFilter("PNG file", "png", "png");    
        fileChooser.addChoosableFileFilter(filter);
        filter=new FileNameExtensionFilter("GIF file","gif","gif");
        fileChooser.addChoosableFileFilter(filter); 

int userSelection = fileChooser.showSaveDialog(parentFrame);
// if(userSelection == JFileChooser.APPROVE_OPTION) {
{   File fileToSave = fileChooser.getSelectedFile();
    System.out.println("Save as file: " + fileToSave.getAbsolutePath()) ; 
    
    Des=fileToSave.getAbsolutePath();
    ImageIO.write(sourceImage, "png", fileToSave); 
    g2d.dispose();
    System.out.println("The text watermark is added to the image."); 
    JOptionPane.showMessageDialog(frame,"The text watermark is added to the image."); 
    
    OutputImageFrame(Sor,Des);
   
    
}
}
catch(IOException ex) 
{ 
     JOptionPane.showMessageDialog(frame,ex,"Error",JOptionPane.ERROR_MESSAGE);
     System.err.println(ex); 
}
 
   
}   
   
 /** * Embeds an image watermark over a source image to produce a watermarked * one. * * @param watermarkImageFile * The image file used as the watermark. * @param sourceImageFile * The source image file. * @param destImageFile * The output image file. */ 

  public void addImageWatermark(File watermarkImageFile, File sourceImageFile, File destImageFile)
 { 
  try
 {
 BufferedImage sourceImage = ImageIO.read(sourceImageFile); 
 BufferedImage watermarkImage = ImageIO.read(watermarkImageFile);
 // initializes necessary graphic properties 
 Graphics2D g2d = (Graphics2D) sourceImage.getGraphics(); 
 AlphaComposite alphaChannel = AlphaComposite.getInstance( AlphaComposite.SRC_OVER, 0.3f); 
 g2d.setComposite(alphaChannel);
 // calculates the coordinate where the image is painted 
 int topLeftX = (int) ((sourceImage.getWidth() - watermarkImage.getWidth())*0.95) ; 
 int topLeftY = (int) ((sourceImage.getHeight() - watermarkImage .getHeight())*0.95);
 // paints the image watermark
 g2d.drawImage(watermarkImage, topLeftX, topLeftY, null); 
 
 JFrame parentFrame = new JFrame();
 JFileChooser fileChooser = new JFileChooser();
 fileChooser.setDialogTitle("Specify a file to save");    
 
        FileFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
        fileChooser.addChoosableFileFilter(filter);
        filter= new FileNameExtensionFilter("PNG file", "png", "png");    
        fileChooser.addChoosableFileFilter(filter);
        filter=new FileNameExtensionFilter("GIF file","gif","gif");
        fileChooser.addChoosableFileFilter(filter); 
 
 int userSelection = fileChooser.showSaveDialog(parentFrame);
// if(userSelection == JFileChooser.APPROVE_OPTION) {
   File fileToSave = fileChooser.getSelectedFile();
   System.out.println("Save as file: " + fileToSave.getAbsolutePath()) ; 
   Des=fileToSave.getAbsolutePath();
  ImageIO.write(sourceImage, "png", fileToSave); 
 g2d.dispose();
 System.out.println("The image watermark is added to the image.");
 JOptionPane.showMessageDialog(frame,"The Image watermark is added to the image.");
  
 OutputImageFrame(Sor,Des);
 } 
catch (IOException ex) { 
System.err.println(ex); 
 JOptionPane.showMessageDialog(frame,ex,"Error",JOptionPane.ERROR_MESSAGE);
} 
} 
    private Component frame;
    public RealWaterMarking() {
        
        initComponents();
   //   jLabel6.setVisible(false);
        jLabel9.setVisible(false);
        AllToolTip_Defination(); 
        Editable_text();
        Select_RadioBution();
        Insert.setVisible(false);
        Extract.setVisible(false);
        setIcon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jFrame1 = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jFrame2 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollBar1 = new javax.swing.JScrollBar();
        jPanelContainer = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        Insert = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jTextField3 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        backButtonInsert = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        Extract = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jCheckBox2 = new javax.swing.JCheckBox();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        backButtonExtract = new javax.swing.JButton();

        jFrame1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jFrame1.setMinimumSize(new java.awt.Dimension(2147483647, 2147483647));
        jFrame1.setType(java.awt.Window.Type.POPUP);
        jFrame1.getContentPane().setLayout(new java.awt.FlowLayout());
        jFrame1.getContentPane().add(jLabel3);
        jFrame1.getContentPane().add(jLabel7);

        jFrame2.setLocation(new java.awt.Point(0, 0));
        jFrame2.setMaximumSize(new java.awt.Dimension(590, 410));
        jFrame2.setResizable(false);
        jFrame2.setSize(new java.awt.Dimension(590, 410));
        jFrame2.setType(java.awt.Window.Type.POPUP);
        jFrame2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jFrame2.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jScrollPane2.setToolTipText("");

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(5);
        jTextArea2.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setText("Instructions for use the Software :\n\n1.     First of all Choose your choice to insert or extract a Visible or Invisible\n       Watermark by selecting Radio button.\n2.    After that press button weather you want to Insert or Extract watermark.\n3.    If you choose invisible insertion option a new window is  opened write \n       text you want to watermarked after that choose  Original  image  than \n        press Embed button then save your Watermarked image into the appr-\n       opriate location.\n4.   If you choose invisible extraction option a new window is opened select\n     watermarked image in which you  want to  Extract  message  and  press \n     decode button to Extract message.\n5.  If you choose Visible Watermark option you only can insert water mark\n     when you press insert button new window is opened then choose source\n     image and select watermark can be image or  text  select  radio  button\n     accordingly then when you press insert button watermark is embeded on\n      your image which can be visible.    \n");
        jTextArea2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextArea2.setMaximumSize(new java.awt.Dimension(575, 400));
        jTextArea2.setMinimumSize(new java.awt.Dimension(575, 400));
        jScrollPane2.setViewportView(jTextArea2);

        jFrame2.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 410));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setToolTipText("");
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 153));
        jLabel1.setText("WaterMarking Project");
        Menu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 400, 66));

        jButton1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jButton1.setText("EXTRACT  WATERMARK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Menu.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 230, 60));

        jButton3.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jButton3.setText("INSERT  WATERMARK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Menu.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 230, 60));

        jButton2.setFont(new java.awt.Font("Times New Roman", 2, 11)); // NOI18N
        jButton2.setText("Help");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Menu.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 110, 30));

        buttonGroup4.add(jRadioButton8);
        jRadioButton8.setText("Invisible Watermark");
        jRadioButton8.setToolTipText("");
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });
        Menu.add(jRadioButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, -1));

        buttonGroup4.add(jRadioButton9);
        jRadioButton9.setText("Visible Watermark");
        jRadioButton9.setToolTipText("");
        jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton9ActionPerformed(evt);
            }
        });
        Menu.add(jRadioButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, -1));

        jPanelContainer.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 470));

        Insert.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel2.setText("IMAGE INFO");
        Insert.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 120, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("SOURCE IMAGE :");
        Insert.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 120, 30));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        Insert.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 220, 30));

        jButton4.setText("Browse...");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        Insert.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 90, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("WATERMARK TEXT / IMAGE");
        Insert.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 200, 60));

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Text");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        Insert.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("Image");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });
        Insert.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 93, -1));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        Insert.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 253, 450, 30));

        jButton5.setText("Browse...");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        Insert.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 253, 90, -1));

        jButton6.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jButton6.setText("INSERT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        Insert.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 210, 60));

        jToolBar2.setRollover(true);

        backButtonInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/watermarking/images.png"))); // NOI18N
        backButtonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonInsertActionPerformed(evt);
            }
        });
        jToolBar2.add(backButtonInsert);

        Insert.add(jToolBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 30));
        Insert.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 740, 240));
        Insert.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 740, 80));

        jPanelContainer.add(Insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 470));

        Extract.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("WaterMark Image(or Path) :");
        Extract.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 160, 30));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        Extract.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 200, 30));

        jButton7.setText("Browse...");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        Extract.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 90, -1));

        jCheckBox2.setText("Key(Optional)");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        Extract.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 100, -1));

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });
        Extract.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 90, 30));

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("N.B.:Key should be Numeric");
        Extract.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 150, 20));

        buttonGroup3.add(jRadioButton6);
        jRadioButton6.setText("Text");
        Extract.add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, 30));

        buttonGroup3.add(jRadioButton7);
        jRadioButton7.setText("Image");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });
        Extract.add(jRadioButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 93, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("WaterMark Image(or Path) :");
        Extract.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 160, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Watermark Text");
        Extract.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 160, 30));

        jButton8.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jButton8.setText("EXTRACT");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        Extract.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 170, 60));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Watermark Type");
        Extract.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 160, 30));

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        Extract.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 470, 40));

        jToolBar1.setRollover(true);

        backButtonExtract.setText("BACK");
        backButtonExtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonExtractActionPerformed(evt);
            }
        });
        jToolBar1.add(backButtonExtract);

        Extract.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, 50));

        jPanelContainer.add(Extract, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanelContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 460));

        setSize(new java.awt.Dimension(751, 509));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param S
     * @param D
     */
    public void OutputImageFrame(String D,String S){
   ImageIcon image1;
   
   ImageIcon image2;
    jLabel3 =null;
    jLabel7= null;
   
    BufferedImage img = null;
try {
    img = ImageIO.read(new File(S));
} catch (IOException e) {
System.out.print("Error");
}
{  try{
    
    
    image1=new ImageIcon(img); 
    jLabel3=new JLabel(image1);
 
  
  }
  catch (Exception ex){}
BufferedImage img1 = null;
try {
    img1 = ImageIO.read(new File(D));
} catch (IOException e) {
System.out.print("Error");
}
  image2=new ImageIcon(img1); 
   jLabel7=new JLabel(image2);
    jFrame1.getContentPane().add(jLabel7);
     jFrame1.getContentPane().add(jLabel3);
     jFrame1.setVisible(true);
  }
        
        
      
    
        
        
    }
    
    private void AllToolTip_Defination()
    {   String k="Insert Watermark on image";
        jButton6.setToolTipText(k);
        k="Extract Watermark From image";
        jButton8.setToolTipText(k);
        k="Insert Watermark on image";
        jButton3.setToolTipText(k);
        k="Extract Watermark From image";
        jButton1.setToolTipText(k);
        k="Information about Software";
        jButton2.setToolTipText(k);    
        k="Back to Menu";
        backButtonExtract.setToolTipText(k);
        backButtonInsert.setToolTipText(k);
   }
    private void Editable_text() {
        jTextField6.setEditable(false);
        jTextField6.setBackground(Color.WHITE);
        if(jCheckBox2.isSelected())
     {
         jTextField6.setEditable(true);
     }
        
        
      
    } 
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if(jRadioButton9.isSelected())
      {Menu.setVisible(false);
        Extract.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    if(jRadioButton8.isSelected())
    {
      DecodeMessage d;
          d = new DecodeMessage();
    }
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       if(jRadioButton9.isSelected()) 
       {  Insert.setVisible(true);
        Menu.setVisible(false);
       }
       if(jRadioButton8.isSelected())
       {
        EmbedMessage e;  
           e = new EmbedMessage();
       }
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
jFrame2.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         JFileChooser chooser=new JFileChooser(new File("h:\\"));
         chooser.setDialogTitle("Open a file");
         
         FileFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
         chooser.addChoosableFileFilter(filter);
         filter= new FileNameExtensionFilter("PNG file", "png", "png");    
         chooser.addChoosableFileFilter(filter);
         filter=new FileNameExtensionFilter("GIF file","gif","gif");
         chooser.addChoosableFileFilter(filter);      
         chooser.showOpenDialog(null);
        
         File f=chooser.getSelectedFile();
         String filename=f.getAbsolutePath();
         jTextField1.setText(filename);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JFileChooser chooser=new JFileChooser();
        
        chooser.setDialogTitle("Open a file");
               
        FileFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
        chooser.addChoosableFileFilter(filter);
        filter= new FileNameExtensionFilter("PNG file", "png", "png");    
        chooser.addChoosableFileFilter(filter);
        filter=new FileNameExtensionFilter("GIF file","gif","gif");
        chooser.addChoosableFileFilter(filter); 
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();
        String filename=f.getAbsolutePath();
        jTextField3.setText(filename);        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        JFileChooser chooser=new JFileChooser();
       
        chooser.setDialogTitle("Open a file");
               
        FileFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
        chooser.addChoosableFileFilter(filter);
        filter= new FileNameExtensionFilter("PNG file", "png", "png");    
        chooser.addChoosableFileFilter(filter);
        filter=new FileNameExtensionFilter("GIF file","gif","gif");
        chooser.addChoosableFileFilter(filter); 
        
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();
        String filename=f.getAbsolutePath();
        jTextField5.setText(filename);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
       
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
     
     
        
        Reset_AllTextField();  
// TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      if(jRadioButton4.isSelected())
      {
          
              String src=jTextField1.getText();
              Sor=src;
              String dsti="demo";
              String txt=jTextField3.getText();
              File sourceImageFile = new File(src);
              File destImageFile = new File(dsti);
           try {
               addTextWatermark(txt, sourceImageFile, destImageFile);
              //  JOptionPane.showMessageDialog(frame,"The text watermark is added to the image.");
          } catch (IOException ex) {
              Logger.getLogger(RealWaterMarking.class.getName()).log(Level.SEVERE, null, ex);
          }
         
         
    }//GEN-LAST:event_jButton6ActionPerformed
    if(jRadioButton5.isSelected())
     {
           String src=jTextField1.getText();
          Sor=src;
           String dsti="demo";
          String txt=jTextField3.getText();
          File sourceImageFile = new File(src); 
          File destImageFile = new File(dsti);       
          File watermarkImageFile= new File(txt);
          addImageWatermark(watermarkImageFile, sourceImageFile, destImageFile);
         
    }
        Reset_AllTextField();
    }
    private void backButtonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonInsertActionPerformed
    
        Insert.setVisible(false);
        Extract.setVisible(false);
        Menu.setVisible(true);
    }//GEN-LAST:event_backButtonInsertActionPerformed

    private void backButtonExtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonExtractActionPerformed
         Insert.setVisible(false);
        Extract.setVisible(false);
        Menu.setVisible(true);    
    }//GEN-LAST:event_backButtonExtractActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
      Editable_text();
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
    char c=evt.getKeyChar();
    if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
         getToolkit().beep();
         jLabel9.setVisible(true);
         evt.consume();
     }
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
      jButton5.setEnabled(false);
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
      jButton5.setEnabled(true);
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void jRadioButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton9ActionPerformed
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jRadioButton9ActionPerformed
    private void Reset_AllTextField()
    {
     jTextField1.setText("");
     jTextField3.setText("");
//     jTextField4.setText("");
     jTextField5.setText("");
     jTextField6.setText("");
     jTextField7.setText("");
     }
    private void Select_RadioBution()
    {
     
        jRadioButton4.setSelected(true);
        jRadioButton8.setSelected(true);
        jRadioButton6.setSelected(true);
        jButton5.setEnabled(false);
    }
    public static void main(String args[]) { 
          
        try {
        // Set System L&F
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException e) {
       System.out.println("Unsupported LookAndFeel Exception.");
    }
    catch (ClassNotFoundException e) {
       System.out.println("Class Not Found Exception.");
    }
    catch (InstantiationException e) {
       System.out.println("Instantiation Exception.");
    }
    catch (IllegalAccessException e) {
       System.out.println("IllegalAccess Exception.");
    } 
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealWaterMarking().setVisible(true);
       
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Extract;
    private javax.swing.JPanel Insert;
    private javax.swing.JPanel Menu;
    private javax.swing.JButton backButtonExtract;
    private javax.swing.JButton backButtonInsert;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelContainer;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Watermark.jpg")));
    }
}
