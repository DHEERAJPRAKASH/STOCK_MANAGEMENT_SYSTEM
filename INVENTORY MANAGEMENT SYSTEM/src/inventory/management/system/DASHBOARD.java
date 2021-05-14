/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.management.system;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
 import javax.swing.JPanel;  

/**
 *
 * @author DHEERAJ PRAKASH . S
 */
public final class DASHBOARD extends javax.swing.JFrame {

    /**
     * Creates new form DASHBOARD
     */
    
    public DASHBOARD() {
        this.con = DBCONNECTION.connect();
        initComponents();
        
        
        this.pack();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        
        showdate();
        showtime();
        DBCONNECTION.connect();
        ClientLoadData();
        ProductLoadData();
        PosAddMouse();
        
      
    }
    Connection con;
    PreparedStatement pst,pst1,pst2 = null;
    ResultSet rs,rs1,rs2;
    DefaultTableModel df;

    void showdate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        DATESHOW.setText(s.format(d));
    }

    void showtime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                TIMESHOW.setText(s.format(d));

            }

        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DASHBOARD_PANEL = new javax.swing.JPanel();
        DASHBOARD = new javax.swing.JLabel();
        TAB1 = new javax.swing.JPanel();
        CLIENT = new javax.swing.JLabel();
        TAB2 = new javax.swing.JPanel();
        PRODUCTS = new javax.swing.JLabel();
        TAB3 = new javax.swing.JPanel();
        POS = new javax.swing.JLabel();
        TAB4 = new javax.swing.JPanel();
        EXIT = new javax.swing.JLabel();
        COMPANY_NAME = new javax.swing.JLabel();
        TAB5 = new javax.swing.JPanel();
        REPORTS = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TITLE = new javax.swing.JPanel();
        KARISHMA = new javax.swing.JLabel();
        DATE = new javax.swing.JLabel();
        DATESHOW = new javax.swing.JLabel();
        TIME = new javax.swing.JLabel();
        TIMESHOW = new javax.swing.JLabel();
        CONTAINER_PANEL = new javax.swing.JPanel();
        JP3 = new javax.swing.JPanel();
        ROUND_INPUT = new javax.swing.JTextField();
        ROUND_LABEL = new javax.swing.JLabel();
        POINT_OF_SALES = new javax.swing.JLabel();
        POS_PRODUCT_ID = new javax.swing.JLabel();
        POS_PRODUCT_ID_PANEL = new javax.swing.JPanel();
        POS_PRODUCT_ID_TEXT_FIELD = new javax.swing.JTextField();
        POS_PRODUCT_NAME = new javax.swing.JLabel();
        POS_PRODUCT_NAME_PANEL = new javax.swing.JPanel();
        POS_PRODUCT_NAME_TEXT_FIELD = new javax.swing.JTextField();
        POS_RATE = new javax.swing.JLabel();
        POS_RATE_PANEL = new javax.swing.JPanel();
        POS_RATE_TEXT_FIELD = new javax.swing.JTextField();
        QTY = new javax.swing.JLabel();
        QTY_PANEL = new javax.swing.JPanel();
        QTY_TEXT_FIELD = new javax.swing.JTextField();
        POS_CLIENT_NAME = new javax.swing.JLabel();
        POS_CLIENT_NAME_PANEL = new javax.swing.JPanel();
        POS_CLIENT_NAME_TEXT_FIELD = new javax.swing.JTextField();
        POS_SCROLLPANE = new javax.swing.JScrollPane();
        POS_TABLE = new javax.swing.JTable();
        POS_BUTTONS_CONTAINER_PANEL = new javax.swing.JPanel();
        ADD_ITEM_PANEL = new javax.swing.JPanel();
        ADD_ITEM = new javax.swing.JLabel();
        REMOVE_ITEM_PANEL = new javax.swing.JPanel();
        REMOVE_ITEM = new javax.swing.JLabel();
        SAVE_PANEL = new javax.swing.JPanel();
        SAVE = new javax.swing.JLabel();
        PRINT_PANEL = new javax.swing.JPanel();
        PRINT = new javax.swing.JLabel();
        CLEAR_PANEL = new javax.swing.JPanel();
        CLEAR = new javax.swing.JLabel();
        CLEAR_ALL_PANEL = new javax.swing.JPanel();
        CLEAR_ALL = new javax.swing.JLabel();
        UOM = new javax.swing.JLabel();
        UOM_PANEL = new javax.swing.JPanel();
        UOM_COMBO_BOX = new javax.swing.JComboBox<>();
        TOTAL = new javax.swing.JLabel();
        POS_TOTAL_PANEL = new javax.swing.JPanel();
        POS_TOTAL_TEXT_FIELD = new javax.swing.JTextField();
        CGST_TOTAL = new javax.swing.JLabel();
        CGST_TOTAL_TEXT_FIELD = new javax.swing.JTextField();
        SGST_TOTAL = new javax.swing.JLabel();
        SGST_TOTAL_TEXT_FIELD = new javax.swing.JTextField();
        TAX_VALUE = new javax.swing.JLabel();
        TAX_VALUE_TEXT_FIELD = new javax.swing.JTextField();
        TOTAL_QTY = new javax.swing.JLabel();
        INVOICE_NO = new javax.swing.JLabel();
        INVOICE_DATE = new javax.swing.JLabel();
        DATE_CHOOSER = new com.toedter.calendar.JDateChooser();
        CLIENT_NAME_REFERENCE = new javax.swing.JLabel();
        CLIENT_NAME_REFERENCE_INPUT = new javax.swing.JLabel();
        POS_CLIENT_ADDRESS = new javax.swing.JLabel();
        POS_CLIENT_ADDRESS_INPUT = new javax.swing.JLabel();
        POS_GSTIN = new javax.swing.JLabel();
        POS_GSTIN_INPUT = new javax.swing.JLabel();
        QTY_IN_STOCK = new javax.swing.JLabel();
        QTY_IN_STOCK_INPUT = new javax.swing.JLabel();
        AMT_IN_WORDS_INPUT = new javax.swing.JLabel();
        AMT_IN_WORDS_INPUT_TEXT_FIELD = new javax.swing.JTextField();
        INVOICE_NO_INPUT_PANEL = new javax.swing.JPanel();
        INVOICE_NO_TEXT_FIELD = new javax.swing.JTextField();
        TOTAL_QTY_PANEL = new javax.swing.JPanel();
        TOTAL_QTY_TEXT_FIELD = new javax.swing.JTextField();
        CANCEL_BILL_PANEL = new javax.swing.JPanel();
        CANCEL_BILL = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JP1 = new javax.swing.JPanel();
        CLIENT_DETAILS = new javax.swing.JLabel();
        CLIENT_NAME = new javax.swing.JLabel();
        CLIENT_SHOPNAME_PANEL = new javax.swing.JPanel();
        CLIENT_SHOPNAME_TEXT_FIELD = new javax.swing.JTextField();
        CLIENT_ADDRESS = new javax.swing.JLabel();
        CLIENT_ADDRESS_PANEL = new javax.swing.JPanel();
        CLIENT_ADDRESS_SCROLLPANE = new javax.swing.JScrollPane();
        CLIENT_ADDRESS_TEXT_FIELD = new javax.swing.JTextArea();
        GSTIN = new javax.swing.JLabel();
        GSTIN_PANEL = new javax.swing.JPanel();
        GSTIN_TEXT_FIELD = new javax.swing.JTextField();
        CLIENT_PHONE_NO = new javax.swing.JLabel();
        CLIENT_PHONE_NO_PANEL = new javax.swing.JPanel();
        CLIENT_PHONE_NO_TEXT_FIELD = new javax.swing.JTextField();
        CLIENT_DISTRICT = new javax.swing.JLabel();
        CLIENT_DISTRICT_PANEL = new javax.swing.JPanel();
        CLIENT_DISTRICT_TEXT_FIELD = new javax.swing.JTextField();
        CLIENT_STATE = new javax.swing.JLabel();
        CLIENT_STATE_PANEL = new javax.swing.JPanel();
        CLIENT_STATE_TEXT_FIELD = new javax.swing.JTextField();
        BUTTONS_CONTAINER_PANEL = new javax.swing.JPanel();
        ADD_PANEL = new javax.swing.JPanel();
        ADD = new javax.swing.JLabel();
        EDIT_PANEL = new javax.swing.JPanel();
        EDIT = new javax.swing.JLabel();
        DELETE_PANEL = new javax.swing.JPanel();
        DELETE = new javax.swing.JLabel();
        CANCEL_PANEL = new javax.swing.JPanel();
        CANCEL = new javax.swing.JLabel();
        CLIENT_DETAILS_SCROLLPANE = new javax.swing.JScrollPane();
        CLIENT_DETAILS_TABLE = new javax.swing.JTable();
        CLIENT_ID_PANEL = new javax.swing.JPanel();
        CLIENT_ID_TEXT_FIELD = new javax.swing.JTextField();
        CLIENT_ID = new javax.swing.JLabel();
        CLIENT_DETAILS_PRINT_DATA_PANEL = new javax.swing.JPanel();
        CLIENT_DETAILS_PRINT_DATA = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JP2 = new javax.swing.JPanel();
        PRODUCT_DETAILS = new javax.swing.JLabel();
        PRODUCT = new javax.swing.JLabel();
        NAME = new javax.swing.JLabel();
        PRODUCT_NAME_PANEL = new javax.swing.JPanel();
        PRODUCT_NAME_TEXT_FIELD = new javax.swing.JTextField();
        PRODUCT_BRAND = new javax.swing.JLabel();
        PRODUCT_BRAND_PANEL = new javax.swing.JPanel();
        PRODUCT_BRAND_TEXT_FIELD = new javax.swing.JTextField();
        HSN_CODE = new javax.swing.JLabel();
        HSN_CODE_PANEL = new javax.swing.JPanel();
        HSN_CODE_TEXT_FIELD = new javax.swing.JTextField();
        PRODUCT_RATE = new javax.swing.JLabel();
        PRODUCT_RATE_PANEL = new javax.swing.JPanel();
        PRODUCT_RATE_TEXT_FIELD = new javax.swing.JTextField();
        PRODUCT_CGST = new javax.swing.JLabel();
        PRODUCT_CGST_PANEL = new javax.swing.JPanel();
        PRODUCT_CGST_COMBO_BOX = new javax.swing.JComboBox<>();
        PRODUCT_SGST = new javax.swing.JLabel();
        PRODUCT_SGST_PANEL = new javax.swing.JPanel();
        PRODUCT_SGST_COMBO_BOX = new javax.swing.JComboBox<>();
        BUTTONS_CONTAINER_PANEL1 = new javax.swing.JPanel();
        ADD_PANEL1 = new javax.swing.JPanel();
        ADD1 = new javax.swing.JLabel();
        EDIT_PANEL1 = new javax.swing.JPanel();
        EDIT1 = new javax.swing.JLabel();
        DELETE_PANEL1 = new javax.swing.JPanel();
        DELETE1 = new javax.swing.JLabel();
        CANCEL_PANEL1 = new javax.swing.JPanel();
        CANCEL1 = new javax.swing.JLabel();
        PRODUCT_DETAILS_SCROLLPANE = new javax.swing.JScrollPane();
        PRODUCT_DETAILS_TABLE = new javax.swing.JTable();
        PRODUCT_ID = new javax.swing.JLabel();
        PRODUCT_ID_PANEL = new javax.swing.JPanel();
        PRODUCT_ID_TEXT_FIELD = new javax.swing.JTextField();
        AVAILABLE_QTY = new javax.swing.JLabel();
        PRODUCT_DETAILS_PRINT_DATA_PANEL = new javax.swing.JPanel();
        PRODUCT_DETAILS_PRINT_DATA = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        AVAILABLE_QTY_TEXT_FIELD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JP4 = new javax.swing.JPanel();
        REPORT_TITLE_PANEL = new javax.swing.JPanel();
        REPORTS_TITLE = new javax.swing.JLabel();
        REPORT_TABBED_PANE = new javax.swing.JTabbedPane();
        AUDIT_REPORTS = new javax.swing.JPanel();
        FROM_DATE = new javax.swing.JLabel();
        FROM_DATE_CHOOSER = new com.toedter.calendar.JDateChooser();
        TO_DATE = new javax.swing.JLabel();
        TO_DATE_CHOOSER = new com.toedter.calendar.JDateChooser();
        REPORT_TABLE_SCROLL_PANE = new javax.swing.JScrollPane();
        REPORT_TABLE = new javax.swing.JTable();
        PROCEED_PANEL = new javax.swing.JPanel();
        PROCEED = new javax.swing.JLabel();
        REPORT_CLIENT_ID = new javax.swing.JLabel();
        REPORT_CLIENT_ID_TEXT_FIELD = new javax.swing.JTextField();
        REPORTS_PRINT_PANEL = new javax.swing.JPanel();
        REPORTS_PRINT = new javax.swing.JLabel();
        REPORTS_CLEAR_PANEL = new javax.swing.JPanel();
        REPORTS_CLEAR = new javax.swing.JLabel();
        REPORTS_SAVE_PANEL = new javax.swing.JPanel();
        REPORTS_SAVE = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        DAILY_BILL_REPORTS = new javax.swing.JPanel();
        FROM_DATE1 = new javax.swing.JLabel();
        FROM_DATE_CHOOSER1 = new com.toedter.calendar.JDateChooser();
        TO_DATE1 = new javax.swing.JLabel();
        TO_DATE_CHOOSER1 = new com.toedter.calendar.JDateChooser();
        DAILY_BILL_TABLE_SCROLL_PANE1 = new javax.swing.JScrollPane();
        DAILY_BILL_TABLE = new javax.swing.JTable();
        GENERATE_PANEL = new javax.swing.JPanel();
        GENERATE = new javax.swing.JLabel();
        REPORT_CLIENT_ID1 = new javax.swing.JLabel();
        REPORT_CLIENT_ID_TEXT_FIELD1 = new javax.swing.JTextField();
        REPORTS_PRINT_PANEL1 = new javax.swing.JPanel();
        REPORTS_PRINT1 = new javax.swing.JLabel();
        REPORTS_CLEAR_PANEL1 = new javax.swing.JPanel();
        REPORTS_CLEAR1 = new javax.swing.JLabel();
        DAILY_BILL_REMOVE_PANEL = new javax.swing.JPanel();
        DAILY_BILL_REMOVE = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("STOCK MANAGEMENT SYSTEM");

        DASHBOARD_PANEL.setBackground(new java.awt.Color(0, 0, 153));
        DASHBOARD_PANEL.setPreferredSize(new java.awt.Dimension(238, 48));

        DASHBOARD.setBackground(new java.awt.Color(0, 0, 153));
        DASHBOARD.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        DASHBOARD.setForeground(new java.awt.Color(255, 255, 255));
        DASHBOARD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8_combo_chart_48px.png"))); // NOI18N
        DASHBOARD.setText("DASHBOARD");

        TAB1.setBackground(new java.awt.Color(0, 0, 153));
        TAB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TAB1MousePressed(evt);
            }
        });

        CLIENT.setBackground(new java.awt.Color(0, 0, 153));
        CLIENT.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        CLIENT.setForeground(new java.awt.Color(255, 255, 255));
        CLIENT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CLIENT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8_branding_48px_1.png"))); // NOI18N
        CLIENT.setText("CLIENT");
        CLIENT.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CLIENTMouseMoved(evt);
            }
        });
        CLIENT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CLIENTMousePressed(evt);
            }
        });

        javax.swing.GroupLayout TAB1Layout = new javax.swing.GroupLayout(TAB1);
        TAB1.setLayout(TAB1Layout);
        TAB1Layout.setHorizontalGroup(
            TAB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CLIENT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TAB1Layout.setVerticalGroup(
            TAB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CLIENT, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
        );

        TAB2.setBackground(new java.awt.Color(0, 0, 153));
        TAB2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TAB2MousePressed(evt);
            }
        });

        PRODUCTS.setBackground(new java.awt.Color(0, 0, 153));
        PRODUCTS.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        PRODUCTS.setForeground(new java.awt.Color(255, 255, 255));
        PRODUCTS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PRODUCTS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8_package_delivery_logistics_48px.png"))); // NOI18N
        PRODUCTS.setText("PRODUCTS");
        PRODUCTS.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PRODUCTSMouseMoved(evt);
            }
        });
        PRODUCTS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PRODUCTSMousePressed(evt);
            }
        });

        javax.swing.GroupLayout TAB2Layout = new javax.swing.GroupLayout(TAB2);
        TAB2.setLayout(TAB2Layout);
        TAB2Layout.setHorizontalGroup(
            TAB2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PRODUCTS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TAB2Layout.setVerticalGroup(
            TAB2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PRODUCTS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );

        TAB3.setBackground(new java.awt.Color(0, 0, 153));
        TAB3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TAB3MousePressed(evt);
            }
        });

        POS.setBackground(new java.awt.Color(0, 0, 153));
        POS.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        POS.setForeground(new java.awt.Color(255, 255, 255));
        POS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8_polyline_48px.png"))); // NOI18N
        POS.setText("POINT OF SALE");
        POS.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                POSMouseMoved(evt);
            }
        });
        POS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                POSMousePressed(evt);
            }
        });

        javax.swing.GroupLayout TAB3Layout = new javax.swing.GroupLayout(TAB3);
        TAB3.setLayout(TAB3Layout);
        TAB3Layout.setHorizontalGroup(
            TAB3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(POS, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        );
        TAB3Layout.setVerticalGroup(
            TAB3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(POS, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
        );

        TAB4.setBackground(new java.awt.Color(0, 0, 153));
        TAB4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TAB4MouseMoved(evt);
            }
        });
        TAB4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TAB4MousePressed(evt);
            }
        });

        EXIT.setBackground(new java.awt.Color(0, 0, 153));
        EXIT.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        EXIT.setForeground(new java.awt.Color(255, 255, 255));
        EXIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8_shutdown_48px.png"))); // NOI18N
        EXIT.setText("EXIT");
        EXIT.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                EXITMouseMoved(evt);
            }
        });
        EXIT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EXITMousePressed(evt);
            }
        });

        javax.swing.GroupLayout TAB4Layout = new javax.swing.GroupLayout(TAB4);
        TAB4.setLayout(TAB4Layout);
        TAB4Layout.setHorizontalGroup(
            TAB4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EXIT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TAB4Layout.setVerticalGroup(
            TAB4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EXIT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        COMPANY_NAME.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        COMPANY_NAME.setForeground(new java.awt.Color(51, 255, 0));
        COMPANY_NAME.setText("POWERED BY  DHEERAJ SOLUTIONS");

        TAB5.setBackground(new java.awt.Color(0, 0, 153));
        TAB5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TAB5MouseMoved(evt);
            }
        });
        TAB5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TAB5MousePressed(evt);
            }
        });

        REPORTS.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        REPORTS.setForeground(new java.awt.Color(255, 255, 255));
        REPORTS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8_combo_chart_100px.png"))); // NOI18N
        REPORTS.setText("REPORTS");
        REPORTS.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                REPORTSMouseMoved(evt);
            }
        });
        REPORTS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                REPORTSMousePressed(evt);
            }
        });

        javax.swing.GroupLayout TAB5Layout = new javax.swing.GroupLayout(TAB5);
        TAB5.setLayout(TAB5Layout);
        TAB5Layout.setHorizontalGroup(
            TAB5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(REPORTS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TAB5Layout.setVerticalGroup(
            TAB5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(REPORTS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LOGO2.png"))); // NOI18N

        javax.swing.GroupLayout DASHBOARD_PANELLayout = new javax.swing.GroupLayout(DASHBOARD_PANEL);
        DASHBOARD_PANEL.setLayout(DASHBOARD_PANELLayout);
        DASHBOARD_PANELLayout.setHorizontalGroup(
            DASHBOARD_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DASHBOARD_PANELLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DASHBOARD_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DASHBOARD_PANELLayout.createSequentialGroup()
                        .addGroup(DASHBOARD_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DASHBOARD_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(DASHBOARD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TAB1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TAB2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TAB5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TAB3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(DASHBOARD_PANELLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(DASHBOARD_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TAB4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addComponent(COMPANY_NAME, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                .addContainerGap())
        );
        DASHBOARD_PANELLayout.setVerticalGroup(
            DASHBOARD_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DASHBOARD_PANELLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DASHBOARD, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(TAB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TAB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TAB3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TAB5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TAB4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(COMPANY_NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
        );

        TITLE.setBackground(new java.awt.Color(0, 0, 153));

        KARISHMA.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        KARISHMA.setForeground(new java.awt.Color(255, 255, 255));
        KARISHMA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        KARISHMA.setText("KARISHMA AGENCIES");

        DATE.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        DATE.setForeground(new java.awt.Color(255, 255, 255));
        DATE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        DATE.setText("DATE:");

        DATESHOW.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        DATESHOW.setForeground(new java.awt.Color(255, 255, 51));
        DATESHOW.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DATESHOW.setText("DATESHOW");

        TIME.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        TIME.setForeground(new java.awt.Color(255, 255, 255));
        TIME.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TIME.setText("TIME:");

        TIMESHOW.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        TIMESHOW.setForeground(new java.awt.Color(51, 255, 0));
        TIMESHOW.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TIMESHOW.setText("TIMESHOW");

        javax.swing.GroupLayout TITLELayout = new javax.swing.GroupLayout(TITLE);
        TITLE.setLayout(TITLELayout);
        TITLELayout.setHorizontalGroup(
            TITLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TITLELayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(KARISHMA, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TITLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DATE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TIME, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TITLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DATESHOW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TIMESHOW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TITLELayout.setVerticalGroup(
            TITLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TITLELayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(KARISHMA, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(TITLELayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TITLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DATE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DATESHOW, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TITLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TIME, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TIMESHOW, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TIME.getAccessibleContext().setAccessibleName("");

        CONTAINER_PANEL.setBackground(new java.awt.Color(255, 255, 255));
        CONTAINER_PANEL.setLayout(new java.awt.CardLayout());

        JP3.setBackground(new java.awt.Color(239, 142, 88));
        JP3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JP3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ROUND_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JP3.add(ROUND_INPUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 470, 120, 30));

        ROUND_LABEL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ROUND_LABEL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ROUND_LABEL.setText("ROUND:");
        JP3.add(ROUND_LABEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 470, 70, 30));

        POINT_OF_SALES.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        POINT_OF_SALES.setForeground(new java.awt.Color(30, 255, 0));
        POINT_OF_SALES.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        POINT_OF_SALES.setText("POINT OF SALES");
        JP3.add(POINT_OF_SALES, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 1166, 31));

        POS_PRODUCT_ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        POS_PRODUCT_ID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        POS_PRODUCT_ID.setText("PRODUCT ID:");
        JP3.add(POS_PRODUCT_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 170, 121, 35));

        POS_PRODUCT_ID_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        POS_PRODUCT_ID_TEXT_FIELD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                POS_PRODUCT_ID_TEXT_FIELDKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout POS_PRODUCT_ID_PANELLayout = new javax.swing.GroupLayout(POS_PRODUCT_ID_PANEL);
        POS_PRODUCT_ID_PANEL.setLayout(POS_PRODUCT_ID_PANELLayout);
        POS_PRODUCT_ID_PANELLayout.setHorizontalGroup(
            POS_PRODUCT_ID_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(POS_PRODUCT_ID_TEXT_FIELD)
        );
        POS_PRODUCT_ID_PANELLayout.setVerticalGroup(
            POS_PRODUCT_ID_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(POS_PRODUCT_ID_TEXT_FIELD, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        JP3.add(POS_PRODUCT_ID_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 170, 141, -1));

        POS_PRODUCT_NAME.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        POS_PRODUCT_NAME.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        POS_PRODUCT_NAME.setText("PRODUCT NAME:");
        JP3.add(POS_PRODUCT_NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 215, 130, 35));

        POS_PRODUCT_NAME_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout POS_PRODUCT_NAME_PANELLayout = new javax.swing.GroupLayout(POS_PRODUCT_NAME_PANEL);
        POS_PRODUCT_NAME_PANEL.setLayout(POS_PRODUCT_NAME_PANELLayout);
        POS_PRODUCT_NAME_PANELLayout.setHorizontalGroup(
            POS_PRODUCT_NAME_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(POS_PRODUCT_NAME_TEXT_FIELD)
        );
        POS_PRODUCT_NAME_PANELLayout.setVerticalGroup(
            POS_PRODUCT_NAME_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(POS_PRODUCT_NAME_TEXT_FIELD, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        JP3.add(POS_PRODUCT_NAME_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 215, 141, -1));

        POS_RATE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        POS_RATE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        POS_RATE.setText("PRICE:");
        JP3.add(POS_RATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 256, 121, 35));

        POS_RATE_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout POS_RATE_PANELLayout = new javax.swing.GroupLayout(POS_RATE_PANEL);
        POS_RATE_PANEL.setLayout(POS_RATE_PANELLayout);
        POS_RATE_PANELLayout.setHorizontalGroup(
            POS_RATE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(POS_RATE_TEXT_FIELD)
        );
        POS_RATE_PANELLayout.setVerticalGroup(
            POS_RATE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(POS_RATE_TEXT_FIELD, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        JP3.add(POS_RATE_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 256, 141, -1));

        QTY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        QTY.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        QTY.setText("QTY:");
        JP3.add(QTY, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 333, 114, 35));

        QTY_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        QTY_TEXT_FIELD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                QTY_TEXT_FIELDKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout QTY_PANELLayout = new javax.swing.GroupLayout(QTY_PANEL);
        QTY_PANEL.setLayout(QTY_PANELLayout);
        QTY_PANELLayout.setHorizontalGroup(
            QTY_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(QTY_TEXT_FIELD)
        );
        QTY_PANELLayout.setVerticalGroup(
            QTY_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(QTY_TEXT_FIELD, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        JP3.add(QTY_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 333, 141, -1));

        POS_CLIENT_NAME.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        POS_CLIENT_NAME.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        POS_CLIENT_NAME.setText("CLIENT ID:");
        JP3.add(POS_CLIENT_NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 42, 121, 31));

        POS_CLIENT_NAME_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        POS_CLIENT_NAME_TEXT_FIELD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                POS_CLIENT_NAME_TEXT_FIELDKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout POS_CLIENT_NAME_PANELLayout = new javax.swing.GroupLayout(POS_CLIENT_NAME_PANEL);
        POS_CLIENT_NAME_PANEL.setLayout(POS_CLIENT_NAME_PANELLayout);
        POS_CLIENT_NAME_PANELLayout.setHorizontalGroup(
            POS_CLIENT_NAME_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(POS_CLIENT_NAME_TEXT_FIELD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        );
        POS_CLIENT_NAME_PANELLayout.setVerticalGroup(
            POS_CLIENT_NAME_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(POS_CLIENT_NAME_PANELLayout.createSequentialGroup()
                .addComponent(POS_CLIENT_NAME_TEXT_FIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        JP3.add(POS_CLIENT_NAME_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 42, -1, -1));

        POS_TABLE.setAutoCreateRowSorter(true);
        POS_TABLE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        POS_TABLE.setForeground(new java.awt.Color(51, 0, 51));
        POS_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "P_ID", "PDT NAME", "HSN CODE", "UOM", "RATE", "QTY", "TAX AMT", "CGST", "C_AMT", "SGST", "S_AMT", "TOTAL "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        POS_TABLE.setGridColor(new java.awt.Color(51, 255, 51));
        POS_TABLE.setRowHeight(35);
        POS_TABLE.setSelectionBackground(new java.awt.Color(138, 234, 210));
        POS_TABLE.getTableHeader().setReorderingAllowed(false);
        JTableHeader tableHeader2 = POS_TABLE.getTableHeader();
        tableHeader2.setBackground(new Color(0,255,102));
        tableHeader2.setPreferredSize(new Dimension(100,30));
        //tableHeader2.setForeground(new Color(0,51,153));
        tableHeader2.setFont(new Font("Tahoma", Font.BOLD, 14));
        POS_TABLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                POS_TABLEMousePressed(evt);
            }
        });
        POS_SCROLLPANE.setViewportView(POS_TABLE);

        JP3.add(POS_SCROLLPANE, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 94, 754, 314));

        POS_BUTTONS_CONTAINER_PANEL.setBackground(new java.awt.Color(239, 142, 88));
        POS_BUTTONS_CONTAINER_PANEL.setOpaque(false);

        ADD_ITEM_PANEL.setBackground(new java.awt.Color(51, 204, 0));

        ADD_ITEM.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ADD_ITEM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ADD_ITEM.setText("ADD ITEM");
        ADD_ITEM.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ADD_ITEMMouseMoved(evt);
            }
        });
        ADD_ITEM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ADD_ITEMMousePressed(evt);
            }
        });

        javax.swing.GroupLayout ADD_ITEM_PANELLayout = new javax.swing.GroupLayout(ADD_ITEM_PANEL);
        ADD_ITEM_PANEL.setLayout(ADD_ITEM_PANELLayout);
        ADD_ITEM_PANELLayout.setHorizontalGroup(
            ADD_ITEM_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ADD_ITEM, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );
        ADD_ITEM_PANELLayout.setVerticalGroup(
            ADD_ITEM_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ADD_ITEM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        REMOVE_ITEM_PANEL.setBackground(new java.awt.Color(255, 51, 0));

        REMOVE_ITEM.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        REMOVE_ITEM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        REMOVE_ITEM.setText("REMOVE ITEM");
        REMOVE_ITEM.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                REMOVE_ITEMMouseMoved(evt);
            }
        });
        REMOVE_ITEM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                REMOVE_ITEMMousePressed(evt);
            }
        });

        javax.swing.GroupLayout REMOVE_ITEM_PANELLayout = new javax.swing.GroupLayout(REMOVE_ITEM_PANEL);
        REMOVE_ITEM_PANEL.setLayout(REMOVE_ITEM_PANELLayout);
        REMOVE_ITEM_PANELLayout.setHorizontalGroup(
            REMOVE_ITEM_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(REMOVE_ITEM, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        REMOVE_ITEM_PANELLayout.setVerticalGroup(
            REMOVE_ITEM_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(REMOVE_ITEM, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        SAVE_PANEL.setBackground(new java.awt.Color(230, 26, 245));

        SAVE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SAVE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SAVE.setText("SAVE");
        SAVE.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                SAVEMouseMoved(evt);
            }
        });
        SAVE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SAVEMousePressed(evt);
            }
        });

        javax.swing.GroupLayout SAVE_PANELLayout = new javax.swing.GroupLayout(SAVE_PANEL);
        SAVE_PANEL.setLayout(SAVE_PANELLayout);
        SAVE_PANELLayout.setHorizontalGroup(
            SAVE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SAVE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SAVE_PANELLayout.setVerticalGroup(
            SAVE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SAVE, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        PRINT_PANEL.setBackground(new java.awt.Color(240, 0, 146));

        PRINT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PRINT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRINT.setText("PRINT");
        PRINT.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PRINTMouseMoved(evt);
            }
        });
        PRINT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PRINTMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PRINT_PANELLayout = new javax.swing.GroupLayout(PRINT_PANEL);
        PRINT_PANEL.setLayout(PRINT_PANELLayout);
        PRINT_PANELLayout.setHorizontalGroup(
            PRINT_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PRINT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PRINT_PANELLayout.setVerticalGroup(
            PRINT_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PRINT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        CLEAR_PANEL.setBackground(new java.awt.Color(204, 255, 51));

        CLEAR.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CLEAR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CLEAR.setText("CLEAR");
        CLEAR.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CLEARMouseMoved(evt);
            }
        });
        CLEAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CLEARMousePressed(evt);
            }
        });

        javax.swing.GroupLayout CLEAR_PANELLayout = new javax.swing.GroupLayout(CLEAR_PANEL);
        CLEAR_PANEL.setLayout(CLEAR_PANELLayout);
        CLEAR_PANELLayout.setHorizontalGroup(
            CLEAR_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CLEAR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        CLEAR_PANELLayout.setVerticalGroup(
            CLEAR_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CLEAR, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        CLEAR_ALL_PANEL.setBackground(new java.awt.Color(0, 255, 255));

        CLEAR_ALL.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CLEAR_ALL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CLEAR_ALL.setText("CLEAR ALL");
        CLEAR_ALL.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CLEAR_ALLMouseMoved(evt);
            }
        });
        CLEAR_ALL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CLEAR_ALLMousePressed(evt);
            }
        });

        javax.swing.GroupLayout CLEAR_ALL_PANELLayout = new javax.swing.GroupLayout(CLEAR_ALL_PANEL);
        CLEAR_ALL_PANEL.setLayout(CLEAR_ALL_PANELLayout);
        CLEAR_ALL_PANELLayout.setHorizontalGroup(
            CLEAR_ALL_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CLEAR_ALL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        CLEAR_ALL_PANELLayout.setVerticalGroup(
            CLEAR_ALL_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CLEAR_ALL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout POS_BUTTONS_CONTAINER_PANELLayout = new javax.swing.GroupLayout(POS_BUTTONS_CONTAINER_PANEL);
        POS_BUTTONS_CONTAINER_PANEL.setLayout(POS_BUTTONS_CONTAINER_PANELLayout);
        POS_BUTTONS_CONTAINER_PANELLayout.setHorizontalGroup(
            POS_BUTTONS_CONTAINER_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(POS_BUTTONS_CONTAINER_PANELLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(POS_BUTTONS_CONTAINER_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CLEAR_PANEL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ADD_ITEM_PANEL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SAVE_PANEL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(POS_BUTTONS_CONTAINER_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(REMOVE_ITEM_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PRINT_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CLEAR_ALL_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        POS_BUTTONS_CONTAINER_PANELLayout.setVerticalGroup(
            POS_BUTTONS_CONTAINER_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(POS_BUTTONS_CONTAINER_PANELLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(POS_BUTTONS_CONTAINER_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(REMOVE_ITEM_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ADD_ITEM_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(POS_BUTTONS_CONTAINER_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SAVE_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PRINT_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(POS_BUTTONS_CONTAINER_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CLEAR_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CLEAR_ALL_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        JP3.add(POS_BUTTONS_CONTAINER_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 426, -1, -1));

        UOM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UOM.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        UOM.setText("UOM:");
        JP3.add(UOM, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 374, 114, 32));

        UOM_COMBO_BOX.setEditable(true);
        UOM_COMBO_BOX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kg", "g", "ml", "l", "pc", "box", "pkt", "bg" }));
        UOM_COMBO_BOX.setAutoscrolls(true);
        UOM_COMBO_BOX.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                UOM_COMBO_BOXItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout UOM_PANELLayout = new javax.swing.GroupLayout(UOM_PANEL);
        UOM_PANEL.setLayout(UOM_PANELLayout);
        UOM_PANELLayout.setHorizontalGroup(
            UOM_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UOM_COMBO_BOX, 0, 141, Short.MAX_VALUE)
        );
        UOM_PANELLayout.setVerticalGroup(
            UOM_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UOM_COMBO_BOX, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        JP3.add(UOM_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 374, -1, -1));

        TOTAL.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TOTAL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TOTAL.setText("TOTAL:");
        JP3.add(TOTAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 426, 132, 37));

        POS_TOTAL_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout POS_TOTAL_PANELLayout = new javax.swing.GroupLayout(POS_TOTAL_PANEL);
        POS_TOTAL_PANEL.setLayout(POS_TOTAL_PANELLayout);
        POS_TOTAL_PANELLayout.setHorizontalGroup(
            POS_TOTAL_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(POS_TOTAL_TEXT_FIELD)
        );
        POS_TOTAL_PANELLayout.setVerticalGroup(
            POS_TOTAL_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(POS_TOTAL_TEXT_FIELD)
        );

        JP3.add(POS_TOTAL_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 426, 122, 37));

        CGST_TOTAL.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CGST_TOTAL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CGST_TOTAL.setText("CGST:");
        JP3.add(CGST_TOTAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(611, 426, 71, 37));

        CGST_TOTAL_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JP3.add(CGST_TOTAL_TEXT_FIELD, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 426, 145, 37));

        SGST_TOTAL.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SGST_TOTAL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        SGST_TOTAL.setText("SGST:");
        JP3.add(SGST_TOTAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(849, 426, -1, 37));

        SGST_TOTAL_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JP3.add(SGST_TOTAL_TEXT_FIELD, new org.netbeans.lib.awtextra.AbsoluteConstraints(912, 426, 115, 37));

        TAX_VALUE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TAX_VALUE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TAX_VALUE.setText("TAX VALUE:");
        JP3.add(TAX_VALUE, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 473, 115, 29));

        TAX_VALUE_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TAX_VALUE_TEXT_FIELD.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        JP3.add(TAX_VALUE_TEXT_FIELD, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 474, 122, 29));

        TOTAL_QTY.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TOTAL_QTY.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TOTAL_QTY.setText("QTY:");
        JP3.add(TOTAL_QTY, new org.netbeans.lib.awtextra.AbsoluteConstraints(611, 476, 71, -1));

        INVOICE_NO.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        INVOICE_NO.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        INVOICE_NO.setText("INVOICE NO:");
        JP3.add(INVOICE_NO, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 94, -1, 28));

        INVOICE_DATE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        INVOICE_DATE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        INVOICE_DATE.setText("INVOICE DATE:");
        JP3.add(INVOICE_DATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 132, 123, 28));

        DATE_CHOOSER.setDateFormatString("dd-MM-yyyy");
        JP3.add(DATE_CHOOSER, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 132, 137, 28));

        CLIENT_NAME_REFERENCE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CLIENT_NAME_REFERENCE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CLIENT_NAME_REFERENCE.setText("CLIENT NAME:");
        JP3.add(CLIENT_NAME_REFERENCE, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 42, -1, -1));

        CLIENT_NAME_REFERENCE_INPUT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CLIENT_NAME_REFERENCE_INPUT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JP3.add(CLIENT_NAME_REFERENCE_INPUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 42, 264, 22));

        POS_CLIENT_ADDRESS.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        POS_CLIENT_ADDRESS.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        POS_CLIENT_ADDRESS.setText("ADDRESS:");
        JP3.add(POS_CLIENT_ADDRESS, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 70, 132, -1));

        POS_CLIENT_ADDRESS_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JP3.add(POS_CLIENT_ADDRESS_INPUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 70, 709, 22));

        POS_GSTIN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        POS_GSTIN.setText("GSTIN:");
        JP3.add(POS_GSTIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(722, 42, -1, -1));

        POS_GSTIN_INPUT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JP3.add(POS_GSTIN_INPUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(797, 42, 360, 22));

        QTY_IN_STOCK.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        QTY_IN_STOCK.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        QTY_IN_STOCK.setText("QTY (IN STOCK):");
        JP3.add(QTY_IN_STOCK, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 297, -1, 30));

        QTY_IN_STOCK_INPUT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        QTY_IN_STOCK_INPUT.setText("STOCK");
        JP3.add(QTY_IN_STOCK_INPUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 297, 141, 30));

        AMT_IN_WORDS_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AMT_IN_WORDS_INPUT.setText("AMT IN WORDS:");
        JP3.add(AMT_IN_WORDS_INPUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 517, -1, 41));

        AMT_IN_WORDS_INPUT_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JP3.add(AMT_IN_WORDS_INPUT_TEXT_FIELD, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 517, 585, 41));

        INVOICE_NO_TEXT_FIELD.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        INVOICE_NO_TEXT_FIELD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                INVOICE_NO_TEXT_FIELDKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout INVOICE_NO_INPUT_PANELLayout = new javax.swing.GroupLayout(INVOICE_NO_INPUT_PANEL);
        INVOICE_NO_INPUT_PANEL.setLayout(INVOICE_NO_INPUT_PANELLayout);
        INVOICE_NO_INPUT_PANELLayout.setHorizontalGroup(
            INVOICE_NO_INPUT_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(INVOICE_NO_TEXT_FIELD, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        );
        INVOICE_NO_INPUT_PANELLayout.setVerticalGroup(
            INVOICE_NO_INPUT_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(INVOICE_NO_TEXT_FIELD)
        );

        JP3.add(INVOICE_NO_INPUT_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 94, -1, 28));

        TOTAL_QTY_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout TOTAL_QTY_PANELLayout = new javax.swing.GroupLayout(TOTAL_QTY_PANEL);
        TOTAL_QTY_PANEL.setLayout(TOTAL_QTY_PANELLayout);
        TOTAL_QTY_PANELLayout.setHorizontalGroup(
            TOTAL_QTY_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TOTAL_QTY_TEXT_FIELD)
        );
        TOTAL_QTY_PANELLayout.setVerticalGroup(
            TOTAL_QTY_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TOTAL_QTY_TEXT_FIELD, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        JP3.add(TOTAL_QTY_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 473, 145, -1));

        CANCEL_BILL_PANEL.setBackground(new java.awt.Color(153, 0, 0));

        CANCEL_BILL.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CANCEL_BILL.setForeground(new java.awt.Color(255, 255, 255));
        CANCEL_BILL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CANCEL_BILL.setText("CANCEL BILL");
        CANCEL_BILL.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CANCEL_BILLMouseMoved(evt);
            }
        });
        CANCEL_BILL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CANCEL_BILLMousePressed(evt);
            }
        });

        javax.swing.GroupLayout CANCEL_BILL_PANELLayout = new javax.swing.GroupLayout(CANCEL_BILL_PANEL);
        CANCEL_BILL_PANEL.setLayout(CANCEL_BILL_PANELLayout);
        CANCEL_BILL_PANELLayout.setHorizontalGroup(
            CANCEL_BILL_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CANCEL_BILL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        CANCEL_BILL_PANELLayout.setVerticalGroup(
            CANCEL_BILL_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CANCEL_BILL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        JP3.add(CANCEL_BILL_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 583, 280, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/COLURFUL.jpg"))); // NOI18N
        JP3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 670));

        CONTAINER_PANEL.add(JP3, "card4");

        JP1.setBackground(new java.awt.Color(51, 255, 255));
        JP1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CLIENT_DETAILS.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        CLIENT_DETAILS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CLIENT_DETAILS.setText("CLIENT DETAILS");
        CLIENT_DETAILS.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JP1.add(CLIENT_DETAILS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1168, -1));

        CLIENT_NAME.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CLIENT_NAME.setForeground(new java.awt.Color(255, 255, 51));
        CLIENT_NAME.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CLIENT_NAME.setText("SHOP NAME:");
        JP1.add(CLIENT_NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 103, -1, 36));

        CLIENT_SHOPNAME_PANEL.setBackground(new java.awt.Color(51, 255, 255));

        CLIENT_SHOPNAME_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CLIENT_SHOPNAME_TEXT_FIELD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CLIENT_SHOPNAME_TEXT_FIELDKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout CLIENT_SHOPNAME_PANELLayout = new javax.swing.GroupLayout(CLIENT_SHOPNAME_PANEL);
        CLIENT_SHOPNAME_PANEL.setLayout(CLIENT_SHOPNAME_PANELLayout);
        CLIENT_SHOPNAME_PANELLayout.setHorizontalGroup(
            CLIENT_SHOPNAME_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CLIENT_SHOPNAME_TEXT_FIELD, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        CLIENT_SHOPNAME_PANELLayout.setVerticalGroup(
            CLIENT_SHOPNAME_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CLIENT_SHOPNAME_TEXT_FIELD, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        JP1.add(CLIENT_SHOPNAME_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 103, 264, -1));

        CLIENT_ADDRESS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CLIENT_ADDRESS.setForeground(new java.awt.Color(255, 255, 51));
        CLIENT_ADDRESS.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CLIENT_ADDRESS.setText("ADDRESS:");
        JP1.add(CLIENT_ADDRESS, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 149, 89, 39));

        CLIENT_ADDRESS_TEXT_FIELD.setColumns(20);
        CLIENT_ADDRESS_TEXT_FIELD.setRows(5);
        CLIENT_ADDRESS_TEXT_FIELD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CLIENT_ADDRESS_TEXT_FIELDKeyPressed(evt);
            }
        });
        CLIENT_ADDRESS_SCROLLPANE.setViewportView(CLIENT_ADDRESS_TEXT_FIELD);

        javax.swing.GroupLayout CLIENT_ADDRESS_PANELLayout = new javax.swing.GroupLayout(CLIENT_ADDRESS_PANEL);
        CLIENT_ADDRESS_PANEL.setLayout(CLIENT_ADDRESS_PANELLayout);
        CLIENT_ADDRESS_PANELLayout.setHorizontalGroup(
            CLIENT_ADDRESS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CLIENT_ADDRESS_PANELLayout.createSequentialGroup()
                .addComponent(CLIENT_ADDRESS_SCROLLPANE)
                .addGap(0, 0, 0))
        );
        CLIENT_ADDRESS_PANELLayout.setVerticalGroup(
            CLIENT_ADDRESS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CLIENT_ADDRESS_SCROLLPANE, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        JP1.add(CLIENT_ADDRESS_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 149, 264, 39));

        GSTIN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        GSTIN.setForeground(new java.awt.Color(255, 255, 51));
        GSTIN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        GSTIN.setText("GSTIN:");
        JP1.add(GSTIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 198, 89, 36));

        GSTIN_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        GSTIN_TEXT_FIELD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GSTIN_TEXT_FIELDKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout GSTIN_PANELLayout = new javax.swing.GroupLayout(GSTIN_PANEL);
        GSTIN_PANEL.setLayout(GSTIN_PANELLayout);
        GSTIN_PANELLayout.setHorizontalGroup(
            GSTIN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GSTIN_TEXT_FIELD, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
        );
        GSTIN_PANELLayout.setVerticalGroup(
            GSTIN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GSTIN_TEXT_FIELD, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        JP1.add(GSTIN_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 198, -1, -1));

        CLIENT_PHONE_NO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CLIENT_PHONE_NO.setForeground(new java.awt.Color(255, 255, 51));
        CLIENT_PHONE_NO.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CLIENT_PHONE_NO.setText("PHONE NO:");
        JP1.add(CLIENT_PHONE_NO, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 244, 89, 29));

        CLIENT_PHONE_NO_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CLIENT_PHONE_NO_TEXT_FIELD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CLIENT_PHONE_NO_TEXT_FIELDKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout CLIENT_PHONE_NO_PANELLayout = new javax.swing.GroupLayout(CLIENT_PHONE_NO_PANEL);
        CLIENT_PHONE_NO_PANEL.setLayout(CLIENT_PHONE_NO_PANELLayout);
        CLIENT_PHONE_NO_PANELLayout.setHorizontalGroup(
            CLIENT_PHONE_NO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CLIENT_PHONE_NO_TEXT_FIELD)
        );
        CLIENT_PHONE_NO_PANELLayout.setVerticalGroup(
            CLIENT_PHONE_NO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CLIENT_PHONE_NO_TEXT_FIELD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        JP1.add(CLIENT_PHONE_NO_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 244, 264, -1));

        CLIENT_DISTRICT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CLIENT_DISTRICT.setForeground(new java.awt.Color(255, 255, 51));
        CLIENT_DISTRICT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CLIENT_DISTRICT.setText("DISTRICT:");
        JP1.add(CLIENT_DISTRICT, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 283, 83, 43));

        CLIENT_DISTRICT_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CLIENT_DISTRICT_TEXT_FIELD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CLIENT_DISTRICT_TEXT_FIELDKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout CLIENT_DISTRICT_PANELLayout = new javax.swing.GroupLayout(CLIENT_DISTRICT_PANEL);
        CLIENT_DISTRICT_PANEL.setLayout(CLIENT_DISTRICT_PANELLayout);
        CLIENT_DISTRICT_PANELLayout.setHorizontalGroup(
            CLIENT_DISTRICT_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CLIENT_DISTRICT_PANELLayout.createSequentialGroup()
                .addComponent(CLIENT_DISTRICT_TEXT_FIELD)
                .addGap(0, 0, 0))
        );
        CLIENT_DISTRICT_PANELLayout.setVerticalGroup(
            CLIENT_DISTRICT_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CLIENT_DISTRICT_TEXT_FIELD, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        JP1.add(CLIENT_DISTRICT_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 283, 264, -1));

        CLIENT_STATE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CLIENT_STATE.setForeground(new java.awt.Color(255, 255, 51));
        CLIENT_STATE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CLIENT_STATE.setText("STATE:");
        JP1.add(CLIENT_STATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 336, 83, 42));

        CLIENT_STATE_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CLIENT_STATE_TEXT_FIELD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CLIENT_STATE_TEXT_FIELDKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout CLIENT_STATE_PANELLayout = new javax.swing.GroupLayout(CLIENT_STATE_PANEL);
        CLIENT_STATE_PANEL.setLayout(CLIENT_STATE_PANELLayout);
        CLIENT_STATE_PANELLayout.setHorizontalGroup(
            CLIENT_STATE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CLIENT_STATE_TEXT_FIELD)
        );
        CLIENT_STATE_PANELLayout.setVerticalGroup(
            CLIENT_STATE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CLIENT_STATE_TEXT_FIELD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        JP1.add(CLIENT_STATE_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 336, 264, -1));

        BUTTONS_CONTAINER_PANEL.setBackground(new java.awt.Color(51, 255, 255));
        BUTTONS_CONTAINER_PANEL.setOpaque(false);

        ADD_PANEL.setBackground(new java.awt.Color(51, 204, 0));

        ADD.setBackground(new java.awt.Color(51, 204, 0));
        ADD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ADD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ADD.setText("ADD");
        ADD.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ADDMouseMoved(evt);
            }
        });
        ADD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ADDMousePressed(evt);
            }
        });

        javax.swing.GroupLayout ADD_PANELLayout = new javax.swing.GroupLayout(ADD_PANEL);
        ADD_PANEL.setLayout(ADD_PANELLayout);
        ADD_PANELLayout.setHorizontalGroup(
            ADD_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ADD, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        ADD_PANELLayout.setVerticalGroup(
            ADD_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ADD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        EDIT_PANEL.setBackground(new java.awt.Color(255, 255, 0));

        EDIT.setBackground(new java.awt.Color(255, 255, 0));
        EDIT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        EDIT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EDIT.setText("EDIT");
        EDIT.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                EDITMouseMoved(evt);
            }
        });
        EDIT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EDITMousePressed(evt);
            }
        });

        javax.swing.GroupLayout EDIT_PANELLayout = new javax.swing.GroupLayout(EDIT_PANEL);
        EDIT_PANEL.setLayout(EDIT_PANELLayout);
        EDIT_PANELLayout.setHorizontalGroup(
            EDIT_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EDIT, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        EDIT_PANELLayout.setVerticalGroup(
            EDIT_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EDIT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        DELETE_PANEL.setBackground(new java.awt.Color(255, 0, 51));

        DELETE.setBackground(new java.awt.Color(255, 0, 51));
        DELETE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DELETE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DELETE.setText("DELETE");
        DELETE.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                DELETEMouseMoved(evt);
            }
        });
        DELETE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DELETEMousePressed(evt);
            }
        });

        javax.swing.GroupLayout DELETE_PANELLayout = new javax.swing.GroupLayout(DELETE_PANEL);
        DELETE_PANEL.setLayout(DELETE_PANELLayout);
        DELETE_PANELLayout.setHorizontalGroup(
            DELETE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DELETE, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        DELETE_PANELLayout.setVerticalGroup(
            DELETE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DELETE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        CANCEL_PANEL.setBackground(new java.awt.Color(255, 51, 255));

        CANCEL.setBackground(new java.awt.Color(255, 51, 255));
        CANCEL.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CANCEL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CANCEL.setText("CANCEL");
        CANCEL.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CANCELMouseMoved(evt);
            }
        });
        CANCEL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CANCELMousePressed(evt);
            }
        });

        javax.swing.GroupLayout CANCEL_PANELLayout = new javax.swing.GroupLayout(CANCEL_PANEL);
        CANCEL_PANEL.setLayout(CANCEL_PANELLayout);
        CANCEL_PANELLayout.setHorizontalGroup(
            CANCEL_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CANCEL, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        CANCEL_PANELLayout.setVerticalGroup(
            CANCEL_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CANCEL, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout BUTTONS_CONTAINER_PANELLayout = new javax.swing.GroupLayout(BUTTONS_CONTAINER_PANEL);
        BUTTONS_CONTAINER_PANEL.setLayout(BUTTONS_CONTAINER_PANELLayout);
        BUTTONS_CONTAINER_PANELLayout.setHorizontalGroup(
            BUTTONS_CONTAINER_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BUTTONS_CONTAINER_PANELLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ADD_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EDIT_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DELETE_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CANCEL_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BUTTONS_CONTAINER_PANELLayout.setVerticalGroup(
            BUTTONS_CONTAINER_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BUTTONS_CONTAINER_PANELLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(BUTTONS_CONTAINER_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CANCEL_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DELETE_PANEL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EDIT_PANEL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ADD_PANEL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        JP1.add(BUTTONS_CONTAINER_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 474, -1, -1));

        CLIENT_DETAILS_TABLE.setAutoCreateRowSorter(true);
        CLIENT_DETAILS_TABLE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CLIENT_DETAILS_TABLE.setForeground(new java.awt.Color(51, 0, 51));
        CLIENT_DETAILS_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"12356", "GANAPATHY SUPER MARKET", "PHASE-2,ANNA NAGAR,TRICHY-26", "12345678901", "9698594605"},
                {null, null, null, null, null}
            },
            new String [] {
                "CL_ID", "SHOP NAME", "ADDRESS", "GSTIN", "PH_NO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        CLIENT_DETAILS_TABLE.setGridColor(new java.awt.Color(51, 255, 51));
        CLIENT_DETAILS_TABLE.setRowHeight(35);
        CLIENT_DETAILS_TABLE.setSelectionBackground(new java.awt.Color(138, 234, 210));
        JTableHeader tableHeader = CLIENT_DETAILS_TABLE.getTableHeader();
        tableHeader.setBackground(new Color(166,23,203));
        tableHeader.setForeground(new Color(255,255,0));
        tableHeader.setPreferredSize(new Dimension(100,30));
        tableHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
        CLIENT_DETAILS_TABLE.setShowGrid(true);
        CLIENT_DETAILS_TABLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CLIENT_DETAILS_TABLEMousePressed(evt);
            }
        });
        CLIENT_DETAILS_SCROLLPANE.setViewportView(CLIENT_DETAILS_TABLE);
        if (CLIENT_DETAILS_TABLE.getColumnModel().getColumnCount() > 0) {
            CLIENT_DETAILS_TABLE.getColumnModel().getColumn(0).setMinWidth(60);
            CLIENT_DETAILS_TABLE.getColumnModel().getColumn(0).setPreferredWidth(60);
            CLIENT_DETAILS_TABLE.getColumnModel().getColumn(0).setMaxWidth(60);
            CLIENT_DETAILS_TABLE.getColumnModel().getColumn(4).setMinWidth(100);
            CLIENT_DETAILS_TABLE.getColumnModel().getColumn(4).setPreferredWidth(100);
            CLIENT_DETAILS_TABLE.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        JP1.add(CLIENT_DETAILS_SCROLLPANE, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 50, 663, 568));

        CLIENT_ID_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CLIENT_ID_TEXT_FIELD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CLIENT_ID_TEXT_FIELDKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout CLIENT_ID_PANELLayout = new javax.swing.GroupLayout(CLIENT_ID_PANEL);
        CLIENT_ID_PANEL.setLayout(CLIENT_ID_PANELLayout);
        CLIENT_ID_PANELLayout.setHorizontalGroup(
            CLIENT_ID_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CLIENT_ID_TEXT_FIELD)
        );
        CLIENT_ID_PANELLayout.setVerticalGroup(
            CLIENT_ID_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CLIENT_ID_TEXT_FIELD, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        JP1.add(CLIENT_ID_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 50, 264, -1));

        CLIENT_ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CLIENT_ID.setForeground(new java.awt.Color(255, 255, 51));
        CLIENT_ID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CLIENT_ID.setText("CLIENT ID:");
        JP1.add(CLIENT_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 50, 91, 35));

        CLIENT_DETAILS_PRINT_DATA_PANEL.setBackground(new java.awt.Color(255, 204, 0));
        CLIENT_DETAILS_PRINT_DATA_PANEL.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CLIENT_DETAILS_PRINT_DATA_PANELMouseMoved(evt);
            }
        });

        CLIENT_DETAILS_PRINT_DATA.setBackground(new java.awt.Color(51, 204, 0));
        CLIENT_DETAILS_PRINT_DATA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CLIENT_DETAILS_PRINT_DATA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CLIENT_DETAILS_PRINT_DATA.setText("PRINT DATA");
        CLIENT_DETAILS_PRINT_DATA.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CLIENT_DETAILS_PRINT_DATAMouseMoved(evt);
            }
        });
        CLIENT_DETAILS_PRINT_DATA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CLIENT_DETAILS_PRINT_DATAMousePressed(evt);
            }
        });

        javax.swing.GroupLayout CLIENT_DETAILS_PRINT_DATA_PANELLayout = new javax.swing.GroupLayout(CLIENT_DETAILS_PRINT_DATA_PANEL);
        CLIENT_DETAILS_PRINT_DATA_PANEL.setLayout(CLIENT_DETAILS_PRINT_DATA_PANELLayout);
        CLIENT_DETAILS_PRINT_DATA_PANELLayout.setHorizontalGroup(
            CLIENT_DETAILS_PRINT_DATA_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CLIENT_DETAILS_PRINT_DATA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        );
        CLIENT_DETAILS_PRINT_DATA_PANELLayout.setVerticalGroup(
            CLIENT_DETAILS_PRINT_DATA_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CLIENT_DETAILS_PRINT_DATA, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        JP1.add(CLIENT_DETAILS_PRINT_DATA_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 538, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/COLOUR4.jpg"))); // NOI18N
        JP1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 740));

        CONTAINER_PANEL.add(JP1, "card2");

        JP2.setBackground(new java.awt.Color(204, 0, 204));
        JP2.setPreferredSize(new java.awt.Dimension(800, 500));
        JP2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PRODUCT_DETAILS.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        PRODUCT_DETAILS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_DETAILS.setText("PRODUCT DETAILS");
        PRODUCT_DETAILS.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JP2.add(PRODUCT_DETAILS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1168, -1));

        PRODUCT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT.setText("PRODUCT");
        JP2.add(PRODUCT, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 99, 104, 23));

        NAME.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        NAME.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NAME.setText("NAME:");
        JP2.add(NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 122, 92, -1));

        PRODUCT_NAME_PANEL.setBackground(new java.awt.Color(51, 255, 255));

        PRODUCT_NAME_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_NAME_TEXT_FIELD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PRODUCT_NAME_TEXT_FIELDKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PRODUCT_NAME_PANELLayout = new javax.swing.GroupLayout(PRODUCT_NAME_PANEL);
        PRODUCT_NAME_PANEL.setLayout(PRODUCT_NAME_PANELLayout);
        PRODUCT_NAME_PANELLayout.setHorizontalGroup(
            PRODUCT_NAME_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PRODUCT_NAME_TEXT_FIELD, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        PRODUCT_NAME_PANELLayout.setVerticalGroup(
            PRODUCT_NAME_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PRODUCT_NAME_TEXT_FIELD)
        );

        JP2.add(PRODUCT_NAME_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 99, 243, 40));

        PRODUCT_BRAND.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_BRAND.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PRODUCT_BRAND.setText("BRAND:");
        JP2.add(PRODUCT_BRAND, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 157, 128, 27));

        PRODUCT_BRAND_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_BRAND_TEXT_FIELD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PRODUCT_BRAND_TEXT_FIELDKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PRODUCT_BRAND_PANELLayout = new javax.swing.GroupLayout(PRODUCT_BRAND_PANEL);
        PRODUCT_BRAND_PANEL.setLayout(PRODUCT_BRAND_PANELLayout);
        PRODUCT_BRAND_PANELLayout.setHorizontalGroup(
            PRODUCT_BRAND_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PRODUCT_BRAND_TEXT_FIELD)
        );
        PRODUCT_BRAND_PANELLayout.setVerticalGroup(
            PRODUCT_BRAND_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PRODUCT_BRAND_TEXT_FIELD, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        JP2.add(PRODUCT_BRAND_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 157, 243, -1));

        HSN_CODE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        HSN_CODE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        HSN_CODE.setText("HSN CODE:");
        JP2.add(HSN_CODE, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 194, 105, 44));

        HSN_CODE_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        HSN_CODE_TEXT_FIELD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                HSN_CODE_TEXT_FIELDKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout HSN_CODE_PANELLayout = new javax.swing.GroupLayout(HSN_CODE_PANEL);
        HSN_CODE_PANEL.setLayout(HSN_CODE_PANELLayout);
        HSN_CODE_PANELLayout.setHorizontalGroup(
            HSN_CODE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HSN_CODE_TEXT_FIELD)
        );
        HSN_CODE_PANELLayout.setVerticalGroup(
            HSN_CODE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HSN_CODE_TEXT_FIELD, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        JP2.add(HSN_CODE_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 203, 243, -1));

        PRODUCT_RATE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_RATE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PRODUCT_RATE.setText("RATE:");
        JP2.add(PRODUCT_RATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 248, 85, 33));

        PRODUCT_RATE_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_RATE_TEXT_FIELD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PRODUCT_RATE_TEXT_FIELDKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PRODUCT_RATE_PANELLayout = new javax.swing.GroupLayout(PRODUCT_RATE_PANEL);
        PRODUCT_RATE_PANEL.setLayout(PRODUCT_RATE_PANELLayout);
        PRODUCT_RATE_PANELLayout.setHorizontalGroup(
            PRODUCT_RATE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PRODUCT_RATE_TEXT_FIELD)
        );
        PRODUCT_RATE_PANELLayout.setVerticalGroup(
            PRODUCT_RATE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PRODUCT_RATE_TEXT_FIELD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        JP2.add(PRODUCT_RATE_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 248, 243, -1));

        PRODUCT_CGST.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_CGST.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PRODUCT_CGST.setText("CGST:");
        JP2.add(PRODUCT_CGST, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 339, 128, 43));

        PRODUCT_CGST_COMBO_BOX.setEditable(true);
        PRODUCT_CGST_COMBO_BOX.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_CGST_COMBO_BOX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "2.5", "6", "9" }));

        javax.swing.GroupLayout PRODUCT_CGST_PANELLayout = new javax.swing.GroupLayout(PRODUCT_CGST_PANEL);
        PRODUCT_CGST_PANEL.setLayout(PRODUCT_CGST_PANELLayout);
        PRODUCT_CGST_PANELLayout.setHorizontalGroup(
            PRODUCT_CGST_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PRODUCT_CGST_COMBO_BOX, 0, 243, Short.MAX_VALUE)
        );
        PRODUCT_CGST_PANELLayout.setVerticalGroup(
            PRODUCT_CGST_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PRODUCT_CGST_COMBO_BOX, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        JP2.add(PRODUCT_CGST_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, -1, -1));

        PRODUCT_SGST.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_SGST.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PRODUCT_SGST.setText("SGST:");
        JP2.add(PRODUCT_SGST, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 392, 70, 37));

        PRODUCT_SGST_COMBO_BOX.setEditable(true);
        PRODUCT_SGST_COMBO_BOX.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_SGST_COMBO_BOX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "2.5", "6", "9" }));

        javax.swing.GroupLayout PRODUCT_SGST_PANELLayout = new javax.swing.GroupLayout(PRODUCT_SGST_PANEL);
        PRODUCT_SGST_PANEL.setLayout(PRODUCT_SGST_PANELLayout);
        PRODUCT_SGST_PANELLayout.setHorizontalGroup(
            PRODUCT_SGST_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PRODUCT_SGST_COMBO_BOX, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PRODUCT_SGST_PANELLayout.setVerticalGroup(
            PRODUCT_SGST_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PRODUCT_SGST_COMBO_BOX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        JP2.add(PRODUCT_SGST_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 392, 243, -1));

        BUTTONS_CONTAINER_PANEL1.setBackground(new java.awt.Color(204, 0, 204));
        BUTTONS_CONTAINER_PANEL1.setOpaque(false);

        ADD_PANEL1.setBackground(new java.awt.Color(51, 204, 0));

        ADD1.setBackground(new java.awt.Color(51, 204, 0));
        ADD1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ADD1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ADD1.setText("ADD");
        ADD1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ADD1MouseMoved(evt);
            }
        });
        ADD1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ADD1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout ADD_PANEL1Layout = new javax.swing.GroupLayout(ADD_PANEL1);
        ADD_PANEL1.setLayout(ADD_PANEL1Layout);
        ADD_PANEL1Layout.setHorizontalGroup(
            ADD_PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ADD1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        ADD_PANEL1Layout.setVerticalGroup(
            ADD_PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ADD1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        EDIT_PANEL1.setBackground(new java.awt.Color(255, 255, 0));

        EDIT1.setBackground(new java.awt.Color(255, 255, 0));
        EDIT1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        EDIT1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EDIT1.setText("EDIT");
        EDIT1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                EDIT1MouseMoved(evt);
            }
        });
        EDIT1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EDIT1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout EDIT_PANEL1Layout = new javax.swing.GroupLayout(EDIT_PANEL1);
        EDIT_PANEL1.setLayout(EDIT_PANEL1Layout);
        EDIT_PANEL1Layout.setHorizontalGroup(
            EDIT_PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EDIT1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        EDIT_PANEL1Layout.setVerticalGroup(
            EDIT_PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EDIT1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        DELETE_PANEL1.setBackground(new java.awt.Color(255, 0, 51));

        DELETE1.setBackground(new java.awt.Color(255, 0, 51));
        DELETE1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DELETE1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DELETE1.setText("DELETE");
        DELETE1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                DELETE1MouseMoved(evt);
            }
        });
        DELETE1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DELETE1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout DELETE_PANEL1Layout = new javax.swing.GroupLayout(DELETE_PANEL1);
        DELETE_PANEL1.setLayout(DELETE_PANEL1Layout);
        DELETE_PANEL1Layout.setHorizontalGroup(
            DELETE_PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DELETE1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        DELETE_PANEL1Layout.setVerticalGroup(
            DELETE_PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DELETE1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        CANCEL_PANEL1.setBackground(new java.awt.Color(102, 102, 255));

        CANCEL1.setBackground(new java.awt.Color(102, 102, 255));
        CANCEL1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CANCEL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CANCEL1.setText("CANCEL");
        CANCEL1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CANCEL1MouseMoved(evt);
            }
        });
        CANCEL1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CANCEL1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout CANCEL_PANEL1Layout = new javax.swing.GroupLayout(CANCEL_PANEL1);
        CANCEL_PANEL1.setLayout(CANCEL_PANEL1Layout);
        CANCEL_PANEL1Layout.setHorizontalGroup(
            CANCEL_PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CANCEL1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        CANCEL_PANEL1Layout.setVerticalGroup(
            CANCEL_PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CANCEL1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout BUTTONS_CONTAINER_PANEL1Layout = new javax.swing.GroupLayout(BUTTONS_CONTAINER_PANEL1);
        BUTTONS_CONTAINER_PANEL1.setLayout(BUTTONS_CONTAINER_PANEL1Layout);
        BUTTONS_CONTAINER_PANEL1Layout.setHorizontalGroup(
            BUTTONS_CONTAINER_PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BUTTONS_CONTAINER_PANEL1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ADD_PANEL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EDIT_PANEL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(DELETE_PANEL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(CANCEL_PANEL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        BUTTONS_CONTAINER_PANEL1Layout.setVerticalGroup(
            BUTTONS_CONTAINER_PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BUTTONS_CONTAINER_PANEL1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(BUTTONS_CONTAINER_PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CANCEL_PANEL1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DELETE_PANEL1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EDIT_PANEL1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ADD_PANEL1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JP2.add(BUTTONS_CONTAINER_PANEL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 447, -1, -1));

        PRODUCT_DETAILS_TABLE.setAutoCreateRowSorter(true);
        PRODUCT_DETAILS_TABLE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_DETAILS_TABLE.setForeground(new java.awt.Color(51, 0, 51));
        PRODUCT_DETAILS_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "ANIL RAVA SEMIYA", "ANIL", "221025669", "556", "2.5", "2.5",  new Integer(1000)},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "P_ID", "PDT NAME", "BRAND", "HSN CODE", "RATE", "CGST", "SGST", "QTY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        JTableHeader tableHeader1 = PRODUCT_DETAILS_TABLE.getTableHeader();
        tableHeader1.setBackground(new Color(255,255,0));
        tableHeader1.setForeground(new Color(0,51,153));
        tableHeader1.setPreferredSize(new Dimension(100,30));
        tableHeader1.setFont(new Font("Tahoma", Font.BOLD, 14));
        PRODUCT_DETAILS_TABLE.setGridColor(new java.awt.Color(51, 255, 51));
        PRODUCT_DETAILS_TABLE.setRowHeight(35);
        PRODUCT_DETAILS_TABLE.setSelectionBackground(new java.awt.Color(138, 234, 210));
        PRODUCT_DETAILS_TABLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PRODUCT_DETAILS_TABLEMousePressed(evt);
            }
        });
        PRODUCT_DETAILS_SCROLLPANE.setViewportView(PRODUCT_DETAILS_TABLE);
        if (PRODUCT_DETAILS_TABLE.getColumnModel().getColumnCount() > 0) {
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(0).setMinWidth(50);
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(0).setPreferredWidth(50);
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(0).setMaxWidth(50);
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(1).setMinWidth(200);
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(1).setPreferredWidth(200);
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(1).setMaxWidth(200);
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(2).setMinWidth(70);
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(2).setPreferredWidth(70);
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(2).setMaxWidth(70);
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(4).setMinWidth(50);
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(4).setPreferredWidth(50);
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(4).setMaxWidth(50);
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(5).setMinWidth(50);
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(5).setPreferredWidth(50);
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(5).setMaxWidth(50);
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(6).setMinWidth(50);
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(6).setPreferredWidth(50);
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(6).setMaxWidth(50);
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(7).setMinWidth(50);
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(7).setPreferredWidth(50);
            PRODUCT_DETAILS_TABLE.getColumnModel().getColumn(7).setMaxWidth(50);
        }

        JP2.add(PRODUCT_DETAILS_SCROLLPANE, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 50, 631, 562));

        PRODUCT_ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_ID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PRODUCT_ID.setText("PRODUCT ID:");
        JP2.add(PRODUCT_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 50, 132, 31));

        PRODUCT_ID_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_ID_TEXT_FIELD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PRODUCT_ID_TEXT_FIELDKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PRODUCT_ID_PANELLayout = new javax.swing.GroupLayout(PRODUCT_ID_PANEL);
        PRODUCT_ID_PANEL.setLayout(PRODUCT_ID_PANELLayout);
        PRODUCT_ID_PANELLayout.setHorizontalGroup(
            PRODUCT_ID_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PRODUCT_ID_TEXT_FIELD)
        );
        PRODUCT_ID_PANELLayout.setVerticalGroup(
            PRODUCT_ID_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PRODUCT_ID_TEXT_FIELD, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        JP2.add(PRODUCT_ID_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 243, -1));

        AVAILABLE_QTY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AVAILABLE_QTY.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        AVAILABLE_QTY.setText("QTY:");
        JP2.add(AVAILABLE_QTY, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 291, 77, 38));

        PRODUCT_DETAILS_PRINT_DATA_PANEL.setBackground(new java.awt.Color(255, 204, 0));
        PRODUCT_DETAILS_PRINT_DATA_PANEL.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PRODUCT_DETAILS_PRINT_DATA_PANELMouseMoved(evt);
            }
        });

        PRODUCT_DETAILS_PRINT_DATA.setBackground(new java.awt.Color(51, 204, 0));
        PRODUCT_DETAILS_PRINT_DATA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PRODUCT_DETAILS_PRINT_DATA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_DETAILS_PRINT_DATA.setText("PRINT DATA");
        PRODUCT_DETAILS_PRINT_DATA.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PRODUCT_DETAILS_PRINT_DATAMouseMoved(evt);
            }
        });
        PRODUCT_DETAILS_PRINT_DATA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PRODUCT_DETAILS_PRINT_DATAMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PRODUCT_DETAILS_PRINT_DATA_PANELLayout = new javax.swing.GroupLayout(PRODUCT_DETAILS_PRINT_DATA_PANEL);
        PRODUCT_DETAILS_PRINT_DATA_PANEL.setLayout(PRODUCT_DETAILS_PRINT_DATA_PANELLayout);
        PRODUCT_DETAILS_PRINT_DATA_PANELLayout.setHorizontalGroup(
            PRODUCT_DETAILS_PRINT_DATA_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PRODUCT_DETAILS_PRINT_DATA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
        );
        PRODUCT_DETAILS_PRINT_DATA_PANELLayout.setVerticalGroup(
            PRODUCT_DETAILS_PRINT_DATA_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PRODUCT_DETAILS_PRINT_DATA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        JP2.add(PRODUCT_DETAILS_PRINT_DATA_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 534, -1, -1));

        AVAILABLE_QTY_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AVAILABLE_QTY_TEXT_FIELD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AVAILABLE_QTY_TEXT_FIELDKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AVAILABLE_QTY_TEXT_FIELD)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AVAILABLE_QTY_TEXT_FIELD)
        );

        JP2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 291, 243, 38));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/COLOURFUL3.png"))); // NOI18N
        JP2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 1, 1090, 680));

        CONTAINER_PANEL.add(JP2, "card3");

        JP4.setBackground(new java.awt.Color(227, 0, 145));
        JP4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        REPORT_TITLE_PANEL.setBackground(new java.awt.Color(227, 0, 145));

        REPORTS_TITLE.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        REPORTS_TITLE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        REPORTS_TITLE.setText("REPORTS");

        javax.swing.GroupLayout REPORT_TITLE_PANELLayout = new javax.swing.GroupLayout(REPORT_TITLE_PANEL);
        REPORT_TITLE_PANEL.setLayout(REPORT_TITLE_PANELLayout);
        REPORT_TITLE_PANELLayout.setHorizontalGroup(
            REPORT_TITLE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(REPORTS_TITLE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        REPORT_TITLE_PANELLayout.setVerticalGroup(
            REPORT_TITLE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(REPORTS_TITLE, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        JP4.add(REPORT_TITLE_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1168, -1));

        REPORT_TABBED_PANE.setBackground(new java.awt.Color(255, 204, 204));

        AUDIT_REPORTS.setBackground(new java.awt.Color(0, 204, 153));
        AUDIT_REPORTS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FROM_DATE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        FROM_DATE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        FROM_DATE.setText("FROM DATE:");
        AUDIT_REPORTS.add(FROM_DATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 10, -1, 30));

        FROM_DATE_CHOOSER.setDateFormatString("dd-MM-yyyy");
        AUDIT_REPORTS.add(FROM_DATE_CHOOSER, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 10, 203, 30));

        TO_DATE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TO_DATE.setText("TO DATE:");
        AUDIT_REPORTS.add(TO_DATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(742, 10, -1, 30));

        TO_DATE_CHOOSER.setDateFormatString("dd-MM-yyyy");
        AUDIT_REPORTS.add(TO_DATE_CHOOSER, new org.netbeans.lib.awtextra.AbsoluteConstraints(831, 10, 193, 30));

        REPORT_TABLE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        REPORT_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GSTIN", "SHOP NAME", "INVOICE NO", "DATE", "TAXABLE AMOUNT", "GST", "CGST", "SGST", "TOTAL"
            }
        ));
        REPORT_TABLE.setFillsViewportHeight(true);
        REPORT_TABLE.setGridColor(new java.awt.Color(0, 0, 0));
        REPORT_TABLE.setRowHeight(35);
        REPORT_TABLE.setSelectionBackground(new java.awt.Color(138, 234, 210));
        JTableHeader header1 = REPORT_TABLE.getTableHeader();
        header1.setPreferredSize(new Dimension(100,30));
        header1.setFont(new Font("Tahoma", Font.BOLD, 14));
        REPORT_TABLE_SCROLL_PANE.setViewportView(REPORT_TABLE);

        AUDIT_REPORTS.add(REPORT_TABLE_SCROLL_PANE, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 108, 1040, 340));

        PROCEED_PANEL.setBackground(new java.awt.Color(255, 255, 51));

        PROCEED.setBackground(new java.awt.Color(255, 255, 51));
        PROCEED.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PROCEED.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PROCEED.setText("PROCEED");
        PROCEED.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PROCEEDMouseMoved(evt);
            }
        });
        PROCEED.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PROCEEDMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PROCEED_PANELLayout = new javax.swing.GroupLayout(PROCEED_PANEL);
        PROCEED_PANEL.setLayout(PROCEED_PANELLayout);
        PROCEED_PANELLayout.setHorizontalGroup(
            PROCEED_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PROCEED, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
        );
        PROCEED_PANELLayout.setVerticalGroup(
            PROCEED_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PROCEED, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        AUDIT_REPORTS.add(PROCEED_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 58, -1, -1));

        REPORT_CLIENT_ID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        REPORT_CLIENT_ID.setText("CLIENT ID:");
        AUDIT_REPORTS.add(REPORT_CLIENT_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        REPORT_CLIENT_ID_TEXT_FIELD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AUDIT_REPORTS.add(REPORT_CLIENT_ID_TEXT_FIELD, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 10, 166, 30));

        REPORTS_PRINT_PANEL.setBackground(new java.awt.Color(255, 204, 51));
        REPORTS_PRINT_PANEL.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                REPORTS_PRINT_PANELMouseMoved(evt);
            }
        });

        REPORTS_PRINT.setBackground(new java.awt.Color(102, 255, 102));
        REPORTS_PRINT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        REPORTS_PRINT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        REPORTS_PRINT.setText("PRINT DATA");
        REPORTS_PRINT.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                REPORTS_PRINTMouseMoved(evt);
            }
        });
        REPORTS_PRINT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                REPORTS_PRINTMousePressed(evt);
            }
        });

        javax.swing.GroupLayout REPORTS_PRINT_PANELLayout = new javax.swing.GroupLayout(REPORTS_PRINT_PANEL);
        REPORTS_PRINT_PANEL.setLayout(REPORTS_PRINT_PANELLayout);
        REPORTS_PRINT_PANELLayout.setHorizontalGroup(
            REPORTS_PRINT_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(REPORTS_PRINT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        REPORTS_PRINT_PANELLayout.setVerticalGroup(
            REPORTS_PRINT_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(REPORTS_PRINT, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        AUDIT_REPORTS.add(REPORTS_PRINT_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(801, 459, 180, -1));

        REPORTS_CLEAR_PANEL.setBackground(new java.awt.Color(255, 0, 0));
        REPORTS_CLEAR_PANEL.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                REPORTS_CLEAR_PANELMouseMoved(evt);
            }
        });

        REPORTS_CLEAR.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        REPORTS_CLEAR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        REPORTS_CLEAR.setText("CLEAR ALL");
        REPORTS_CLEAR.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                REPORTS_CLEARMouseMoved(evt);
            }
        });
        REPORTS_CLEAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                REPORTS_CLEARMousePressed(evt);
            }
        });

        javax.swing.GroupLayout REPORTS_CLEAR_PANELLayout = new javax.swing.GroupLayout(REPORTS_CLEAR_PANEL);
        REPORTS_CLEAR_PANEL.setLayout(REPORTS_CLEAR_PANELLayout);
        REPORTS_CLEAR_PANELLayout.setHorizontalGroup(
            REPORTS_CLEAR_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(REPORTS_CLEAR, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
        );
        REPORTS_CLEAR_PANELLayout.setVerticalGroup(
            REPORTS_CLEAR_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(REPORTS_CLEAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        AUDIT_REPORTS.add(REPORTS_CLEAR_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 459, -1, 50));

        REPORTS_SAVE_PANEL.setBackground(new java.awt.Color(240, 0, 230));
        REPORTS_SAVE_PANEL.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                REPORTS_SAVE_PANELMouseDragged(evt);
            }
        });

        REPORTS_SAVE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        REPORTS_SAVE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        REPORTS_SAVE.setText("SAVE ");
        REPORTS_SAVE.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                REPORTS_SAVEMouseMoved(evt);
            }
        });
        REPORTS_SAVE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                REPORTS_SAVEMousePressed(evt);
            }
        });

        javax.swing.GroupLayout REPORTS_SAVE_PANELLayout = new javax.swing.GroupLayout(REPORTS_SAVE_PANEL);
        REPORTS_SAVE_PANEL.setLayout(REPORTS_SAVE_PANELLayout);
        REPORTS_SAVE_PANELLayout.setHorizontalGroup(
            REPORTS_SAVE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(REPORTS_SAVE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );
        REPORTS_SAVE_PANELLayout.setVerticalGroup(
            REPORTS_SAVE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(REPORTS_SAVE, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        AUDIT_REPORTS.add(REPORTS_SAVE_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 459, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/COLOUR5.jpg"))); // NOI18N
        AUDIT_REPORTS.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 580));

        REPORT_TABBED_PANE.addTab("AUDIT REPORTS", AUDIT_REPORTS);

        DAILY_BILL_REPORTS.setBackground(new java.awt.Color(153, 255, 153));
        DAILY_BILL_REPORTS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FROM_DATE1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        FROM_DATE1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        FROM_DATE1.setText("FROM DATE:");
        DAILY_BILL_REPORTS.add(FROM_DATE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 10, 123, 34));

        FROM_DATE_CHOOSER1.setDateFormatString("dd-MM-yyyy");
        DAILY_BILL_REPORTS.add(FROM_DATE_CHOOSER1, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 10, 198, 34));

        TO_DATE1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TO_DATE1.setText("TO DATE:");
        DAILY_BILL_REPORTS.add(TO_DATE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, 34));

        TO_DATE_CHOOSER1.setDateFormatString("dd-MM-yyyy");
        DAILY_BILL_REPORTS.add(TO_DATE_CHOOSER1, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 10, 210, 34));

        DAILY_BILL_TABLE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DAILY_BILL_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INVOICE NO", "DATE", "SHOP NAME", "SHOP GSTIN", "PRODUCT DESC", "HSN CODE", "UOM", "QTY", "RATE", "TAX VALUE", "GST%", "GST AMT", "TOTAL"
            }
        ));
        DAILY_BILL_TABLE.setFillsViewportHeight(true);
        JTableHeader header = DAILY_BILL_TABLE.getTableHeader();
        header.setPreferredSize(new Dimension(100,30));
        DAILY_BILL_TABLE.setGridColor(new java.awt.Color(0, 0, 0));
        DAILY_BILL_TABLE.setRowHeight(35);
        DAILY_BILL_TABLE.setSelectionBackground(new java.awt.Color(138, 234, 210));
        DAILY_BILL_TABLE_SCROLL_PANE1.setViewportView(DAILY_BILL_TABLE);

        DAILY_BILL_REPORTS.add(DAILY_BILL_TABLE_SCROLL_PANE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 113, 1050, 360));

        GENERATE_PANEL.setBackground(new java.awt.Color(255, 255, 51));

        GENERATE.setBackground(new java.awt.Color(255, 255, 51));
        GENERATE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        GENERATE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GENERATE.setText("GENERATE");
        GENERATE.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                GENERATEMouseMoved(evt);
            }
        });
        GENERATE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GENERATEMousePressed(evt);
            }
        });

        javax.swing.GroupLayout GENERATE_PANELLayout = new javax.swing.GroupLayout(GENERATE_PANEL);
        GENERATE_PANEL.setLayout(GENERATE_PANELLayout);
        GENERATE_PANELLayout.setHorizontalGroup(
            GENERATE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GENERATE, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );
        GENERATE_PANELLayout.setVerticalGroup(
            GENERATE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GENERATE, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        DAILY_BILL_REPORTS.add(GENERATE_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 57, -1, -1));

        REPORT_CLIENT_ID1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        REPORT_CLIENT_ID1.setText("CLIENT ID:");
        DAILY_BILL_REPORTS.add(REPORT_CLIENT_ID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 10, -1, 34));

        REPORT_CLIENT_ID_TEXT_FIELD1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DAILY_BILL_REPORTS.add(REPORT_CLIENT_ID_TEXT_FIELD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 10, 166, 34));

        REPORTS_PRINT_PANEL1.setBackground(new java.awt.Color(255, 204, 51));
        REPORTS_PRINT_PANEL1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                REPORTS_PRINT_PANEL1MouseMoved(evt);
            }
        });

        REPORTS_PRINT1.setBackground(new java.awt.Color(102, 255, 102));
        REPORTS_PRINT1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        REPORTS_PRINT1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        REPORTS_PRINT1.setText("PRINT DATA");
        REPORTS_PRINT1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                REPORTS_PRINT1MouseMoved(evt);
            }
        });
        REPORTS_PRINT1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                REPORTS_PRINT1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout REPORTS_PRINT_PANEL1Layout = new javax.swing.GroupLayout(REPORTS_PRINT_PANEL1);
        REPORTS_PRINT_PANEL1.setLayout(REPORTS_PRINT_PANEL1Layout);
        REPORTS_PRINT_PANEL1Layout.setHorizontalGroup(
            REPORTS_PRINT_PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(REPORTS_PRINT1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        REPORTS_PRINT_PANEL1Layout.setVerticalGroup(
            REPORTS_PRINT_PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(REPORTS_PRINT1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        DAILY_BILL_REPORTS.add(REPORTS_PRINT_PANEL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 485, 160, 50));

        REPORTS_CLEAR_PANEL1.setBackground(new java.awt.Color(51, 255, 51));
        REPORTS_CLEAR_PANEL1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                REPORTS_CLEAR_PANEL1MouseMoved(evt);
            }
        });

        REPORTS_CLEAR1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        REPORTS_CLEAR1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        REPORTS_CLEAR1.setText("CLEAR ALL");
        REPORTS_CLEAR1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                REPORTS_CLEAR1MouseMoved(evt);
            }
        });
        REPORTS_CLEAR1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                REPORTS_CLEAR1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout REPORTS_CLEAR_PANEL1Layout = new javax.swing.GroupLayout(REPORTS_CLEAR_PANEL1);
        REPORTS_CLEAR_PANEL1.setLayout(REPORTS_CLEAR_PANEL1Layout);
        REPORTS_CLEAR_PANEL1Layout.setHorizontalGroup(
            REPORTS_CLEAR_PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(REPORTS_CLEAR1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        REPORTS_CLEAR_PANEL1Layout.setVerticalGroup(
            REPORTS_CLEAR_PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(REPORTS_CLEAR1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        DAILY_BILL_REPORTS.add(REPORTS_CLEAR_PANEL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 489, 190, 50));

        DAILY_BILL_REMOVE_PANEL.setBackground(new java.awt.Color(255, 0, 0));

        DAILY_BILL_REMOVE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DAILY_BILL_REMOVE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DAILY_BILL_REMOVE.setText("REMOVE ITEM");
        DAILY_BILL_REMOVE.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                DAILY_BILL_REMOVEMouseMoved(evt);
            }
        });
        DAILY_BILL_REMOVE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DAILY_BILL_REMOVEMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout DAILY_BILL_REMOVE_PANELLayout = new javax.swing.GroupLayout(DAILY_BILL_REMOVE_PANEL);
        DAILY_BILL_REMOVE_PANEL.setLayout(DAILY_BILL_REMOVE_PANELLayout);
        DAILY_BILL_REMOVE_PANELLayout.setHorizontalGroup(
            DAILY_BILL_REMOVE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DAILY_BILL_REMOVE, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        DAILY_BILL_REMOVE_PANELLayout.setVerticalGroup(
            DAILY_BILL_REMOVE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DAILY_BILL_REMOVE, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        DAILY_BILL_REPORTS.add(DAILY_BILL_REMOVE_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, 190, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/COLOUR6.jpg"))); // NOI18N
        DAILY_BILL_REPORTS.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 580));

        REPORT_TABBED_PANE.addTab("DAILY BILL RECORDS", DAILY_BILL_REPORTS);

        JP4.add(REPORT_TABBED_PANE, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 39, -1, -1));

        CONTAINER_PANEL.add(JP4, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(DASHBOARD_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(CONTAINER_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(TITLE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TITLE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(CONTAINER_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(2, 2, 2))
            .addComponent(DASHBOARD_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TAB1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TAB1MousePressed
        setcolor(TAB1);
        resetcolor(TAB2);
        resetcolor(TAB3);
        resetcolor(TAB4);
        resetcolor(TAB5);
        CLIENT_ID_TEXT_FIELD.requestFocus();
    }//GEN-LAST:event_TAB1MousePressed

    private void TAB2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TAB2MousePressed
        setcolor(TAB2);
        resetcolor(TAB1);
        resetcolor(TAB3);
        resetcolor(TAB4);
        resetcolor(TAB5);
        PRODUCT_ID_TEXT_FIELD.requestFocus();

    }//GEN-LAST:event_TAB2MousePressed

    private void TAB3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TAB3MousePressed
        setcolor(TAB3);
        resetcolor(TAB1);
        resetcolor(TAB2);
        resetcolor(TAB4);
        resetcolor(TAB5);
        POS_CLIENT_NAME_TEXT_FIELD.requestFocus();
    }//GEN-LAST:event_TAB3MousePressed

    private void CLIENTMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLIENTMousePressed
        JP1.setVisible(true);
        JP2.setVisible(false);
        JP3.setVisible(false);
        JP4.setVisible(false);
        setcolor(TAB1);
        resetcolor(TAB2);
        resetcolor(TAB3);
        resetcolor(TAB4);
        resetcolor(TAB5);
        CLIENT_ID_TEXT_FIELD.requestFocus();
    }//GEN-LAST:event_CLIENTMousePressed

    private void PRODUCTSMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRODUCTSMousePressed
        JP1.setVisible(false);
        JP2.setVisible(true);
        JP3.setVisible(false);
        JP4.setVisible(false);
        setcolor(TAB2);
        resetcolor(TAB1);
        resetcolor(TAB3);
        resetcolor(TAB4);
        resetcolor(TAB5);
        ProductLoadData();
        PRODUCT_ID_TEXT_FIELD.requestFocus();
    }//GEN-LAST:event_PRODUCTSMousePressed

    private void POSMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_POSMousePressed
        JP1.setVisible(false);
        JP2.setVisible(false);
        JP3.setVisible(true);
        JP4.setVisible(false);
        setcolor(TAB3);
        resetcolor(TAB1);
        resetcolor(TAB2);
        resetcolor(TAB4);
        resetcolor(TAB5);
        POS_CLIENT_NAME_TEXT_FIELD.requestFocus();
        REMOVE_ITEM.setEnabled(false);
    }//GEN-LAST:event_POSMousePressed

    private void CLIENTMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLIENTMouseMoved
        Cursor cur1 = new Cursor(Cursor.HAND_CURSOR);
        CLIENT.setCursor(cur1);
    }//GEN-LAST:event_CLIENTMouseMoved

    private void PRODUCTSMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRODUCTSMouseMoved
        Cursor cur2 = new Cursor(Cursor.HAND_CURSOR);
        PRODUCTS.setCursor(cur2);
    }//GEN-LAST:event_PRODUCTSMouseMoved

    private void POSMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_POSMouseMoved
        Cursor cur3 = new Cursor(Cursor.HAND_CURSOR);
        POS.setCursor(cur3);
    }//GEN-LAST:event_POSMouseMoved

    private void EXITMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EXITMouseMoved
        Cursor cur4 = new Cursor(Cursor.HAND_CURSOR);
        EXIT.setCursor(cur4);
    }//GEN-LAST:event_EXITMouseMoved

    private void TAB4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TAB4MouseMoved
        Cursor cur5 = new Cursor(Cursor.HAND_CURSOR);
        TAB4.setCursor(cur5);
    }//GEN-LAST:event_TAB4MouseMoved

    private void TAB4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TAB4MousePressed
        System.exit(0);
        setcolor(TAB4);
        resetcolor(TAB1);
        resetcolor(TAB2);
        resetcolor(TAB3);
    }//GEN-LAST:event_TAB4MousePressed

    private void EXITMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EXITMousePressed
        System.exit(0);
        setcolor(TAB4);
        resetcolor(TAB1);
        resetcolor(TAB2);
        resetcolor(TAB3);
    }//GEN-LAST:event_EXITMousePressed

    private void ADDMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDMouseMoved
        Cursor cur6 = new Cursor(Cursor.HAND_CURSOR);
        ADD.setCursor(cur6);
    }//GEN-LAST:event_ADDMouseMoved

    private void EDITMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDITMouseMoved
        Cursor cur7 = new Cursor(Cursor.HAND_CURSOR);
        EDIT.setCursor(cur7);
    }//GEN-LAST:event_EDITMouseMoved

    private void DELETEMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DELETEMouseMoved
        Cursor cur8 = new Cursor(Cursor.HAND_CURSOR);
        DELETE.setCursor(cur8);
    }//GEN-LAST:event_DELETEMouseMoved

    private void CANCELMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CANCELMouseMoved
        Cursor cur9 = new Cursor(Cursor.HAND_CURSOR);
        CANCEL.setCursor(cur9);
    }//GEN-LAST:event_CANCELMouseMoved

    //CLIENT DETAILS - ADD BUTTON ACTION
    private void ADDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDMousePressed
       
        ClientAddMouse();
    }//GEN-LAST:event_ADDMousePressed
    
    public void ClientAddMouse()
    {
        try {
             
            String ClientId = CLIENT_ID_TEXT_FIELD.getText();       // GETTING CLIENT ID FROM TEXTFIELD
            String ShopName = CLIENT_SHOPNAME_TEXT_FIELD.getText(); // GETTING SHOP NAME FROM TEXTFIELD
            String Address = CLIENT_ADDRESS_TEXT_FIELD.getText();   // GETTING SHOP ADDRESS FROM TEXTFIELD
            String GstIn = GSTIN_TEXT_FIELD.getText();              // GETTING GSTIN FROM TEXTFIELD
            String PhoneNo = CLIENT_PHONE_NO_TEXT_FIELD.getText();  // GETTING CLIENT PHONE NO FROM TEXTFIELD
            String District = CLIENT_DISTRICT_TEXT_FIELD.getText(); // GETTING DISTRICT FROM TEXTFIELD
            String State = CLIENT_STATE_TEXT_FIELD.getText();       // GETTING STATE FROM TEXTFIELD
            
            //INSERTING THE OBTAINED VALUE TO THE DATABASE
            String sql = "INSERT INTO CLIENT_DETAILS(CLIENT_ID,SHOP_NAME,ADDRESS,GSTIN,PHONE_NO,DISTRICT,STATE)values(?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
               // SETTING UP THE CORRECT VALUES
            pst.setString(1, ClientId);
            pst.setString(2, ShopName);
            pst.setString(3, Address);
            pst.setString(4, GstIn);
            pst.setString(5, PhoneNo);
            pst.setString(6, District);
            pst.setString(7, State);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"CLIENT DETAILS ADDED SUCCESSFULLY");
            
            //CLEARING THE TEXT FIELD FOR THE NEXT ENTRY
            CLIENT_ID_TEXT_FIELD.setText("");
            CLIENT_SHOPNAME_TEXT_FIELD.setText("");
            CLIENT_ADDRESS_TEXT_FIELD.setText("");
            GSTIN_TEXT_FIELD.setText("");
            CLIENT_PHONE_NO_TEXT_FIELD.setText("");
            CLIENT_DISTRICT_TEXT_FIELD.setText("");
            CLIENT_STATE_TEXT_FIELD.setText("");
            CLIENT_ID_TEXT_FIELD.requestFocus();
            ClientLoadData();
            
        } 
        catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(this, "INVALID ID/GSTIN \nKINDLY RECHECK", "WARNING", JOptionPane.WARNING_MESSAGE);
           //SINCE CLIENT ID AND GSTIN ARE GIVEN AS UNIQUE IN SQLITE - WRITE THE VALID ENTRY ( NO DUPLICATES )
        }
        finally
        {
            try
            {
                rs.close(); //CLOSING THE RESULT SET
                pst.close();//CLOSING THE PREPARE STATEMENT
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(this,"DATABASE NOT CLOSED PROPERLY \nRETRY AGAIN");
            }
        }

    }
    //CLIENT TABLE - INSERTING VALUES TO CLIENT TABLE FROM DATABASE
    private void CLIENT_DETAILS_TABLEMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLIENT_DETAILS_TABLEMousePressed

        try
        {
            int row = CLIENT_DETAILS_TABLE.getSelectedRow();                                     //GIVES THE VALUE OF SELECTED ROW
            String Table_click = (CLIENT_DETAILS_TABLE.getModel().getValueAt(row,0).toString()); //THEN THE CLICKED VALUE IS STORED HERE
            String sql = "select * from CLIENT_DETAILS where CLIENT_ID='"+Table_click+"' ";      //IT IS CHECKED IN THE DATABASE TO RETRIVE DATA FROM IT
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next())
            {  
                // RETURNING THE VALUES TO THE TEXTFIELD FOR ANY CORRECTION/TO KNOW ABOUT THE VALUES
                String add1 = rs.getString("CLIENT_ID");
                CLIENT_ID_TEXT_FIELD.setText(add1);
                String add2 = rs.getString("SHOP_NAME");
                CLIENT_SHOPNAME_TEXT_FIELD.setText(add2);
                String add3 = rs.getString("ADDRESS");
                CLIENT_ADDRESS_TEXT_FIELD.setText(add3);
                String add4 = rs.getString("GSTIN");
                GSTIN_TEXT_FIELD.setText(add4);
                String add5 = rs.getString("PHONE_NO");
                CLIENT_PHONE_NO_TEXT_FIELD.setText(add5);
                String add6 = rs.getString("DISTRICT");
                CLIENT_DISTRICT_TEXT_FIELD.setText(add6);
                String add7 = rs.getString("STATE");
                CLIENT_STATE_TEXT_FIELD.setText(add7);
                CLIENT_ID_TEXT_FIELD.requestFocus(); //THE TEXT BLINKER IS KEPT AT FIRST TEXTFIELD FOR ANOTHER OPERATION
                ADD.setEnabled(false);
                EDIT.setEnabled(true);
                DELETE.setEnabled(true);
           }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(this,"DATABASE LOCKED \nRETRY AGAIN");
        }
        finally
        {
            try
            {
                rs.close();  //CLOSING THE RESULT SET
                pst.close(); //CLOSING THE PREPARE STATEMENT
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(this,"DATABASE NOT CLOSED PROPERLY \nRETRY AGAIN");
            }
        }
       
    }//GEN-LAST:event_CLIENT_DETAILS_TABLEMousePressed

    //CLIENT DETAILS - EDIT BUTTON ACTION
    private void EDITMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDITMousePressed
       
        int row = CLIENT_DETAILS_TABLE.getSelectedRow();                                     //GIVES THE VALUE OF SELECTED ROW
        String Table_click = (CLIENT_DETAILS_TABLE.getModel().getValueAt(row,0).toString()); //THEN THE CLICKED VALUE IS STORED HERE
        
        try
        {
            //ALL THE VALUES OF SELECTED ROW ARE RETURNED TO RESPECTIVE TEXT FIELDS FOR UPDATION
            String ClientId = CLIENT_ID_TEXT_FIELD.getText();
            String ShopName = CLIENT_SHOPNAME_TEXT_FIELD.getText();
            String Address = CLIENT_ADDRESS_TEXT_FIELD.getText();
            String GstIn = GSTIN_TEXT_FIELD.getText();
            String PhoneNo = CLIENT_PHONE_NO_TEXT_FIELD.getText();
            String District = CLIENT_DISTRICT_TEXT_FIELD.getText();
            String State = CLIENT_STATE_TEXT_FIELD.getText();
        
            //UPDATE QUERY IS WRITTEN
            String sql = "update CLIENT_DETAILS set CLIENT_ID=?, SHOP_NAME=?, ADDRESS=?, GSTIN=?, PHONE_NO=?, DISTRICT=?, STATE=? where CLIENT_ID='"+Table_click+"' ";
            pst = con.prepareStatement(sql);
            
            //RESPECTIVE UPDATED VALUES ARE SET IN DATABASE
            pst.setString(1,ClientId);
            pst.setString(2,ShopName);
            pst.setString(3,Address);
            pst.setString(4,GstIn);
            pst.setString(5,PhoneNo);
            pst.setString(6,District);
            pst.setString(7,State);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"CLIENT DETAILS UPDATED");
        
            //AGAIN ALL THE TEXTFIELD IS CLEARED FOR ANOTHER OPERATION
            CLIENT_ID_TEXT_FIELD.setText("");
            CLIENT_SHOPNAME_TEXT_FIELD.setText("");
            CLIENT_ADDRESS_TEXT_FIELD.setText("");
            GSTIN_TEXT_FIELD.setText("");
            CLIENT_PHONE_NO_TEXT_FIELD.setText("");
            CLIENT_DISTRICT_TEXT_FIELD.setText("");
            CLIENT_STATE_TEXT_FIELD.setText("");
            CLIENT_ID_TEXT_FIELD.requestFocus();
            ClientLoadData();
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(this,"DATABASE LOCKED \nRETRY AGAIN");
        }
        finally
        {
            try
            {
                pst.close();
            }
            catch(SQLException e)
            {
               JOptionPane.showMessageDialog(this,"DATABASE NOT CLOSED PROPERLY \nRETRY AGAIN");
            }
        }
        ADD.setEnabled(true);
          
    }//GEN-LAST:event_EDITMousePressed

    //CLIENT DETAILS - DELETE BUTTON ACTION
    private void DELETEMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DELETEMousePressed
         
        int row = CLIENT_DETAILS_TABLE.getSelectedRow();                                     //GIVES THE VALUE OF SELECTED ROW
        String Table_click = (CLIENT_DETAILS_TABLE.getModel().getValueAt(row,0).toString()); //THEN THE CLICKED VALUE IS STORED HERE
        
        try 
        {
            String ClientId = Table_click;
        
            //DELETE QUERY IS WRITTEN
            String sql = "delete from CLIENT_DETAILS where CLIENT_ID=?";
            pst = con.prepareStatement(sql);
        
            pst.setString(1,ClientId);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"CLIENT DETAILS DELETED");
        
            //AGAIN ALL THE TEXTFIELD IS CLEARED FOR ANOTHER OPERATION
            CLIENT_ID_TEXT_FIELD.setText("");
            CLIENT_SHOPNAME_TEXT_FIELD.setText("");
            CLIENT_ADDRESS_TEXT_FIELD.setText("");
            GSTIN_TEXT_FIELD.setText("");
            CLIENT_PHONE_NO_TEXT_FIELD.setText("");
            CLIENT_DISTRICT_TEXT_FIELD.setText("");
            CLIENT_STATE_TEXT_FIELD.setText("");
            CLIENT_ID_TEXT_FIELD.requestFocus();
            ClientLoadData();
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(this,"DATABASE LOCKED \nRETRY AGAIN");
        }
        finally
        {
            try
            {
                pst.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(this,"DATABASE NOT CLOSED PROPERLY \nRETRY AGAIN");
            }
        }
        ADD.setEnabled(true);
        EDIT1.setEnabled(false);
    }//GEN-LAST:event_DELETEMousePressed

    //CLIENT DETAILS - CANCEL BUTTON ACTION
    private void CANCELMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CANCELMousePressed
        
        //ALL THE TEXTFIELD IS CLEARED FOR ANOTHER OPERATION
        CLIENT_ID_TEXT_FIELD.setText("");
        CLIENT_SHOPNAME_TEXT_FIELD.setText("");
        CLIENT_ADDRESS_TEXT_FIELD.setText("");
        GSTIN_TEXT_FIELD.setText("");
        CLIENT_PHONE_NO_TEXT_FIELD.setText("");
        CLIENT_DISTRICT_TEXT_FIELD.setText("");
        CLIENT_STATE_TEXT_FIELD.setText("");
        CLIENT_ID_TEXT_FIELD.requestFocus();
        ClientLoadData();
        ADD.setEnabled(true);
    }//GEN-LAST:event_CANCELMousePressed

    //PRODUCT DETAILS - INSERTING VALUES TO TABLE FROM DATABASE
    private void PRODUCT_DETAILS_TABLEMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRODUCT_DETAILS_TABLEMousePressed
       
       try 
        {
            int row = PRODUCT_DETAILS_TABLE.getSelectedRow();                                     //GIVES THE VALUE OF SELECTED ROW     
            String Table_click = (PRODUCT_DETAILS_TABLE.getModel().getValueAt(row,0).toString()); //THEN THE CLICKED VALUE IS STORED HERE
            String sql = "select * from PRODUCT_DETAILS where PRODUCT_ID='"+Table_click+"' ";     //IT IS CHECKED IN THE DATABASE TO RETRIVE DATA FROM IT
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                // RETURNING THE VALUES TO THE TEXTFIELD FOR ANY CORRECTION/TO KNOW ABOUT THE VALUES
                String add1 = rs.getString("PRODUCT_ID");
                PRODUCT_ID_TEXT_FIELD.setText(add1);
                String add2 = rs.getString("PRODUCT_NAME");
                PRODUCT_NAME_TEXT_FIELD.setText(add2);
                String add3 = rs.getString("BRAND");
                PRODUCT_BRAND_TEXT_FIELD.setText(add3);
                String add4 = rs.getString("HSN_CODE");
                HSN_CODE_TEXT_FIELD.setText(add4);
                String add5 = rs.getString("RATE");
                PRODUCT_RATE_TEXT_FIELD.setText(add5);
                String add6 = rs.getString("CGST");
                PRODUCT_CGST_COMBO_BOX.setSelectedItem(add6);
                String add7 = rs.getString("SGST");
                PRODUCT_SGST_COMBO_BOX.setSelectedItem(add7);
                AVAILABLE_QTY_TEXT_FIELD.requestFocus(); // BLINKER IS SET ON FIRST TEXTFIELD
                ADD1.setEnabled(false);
                EDIT1.setEnabled(true);
                DELETE1.setEnabled(true);
                
            }
        }
        catch (SQLException ex) 
        {
             JOptionPane.showMessageDialog(this, "AN UNEXPECTED ERROR OCCURED \nRETRY AGAIN", "ERROR", JOptionPane.WARNING_MESSAGE);   
        }
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(this,"DATABASE NOT CLOSED PROPERLY \nRETRY AGAIN");
            }
        }
    }//GEN-LAST:event_PRODUCT_DETAILS_TABLEMousePressed

    
    private void ADD1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD1MouseMoved
        Cursor cur10 = new Cursor(Cursor.HAND_CURSOR);
        ADD1.setCursor(cur10);
    }//GEN-LAST:event_ADD1MouseMoved

    private void ADD1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD1MousePressed
        
         try {
            
            String ProductId = PRODUCT_ID_TEXT_FIELD.getText();
            String ProductName = PRODUCT_NAME_TEXT_FIELD.getText();
            String Brand = PRODUCT_BRAND_TEXT_FIELD.getText();
            String HsnCode = HSN_CODE_TEXT_FIELD.getText();
            String Rate = PRODUCT_RATE_TEXT_FIELD.getText();
            String Cgst = (String) PRODUCT_CGST_COMBO_BOX.getSelectedItem();
            String Sgst =  (String) PRODUCT_SGST_COMBO_BOX.getSelectedItem();
            String avail_qty = AVAILABLE_QTY_TEXT_FIELD.getText();
            String sql = "INSERT INTO PRODUCT_DETAILS(PRODUCT_ID,PRODUCT_NAME,BRAND,HSN_CODE,RATE,CGST,SGST,CURRENT_QTY)values(?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);

            pst.setString(1, ProductId);
            pst.setString(2, ProductName);
            pst.setString(3, Brand);
            pst.setString(4, HsnCode);
            pst.setString(5, Rate);
            pst.setString(6, Cgst);
            pst.setString(7, Sgst);
            pst.setString(8, avail_qty);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"PRODUCT DETAILS UPDATED");
            
            PRODUCT_ID_TEXT_FIELD.setText("");
            PRODUCT_NAME_TEXT_FIELD.setText("");
            PRODUCT_BRAND_TEXT_FIELD.setText("");
            HSN_CODE_TEXT_FIELD.setText("");
            PRODUCT_RATE_TEXT_FIELD.setText("");
            AVAILABLE_QTY_TEXT_FIELD.setText("");
            PRODUCT_CGST_COMBO_BOX.setSelectedIndex(0);
            PRODUCT_SGST_COMBO_BOX.setSelectedIndex(0);
            PRODUCT_ID_TEXT_FIELD.requestFocus();
            ProductLoadData();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"DATABASE LOCKED \nRETRY AGAIN");
        }
        
         finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(this,"DATABASE NOT CLOSED PROPERLY \nRETRY AGAIN");
            }
        }

    }//GEN-LAST:event_ADD1MousePressed

    public void ProductLoadData()
    {
         try {
             EDIT1.setEnabled(false);
             DELETE1.setEnabled(false);
            String sql2 = "UPDATE PRODUCT_DETAILS SET CURRENT_QTY = 0 WHERE CURRENT_QTY <= 0";
             pst1 = con.prepareStatement(sql2);
             pst1.executeUpdate();
            String sql = "select * from PRODUCT_DETAILS";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
             
            
            ResultSetMetaData metadata = rs.getMetaData();
            int a = metadata.getColumnCount();
            df = (DefaultTableModel)PRODUCT_DETAILS_TABLE.getModel();
            df.setRowCount(0);
            
            while(rs.next())
            {
                Vector<String> v1 = new <String> Vector<String>();
                for(int i=1;i<=a;i++)
                {
                    v1.add(rs.getString("PRODUCT_ID"));
                    v1.add(rs.getString("PRODUCT_NAME"));
                    v1.add(rs.getString("BRAND"));
                    v1.add(rs.getString("HSN_CODE"));
                    v1.add(rs.getString("RATE"));
                    v1.add(rs.getString("CGST"));
                    v1.add(rs.getString("SGST"));
                    v1.add(rs.getString("CURRENT_QTY"));
                    
                }
                df.addRow(v1);
            }
            
        } 
        
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"DATABASE LOCKED \nRETRY AGAIN");
        }
        
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(this,"DATABASE NOT CLOSED PROPERLY \nRETRY AGAIN");
            }
        }
    }
    
    private void EDIT1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDIT1MouseMoved
        Cursor cur11 = new Cursor(Cursor.HAND_CURSOR);
        EDIT1.setCursor(cur11);
    }//GEN-LAST:event_EDIT1MouseMoved

    private void EDIT1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDIT1MousePressed
        
        ProductEditMouse();
    }//GEN-LAST:event_EDIT1MousePressed

    public void ProductEditMouse()
    {
        int row = PRODUCT_DETAILS_TABLE.getSelectedRow();
        String Table_click = (PRODUCT_DETAILS_TABLE.getModel().getValueAt(row,0).toString());
        
        try {
            
       String ProductId = PRODUCT_ID_TEXT_FIELD.getText();
            String ProductName = PRODUCT_NAME_TEXT_FIELD.getText();
            String Brand = PRODUCT_BRAND_TEXT_FIELD.getText();
            String HsnCode = HSN_CODE_TEXT_FIELD.getText();
            String Rate = PRODUCT_RATE_TEXT_FIELD.getText();
            String Cgst = (String) PRODUCT_CGST_COMBO_BOX.getSelectedItem();
            String Sgst =  (String) PRODUCT_SGST_COMBO_BOX.getSelectedItem();
            String avail_qty = AVAILABLE_QTY_TEXT_FIELD.getText();
        
        String sql = "update PRODUCT_DETAILS set PRODUCT_ID=?, PRODUCT_NAME=?, BRAND=?, HSN_CODE=?, RATE=?, CGST=?, SGST=?, CURRENT_QTY=? where PRODUCT_ID='"+Table_click+"' ";
        pst = con.prepareStatement(sql);
        
         pst.setString(1, ProductId);
         pst.setString(2, ProductName);
         pst.setString(3, Brand);
         pst.setString(4, HsnCode);
         pst.setString(5, Rate);
         pst.setString(6, Cgst);
         pst.setString(7, Sgst);
         pst.setString(8, avail_qty);
         pst.executeUpdate();
        JOptionPane.showMessageDialog(this,"PRODUCT DETAILS UPDATED");
        
        PRODUCT_ID_TEXT_FIELD.setText("");
        PRODUCT_NAME_TEXT_FIELD.setText("");
        PRODUCT_BRAND_TEXT_FIELD.setText("");
        HSN_CODE_TEXT_FIELD.setText("");
        PRODUCT_RATE_TEXT_FIELD.setText("");
        AVAILABLE_QTY_TEXT_FIELD.setText("");
        PRODUCT_CGST_COMBO_BOX.setSelectedIndex(0);
        PRODUCT_SGST_COMBO_BOX.setSelectedIndex(0);
        PRODUCT_ID_TEXT_FIELD.requestFocus();
        ProductLoadData();
        }
        
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"DATABASE LOCKED \nRETRY AGAIN");
        }
        
        finally
        {
            try
            {
                pst.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(this,"DATABASE NOT CLOSED PROPERLY \nRETRY AGAIN");
            }
        }
        ADD1.setEnabled(true);
    }
    private void DELETE1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DELETE1MouseMoved
        Cursor cur12 = new Cursor(Cursor.HAND_CURSOR);
        DELETE1.setCursor(cur12);
    }//GEN-LAST:event_DELETE1MouseMoved

    private void DELETE1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DELETE1MousePressed
        
        int row = PRODUCT_DETAILS_TABLE.getSelectedRow();
        String Table_click = (PRODUCT_DETAILS_TABLE.getModel().getValueAt(row,0).toString());
        
        try {
            
        //int ClientId = Integer.parseInt(Table_click);
        String ProductId = Table_click;
        
        String sql = "delete from PRODUCT_DETAILS where PRODUCT_ID=?";
        pst = con.prepareStatement(sql);
        
        pst.setString(1,ProductId);
       
        pst.executeUpdate();
        JOptionPane.showMessageDialog(this,"PRODUCT DETAILS DELETED");
        
        PRODUCT_ID_TEXT_FIELD.setText("");
        PRODUCT_NAME_TEXT_FIELD.setText("");
        PRODUCT_BRAND_TEXT_FIELD.setText("");
        HSN_CODE_TEXT_FIELD.setText("");
        PRODUCT_RATE_TEXT_FIELD.setText("");
        PRODUCT_CGST_COMBO_BOX.setSelectedIndex(0);
        PRODUCT_SGST_COMBO_BOX.setSelectedIndex(0);
        PRODUCT_ID_TEXT_FIELD.requestFocus();
        ProductLoadData();
        }
        
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"DATABASE LOCKED \nRETRY AGAIN");
        }
        
        finally
        {
            try
            {
                pst.close();
            }
            catch(SQLException e)
            {
               JOptionPane.showMessageDialog(this,"DATABASE NOT CLOSED PROPERLY \nRETRY AGAIN");
            }
        }
        ADD1.setEnabled(true);
    }//GEN-LAST:event_DELETE1MousePressed

    private void CANCEL1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CANCEL1MouseMoved
        Cursor cur13 = new Cursor(Cursor.HAND_CURSOR);
        CANCEL1.setCursor(cur13);
    }//GEN-LAST:event_CANCEL1MouseMoved

    private void CANCEL1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CANCEL1MousePressed
        
        PRODUCT_ID_TEXT_FIELD.setText("");
        PRODUCT_NAME_TEXT_FIELD.setText("");
        PRODUCT_BRAND_TEXT_FIELD.setText("");
        HSN_CODE_TEXT_FIELD.setText("");
        PRODUCT_RATE_TEXT_FIELD.setText("");
        PRODUCT_CGST_COMBO_BOX.setSelectedIndex(0);
        PRODUCT_SGST_COMBO_BOX.setSelectedIndex(0);
        PRODUCT_ID_TEXT_FIELD.requestFocus();
        ProductLoadData();
        ADD1.setEnabled(true);
        
    }//GEN-LAST:event_CANCEL1MousePressed

    private void ADD_ITEMMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD_ITEMMouseMoved
       Cursor cur14 = new Cursor(Cursor.HAND_CURSOR);
       ADD_ITEM.setCursor(cur14);
    }//GEN-LAST:event_ADD_ITEMMouseMoved

    private void REMOVE_ITEMMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REMOVE_ITEMMouseMoved
       Cursor cur15 = new Cursor(Cursor.HAND_CURSOR);
       REMOVE_ITEM.setCursor(cur15);
    }//GEN-LAST:event_REMOVE_ITEMMouseMoved

    private void SAVEMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SAVEMouseMoved
       Cursor cur16 = new Cursor(Cursor.HAND_CURSOR);
       SAVE.setCursor(cur16);
    }//GEN-LAST:event_SAVEMouseMoved

    private void PRINTMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRINTMouseMoved
       Cursor cur17 = new Cursor(Cursor.HAND_CURSOR);
       PRINT.setCursor(cur17);
    }//GEN-LAST:event_PRINTMouseMoved

    private void CLEARMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLEARMouseMoved
       Cursor cur18 = new Cursor(Cursor.HAND_CURSOR);
       CLEAR.setCursor(cur18);
    }//GEN-LAST:event_CLEARMouseMoved

    private void POS_PRODUCT_ID_TEXT_FIELDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_POS_PRODUCT_ID_TEXT_FIELDKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER )
        {
            try {
                ProductLoadData();
                String product_id = POS_PRODUCT_ID_TEXT_FIELD.getText();
                String sql = "select * from PRODUCT_DETAILS where PRODUCT_ID=?";
                pst = con.prepareStatement(sql);
                pst.setString(1, product_id);
                rs = pst.executeQuery();
                
                  if(rs.next() == false)
                  {
                      JOptionPane.showMessageDialog(this, "PRODUCT ID NOT FOUND", "WARNING", JOptionPane.WARNING_MESSAGE);
                      POS_PRODUCT_ID_TEXT_FIELD.setText("");
                      POS_PRODUCT_ID_TEXT_FIELD.requestFocus();
                  }
                  else
                  {
                      String productname = rs.getString("PRODUCT_NAME");
                      String productrate = rs.getString("RATE");
                      String qty_in_stock =rs.getString("CURRENT_QTY");
                      int temp_qty_in_stock = Integer.parseInt(qty_in_stock);
                      
                      POS_PRODUCT_NAME_TEXT_FIELD.setText(productname);
                      POS_RATE_TEXT_FIELD.setText(productrate);
                      if(temp_qty_in_stock <= 10)
                      {
                          QTY_IN_STOCK_INPUT.setForeground(new Color(255, 255, 0)); 
                          QTY_IN_STOCK_INPUT.setText(qty_in_stock);
                      }
                      else
                      {
                          QTY_IN_STOCK_INPUT.setForeground(Color.GREEN);
                          QTY_IN_STOCK_INPUT.setText(qty_in_stock);
                      }
                      
                      QTY_TEXT_FIELD.requestFocus();
                      
                  }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "INVALID ID/GSTIN \nKINDLY RECHECK", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        }
        POSShortcut(evt);
    }//GEN-LAST:event_POS_PRODUCT_ID_TEXT_FIELDKeyPressed

    private void ADD_ITEMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD_ITEMMousePressed
       
        PosAddMouse();
    }//GEN-LAST:event_ADD_ITEMMousePressed

    public void PosAddMouse()
    {
        DecimalFormat f = new DecimalFormat("##.00");
         try {
               
               String product_id = POS_PRODUCT_ID_TEXT_FIELD.getText();
               String sql = "select * from PRODUCT_DETAILS where PRODUCT_ID=?";
                pst = con.prepareStatement(sql);
                pst.setString(1, product_id);
                rs = pst.executeQuery(); 
            
                while(rs.next())
                {
                    int currentqty;
                    currentqty = rs.getInt("CURRENT_QTY");
                    //String temp_pid = product_id;
                    float price = Float.parseFloat(POS_RATE_TEXT_FIELD.getText());
                    int qty   = Integer.parseInt(QTY_TEXT_FIELD.getText());
                    float taxableamt = price*qty;
                
                    String productname = POS_PRODUCT_NAME_TEXT_FIELD.getText();
                    String hsncode = rs.getString("HSN_CODE");
                    String uom = (String)UOM_COMBO_BOX.getSelectedItem();
                
                    float cgst = Float.parseFloat(rs.getString("CGST"));
                    float cgstamt = taxableamt*(cgst/100);
                    float sgst = Float.parseFloat(rs.getString("SGST"));
                    float sgstamt = taxableamt*(sgst/100);
                
                    float total = taxableamt + cgstamt + sgstamt;
                
                    f.format(total);
                    //System.out.println(f.format(total));
                    
                    if(qty > currentqty)
                    {
                        
                        JOptionPane.showMessageDialog(this, " QUANTITY NOT ENOUGH \nKINDLY RELOAD THE STOCKS", "WARNING", JOptionPane.WARNING_MESSAGE);
                       
                        POS_PRODUCT_ID_TEXT_FIELD.setText("");
                        POS_PRODUCT_NAME_TEXT_FIELD.setText("");
                        POS_RATE_TEXT_FIELD.setText("");
                        QTY_TEXT_FIELD.setText("");
                        QTY_IN_STOCK_INPUT.setText("STOCK");
                        UOM_COMBO_BOX.setSelectedIndex(0);
                        POS_PRODUCT_ID_TEXT_FIELD.requestFocus();
                        ADD_ITEM.setEnabled(true);
                    }
                    else
                    {
                        df = (DefaultTableModel)POS_TABLE.getModel();
                        int a = POS_TABLE.getRowCount();
                       // System.out.println("no of rows= "+a);
                        if(a<12)
                        {
                            df.addRow(new Object[] 
                        {
                            product_id,
                            productname,
                            hsncode,
                            uom,
                            price,
                            qty,
                            f.format(taxableamt),
                            cgst,
                            f.format(cgstamt),
                            sgst,
                            f.format(sgstamt),
                            f.format(total)
                        });
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(this, "ONLY 12 ITEMS ARE ALLOWED", "WARNING", JOptionPane.WARNING_MESSAGE);
                        }
                        
                        
                }
                
                }
                try
                {
                    double temp_total;
                    temp_total = 0;
                    double temp_cgst = 0;
                    double temp_sgst = 0;
                    int temp_qty = 0;
                    double temp_tax_amount=0;
                    
                   
                    for(int i=0 ; i<POS_TABLE.getRowCount();i++)
                    {
                        double hai =Double.parseDouble(POS_TABLE.getValueAt(i, 11).toString());
                        temp_total =temp_total + hai;
                        
                        
                        double cgst_amount = Double.parseDouble(POS_TABLE.getValueAt(i, 8).toString());
                        temp_cgst = temp_cgst + cgst_amount;
                       
                        
                        double sgst_amount = Double.parseDouble(POS_TABLE.getValueAt(i, 10).toString());
                        temp_sgst =  temp_sgst + sgst_amount;
                        
                        
                        int total_quantity = Integer.parseInt(POS_TABLE.getValueAt(i, 5).toString());
                        temp_qty = temp_qty + total_quantity;
                       
                       
                        double total_tax_amount = Double.parseDouble(POS_TABLE.getValueAt(i, 6).toString());
                        temp_tax_amount = temp_tax_amount + total_tax_amount;
                        
                        
                        POS_TOTAL_TEXT_FIELD.setText(String.valueOf(f.format(temp_total)));
                        CGST_TOTAL_TEXT_FIELD.setText(String.valueOf( f.format(temp_cgst)));
                        SGST_TOTAL_TEXT_FIELD.setText(String.valueOf(f.format(temp_sgst)));
                        TAX_VALUE_TEXT_FIELD.setText(String.valueOf(f.format(temp_tax_amount)));
                        TOTAL_QTY_TEXT_FIELD.setText(String.valueOf(temp_qty));
                        
                        String temp_round = POS_TOTAL_TEXT_FIELD.getText();
                        double original_round = Double.parseDouble(temp_round);
                        
                        ROUND_INPUT.setText(String.valueOf(Math.round(original_round)));
                        
                        POS_PRODUCT_ID_TEXT_FIELD.setText("");
                        POS_PRODUCT_NAME_TEXT_FIELD.setText("");
                        POS_RATE_TEXT_FIELD.setText("");
                        QTY_TEXT_FIELD.setText("");
                        QTY_IN_STOCK_INPUT.setText("STOCK");
                        UOM_COMBO_BOX.setSelectedIndex(0);
                        POS_PRODUCT_ID_TEXT_FIELD.requestFocus();
                    }
             
                    String sql2 = "UPDATE PRODUCT_DETAILS SET CURRENT_QTY = CURRENT_QTY-? WHERE PRODUCT_ID=?";
                    pst1 = con.prepareStatement(sql2);
             
                    for(int i=0; i<POS_TABLE.getRowCount();i++)
                    {
                        String p_id = (String) POS_TABLE.getValueAt(i, 0) ;
                        int q_ty = (int) POS_TABLE.getValueAt(i, 5) ;
                
                        pst1.setInt(1, q_ty);
                        pst1.setString(2, p_id);

                    }
                    pst1.executeUpdate();   
                }
                catch(NumberFormatException e )
                {
                    JOptionPane.showMessageDialog(this, "FORMAT CONVERSION ERROR", "WARNING", JOptionPane.WARNING_MESSAGE);
                }

        } 
        
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "KINDLY RECHECK YOUR PRODUCT ID", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
        
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(this,"DATABASE NOT CLOSED PROPERLY \nRETRY AGAIN");
            }
        }
    }
    private void CLEARMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLEARMousePressed
        
        POSCLEAR();
    }//GEN-LAST:event_CLEARMousePressed

    private void REMOVE_ITEMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REMOVE_ITEMMousePressed
        
        POSREMOVE();
    }//GEN-LAST:event_REMOVE_ITEMMousePressed

    private void PRINTMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRINTMousePressed
        
       POSPRINT();
    }//GEN-LAST:event_PRINTMousePressed

    public void POSREMOVE()
    {
        df = (DefaultTableModel)POS_TABLE.getModel();
        if(POS_TABLE.getSelectedRow() != -1) {
               
              
            try {
                int row = POS_TABLE.getSelectedRow();                                     
                int Table_click_qty = (int)POS_TABLE.getModel().getValueAt(row,5); 
                String Table_click_pid = (POS_TABLE.getModel().getValueAt(row,0).toString());
               
                String sql2 = "UPDATE PRODUCT_DETAILS SET CURRENT_QTY = CURRENT_QTY+? WHERE PRODUCT_ID=?";
                pst1 = con.prepareStatement(sql2);
               
                pst1.setInt(1, Table_click_qty);
                pst1.setString(2, Table_click_pid);
                
                pst1.executeUpdate();
               
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,"DATABASE LOCKED \nRETRY AGAIN");
            }
           
            df.removeRow(POS_TABLE.getSelectedRow());
            JOptionPane.showMessageDialog(null, "SUCCESSFULLY REMOVED THE ROW");
            }
        else
        {
            JOptionPane.showMessageDialog(null, "SELECT A ROW FIRST", "FACT", JOptionPane.WARNING_MESSAGE);
        }
         
    }
    public void POSPRINT()
    {
        DecimalFormat f = new DecimalFormat("##.00");
         String cgst_amount =  CGST_TOTAL_TEXT_FIELD.getText();
        String sgst_amount =  SGST_TOTAL_TEXT_FIELD.getText();
        String total_amount = POS_TOTAL_TEXT_FIELD.getText();
        String total_qty = TOTAL_QTY_TEXT_FIELD.getText();
        String total_tax = TAX_VALUE_TEXT_FIELD.getText();
        double temp_round_total = Double.parseDouble(total_amount);
        double orginal_round_total = Math.round(temp_round_total);
        String round = String.valueOf(f.format(orginal_round_total));
       
        //System.out.println(round);
        //String round_total = String.valueOf(orginal_round_total);
        String invoice_no = INVOICE_NO_TEXT_FIELD.getText();
        String date = ((JTextField)DATE_CHOOSER.getDateEditor().getUiComponent()).getText();
        String shopname_ref = CLIENT_NAME_REFERENCE_INPUT.getText();
        String gstin_ref = POS_GSTIN_INPUT.getText();
        String address_ref = POS_CLIENT_ADDRESS_INPUT.getText();
        String amt_words = AMT_IN_WORDS_INPUT_TEXT_FIELD.getText();
        
     
        PRINT_BILL print_bill = new PRINT_BILL(invoice_no,date,cgst_amount,sgst_amount,total_amount,total_qty,total_tax,round,shopname_ref,gstin_ref,address_ref,amt_words);
        
    }
    
    public void POSCLEARALL()
    {
         CLIENT_NAME_REFERENCE_INPUT.setText("");
        POS_GSTIN_INPUT.setText("");
        POS_CLIENT_ADDRESS_INPUT.setText("");
        POS_PRODUCT_ID_TEXT_FIELD.setText("");
        POS_PRODUCT_NAME_TEXT_FIELD.setText("");
        POS_RATE_TEXT_FIELD.setText("");
        QTY_TEXT_FIELD.setText("");
        UOM_COMBO_BOX.setSelectedIndex(0);
        AMT_IN_WORDS_INPUT_TEXT_FIELD.setText("");
        TOTAL_QTY_TEXT_FIELD.setText("");
        TAX_VALUE_TEXT_FIELD.setText("");
        SGST_TOTAL_TEXT_FIELD.setText("");
        CGST_TOTAL_TEXT_FIELD.setText("");
        POS_TOTAL_TEXT_FIELD.setText("");
        DATE_CHOOSER.setCalendar(null);
        INVOICE_NO_TEXT_FIELD.setText("");
        POS_CLIENT_NAME_TEXT_FIELD.setText("");
        
        df = (DefaultTableModel)POS_TABLE.getModel();
        int rowcount = df.getRowCount();
        for(int i = rowcount - 1; i >= 0; i--)
        {
            df.removeRow(i);
        }

        POS_CLIENT_NAME_TEXT_FIELD.requestFocus();
    }
    
    public void POSCLEAR()
    {
        POS_PRODUCT_ID_TEXT_FIELD.setText("");
        POS_PRODUCT_NAME_TEXT_FIELD.setText("");
        POS_RATE_TEXT_FIELD.setText("");
        QTY_TEXT_FIELD.setText("");
        UOM_COMBO_BOX.setSelectedIndex(0);
       
    }
     public static final String[] units = { "","ONE","TWO","THREE","FOUR",
            "FIVE","SIX","SEVEN","EIGHT","NINE","TEN","ELEVEN","TWELVE","THIRTEEN",
            "FOURTEEN","FIFTEEN","SIXTEEN","SEVENTEEN","EIGHTEEN","NINETEEN" };

    public static final String[] tens = { "","","TWENTY","THIRTY","FOURTY",
            "FIFTY","SIXTY","SEVENTY","EIGHTY","NINETY" };

    public static String convert(final int n)
    {
        if(n < 0)
        {
            return "Minus" + convert(-n);
        }
        if(n < 20)
        {
            return units[n];
        }
        if(n < 100)
        {
            return tens[n / 10] + (( n % 10 != 0) ? " " : "") + units[n % 10];
        }
        if(n < 1000)
        {
            return units[n / 100] + " HUNDRED AND " + (( n % 100 != 0) ? " " : "") + convert(n % 100);
        }
        if(n < 100000)
        {
            return convert(n / 1000) + " THOUSAND" + (( n % 100000 != 0) ? " " : "") + convert(n % 1000);
        }
        if(n < 1000000)
        {
            return convert(n / 100000) + " LAKH" + (( n % 1000000 != 0) ? " " : "") + convert(n % 100000);
        }
        return convert(n / 10000000) + " CRORE" + (( n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
    }
    
    private void SAVEMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SAVEMousePressed
        POSSAVE();
    }//GEN-LAST:event_SAVEMousePressed

    public void POSSAVE()
    {
         try{
            DecimalFormat f = new DecimalFormat("##.00");
            String sql = "INSERT INTO DAILY_BILL(INVOICE_NO,DATE,SHOP_ID,SHOP_NAME,SHOP_GSTIN,SNO,PDT_DESC,HSN_CODE,UOM,QTY,RATE,TAXABLE_VALUE,DISCOUNT,CGST_RATE,CGST_AMOUNT,SGST_RATE,SGST_AMOUNT,TOTAL_AMOUNT,RECORD_GST,RECORD_GST_AMOUNT)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            
            for(int i = 0; i < POS_TABLE.getRowCount(); i++)
            {
                int sno = i + 1;
                String Sno = String.valueOf(sno);
                String prod_desc = (String) POS_TABLE.getValueAt(i, 1);
                String hsn = (String) POS_TABLE.getValueAt(i, 2);
                String unit = (String) POS_TABLE.getValueAt(i, 3);
                int temp_qty = Integer.parseInt(POS_TABLE.getValueAt(i, 5).toString());
                String qty = String.valueOf(temp_qty);
                double temp_rate = Double.parseDouble(POS_TABLE.getValueAt(i, 4).toString());
                String rate = String.valueOf(temp_rate);
                double temp_val_tax = Double.parseDouble(POS_TABLE.getValueAt(i, 6).toString());
                String val_tax = String.valueOf(temp_val_tax);
                String discount = " ";
                double temp_rate_cgst = Double.parseDouble(POS_TABLE.getValueAt(i, 7).toString());
                String rate_cgst = String.valueOf(temp_rate_cgst);
                double temp_amount_cgst = Double.parseDouble(POS_TABLE.getValueAt(i, 8).toString());
                String amount_cgst = String.valueOf(temp_amount_cgst);
                double temp_rate_sgst = Double.parseDouble(POS_TABLE.getValueAt(i, 9).toString());
                String rate_sgst = String.valueOf(temp_rate_sgst);
                double temp_amount_sgst = Double.parseDouble(POS_TABLE.getValueAt(i, 10).toString());
                String amount_sgst = String.valueOf(temp_amount_sgst);
                double temp_amount_total = Double.parseDouble(POS_TABLE.getValueAt(i, 11).toString());
                String amount_total = String.valueOf(f.format(temp_amount_total));
                
                double rec_rate_gst = temp_rate_cgst + temp_rate_sgst;
                int record_rate_gst  = (int) rec_rate_gst;
               // String record_rate_gst = String.valueOf(temp_rec_rate_gst);
                
                double rec_amount_gst = temp_amount_cgst + temp_amount_sgst;
                String record_amount_gst = String.valueOf(rec_amount_gst);
                
                String temp_shop_name = CLIENT_NAME_REFERENCE_INPUT.getText();
                String temp_shop_gstin = POS_GSTIN_INPUT.getText();
                String shop_id = POS_CLIENT_NAME_TEXT_FIELD.getText();
            
                //System.out.println(rec_rate_gst + "       " + rec_amount_gst);
                pst.setString(1,INVOICE_NO_TEXT_FIELD.getText());
                pst.setString(2, ((JTextField)DATE_CHOOSER.getDateEditor().getUiComponent()).getText());
                pst.setString(3, shop_id);
                pst.setString(4, temp_shop_name);
                pst.setString(5, temp_shop_gstin);
                pst.setString(6, Sno);
                pst.setString(7, prod_desc);
                pst.setString(8, hsn);
                pst.setString(9, unit);
                pst.setString(10, qty);
                pst.setString(11, rate);
                pst.setString(12, val_tax);
                pst.setString(13, discount);
                pst.setString(14, rate_cgst);
                pst.setString(15, amount_cgst);
                pst.setString(16, rate_sgst);
                pst.setString(17, amount_sgst);
                pst.setString(18, amount_total);
                pst.setInt(19, record_rate_gst);
                pst.setString(20, record_amount_gst);
                pst.executeUpdate();       
             }
             JOptionPane.showMessageDialog(this,"BILL SAVED");
             double tot = Double.parseDouble(ROUND_INPUT.getText());
             int int_tot = (int) tot;
//             System.out.println(convert(int_tot));
             String c = "RUPEES " + convert(int_tot) + " ONLY";
             AMT_IN_WORDS_INPUT_TEXT_FIELD.setText(c);
             
             } 
        catch(HeadlessException e)
        {
             JOptionPane.showMessageDialog(this, "ANY ONE OF YOUR INPUT DEVICE IS MALFUNCTIONING", "ERROR", JOptionPane.WARNING_MESSAGE); 
        }
        catch(NumberFormatException e)
        {
             JOptionPane.showMessageDialog(this, "FORMAT CONVERSION ERROR", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,"DATABASE LOCKED \nRETRY AGAIN");
        }
         finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(SQLException e)
            {
               JOptionPane.showMessageDialog(this,"DATABASE NOT CLOSED PROPERLY \nRETRY AGAIN");
            }
        }
    }
       
    private void POS_CLIENT_NAME_TEXT_FIELDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_POS_CLIENT_NAME_TEXT_FIELDKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER )
        {
            try {
                
                String client_id = POS_CLIENT_NAME_TEXT_FIELD.getText();
                String sql = "select * from CLIENT_DETAILS where CLIENT_ID=?";
                pst = con.prepareStatement(sql);
                pst.setString(1, client_id);
                rs = pst.executeQuery();
                
                  if(rs.next() == false)
                  {
                      JOptionPane.showMessageDialog(this, "CLIENT ID NOT FOUND", "WARNING", JOptionPane.WARNING_MESSAGE);
                  }
                  else
                  {
                      String shopname = rs.getString("SHOP_NAME");
                      String gstin = rs.getString("GSTIN");
                      String address = rs.getString("ADDRESS");
                      
                      CLIENT_NAME_REFERENCE_INPUT.setText(shopname);
                      POS_CLIENT_ADDRESS_INPUT.setText(address);
                      POS_GSTIN_INPUT.setText(gstin);
                      INVOICE_NO_TEXT_FIELD.requestFocus();
                      
                  }
            } 
            catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(this, "INVALID ID/GSTIN \nKINDLY RECHECK", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        POSShortcut(evt);
    }//GEN-LAST:event_POS_CLIENT_NAME_TEXT_FIELDKeyPressed

    private void CLEAR_ALLMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLEAR_ALLMouseMoved
        
       Cursor cur19 = new Cursor(Cursor.HAND_CURSOR);
       CLEAR_ALL.setCursor(cur19);
    }//GEN-LAST:event_CLEAR_ALLMouseMoved

    private void CLEAR_ALLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLEAR_ALLMousePressed
       
       POSCLEARALL();
    }//GEN-LAST:event_CLEAR_ALLMousePressed

    private void TAB5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TAB5MouseMoved
       Cursor cur20 = new Cursor(Cursor.HAND_CURSOR);
       TAB5.setCursor(cur20);
    }//GEN-LAST:event_TAB5MouseMoved

    private void REPORTSMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REPORTSMouseMoved
       Cursor cur21 = new Cursor(Cursor.HAND_CURSOR);
       REPORTS.setCursor(cur21);
    }//GEN-LAST:event_REPORTSMouseMoved

    private void TAB5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TAB5MousePressed
        JP1.setVisible(false);
        JP2.setVisible(false);
        JP3.setVisible(false);
        JP4.setVisible(true);
        setcolor(TAB5);
        resetcolor(TAB2);
        resetcolor(TAB3);
        resetcolor(TAB4);
        resetcolor(TAB1);
    }//GEN-LAST:event_TAB5MousePressed

    private void REPORTSMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REPORTSMousePressed
        JP1.setVisible(false);
        JP2.setVisible(false);
        JP3.setVisible(false);
        JP4.setVisible(true);
        setcolor(TAB5);
        resetcolor(TAB2);
        resetcolor(TAB3);
        resetcolor(TAB4);
        resetcolor(TAB1);
    }//GEN-LAST:event_REPORTSMousePressed

    private void PROCEEDMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PROCEEDMouseMoved
        Cursor cur22 = new Cursor(Cursor.HAND_CURSOR);
       PROCEED.setCursor(cur22);
    }//GEN-LAST:event_PROCEEDMouseMoved

    private void PROCEEDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PROCEEDMousePressed
       
        try
        {
           String FROM_DATE_TEMP = ((JTextField)FROM_DATE_CHOOSER.getDateEditor().getUiComponent()).getText();
           String TO_DATE_TEMP   = ((JTextField)TO_DATE_CHOOSER.getDateEditor().getUiComponent()).getText();
           String CID_TEMP = REPORT_CLIENT_ID_TEXT_FIELD.getText();
//           System.out.println(CID_TEMP);
//           System.out.println(TO_DATE_TEMP);
           
           String sql = "SELECT INVOICE_NO,SHOP_NAME,SHOP_GSTIN,DATE,RECORD_GST,SUM(RECORD_GST_AMOUNT) AS AMOUNT FROM DAILY_BILL  WHERE DATE BETWEEN ? AND ? AND SHOP_ID=? GROUP BY RECORD_GST,DATE ORDER BY DATE,RECORD_GST" ;
           pst = con.prepareStatement(sql);
           pst.setString(1, FROM_DATE_TEMP);
           pst.setString(2, TO_DATE_TEMP);
           pst.setString(3, CID_TEMP);
           rs = pst.executeQuery();
           
           ResultSetMetaData metadata = rs.getMetaData();
            df = (DefaultTableModel)REPORT_TABLE.getModel();
            int a = metadata.getColumnCount();
            DecimalFormat f = new DecimalFormat("##.00");
            while(rs.next())
            {
                Vector v1 = new Vector();
                for(int i=1;i<=a;i++)
                {
                    v1.add(rs.getString("SHOP_GSTIN"));
                    v1.add(rs.getString("SHOP_NAME"));
                    v1.add(rs.getString("INVOICE_NO"));
                    v1.add(rs.getString("DATE"));
                    
                    String temp_tax_amt=rs.getString("AMOUNT");
                    Double tax_amt = Double.parseDouble(temp_tax_amt);
                    v1.add(f.format(tax_amt));
                    
                    String gst_percentage = rs.getString("RECORD_GST") + "%";
                    v1.add(gst_percentage);
                    String temp_gst_percentage = rs.getString("RECORD_GST");
                    //double temp_tax_amount = Double.parseDouble(tax_amt);
                    double half_percentage = (Double.parseDouble(temp_gst_percentage))/2;
                    double tax_cgst_amt = tax_amt * (half_percentage / 100);
                    double tax_sgst_amt = tax_amt * (half_percentage / 100);
                    double total = tax_amt + tax_cgst_amt + tax_sgst_amt;
                    
                    v1.add(f.format(tax_cgst_amt));
                    v1.add(f.format(tax_sgst_amt));
                    v1.add(f.format(total));
                    
                }
                df.addRow(v1);
                
                
                
            }
            FROM_DATE_CHOOSER.setCalendar(null);
            TO_DATE_CHOOSER.setCalendar(null);
            REPORT_CLIENT_ID_TEXT_FIELD.setText("");
            
             
        }
        catch(NumberFormatException e)
        {
             JOptionPane.showMessageDialog(this, "FORMAT CONVERSION ERROR", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,"DATABASE LOCKED \nRETRY AGAIN");
        }
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(SQLException e)
            {
               JOptionPane.showMessageDialog(this,"DATABASE NOT CLOSED PROPERLY \nRETRY AGAIN");
            }
        }
    }//GEN-LAST:event_PROCEEDMousePressed

    private void REPORTS_CLEARMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REPORTS_CLEARMouseMoved
        Cursor cur23 = new Cursor(Cursor.HAND_CURSOR);
       REPORTS_CLEAR.setCursor(cur23);
    }//GEN-LAST:event_REPORTS_CLEARMouseMoved

    private void REPORTS_PRINT_PANELMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REPORTS_PRINT_PANELMouseMoved
        
        Cursor cur24 = new Cursor(Cursor.HAND_CURSOR);
        REPORTS_PRINT_PANEL.setCursor(cur24);
    }//GEN-LAST:event_REPORTS_PRINT_PANELMouseMoved

    private void REPORTS_CLEAR_PANELMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REPORTS_CLEAR_PANELMouseMoved
        
        Cursor cur25 = new Cursor(Cursor.HAND_CURSOR);
        REPORTS_CLEAR_PANEL.setCursor(cur25);
    }//GEN-LAST:event_REPORTS_CLEAR_PANELMouseMoved

    private void REPORTS_PRINTMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REPORTS_PRINTMouseMoved
        
        Cursor cur26 = new Cursor(Cursor.HAND_CURSOR);
        REPORTS_PRINT.setCursor(cur26);
    }//GEN-LAST:event_REPORTS_PRINTMouseMoved

    private void REPORTS_SAVEMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REPORTS_SAVEMouseMoved
        
        Cursor cur27 = new Cursor(Cursor.HAND_CURSOR);
        REPORTS_SAVE.setCursor(cur27);
    }//GEN-LAST:event_REPORTS_SAVEMouseMoved

    private void REPORTS_SAVE_PANELMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REPORTS_SAVE_PANELMouseDragged
        Cursor cur28 = new Cursor(Cursor.HAND_CURSOR);
        REPORTS_SAVE_PANEL.setCursor(cur28);
    }//GEN-LAST:event_REPORTS_SAVE_PANELMouseDragged

    private void REPORTS_SAVEMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REPORTS_SAVEMousePressed
        
        try{
            
            String sql2 = "INSERT INTO REPORTS(GSTIN,SHOP_NAME,INVOICE_NO,DATE,AMOUNT,PERCENTAGE,CGST,SGST,TOTAL)VALUES(?,?,?,?,?,?,?,?,?)";
            pst1 = con.prepareStatement(sql2);
             
            for(int i=0; i<REPORT_TABLE.getRowCount();i++)
            {
                String gstin = (String) REPORT_TABLE.getValueAt(i, 0) ;
                String shop_name = (String)REPORT_TABLE.getValueAt(i, 1) ;
                String invoice_no = (String)REPORT_TABLE.getValueAt(i, 2) ;
                String date = (String)REPORT_TABLE.getValueAt(i, 3) ;
                String amount = (String)REPORT_TABLE.getValueAt(i, 4) ;
                String percentage = (String)REPORT_TABLE.getValueAt(i, 5) ;
                String cgst = (String)REPORT_TABLE.getValueAt(i, 6) ;
                String sgst = (String)REPORT_TABLE.getValueAt(i, 7) ;
                String total = (String)REPORT_TABLE.getValueAt(i, 8) ;
                
                pst1.setString(1, gstin);
                pst1.setString(2, shop_name);
                pst1.setString(3, invoice_no);
                pst1.setString(4, date);
                pst1.setString(5, amount);
                pst1.setString(6, percentage);
                pst1.setString(7, cgst);
                pst1.setString(8, sgst);
                pst1.setString(9, total);
                pst1.executeUpdate();
            }
            JOptionPane.showMessageDialog(this,"REPORTS SAVED");
        }
        catch(HeadlessException e)
        {
             JOptionPane.showMessageDialog(this, "ANY ONE OF YOUR INPUT DEVICE IS MALFUNCTIONING", "ERROR", JOptionPane.WARNING_MESSAGE); 
        }
        catch(NumberFormatException e)
        {
             JOptionPane.showMessageDialog(this, "FORMAT CONVERSION ERROR", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,"DATABASE LOCKED \nRETRY AGAIN");
        }
        
    }//GEN-LAST:event_REPORTS_SAVEMousePressed

    private void REPORTS_PRINTMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REPORTS_PRINTMousePressed
        
        MessageFormat header = new MessageFormat("REPORTS");
        MessageFormat footer = new MessageFormat("Page {0,number,integer}");
        try
        {
            REPORT_TABLE.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }
        catch(PrinterException e)
        {
            JOptionPane.showMessageDialog(this, "PRINTER ERROR \nRETRY AGAIN", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_REPORTS_PRINTMousePressed

    private void REPORTS_CLEARMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REPORTS_CLEARMousePressed
       
        REPORT_CLIENT_ID_TEXT_FIELD.setText("");
        FROM_DATE_CHOOSER.setCalendar(null);
        TO_DATE_CHOOSER.setCalendar(null);
                
        df = (DefaultTableModel)REPORT_TABLE.getModel();
        int rowcount = df.getRowCount();
        for(int i = rowcount - 1; i >= 0; i--)
        {
            df.removeRow(i);
        }
    }//GEN-LAST:event_REPORTS_CLEARMousePressed

    private void GENERATEMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GENERATEMouseMoved
       
        Cursor cur29 = new Cursor(Cursor.HAND_CURSOR);
        GENERATE.setCursor(cur29);
    }//GEN-LAST:event_GENERATEMouseMoved

    private void GENERATEMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GENERATEMousePressed
        
        try {
            
            String FROM_DATE_DAILY = ((JTextField)FROM_DATE_CHOOSER1.getDateEditor().getUiComponent()).getText();
            String TO_DATE_DAILY   = ((JTextField)TO_DATE_CHOOSER1.getDateEditor().getUiComponent()).getText();
            String CLIENT_ID_DAILY = REPORT_CLIENT_ID_TEXT_FIELD1.getText();
            if(FROM_DATE_DAILY.equals("") && TO_DATE_DAILY.equals("") && CLIENT_ID_DAILY.equals(""))
            {
                String sql = "select * from DAILY_BILL";
                pst = con.prepareStatement(sql); 
            }
             
            else if(!"".equals(CLIENT_ID_DAILY) && FROM_DATE_DAILY.equals("") && TO_DATE_DAILY.equals(""))
            {
                    String sql = "select * from DAILY_BILL where SHOP_ID=? ORDER BY DATE";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, CLIENT_ID_DAILY);
            } 
            else if(!"".equals(FROM_DATE_DAILY) && !"".equals(TO_DATE_DAILY))
            {
                if(CLIENT_ID_DAILY.equals(""))
                {
                    String sql = "select * from DAILY_BILL where DATE BETWEEN ? AND ? ORDER BY DATE";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, FROM_DATE_DAILY);
                    pst.setString(2, TO_DATE_DAILY);
                   
                }
                
                else
                {
                    String sql = "select * from DAILY_BILL where DATE BETWEEN ? AND ? AND SHOP_ID=? ORDER BY DATE";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, FROM_DATE_DAILY);
                    pst.setString(2, TO_DATE_DAILY);
                    pst.setString(3, CLIENT_ID_DAILY);
                }
                    
                
            }
            rs = pst.executeQuery();
            ResultSetMetaData metadata = rs.getMetaData();
            int a = metadata.getColumnCount();
            df = (DefaultTableModel)DAILY_BILL_TABLE.getModel();
            df.setRowCount(0);
            while(rs.next())
            {
                Vector v1 = new Vector();
                for(int i=1;i<=a;i++)
                {
                    v1.add(rs.getString("INVOICE_NO"));
                    v1.add(rs.getString("DATE"));
                    v1.add(rs.getString("SHOP_NAME"));
                    v1.add(rs.getString("SHOP_GSTIN"));
                    v1.add(rs.getString("PDT_DESC"));
                    v1.add(rs.getString("HSN_CODE"));
                    v1.add(rs.getString("UOM"));
                    v1.add(rs.getString("QTY"));
                    v1.add(rs.getString("RATE"));
                    v1.add(rs.getString("TAXABLE_VALUE"));
                    v1.add(rs.getString("RECORD_GST"));
                    v1.add(rs.getString("RECORD_GST_AMOUNT"));
                    v1.add(rs.getString("TOTAL_AMOUNT"));
                }
                
                df.addRow(v1);
            }
            
        } 
        
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(this,"DATABASE LOCKED \nRETRY AGAIN");
        }
        
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(this,"DATABASE NOT CLOSED PROPERLY \nRETRY AGAIN");
            }
        }
    }//GEN-LAST:event_GENERATEMousePressed

    private void REPORTS_PRINT1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REPORTS_PRINT1MouseMoved
        Cursor cur30 = new Cursor(Cursor.HAND_CURSOR);
        REPORTS_PRINT1.setCursor(cur30);
    }//GEN-LAST:event_REPORTS_PRINT1MouseMoved

    private void REPORTS_PRINT1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REPORTS_PRINT1MousePressed
        
        MessageFormat header = new MessageFormat("DAILY REPORTS");
        MessageFormat footer = new MessageFormat("Page {0,number,integer}");
        try
        {
            DAILY_BILL_TABLE.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }
        catch(PrinterException e)
        {
            JOptionPane.showMessageDialog(this, "PRINTER ERROR \nRETRY AGAIN", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_REPORTS_PRINT1MousePressed

    private void REPORTS_PRINT_PANEL1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REPORTS_PRINT_PANEL1MouseMoved
        Cursor cur31 = new Cursor(Cursor.HAND_CURSOR);
        REPORTS_PRINT_PANEL1.setCursor(cur31);
    }//GEN-LAST:event_REPORTS_PRINT_PANEL1MouseMoved

    private void REPORTS_CLEAR1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REPORTS_CLEAR1MouseMoved
        Cursor cur32 = new Cursor(Cursor.HAND_CURSOR);
        REPORTS_CLEAR1.setCursor(cur32);
    }//GEN-LAST:event_REPORTS_CLEAR1MouseMoved

    private void REPORTS_CLEAR1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REPORTS_CLEAR1MousePressed
        REPORT_CLIENT_ID_TEXT_FIELD1.setText("");
        FROM_DATE_CHOOSER1.setCalendar(null);
        TO_DATE_CHOOSER1.setCalendar(null);
                
        df = (DefaultTableModel)DAILY_BILL_TABLE.getModel();
        int rowcount = df.getRowCount();
        for(int i = rowcount - 1; i >= 0; i--)
        {
            df.removeRow(i);
        }
    }//GEN-LAST:event_REPORTS_CLEAR1MousePressed

    private void REPORTS_CLEAR_PANEL1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REPORTS_CLEAR_PANEL1MouseMoved
        Cursor cur33 = new Cursor(Cursor.HAND_CURSOR);
        REPORTS_CLEAR_PANEL1.setCursor(cur33);
    }//GEN-LAST:event_REPORTS_CLEAR_PANEL1MouseMoved

    private void QTY_TEXT_FIELDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QTY_TEXT_FIELDKeyPressed
        
         if(evt.getKeyCode() == KeyEvent.VK_ENTER )
        {
            PosAddMouse();
        }
        POSShortcut(evt);
        
    }//GEN-LAST:event_QTY_TEXT_FIELDKeyPressed

    public void POSShortcut(java.awt.event.KeyEvent evt)
    {
         if(evt.isControlDown()&& evt.getKeyCode() == KeyEvent.VK_S )
            {
                POSSAVE();
            }
         else if(evt.isControlDown()&& evt.getKeyCode() == KeyEvent.VK_P )
            {
                 POSPRINT();
            }
         else if(evt.isControlDown()&& evt.getKeyCode() == KeyEvent.VK_X )
            {
                 POSREMOVE();
            }
         else if(evt.isControlDown()&& evt.getKeyCode() == KeyEvent.VK_Z )
            {
                 POSCLEAR();
            }
         else if(evt.isControlDown()&& evt.getKeyCode() == KeyEvent.VK_A )
            {
                 POSCLEARALL();
            }
         else if(evt.isControlDown()&& evt.getKeyCode() == KeyEvent.VK_D )
            {
                 CANCELBILL();
            }
    }
    private void CLIENT_DETAILS_PRINT_DATAMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLIENT_DETAILS_PRINT_DATAMouseMoved
       
        Cursor cur34 = new Cursor(Cursor.HAND_CURSOR);
        CLIENT_DETAILS_PRINT_DATA.setCursor(cur34);
    }//GEN-LAST:event_CLIENT_DETAILS_PRINT_DATAMouseMoved

    private void CLIENT_DETAILS_PRINT_DATAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLIENT_DETAILS_PRINT_DATAMousePressed
        
        MessageFormat header = new MessageFormat("CLIENT DETAILS");
        MessageFormat footer = new MessageFormat("Page {0,number,integer}");
        try
        {
            CLIENT_DETAILS_TABLE.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }
        catch(PrinterException e)
        {
            JOptionPane.showMessageDialog(this, "PRINTER ERROR \nRETRY AGAIN", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_CLIENT_DETAILS_PRINT_DATAMousePressed

    private void CLIENT_DETAILS_PRINT_DATA_PANELMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLIENT_DETAILS_PRINT_DATA_PANELMouseMoved
        
        Cursor cur35 = new Cursor(Cursor.HAND_CURSOR);
        CLIENT_DETAILS_PRINT_DATA_PANEL.setCursor(cur35);
    }//GEN-LAST:event_CLIENT_DETAILS_PRINT_DATA_PANELMouseMoved

    private void PRODUCT_DETAILS_PRINT_DATA_PANELMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRODUCT_DETAILS_PRINT_DATA_PANELMouseMoved

        Cursor cur37 = new Cursor(Cursor.HAND_CURSOR);
        PRODUCT_DETAILS_PRINT_DATA_PANEL.setCursor(cur37);
    }//GEN-LAST:event_PRODUCT_DETAILS_PRINT_DATA_PANELMouseMoved

    private void PRODUCT_DETAILS_PRINT_DATAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRODUCT_DETAILS_PRINT_DATAMousePressed

        MessageFormat header = new MessageFormat("PRODUCT DETAILS");
        MessageFormat footer = new MessageFormat("Page {0,number,integer}");
        try
        {
            PRODUCT_DETAILS_TABLE.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }
        catch(PrinterException e)
        {
            JOptionPane.showMessageDialog(this, "PRINTER ERROR \nRETRY AGAIN", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_PRODUCT_DETAILS_PRINT_DATAMousePressed

    private void PRODUCT_DETAILS_PRINT_DATAMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRODUCT_DETAILS_PRINT_DATAMouseMoved

        Cursor cur36 = new Cursor(Cursor.HAND_CURSOR);
        PRODUCT_DETAILS_PRINT_DATA.setCursor(cur36);
    }//GEN-LAST:event_PRODUCT_DETAILS_PRINT_DATAMouseMoved

    private void INVOICE_NO_TEXT_FIELDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_INVOICE_NO_TEXT_FIELDKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER )
        {
            DATE_CHOOSER.getDateEditor().getUiComponent().requestFocusInWindow();
        }
        POSShortcut(evt);
    }//GEN-LAST:event_INVOICE_NO_TEXT_FIELDKeyPressed

    //CLIENT MOUSE ENTER KEY PRESSED
    private void CLIENT_ID_TEXT_FIELDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CLIENT_ID_TEXT_FIELDKeyPressed
        
         if(evt.getKeyCode() == KeyEvent.VK_ENTER )
        {
            CLIENT_SHOPNAME_TEXT_FIELD.requestFocus();
        }
    }//GEN-LAST:event_CLIENT_ID_TEXT_FIELDKeyPressed

    private void CLIENT_ADDRESS_TEXT_FIELDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CLIENT_ADDRESS_TEXT_FIELDKeyPressed
        
        if(evt.isControlDown()&& evt.getKeyCode() == KeyEvent.VK_ENTER )
        {
            GSTIN_TEXT_FIELD.requestFocus();
        }
        
    }//GEN-LAST:event_CLIENT_ADDRESS_TEXT_FIELDKeyPressed

    private void CLIENT_SHOPNAME_TEXT_FIELDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CLIENT_SHOPNAME_TEXT_FIELDKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER )
        {
            CLIENT_ADDRESS_TEXT_FIELD.requestFocus();
        }
    }//GEN-LAST:event_CLIENT_SHOPNAME_TEXT_FIELDKeyPressed

    private void GSTIN_TEXT_FIELDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GSTIN_TEXT_FIELDKeyPressed
       
        if(evt.getKeyCode() == KeyEvent.VK_ENTER )
        {
            CLIENT_PHONE_NO_TEXT_FIELD.requestFocus();
        }
        
    }//GEN-LAST:event_GSTIN_TEXT_FIELDKeyPressed

    private void CLIENT_PHONE_NO_TEXT_FIELDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CLIENT_PHONE_NO_TEXT_FIELDKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER )
        {
            CLIENT_DISTRICT_TEXT_FIELD.requestFocus();
        }
    }//GEN-LAST:event_CLIENT_PHONE_NO_TEXT_FIELDKeyPressed

    private void CLIENT_DISTRICT_TEXT_FIELDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CLIENT_DISTRICT_TEXT_FIELDKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER )
        {
            CLIENT_STATE_TEXT_FIELD.requestFocus();
        }
    }//GEN-LAST:event_CLIENT_DISTRICT_TEXT_FIELDKeyPressed

    private void CLIENT_STATE_TEXT_FIELDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CLIENT_STATE_TEXT_FIELDKeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER )
        {
           ClientAddMouse();
        }
    }//GEN-LAST:event_CLIENT_STATE_TEXT_FIELDKeyPressed

    //PRODUCT DETAILS ENTER KEY PRESSED
    private void PRODUCT_ID_TEXT_FIELDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PRODUCT_ID_TEXT_FIELDKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER )
        {
            PRODUCT_NAME_TEXT_FIELD.requestFocus();
        }
    }//GEN-LAST:event_PRODUCT_ID_TEXT_FIELDKeyPressed

    private void PRODUCT_NAME_TEXT_FIELDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PRODUCT_NAME_TEXT_FIELDKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER )
        {
            PRODUCT_BRAND_TEXT_FIELD.requestFocus();
        }
    }//GEN-LAST:event_PRODUCT_NAME_TEXT_FIELDKeyPressed

    private void PRODUCT_BRAND_TEXT_FIELDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PRODUCT_BRAND_TEXT_FIELDKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER )
        {
            HSN_CODE_TEXT_FIELD.requestFocus();
        }
    }//GEN-LAST:event_PRODUCT_BRAND_TEXT_FIELDKeyPressed

    private void HSN_CODE_TEXT_FIELDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HSN_CODE_TEXT_FIELDKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER )
        {
            PRODUCT_RATE_TEXT_FIELD.requestFocus();
        }
    }//GEN-LAST:event_HSN_CODE_TEXT_FIELDKeyPressed

    private void PRODUCT_RATE_TEXT_FIELDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PRODUCT_RATE_TEXT_FIELDKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER )
        {
            AVAILABLE_QTY_TEXT_FIELD.requestFocus();
        }
    }//GEN-LAST:event_PRODUCT_RATE_TEXT_FIELDKeyPressed

    private void AVAILABLE_QTY_TEXT_FIELDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AVAILABLE_QTY_TEXT_FIELDKeyPressed
        try
        {
            if(evt.isControlDown()&& evt.getKeyCode() == KeyEvent.VK_ENTER )
            {
                ProductEditMouse();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "SELECT ANY ROW FROM TABLE INITIALLY", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_AVAILABLE_QTY_TEXT_FIELDKeyPressed

    private void UOM_COMBO_BOXItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_UOM_COMBO_BOXItemStateChanged
        QTY_TEXT_FIELD.requestFocus();
    }//GEN-LAST:event_UOM_COMBO_BOXItemStateChanged

    private void POS_TABLEMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_POS_TABLEMousePressed
        
        QTY_TEXT_FIELD.requestFocus();
        REMOVE_ITEM.setEnabled(true);
    }//GEN-LAST:event_POS_TABLEMousePressed

    private void CANCEL_BILLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CANCEL_BILLMousePressed
       
       CANCELBILL();
    }//GEN-LAST:event_CANCEL_BILLMousePressed

    private void DAILY_BILL_REMOVEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DAILY_BILL_REMOVEMouseClicked
        DAILYREMOVE();
    }//GEN-LAST:event_DAILY_BILL_REMOVEMouseClicked

    private void DAILY_BILL_REMOVEMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DAILY_BILL_REMOVEMouseMoved
        
        Cursor cur33 = new Cursor(Cursor.HAND_CURSOR);
        DAILY_BILL_REMOVE.setCursor(cur33);
    }//GEN-LAST:event_DAILY_BILL_REMOVEMouseMoved

    private void CANCEL_BILLMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CANCEL_BILLMouseMoved
        
        Cursor cur34 = new Cursor(Cursor.HAND_CURSOR);
        CANCEL_BILL.setCursor(cur34);
    }//GEN-LAST:event_CANCEL_BILLMouseMoved

    
    public void DAILYREMOVE()
    {
        df = (DefaultTableModel)DAILY_BILL_TABLE.getModel();
        if(DAILY_BILL_TABLE.getSelectedRow() != -1) {
               
              
            try {
                int row = DAILY_BILL_TABLE.getSelectedRow();                                     
                String Table_click_Invoice_no = (String)DAILY_BILL_TABLE.getModel().getValueAt(row,0);
                String Table_click_Date = (String)DAILY_BILL_TABLE.getModel().getValueAt(row,1);
                String Table_click_shop_gstin = (String)DAILY_BILL_TABLE.getModel().getValueAt(row,3);
                String Table_click_hsn_code = (String)DAILY_BILL_TABLE.getModel().getValueAt(row,5);
                
                String sql2 = "DELETE FROM DAILY_BILL WHERE INVOICE_NO=? AND DATE=? AND SHOP_GSTIN=? AND HSN_CODE=?";
                pst1 = con.prepareStatement(sql2);
               
                pst1.setString(1, Table_click_Invoice_no);
                pst1.setString(2, Table_click_Date);
                pst1.setString(3, Table_click_shop_gstin);
                pst1.setString(4, Table_click_hsn_code);
                
                pst1.executeUpdate();
               
            } catch (SQLException ex) {
                //System.out.println(ex);
                JOptionPane.showMessageDialog(this,"DATABASE LOCKED \nRETRY AGAIN");
            }
           
            df.removeRow(DAILY_BILL_TABLE.getSelectedRow());
            JOptionPane.showMessageDialog(null, "SUCCESSFULLY REMOVED THE ROW");
            }
        else
        {
            JOptionPane.showMessageDialog(null, "SELECT A ROW FIRST", "FACT", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void CANCELBILL()
    {
         int result = JOptionPane.showConfirmDialog(this, "DO YOU WANT TO CANCEL THE BILL?", "CONFIRMATION", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
            df = (DefaultTableModel)POS_TABLE.getModel();
            for(int i=0; i<POS_TABLE.getRowCount();i++)
            {
                String temp_pid = (String) POS_TABLE.getValueAt(i, 0);
                int temp_qty =  (int) POS_TABLE.getValueAt(i, 5);
                //System.out.println(temp_pid + "  " + temp_qty);
           
                try{
                    String sql2 = "UPDATE PRODUCT_DETAILS SET CURRENT_QTY = CURRENT_QTY+? WHERE PRODUCT_ID=?";
                    pst1 = con.prepareStatement(sql2);
               
                    pst1.setInt(1, temp_qty);
                    pst1.setString(2, temp_pid);
                    pst1.executeUpdate();
                    
                    POSCLEARALL();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(this,"DATABASE LOCKED \nRETRY AGAIN");
            }
        }     
        }
    }
    public void ClientLoadData()
    {
        try {
            EDIT.setEnabled(false);
            DELETE.setEnabled(false);
            String sql = "select * from CLIENT_DETAILS";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            ResultSetMetaData metadata = rs.getMetaData();
            int a = metadata.getColumnCount();
            df = (DefaultTableModel)CLIENT_DETAILS_TABLE.getModel();
            df.setRowCount(0);
            
            while(rs.next())
            {
                Vector v1 = new Vector();
                for(int i=1;i<=a;i++)
                {
                    v1.add(rs.getString("CLIENT_ID"));
                    v1.add(rs.getString("SHOP_NAME"));
                    v1.add(rs.getString("ADDRESS"));
                    v1.add(rs.getString("GSTIN"));
//                    v1.add(rs.getString("DISTRICT"));
//                    v1.add(rs.getString("STATE"));
                    v1.add(rs.getString("PHONE_NO"));
                    
                }
                //System.out.println(v1);
                df.addRow(v1);
            }
            
        } 
        
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"DATABASE LOCKED \nRETRY AGAIN");
        }
        
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(this,"DATABASE NOT CLOSED PROPERLY \nRETRY AGAIN");
            }
        }
    }
    
  
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
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DASHBOARD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DASHBOARD().setVisible(true);
            }
            
        });
        
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ADD;
    private javax.swing.JLabel ADD1;
    private javax.swing.JLabel ADD_ITEM;
    private javax.swing.JPanel ADD_ITEM_PANEL;
    private javax.swing.JPanel ADD_PANEL;
    private javax.swing.JPanel ADD_PANEL1;
    private javax.swing.JLabel AMT_IN_WORDS_INPUT;
    private javax.swing.JTextField AMT_IN_WORDS_INPUT_TEXT_FIELD;
    private javax.swing.JPanel AUDIT_REPORTS;
    private javax.swing.JLabel AVAILABLE_QTY;
    private javax.swing.JTextField AVAILABLE_QTY_TEXT_FIELD;
    private javax.swing.JPanel BUTTONS_CONTAINER_PANEL;
    private javax.swing.JPanel BUTTONS_CONTAINER_PANEL1;
    private javax.swing.JLabel CANCEL;
    private javax.swing.JLabel CANCEL1;
    private javax.swing.JLabel CANCEL_BILL;
    private javax.swing.JPanel CANCEL_BILL_PANEL;
    private javax.swing.JPanel CANCEL_PANEL;
    private javax.swing.JPanel CANCEL_PANEL1;
    private javax.swing.JLabel CGST_TOTAL;
    private javax.swing.JTextField CGST_TOTAL_TEXT_FIELD;
    private javax.swing.JLabel CLEAR;
    private javax.swing.JLabel CLEAR_ALL;
    private javax.swing.JPanel CLEAR_ALL_PANEL;
    private javax.swing.JPanel CLEAR_PANEL;
    private javax.swing.JLabel CLIENT;
    private javax.swing.JLabel CLIENT_ADDRESS;
    private javax.swing.JPanel CLIENT_ADDRESS_PANEL;
    private javax.swing.JScrollPane CLIENT_ADDRESS_SCROLLPANE;
    private javax.swing.JTextArea CLIENT_ADDRESS_TEXT_FIELD;
    private javax.swing.JLabel CLIENT_DETAILS;
    private javax.swing.JLabel CLIENT_DETAILS_PRINT_DATA;
    private javax.swing.JPanel CLIENT_DETAILS_PRINT_DATA_PANEL;
    private javax.swing.JScrollPane CLIENT_DETAILS_SCROLLPANE;
    private javax.swing.JTable CLIENT_DETAILS_TABLE;
    private javax.swing.JLabel CLIENT_DISTRICT;
    private javax.swing.JPanel CLIENT_DISTRICT_PANEL;
    private javax.swing.JTextField CLIENT_DISTRICT_TEXT_FIELD;
    private javax.swing.JLabel CLIENT_ID;
    private javax.swing.JPanel CLIENT_ID_PANEL;
    private javax.swing.JTextField CLIENT_ID_TEXT_FIELD;
    private javax.swing.JLabel CLIENT_NAME;
    private javax.swing.JLabel CLIENT_NAME_REFERENCE;
    private javax.swing.JLabel CLIENT_NAME_REFERENCE_INPUT;
    private javax.swing.JLabel CLIENT_PHONE_NO;
    private javax.swing.JPanel CLIENT_PHONE_NO_PANEL;
    private javax.swing.JTextField CLIENT_PHONE_NO_TEXT_FIELD;
    private javax.swing.JPanel CLIENT_SHOPNAME_PANEL;
    private javax.swing.JTextField CLIENT_SHOPNAME_TEXT_FIELD;
    private javax.swing.JLabel CLIENT_STATE;
    private javax.swing.JPanel CLIENT_STATE_PANEL;
    private javax.swing.JTextField CLIENT_STATE_TEXT_FIELD;
    private javax.swing.JLabel COMPANY_NAME;
    private javax.swing.JPanel CONTAINER_PANEL;
    private javax.swing.JLabel DAILY_BILL_REMOVE;
    private javax.swing.JPanel DAILY_BILL_REMOVE_PANEL;
    private javax.swing.JPanel DAILY_BILL_REPORTS;
    private javax.swing.JTable DAILY_BILL_TABLE;
    private javax.swing.JScrollPane DAILY_BILL_TABLE_SCROLL_PANE1;
    private javax.swing.JLabel DASHBOARD;
    private javax.swing.JPanel DASHBOARD_PANEL;
    private javax.swing.JLabel DATE;
    private javax.swing.JLabel DATESHOW;
    private com.toedter.calendar.JDateChooser DATE_CHOOSER;
    private javax.swing.JLabel DELETE;
    private javax.swing.JLabel DELETE1;
    private javax.swing.JPanel DELETE_PANEL;
    private javax.swing.JPanel DELETE_PANEL1;
    private javax.swing.JLabel EDIT;
    private javax.swing.JLabel EDIT1;
    private javax.swing.JPanel EDIT_PANEL;
    private javax.swing.JPanel EDIT_PANEL1;
    private javax.swing.JLabel EXIT;
    private javax.swing.JLabel FROM_DATE;
    private javax.swing.JLabel FROM_DATE1;
    private com.toedter.calendar.JDateChooser FROM_DATE_CHOOSER;
    private com.toedter.calendar.JDateChooser FROM_DATE_CHOOSER1;
    private javax.swing.JLabel GENERATE;
    private javax.swing.JPanel GENERATE_PANEL;
    private javax.swing.JLabel GSTIN;
    private javax.swing.JPanel GSTIN_PANEL;
    private javax.swing.JTextField GSTIN_TEXT_FIELD;
    private javax.swing.JLabel HSN_CODE;
    private javax.swing.JPanel HSN_CODE_PANEL;
    private javax.swing.JTextField HSN_CODE_TEXT_FIELD;
    private javax.swing.JLabel INVOICE_DATE;
    private javax.swing.JLabel INVOICE_NO;
    private javax.swing.JPanel INVOICE_NO_INPUT_PANEL;
    private javax.swing.JTextField INVOICE_NO_TEXT_FIELD;
    private javax.swing.JPanel JP1;
    private javax.swing.JPanel JP2;
    private javax.swing.JPanel JP3;
    private javax.swing.JPanel JP4;
    private javax.swing.JLabel KARISHMA;
    private javax.swing.JLabel NAME;
    private javax.swing.JLabel POINT_OF_SALES;
    private javax.swing.JLabel POS;
    private javax.swing.JPanel POS_BUTTONS_CONTAINER_PANEL;
    private javax.swing.JLabel POS_CLIENT_ADDRESS;
    private javax.swing.JLabel POS_CLIENT_ADDRESS_INPUT;
    private javax.swing.JLabel POS_CLIENT_NAME;
    private javax.swing.JPanel POS_CLIENT_NAME_PANEL;
    private javax.swing.JTextField POS_CLIENT_NAME_TEXT_FIELD;
    private javax.swing.JLabel POS_GSTIN;
    private javax.swing.JLabel POS_GSTIN_INPUT;
    private javax.swing.JLabel POS_PRODUCT_ID;
    private javax.swing.JPanel POS_PRODUCT_ID_PANEL;
    private javax.swing.JTextField POS_PRODUCT_ID_TEXT_FIELD;
    private javax.swing.JLabel POS_PRODUCT_NAME;
    private javax.swing.JPanel POS_PRODUCT_NAME_PANEL;
    private javax.swing.JTextField POS_PRODUCT_NAME_TEXT_FIELD;
    private javax.swing.JLabel POS_RATE;
    private javax.swing.JPanel POS_RATE_PANEL;
    private javax.swing.JTextField POS_RATE_TEXT_FIELD;
    private javax.swing.JScrollPane POS_SCROLLPANE;
    private javax.swing.JTable POS_TABLE;
    private javax.swing.JPanel POS_TOTAL_PANEL;
    private javax.swing.JTextField POS_TOTAL_TEXT_FIELD;
    private javax.swing.JLabel PRINT;
    private javax.swing.JPanel PRINT_PANEL;
    private javax.swing.JLabel PROCEED;
    private javax.swing.JPanel PROCEED_PANEL;
    private javax.swing.JLabel PRODUCT;
    private javax.swing.JLabel PRODUCTS;
    private javax.swing.JLabel PRODUCT_BRAND;
    private javax.swing.JPanel PRODUCT_BRAND_PANEL;
    private javax.swing.JTextField PRODUCT_BRAND_TEXT_FIELD;
    private javax.swing.JLabel PRODUCT_CGST;
    private javax.swing.JComboBox<String> PRODUCT_CGST_COMBO_BOX;
    private javax.swing.JPanel PRODUCT_CGST_PANEL;
    private javax.swing.JLabel PRODUCT_DETAILS;
    private javax.swing.JLabel PRODUCT_DETAILS_PRINT_DATA;
    private javax.swing.JPanel PRODUCT_DETAILS_PRINT_DATA_PANEL;
    private javax.swing.JScrollPane PRODUCT_DETAILS_SCROLLPANE;
    private javax.swing.JTable PRODUCT_DETAILS_TABLE;
    private javax.swing.JLabel PRODUCT_ID;
    private javax.swing.JPanel PRODUCT_ID_PANEL;
    private javax.swing.JTextField PRODUCT_ID_TEXT_FIELD;
    private javax.swing.JPanel PRODUCT_NAME_PANEL;
    private javax.swing.JTextField PRODUCT_NAME_TEXT_FIELD;
    private javax.swing.JLabel PRODUCT_RATE;
    private javax.swing.JPanel PRODUCT_RATE_PANEL;
    private javax.swing.JTextField PRODUCT_RATE_TEXT_FIELD;
    private javax.swing.JLabel PRODUCT_SGST;
    private javax.swing.JComboBox<String> PRODUCT_SGST_COMBO_BOX;
    private javax.swing.JPanel PRODUCT_SGST_PANEL;
    private javax.swing.JLabel QTY;
    private javax.swing.JLabel QTY_IN_STOCK;
    private javax.swing.JLabel QTY_IN_STOCK_INPUT;
    private javax.swing.JPanel QTY_PANEL;
    private javax.swing.JTextField QTY_TEXT_FIELD;
    private javax.swing.JLabel REMOVE_ITEM;
    private javax.swing.JPanel REMOVE_ITEM_PANEL;
    private javax.swing.JLabel REPORTS;
    private javax.swing.JLabel REPORTS_CLEAR;
    private javax.swing.JLabel REPORTS_CLEAR1;
    private javax.swing.JPanel REPORTS_CLEAR_PANEL;
    private javax.swing.JPanel REPORTS_CLEAR_PANEL1;
    private javax.swing.JLabel REPORTS_PRINT;
    private javax.swing.JLabel REPORTS_PRINT1;
    private javax.swing.JPanel REPORTS_PRINT_PANEL;
    private javax.swing.JPanel REPORTS_PRINT_PANEL1;
    private javax.swing.JLabel REPORTS_SAVE;
    private javax.swing.JPanel REPORTS_SAVE_PANEL;
    private javax.swing.JLabel REPORTS_TITLE;
    private javax.swing.JLabel REPORT_CLIENT_ID;
    private javax.swing.JLabel REPORT_CLIENT_ID1;
    private javax.swing.JTextField REPORT_CLIENT_ID_TEXT_FIELD;
    private javax.swing.JTextField REPORT_CLIENT_ID_TEXT_FIELD1;
    private javax.swing.JTabbedPane REPORT_TABBED_PANE;
    private javax.swing.JTable REPORT_TABLE;
    private javax.swing.JScrollPane REPORT_TABLE_SCROLL_PANE;
    private javax.swing.JPanel REPORT_TITLE_PANEL;
    private javax.swing.JTextField ROUND_INPUT;
    private javax.swing.JLabel ROUND_LABEL;
    private javax.swing.JLabel SAVE;
    private javax.swing.JPanel SAVE_PANEL;
    private javax.swing.JLabel SGST_TOTAL;
    private javax.swing.JTextField SGST_TOTAL_TEXT_FIELD;
    private javax.swing.JPanel TAB1;
    private javax.swing.JPanel TAB2;
    private javax.swing.JPanel TAB3;
    private javax.swing.JPanel TAB4;
    private javax.swing.JPanel TAB5;
    private javax.swing.JLabel TAX_VALUE;
    private javax.swing.JTextField TAX_VALUE_TEXT_FIELD;
    private javax.swing.JLabel TIME;
    private javax.swing.JLabel TIMESHOW;
    private javax.swing.JPanel TITLE;
    private javax.swing.JLabel TOTAL;
    private javax.swing.JLabel TOTAL_QTY;
    private javax.swing.JPanel TOTAL_QTY_PANEL;
    private javax.swing.JTextField TOTAL_QTY_TEXT_FIELD;
    private javax.swing.JLabel TO_DATE;
    private javax.swing.JLabel TO_DATE1;
    private com.toedter.calendar.JDateChooser TO_DATE_CHOOSER;
    private com.toedter.calendar.JDateChooser TO_DATE_CHOOSER1;
    private javax.swing.JLabel UOM;
    private javax.swing.JComboBox<String> UOM_COMBO_BOX;
    private javax.swing.JPanel UOM_PANEL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    void setcolor(JPanel panel) {
        panel.setBackground(new Color(65, 65, 118));
    }

    void resetcolor(JPanel panel) {
        panel.setBackground(new Color(0, 0, 153));
    }   
}