/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.management.system;

import static com.sun.tools.javac.util.Constants.format;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.awt.Graphics;
import java.awt.Graphics2D;


import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import static java.lang.String.format;
import static java.lang.String.format;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author DHEERAJ PRAKASH . S 
 */
public class PRINT_BILL extends javax.swing.JFrame {

    /**
     * Creates new form PRINT_BILL
     */
    
   
    public PRINT_BILL() {
       
        initComponents();
        this.pack();
        
    }
      Connection con;
      ResultSet rs;
      PreparedStatement pst,pst1,pst2 = null;
      DefaultTableModel df;

     String Invoice_No ,Date;
    PRINT_BILL(String invoice_no,String date,String cgst_amount, String sgst_amount, String total_amount, String total_qty, String total_tax, String round_total,String shopname_ref,String gstin_ref,String address_ref,String amt_words) {
       this.con = DBCONNECTION.connect();
       
       initComponents();
       DBCONNECTION.connect();
       this.pack();
       this.Invoice_No =invoice_no;
       this.Date = date;
       
       try {
            
          
            String sql = "select * from DAILY_BILL where INVOICE_NO=? and DATE=?";
            pst = con.prepareStatement(sql);
           
            pst.setString(1, Invoice_No);
            pst.setString(2,Date);
             
            rs = pst.executeQuery();
            
            ResultSetMetaData metadata = rs.getMetaData();
            int a = metadata.getColumnCount();
            df = (DefaultTableModel)BILL_TABLE.getModel();
            df.setRowCount(0);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
            
            BILL_TABLE.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
            BILL_TABLE.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
            BILL_TABLE.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
            BILL_TABLE.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
            BILL_TABLE.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
            BILL_TABLE.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
            BILL_TABLE.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
            BILL_TABLE.getColumnModel().getColumn(8).setCellRenderer( rightRenderer );
            BILL_TABLE.getColumnModel().getColumn(9).setCellRenderer( centerRenderer );
            BILL_TABLE.getColumnModel().getColumn(10).setCellRenderer( rightRenderer );
            BILL_TABLE.getColumnModel().getColumn(11).setCellRenderer( centerRenderer );
            BILL_TABLE.getColumnModel().getColumn(12).setCellRenderer( rightRenderer );
            BILL_TABLE.getColumnModel().getColumn(13).setCellRenderer( rightRenderer );
            
           // BILL_TABLE.getColumnModel().getColumn(11).setCellRenderer(centerRenderer);
            
            
            while(rs.next())
            {
                Vector<String> v1 = new Vector<String>();
                for(int i=1;i<=a;i++)
                {
                    
                    v1.add(rs.getString("SNO"));
                    v1.add(rs.getString("PDT_DESC"));
                    v1.add(rs.getString("HSN_CODE"));
                    v1.add(rs.getString("UOM"));
                    v1.add(rs.getString("QTY"));
                    v1.add(rs.getString("RATE"));
                    v1.add(rs.getString("TAXABLE_VALUE"));
                    v1.add("-");
                    v1.add(rs.getString("TAXABLE_VALUE"));
                    v1.add((rs.getString("CGST_RATE"))+"%");
                    v1.add(rs.getString("CGST_AMOUNT"));
                    v1.add((rs.getString("SGST_RATE"))+"%");
                    v1.add(rs.getString("SGST_AMOUNT"));
                    v1.add(rs.getString("TOTAL_AMOUNT"));
                }
                df.addRow(v1);
            }
            
            
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(DASHBOARD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
       
       setVisible(true);
       
      
       
       INVOICE_NO_INPUT.setText(invoice_no);
       INVOICE_DATE_INPUT.setText(date);
       DATE_OF_SUPPLY_INPUT.setText(date);
        
       QTY_TOTAL_INPUT.setText(total_qty);
       PRODUCT_AMOUNT_TOTAL_INPUT.setText(total_tax);
       PRODUCT_TAXABLE_VALUE_TOTAL_INPUT.setText(total_tax);
       PRODUCT_CGST_AMOUNT_TOTAL_INPUT.setText(cgst_amount);
       PRODUCT_SGST_AMOUNT_TOTAL_INPUT.setText(sgst_amount);
       OVERALL_TOTAL.setText(total_amount);
       
       AMOUNT_BEFORE_TAX_INPUT.setText(total_tax);
       ADD_CGST_INPUT.setText(cgst_amount);
       ADD_SGST_INPUT.setText(sgst_amount);
       
       ROUNDED_OFF_INPUT.setText(round_total);
       
        //System.out.println("In usage:"+shopname_ref);
       SHOP_NAME_INPUT.setText(shopname_ref);
        SHOP_NAME_1_INPUT.setText(shopname_ref);
        
        SHOP_ADDRESS_INPUT.setText(address_ref);
        SHOP_ADDRESS_1_INPUT.setText(address_ref);
        
        SHOP_GSTIN_INPUT.setText(gstin_ref);
        SHOP_GSTIN_1_INPUT.setText(gstin_ref);
        AMOUNT_IN_WORDS_INPUT.setText(amt_words);
        
       printRecord();
    }

    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CONTAINER_PANEL = new javax.swing.JPanel();
        AGENCY_INFO_PANEL = new javax.swing.JPanel();
        PILLAYAR_SUZHI = new javax.swing.JLabel();
        SEPARATOR_1 = new javax.swing.JSeparator();
        KARISHMA_AGENCIES = new javax.swing.JLabel();
        AGENCY_ADDRESS = new javax.swing.JLabel();
        GOD_NAME = new javax.swing.JLabel();
        FSSAI_NO = new javax.swing.JLabel();
        AGENCY_PHONE = new javax.swing.JLabel();
        AGENCY_GSTIN = new javax.swing.JLabel();
        SEPARATOR_2 = new javax.swing.JSeparator();
        TAX_INVOICE = new javax.swing.JLabel();
        BILL_INFO_PANEL = new javax.swing.JPanel();
        INVOICE_NO = new javax.swing.JLabel();
        INVOICE_NO_INPUT = new javax.swing.JLabel();
        REVERSE_CHARGE = new javax.swing.JLabel();
        REVERSE_CHARGE_INPUT = new javax.swing.JLabel();
        INVOICE_DATE = new javax.swing.JLabel();
        AGENCY_STATE = new javax.swing.JLabel();
        INVOICE_DATE_INPUT = new javax.swing.JLabel();
        AGENCY_STATE_INPUT = new javax.swing.JLabel();
        AGENCY_CODE = new javax.swing.JLabel();
        AGENCY_CODE_INPUT = new javax.swing.JLabel();
        SEPARATOR_3 = new javax.swing.JSeparator();
        TRANSPORT_MODE = new javax.swing.JLabel();
        TRANSPORT_MODE_INPUT = new javax.swing.JLabel();
        VEHICLE_NO = new javax.swing.JLabel();
        VEHICLE_NO_INPUT = new javax.swing.JLabel();
        DATE_OF_SUPPLY = new javax.swing.JLabel();
        DATE_OF_SUPPLY_INPUT = new javax.swing.JLabel();
        PLACE_OF_SUPPLY = new javax.swing.JLabel();
        PLACE_OF_SUPPLY_INPUT = new javax.swing.JLabel();
        CLIENT_PANEL = new javax.swing.JPanel();
        BILL_TO_PARTY = new javax.swing.JLabel();
        CLIENT_INFO_PANEL = new javax.swing.JPanel();
        SHOP_NAME = new javax.swing.JLabel();
        SHOP_ADDRESS = new javax.swing.JLabel();
        SHOP_GSTIN = new javax.swing.JLabel();
        SHOP_STATE = new javax.swing.JLabel();
        SHOP_NAME_INPUT = new javax.swing.JLabel();
        SEPARATOR_5 = new javax.swing.JSeparator();
        SHOP_ADDRESS_INPUT = new javax.swing.JLabel();
        SHOP_GSTIN_INPUT = new javax.swing.JLabel();
        SHOP_STATE_INPUT = new javax.swing.JLabel();
        SHOP_CODE = new javax.swing.JLabel();
        SHOP_CODE_INPUT = new javax.swing.JLabel();
        SHOP_NAME_1 = new javax.swing.JLabel();
        SHOP_ADDRESS_1 = new javax.swing.JLabel();
        SHOP_GSTIN_1 = new javax.swing.JLabel();
        SHOP_STATE_1 = new javax.swing.JLabel();
        SHOP_NAME_1_INPUT = new javax.swing.JLabel();
        SHOP_ADDRESS_1_INPUT = new javax.swing.JLabel();
        SHOP_GSTIN_1_INPUT = new javax.swing.JLabel();
        SHOP_STATE_1_INPUT = new javax.swing.JLabel();
        SHOP_CODE_1 = new javax.swing.JLabel();
        SHOP_CODE_1_INPUT = new javax.swing.JLabel();
        BILL_ITEMS_PANEL = new javax.swing.JPanel();
        BILL_TABLE_SCROLL_PANE = new javax.swing.JScrollPane();
        BILL_TABLE = new javax.swing.JTable();
        S_NO = new javax.swing.JLabel();
        PRODUCT_DESC = new javax.swing.JLabel();
        PRODUCT_HSN_CODE = new javax.swing.JLabel();
        PRODUCT_UOM = new javax.swing.JLabel();
        PRODUCT_QTY = new javax.swing.JLabel();
        PRODUCT_RATE = new javax.swing.JLabel();
        PRODUCT_AMOUNT = new javax.swing.JLabel();
        PRODUCT_DISCOUNT = new javax.swing.JLabel();
        PRODUCT_TAXABLE_VALUE = new javax.swing.JLabel();
        PRODUCT_CGST = new javax.swing.JLabel();
        PRODUCT_CGST_RATE = new javax.swing.JLabel();
        PRODUCT_CGST_AMOUNT = new javax.swing.JLabel();
        PRODUCT_SGST = new javax.swing.JLabel();
        PRODUCT_SGST_RATE = new javax.swing.JLabel();
        PRODUCT_SGST_AMOUNT = new javax.swing.JLabel();
        PRODUCT_TOTAL = new javax.swing.JLabel();
        IN_WORDS_PANEL = new javax.swing.JPanel();
        AMOUNT_IN_WORDS = new javax.swing.JLabel();
        AMOUNT_IN_WORDS_INPUT = new javax.swing.JLabel();
        TOTAL = new javax.swing.JLabel();
        DUMMY_1 = new javax.swing.JLabel();
        DUMMY_2 = new javax.swing.JLabel();
        QTY_TOTAL_INPUT = new javax.swing.JLabel();
        DUMMY_3 = new javax.swing.JLabel();
        PRODUCT_AMOUNT_TOTAL_INPUT = new javax.swing.JLabel();
        DUMMY_4 = new javax.swing.JLabel();
        PRODUCT_TAXABLE_VALUE_TOTAL_INPUT = new javax.swing.JLabel();
        DUMMY_5 = new javax.swing.JLabel();
        PRODUCT_CGST_AMOUNT_TOTAL_INPUT = new javax.swing.JLabel();
        DUMMY_6 = new javax.swing.JLabel();
        PRODUCT_SGST_AMOUNT_TOTAL_INPUT = new javax.swing.JLabel();
        OVERALL_TOTAL = new javax.swing.JLabel();
        AMOUNT_INFO_PANEL = new javax.swing.JPanel();
        AMOUNT_BEFORE_TAX = new javax.swing.JLabel();
        AMOUNT_BEFORE_TAX_INPUT = new javax.swing.JLabel();
        ADD_CGST = new javax.swing.JLabel();
        ADD_CGST_INPUT = new javax.swing.JLabel();
        ADD_SGST = new javax.swing.JLabel();
        ROUNDED_OFF = new javax.swing.JLabel();
        ADD_SGST_INPUT = new javax.swing.JLabel();
        ROUNDED_OFF_INPUT = new javax.swing.JLabel();
        GST_REVERSE = new javax.swing.JLabel();
        GST_REVERSE_INPUT = new javax.swing.JLabel();
        ACKNOWLEDGEMENT = new javax.swing.JLabel();
        FOR_KARISHMA_AGENCIES = new javax.swing.JLabel();
        AUTHORISED_SIGNATORY = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BILL");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(null);
        setName("BILL"); // NOI18N
        setUndecorated(true);

        CONTAINER_PANEL.setBackground(new java.awt.Color(255, 255, 255));
        CONTAINER_PANEL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        AGENCY_INFO_PANEL.setBackground(new java.awt.Color(255, 255, 255));
        AGENCY_INFO_PANEL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PILLAYAR_SUZHI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PILLAYAR_SUZHI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/PILLAYAR_SUZHI.png"))); // NOI18N

        SEPARATOR_1.setForeground(new java.awt.Color(0, 0, 0));
        SEPARATOR_1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        KARISHMA_AGENCIES.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        KARISHMA_AGENCIES.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        KARISHMA_AGENCIES.setText("KARISHMA AGENCIES");

        AGENCY_ADDRESS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AGENCY_ADDRESS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AGENCY_ADDRESS.setText("M-28,PHASE-2,ANNANAGAR,TRICHY-26.");

        GOD_NAME.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        GOD_NAME.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GOD_NAME.setText("ILAMAYI AMMAN THUNAI");

        FSSAI_NO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FSSAI_NO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FSSAI_NO.setText("fssai:12417028000218");

        AGENCY_PHONE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AGENCY_PHONE.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AGENCY_PHONE.setText("PH NO:9552380856");

        AGENCY_GSTIN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AGENCY_GSTIN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AGENCY_GSTIN.setText("GSTIN: 33AFHPH343I");

        SEPARATOR_2.setForeground(new java.awt.Color(0, 0, 0));
        SEPARATOR_2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        TAX_INVOICE.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        TAX_INVOICE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TAX_INVOICE.setText("TAX INVOICE");

        javax.swing.GroupLayout AGENCY_INFO_PANELLayout = new javax.swing.GroupLayout(AGENCY_INFO_PANEL);
        AGENCY_INFO_PANEL.setLayout(AGENCY_INFO_PANELLayout);
        AGENCY_INFO_PANELLayout.setHorizontalGroup(
            AGENCY_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SEPARATOR_1)
            .addGroup(AGENCY_INFO_PANELLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AGENCY_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KARISHMA_AGENCIES, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AGENCY_ADDRESS, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119)
                .addGroup(AGENCY_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(GOD_NAME, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(FSSAI_NO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AGENCY_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AGENCY_PHONE, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AGENCY_GSTIN))
                .addGap(23, 23, 23))
            .addComponent(SEPARATOR_2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(AGENCY_INFO_PANELLayout.createSequentialGroup()
                .addComponent(PILLAYAR_SUZHI, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(TAX_INVOICE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        AGENCY_INFO_PANELLayout.setVerticalGroup(
            AGENCY_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AGENCY_INFO_PANELLayout.createSequentialGroup()
                .addComponent(PILLAYAR_SUZHI, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(SEPARATOR_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(AGENCY_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(KARISHMA_AGENCIES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(AGENCY_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(GOD_NAME)
                        .addComponent(AGENCY_PHONE, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AGENCY_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AGENCY_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(AGENCY_ADDRESS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(FSSAI_NO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(AGENCY_GSTIN))
                .addGap(1, 1, 1)
                .addComponent(SEPARATOR_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(TAX_INVOICE, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        BILL_INFO_PANEL.setBackground(new java.awt.Color(255, 255, 255));
        BILL_INFO_PANEL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        INVOICE_NO.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        INVOICE_NO.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        INVOICE_NO.setText("Invoice No:");

        INVOICE_NO_INPUT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        INVOICE_NO_INPUT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        INVOICE_NO_INPUT.setText("100000000");

        REVERSE_CHARGE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        REVERSE_CHARGE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        REVERSE_CHARGE.setText("Reverse Charge(Y/N):");

        REVERSE_CHARGE_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        REVERSE_CHARGE_INPUT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        INVOICE_DATE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        INVOICE_DATE.setText("Invoice Date:");

        AGENCY_STATE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AGENCY_STATE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        AGENCY_STATE.setText("State:");

        INVOICE_DATE_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        INVOICE_DATE_INPUT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        INVOICE_DATE_INPUT.setText("22/03/2021");

        AGENCY_STATE_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AGENCY_STATE_INPUT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AGENCY_STATE_INPUT.setText("TAMILNADU");

        AGENCY_CODE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AGENCY_CODE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        AGENCY_CODE.setText("Code:");

        AGENCY_CODE_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AGENCY_CODE_INPUT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AGENCY_CODE_INPUT.setText("33");

        SEPARATOR_3.setForeground(new java.awt.Color(0, 0, 0));
        SEPARATOR_3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SEPARATOR_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        TRANSPORT_MODE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TRANSPORT_MODE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TRANSPORT_MODE.setText("Transport Mode:");

        TRANSPORT_MODE_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TRANSPORT_MODE_INPUT.setText("Vehicle - TVS XL");

        VEHICLE_NO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        VEHICLE_NO.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        VEHICLE_NO.setText("Vehicle No:");

        VEHICLE_NO_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        VEHICLE_NO_INPUT.setText("TN 81 Y  4261");

        DATE_OF_SUPPLY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DATE_OF_SUPPLY.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        DATE_OF_SUPPLY.setText("Date Of Supply:");

        DATE_OF_SUPPLY_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DATE_OF_SUPPLY_INPUT.setText("22/03/2021");

        PLACE_OF_SUPPLY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PLACE_OF_SUPPLY.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PLACE_OF_SUPPLY.setText("Place Of Supply:");

        PLACE_OF_SUPPLY_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PLACE_OF_SUPPLY_INPUT.setText("M-28,PHASE-2,ANNANAGAR,TRICHY-26.");

        javax.swing.GroupLayout BILL_INFO_PANELLayout = new javax.swing.GroupLayout(BILL_INFO_PANEL);
        BILL_INFO_PANEL.setLayout(BILL_INFO_PANELLayout);
        BILL_INFO_PANELLayout.setHorizontalGroup(
            BILL_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BILL_INFO_PANELLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BILL_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(REVERSE_CHARGE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(INVOICE_NO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BILL_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(INVOICE_NO_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(REVERSE_CHARGE_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BILL_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AGENCY_CODE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(INVOICE_DATE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AGENCY_STATE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BILL_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AGENCY_CODE_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AGENCY_STATE_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(INVOICE_DATE_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SEPARATOR_3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BILL_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PLACE_OF_SUPPLY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(VEHICLE_NO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TRANSPORT_MODE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BILL_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BILL_INFO_PANELLayout.createSequentialGroup()
                        .addComponent(VEHICLE_NO_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DATE_OF_SUPPLY)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DATE_OF_SUPPLY_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TRANSPORT_MODE_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PLACE_OF_SUPPLY_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        BILL_INFO_PANELLayout.setVerticalGroup(
            BILL_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SEPARATOR_3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(BILL_INFO_PANELLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(BILL_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BILL_INFO_PANELLayout.createSequentialGroup()
                        .addGroup(BILL_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(INVOICE_DATE_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(INVOICE_DATE, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                            .addComponent(INVOICE_NO_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(INVOICE_NO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BILL_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(REVERSE_CHARGE, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(REVERSE_CHARGE_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AGENCY_STATE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AGENCY_STATE_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BILL_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AGENCY_CODE, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AGENCY_CODE_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(BILL_INFO_PANELLayout.createSequentialGroup()
                        .addGroup(BILL_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TRANSPORT_MODE_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TRANSPORT_MODE, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BILL_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DATE_OF_SUPPLY_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(VEHICLE_NO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(VEHICLE_NO_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DATE_OF_SUPPLY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BILL_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PLACE_OF_SUPPLY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PLACE_OF_SUPPLY_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1))
        );

        CLIENT_PANEL.setBackground(new java.awt.Color(255, 255, 255));
        CLIENT_PANEL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BILL_TO_PARTY.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BILL_TO_PARTY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BILL_TO_PARTY.setText("BILL TO PARTY                                                                               SHIP TO PARTY");
        BILL_TO_PARTY.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout CLIENT_PANELLayout = new javax.swing.GroupLayout(CLIENT_PANEL);
        CLIENT_PANEL.setLayout(CLIENT_PANELLayout);
        CLIENT_PANELLayout.setHorizontalGroup(
            CLIENT_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CLIENT_PANELLayout.createSequentialGroup()
                .addComponent(BILL_TO_PARTY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        CLIENT_PANELLayout.setVerticalGroup(
            CLIENT_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CLIENT_PANELLayout.createSequentialGroup()
                .addComponent(BILL_TO_PARTY, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        CLIENT_INFO_PANEL.setBackground(new java.awt.Color(255, 255, 255));
        CLIENT_INFO_PANEL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SHOP_NAME.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        SHOP_NAME.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        SHOP_NAME.setText("NAME:");

        SHOP_ADDRESS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SHOP_ADDRESS.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        SHOP_ADDRESS.setText("ADDRESS:");

        SHOP_GSTIN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SHOP_GSTIN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        SHOP_GSTIN.setText("GSTIN:");

        SHOP_STATE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SHOP_STATE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        SHOP_STATE.setText("STATE:");

        SHOP_NAME_INPUT.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        SHOP_NAME_INPUT.setText("S.DHEERAJ PRAKASH");

        SEPARATOR_5.setForeground(new java.awt.Color(0, 0, 0));
        SEPARATOR_5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SEPARATOR_5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        SHOP_ADDRESS_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SHOP_ADDRESS_INPUT.setText("H/211,PHASE-2,ANNANAGAR,TRICHY-26.");

        SHOP_GSTIN_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SHOP_GSTIN_INPUT.setText("221025");

        SHOP_STATE_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SHOP_STATE_INPUT.setText("TAMILNADU");

        SHOP_CODE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SHOP_CODE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        SHOP_CODE.setText("CODE:");

        SHOP_CODE_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SHOP_CODE_INPUT.setText("33");

        SHOP_NAME_1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        SHOP_NAME_1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        SHOP_NAME_1.setText("NAME:");

        SHOP_ADDRESS_1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SHOP_ADDRESS_1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        SHOP_ADDRESS_1.setText("ADDRESS:");

        SHOP_GSTIN_1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SHOP_GSTIN_1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        SHOP_GSTIN_1.setText("GSTIN:");

        SHOP_STATE_1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SHOP_STATE_1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        SHOP_STATE_1.setText("STATE:");

        SHOP_NAME_1_INPUT.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        SHOP_NAME_1_INPUT.setText("S.DHEERAJ PRAKASH");

        SHOP_ADDRESS_1_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SHOP_ADDRESS_1_INPUT.setText("H/211,PHASE-2,ANNANAGAR,TRICHY-26.");

        SHOP_GSTIN_1_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SHOP_GSTIN_1_INPUT.setText("221025");

        SHOP_STATE_1_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SHOP_STATE_1_INPUT.setText("TAMILNADU");

        SHOP_CODE_1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SHOP_CODE_1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        SHOP_CODE_1.setText("CODE:");

        SHOP_CODE_1_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SHOP_CODE_1_INPUT.setText("33");

        javax.swing.GroupLayout CLIENT_INFO_PANELLayout = new javax.swing.GroupLayout(CLIENT_INFO_PANEL);
        CLIENT_INFO_PANEL.setLayout(CLIENT_INFO_PANELLayout);
        CLIENT_INFO_PANELLayout.setHorizontalGroup(
            CLIENT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CLIENT_INFO_PANELLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CLIENT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(SHOP_STATE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SHOP_GSTIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SHOP_ADDRESS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(SHOP_NAME, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CLIENT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CLIENT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(CLIENT_INFO_PANELLayout.createSequentialGroup()
                            .addComponent(SHOP_STATE_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(SHOP_CODE, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SHOP_CODE_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(SHOP_GSTIN_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SHOP_ADDRESS_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
                    .addComponent(SHOP_NAME_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SEPARATOR_5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CLIENT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SHOP_NAME_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SHOP_ADDRESS_1, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(SHOP_GSTIN_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SHOP_STATE_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CLIENT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SHOP_GSTIN_1_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CLIENT_INFO_PANELLayout.createSequentialGroup()
                        .addComponent(SHOP_STATE_1_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SHOP_CODE_1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SHOP_CODE_1_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SHOP_NAME_1_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SHOP_ADDRESS_1_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)))
        );
        CLIENT_INFO_PANELLayout.setVerticalGroup(
            CLIENT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SEPARATOR_5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(CLIENT_INFO_PANELLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(CLIENT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CLIENT_INFO_PANELLayout.createSequentialGroup()
                        .addGroup(CLIENT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SHOP_NAME_1_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SHOP_NAME_1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CLIENT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SHOP_ADDRESS_1_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SHOP_ADDRESS_1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CLIENT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SHOP_GSTIN_1_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SHOP_GSTIN_1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CLIENT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SHOP_STATE_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SHOP_STATE_1_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SHOP_CODE_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SHOP_CODE_1_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CLIENT_INFO_PANELLayout.createSequentialGroup()
                        .addGroup(CLIENT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SHOP_NAME_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SHOP_NAME, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CLIENT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SHOP_ADDRESS_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SHOP_ADDRESS, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CLIENT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SHOP_GSTIN_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SHOP_GSTIN, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CLIENT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SHOP_STATE, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(SHOP_STATE_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SHOP_CODE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SHOP_CODE_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );

        BILL_ITEMS_PANEL.setBackground(new java.awt.Color(255, 255, 255));
        BILL_ITEMS_PANEL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BILL_TABLE_SCROLL_PANE.setBackground(new java.awt.Color(255, 255, 255));
        BILL_TABLE_SCROLL_PANE.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        BILL_TABLE_SCROLL_PANE.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        BILL_TABLE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BILL_TABLE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BILL_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "ANIL ATTA RAVA SWMIYA", "9698594605", "KG", "100", "500", "5000", null, "5000", "2.5", "3600", "2.5", "5000", "25000"},
                {"2", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"3", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"4", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"5", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"6", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"7", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"8", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"9", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"10", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"11", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"12", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"13", null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "sno", "product description", "hsn code", "uom", "qty", "rate", "amount", "discount", "taxable value", "rate", "amount", "rate", "amount", "total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        BILL_TABLE.getTableHeader().setVisible(false);
        JTableHeader header9 = BILL_TABLE.getTableHeader();
        header9.setPreferredSize(new Dimension(1,1));
        BILL_TABLE.revalidate();
        BILL_TABLE.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BILL_TABLE.setGridColor(new java.awt.Color(0, 0, 0));
        BILL_TABLE.setOpaque(false);
        BILL_TABLE.setRowHeight(30);
        BILL_TABLE_SCROLL_PANE.setViewportView(BILL_TABLE);
        if (BILL_TABLE.getColumnModel().getColumnCount() > 0) {
            BILL_TABLE.getColumnModel().getColumn(0).setMinWidth(37);
            BILL_TABLE.getColumnModel().getColumn(0).setPreferredWidth(37);
            BILL_TABLE.getColumnModel().getColumn(0).setMaxWidth(37);
            BILL_TABLE.getColumnModel().getColumn(1).setMinWidth(260);
            BILL_TABLE.getColumnModel().getColumn(1).setPreferredWidth(260);
            BILL_TABLE.getColumnModel().getColumn(1).setMaxWidth(260);
            BILL_TABLE.getColumnModel().getColumn(2).setMinWidth(95);
            BILL_TABLE.getColumnModel().getColumn(2).setPreferredWidth(95);
            BILL_TABLE.getColumnModel().getColumn(2).setMaxWidth(95);
            BILL_TABLE.getColumnModel().getColumn(3).setMinWidth(38);
            BILL_TABLE.getColumnModel().getColumn(3).setPreferredWidth(38);
            BILL_TABLE.getColumnModel().getColumn(3).setMaxWidth(38);
            BILL_TABLE.getColumnModel().getColumn(4).setMinWidth(60);
            BILL_TABLE.getColumnModel().getColumn(4).setPreferredWidth(60);
            BILL_TABLE.getColumnModel().getColumn(4).setMaxWidth(60);
            BILL_TABLE.getColumnModel().getColumn(5).setMinWidth(54);
            BILL_TABLE.getColumnModel().getColumn(5).setPreferredWidth(54);
            BILL_TABLE.getColumnModel().getColumn(5).setMaxWidth(54);
            BILL_TABLE.getColumnModel().getColumn(6).setMinWidth(88);
            BILL_TABLE.getColumnModel().getColumn(6).setPreferredWidth(88);
            BILL_TABLE.getColumnModel().getColumn(6).setMaxWidth(88);
            BILL_TABLE.getColumnModel().getColumn(7).setMinWidth(56);
            BILL_TABLE.getColumnModel().getColumn(7).setPreferredWidth(56);
            BILL_TABLE.getColumnModel().getColumn(7).setMaxWidth(56);
            BILL_TABLE.getColumnModel().getColumn(8).setMinWidth(93);
            BILL_TABLE.getColumnModel().getColumn(8).setPreferredWidth(93);
            BILL_TABLE.getColumnModel().getColumn(8).setMaxWidth(93);
            BILL_TABLE.getColumnModel().getColumn(9).setMinWidth(65);
            BILL_TABLE.getColumnModel().getColumn(9).setPreferredWidth(65);
            BILL_TABLE.getColumnModel().getColumn(9).setMaxWidth(65);
            BILL_TABLE.getColumnModel().getColumn(10).setMinWidth(65);
            BILL_TABLE.getColumnModel().getColumn(10).setPreferredWidth(65);
            BILL_TABLE.getColumnModel().getColumn(10).setMaxWidth(65);
            BILL_TABLE.getColumnModel().getColumn(11).setMinWidth(65);
            BILL_TABLE.getColumnModel().getColumn(11).setPreferredWidth(65);
            BILL_TABLE.getColumnModel().getColumn(11).setMaxWidth(65);
            BILL_TABLE.getColumnModel().getColumn(12).setMinWidth(65);
            BILL_TABLE.getColumnModel().getColumn(12).setPreferredWidth(65);
            BILL_TABLE.getColumnModel().getColumn(12).setMaxWidth(65);
        }

        S_NO.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        S_NO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        S_NO.setText("S/NO");
        S_NO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PRODUCT_DESC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_DESC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_DESC.setText("PRODUCT DISCRIPTION");
        PRODUCT_DESC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PRODUCT_HSN_CODE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_HSN_CODE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_HSN_CODE.setText("HSN CODE");
        PRODUCT_HSN_CODE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PRODUCT_UOM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PRODUCT_UOM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_UOM.setText("UOM");
        PRODUCT_UOM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PRODUCT_QTY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_QTY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_QTY.setText("QTY");
        PRODUCT_QTY.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PRODUCT_RATE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_RATE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_RATE.setText("RATE");
        PRODUCT_RATE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PRODUCT_AMOUNT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_AMOUNT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_AMOUNT.setText("AMOUNT");
        PRODUCT_AMOUNT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PRODUCT_DISCOUNT.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        PRODUCT_DISCOUNT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_DISCOUNT.setText("DISCOUNT");
        PRODUCT_DISCOUNT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PRODUCT_TAXABLE_VALUE.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        PRODUCT_TAXABLE_VALUE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_TAXABLE_VALUE.setText("TAXABLE VALUE");
        PRODUCT_TAXABLE_VALUE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PRODUCT_CGST.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_CGST.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_CGST.setText("CGST");
        PRODUCT_CGST.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PRODUCT_CGST_RATE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PRODUCT_CGST_RATE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_CGST_RATE.setText("RATE");
        PRODUCT_CGST_RATE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PRODUCT_CGST_AMOUNT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PRODUCT_CGST_AMOUNT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_CGST_AMOUNT.setText("AMT");
        PRODUCT_CGST_AMOUNT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PRODUCT_SGST.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_SGST.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_SGST.setText("SGST");
        PRODUCT_SGST.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PRODUCT_SGST_RATE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PRODUCT_SGST_RATE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_SGST_RATE.setText("RATE");
        PRODUCT_SGST_RATE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PRODUCT_SGST_AMOUNT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PRODUCT_SGST_AMOUNT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_SGST_AMOUNT.setText("AMT");
        PRODUCT_SGST_AMOUNT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PRODUCT_TOTAL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_TOTAL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_TOTAL.setText("TOTAL");
        PRODUCT_TOTAL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        IN_WORDS_PANEL.setBackground(new java.awt.Color(255, 255, 255));
        IN_WORDS_PANEL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        AMOUNT_IN_WORDS.setBackground(new java.awt.Color(255, 255, 255));
        AMOUNT_IN_WORDS.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AMOUNT_IN_WORDS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AMOUNT_IN_WORDS.setText("TOTAL INVOICE AMOUNT IN WORDS");
        AMOUNT_IN_WORDS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        AMOUNT_IN_WORDS_INPUT.setBackground(new java.awt.Color(255, 255, 255));
        AMOUNT_IN_WORDS_INPUT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AMOUNT_IN_WORDS_INPUT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AMOUNT_IN_WORDS_INPUT.setText("FIFTY THOUSAND RUPEES ONLY");
        AMOUNT_IN_WORDS_INPUT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout IN_WORDS_PANELLayout = new javax.swing.GroupLayout(IN_WORDS_PANEL);
        IN_WORDS_PANEL.setLayout(IN_WORDS_PANELLayout);
        IN_WORDS_PANELLayout.setHorizontalGroup(
            IN_WORDS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AMOUNT_IN_WORDS_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(AMOUNT_IN_WORDS, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
        );
        IN_WORDS_PANELLayout.setVerticalGroup(
            IN_WORDS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IN_WORDS_PANELLayout.createSequentialGroup()
                .addComponent(AMOUNT_IN_WORDS, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(AMOUNT_IN_WORDS_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        TOTAL.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TOTAL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TOTAL.setText("TOTAL");
        TOTAL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DUMMY_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DUMMY_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DUMMY_1.setText("-");
        DUMMY_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DUMMY_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DUMMY_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DUMMY_2.setText("-");
        DUMMY_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        QTY_TOTAL_INPUT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        QTY_TOTAL_INPUT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QTY_TOTAL_INPUT.setText("1005");
        QTY_TOTAL_INPUT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DUMMY_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DUMMY_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DUMMY_3.setText("-");
        DUMMY_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PRODUCT_AMOUNT_TOTAL_INPUT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PRODUCT_AMOUNT_TOTAL_INPUT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_AMOUNT_TOTAL_INPUT.setText("15000");
        PRODUCT_AMOUNT_TOTAL_INPUT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DUMMY_4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DUMMY_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DUMMY_4.setText("-");
        DUMMY_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PRODUCT_TAXABLE_VALUE_TOTAL_INPUT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PRODUCT_TAXABLE_VALUE_TOTAL_INPUT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_TAXABLE_VALUE_TOTAL_INPUT.setText("15000.00");
        PRODUCT_TAXABLE_VALUE_TOTAL_INPUT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DUMMY_5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DUMMY_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DUMMY_5.setText("-");
        DUMMY_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PRODUCT_CGST_AMOUNT_TOTAL_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_CGST_AMOUNT_TOTAL_INPUT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_CGST_AMOUNT_TOTAL_INPUT.setText("82.333");
        PRODUCT_CGST_AMOUNT_TOTAL_INPUT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DUMMY_6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DUMMY_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DUMMY_6.setText("-");
        DUMMY_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PRODUCT_SGST_AMOUNT_TOTAL_INPUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODUCT_SGST_AMOUNT_TOTAL_INPUT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRODUCT_SGST_AMOUNT_TOTAL_INPUT.setText("15000");
        PRODUCT_SGST_AMOUNT_TOTAL_INPUT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PRODUCT_SGST_AMOUNT_TOTAL_INPUT.setVerifyInputWhenFocusTarget(false);

        OVERALL_TOTAL.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        OVERALL_TOTAL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        OVERALL_TOTAL.setText("50000");
        OVERALL_TOTAL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        AMOUNT_INFO_PANEL.setBackground(new java.awt.Color(255, 255, 255));

        AMOUNT_BEFORE_TAX.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AMOUNT_BEFORE_TAX.setText("AMOUNT BEFORE TAX:");

        AMOUNT_BEFORE_TAX_INPUT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AMOUNT_BEFORE_TAX_INPUT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        AMOUNT_BEFORE_TAX_INPUT.setText("25000");

        ADD_CGST.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ADD_CGST.setText("ADD CGST:");

        ADD_CGST_INPUT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ADD_CGST_INPUT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ADD_CGST_INPUT.setText("5000");

        ADD_SGST.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ADD_SGST.setText("ADD SGST:");

        ROUNDED_OFF.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ROUNDED_OFF.setText("ROUNDED OFF:");

        ADD_SGST_INPUT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ADD_SGST_INPUT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ADD_SGST_INPUT.setText("5000");

        ROUNDED_OFF_INPUT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ROUNDED_OFF_INPUT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ROUNDED_OFF_INPUT.setText("50000");

        GST_REVERSE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        GST_REVERSE.setText("GST ON REVERSE CHARGES:");

        GST_REVERSE_INPUT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        GST_REVERSE_INPUT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GST_REVERSE_INPUT.setText("-");

        ACKNOWLEDGEMENT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ACKNOWLEDGEMENT.setText("certified about the above values are true and corect");

        FOR_KARISHMA_AGENCIES.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FOR_KARISHMA_AGENCIES.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FOR_KARISHMA_AGENCIES.setText("FOR KARISHMA AGENCIES");

        AUTHORISED_SIGNATORY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AUTHORISED_SIGNATORY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AUTHORISED_SIGNATORY.setText("AUTHORISED SIGNATORY");

        javax.swing.GroupLayout AMOUNT_INFO_PANELLayout = new javax.swing.GroupLayout(AMOUNT_INFO_PANEL);
        AMOUNT_INFO_PANEL.setLayout(AMOUNT_INFO_PANELLayout);
        AMOUNT_INFO_PANELLayout.setHorizontalGroup(
            AMOUNT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AMOUNT_INFO_PANELLayout.createSequentialGroup()
                .addGroup(AMOUNT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(GST_REVERSE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ROUNDED_OFF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ADD_SGST, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ADD_CGST, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AMOUNT_BEFORE_TAX, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(AMOUNT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GST_REVERSE_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AMOUNT_INFO_PANELLayout.createSequentialGroup()
                        .addGroup(AMOUNT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ROUNDED_OFF_INPUT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ADD_SGST_INPUT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ADD_CGST_INPUT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AMOUNT_BEFORE_TAX_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addComponent(ACKNOWLEDGEMENT, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(FOR_KARISHMA_AGENCIES, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(AUTHORISED_SIGNATORY, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        AMOUNT_INFO_PANELLayout.setVerticalGroup(
            AMOUNT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AMOUNT_INFO_PANELLayout.createSequentialGroup()
                .addGroup(AMOUNT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(AMOUNT_BEFORE_TAX_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(AMOUNT_BEFORE_TAX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(AMOUNT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ADD_CGST, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADD_CGST_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(AMOUNT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ADD_SGST, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADD_SGST_INPUT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(AMOUNT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ROUNDED_OFF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ROUNDED_OFF_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(AMOUNT_INFO_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GST_REVERSE, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GST_REVERSE_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(ACKNOWLEDGEMENT)
                .addGap(1, 1, 1)
                .addComponent(FOR_KARISHMA_AGENCIES)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(AUTHORISED_SIGNATORY, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout BILL_ITEMS_PANELLayout = new javax.swing.GroupLayout(BILL_ITEMS_PANEL);
        BILL_ITEMS_PANEL.setLayout(BILL_ITEMS_PANELLayout);
        BILL_ITEMS_PANELLayout.setHorizontalGroup(
            BILL_ITEMS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BILL_ITEMS_PANELLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(BILL_ITEMS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BILL_ITEMS_PANELLayout.createSequentialGroup()
                        .addGroup(BILL_ITEMS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BILL_ITEMS_PANELLayout.createSequentialGroup()
                                .addComponent(TOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(DUMMY_1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(DUMMY_2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(QTY_TOTAL_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(DUMMY_3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(PRODUCT_AMOUNT_TOTAL_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(DUMMY_4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(PRODUCT_TAXABLE_VALUE_TOTAL_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(IN_WORDS_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(BILL_ITEMS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BILL_ITEMS_PANELLayout.createSequentialGroup()
                                .addComponent(DUMMY_5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(PRODUCT_CGST_AMOUNT_TOTAL_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(DUMMY_6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(PRODUCT_SGST_AMOUNT_TOTAL_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(OVERALL_TOTAL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(AMOUNT_INFO_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(BILL_ITEMS_PANELLayout.createSequentialGroup()
                        .addComponent(S_NO, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(PRODUCT_DESC, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(PRODUCT_HSN_CODE, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(PRODUCT_UOM, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(PRODUCT_QTY, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(PRODUCT_RATE, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(PRODUCT_AMOUNT, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(PRODUCT_DISCOUNT)
                        .addGap(0, 0, 0)
                        .addComponent(PRODUCT_TAXABLE_VALUE, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(BILL_ITEMS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(BILL_ITEMS_PANELLayout.createSequentialGroup()
                                .addComponent(PRODUCT_CGST_RATE, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(PRODUCT_CGST_AMOUNT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(PRODUCT_CGST, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(BILL_ITEMS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PRODUCT_SGST, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(BILL_ITEMS_PANELLayout.createSequentialGroup()
                                .addComponent(PRODUCT_SGST_RATE, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(PRODUCT_SGST_AMOUNT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, 0)
                        .addComponent(PRODUCT_TOTAL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(BILL_TABLE_SCROLL_PANE)))
        );
        BILL_ITEMS_PANELLayout.setVerticalGroup(
            BILL_ITEMS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BILL_ITEMS_PANELLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(BILL_ITEMS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(S_NO, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PRODUCT_DESC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PRODUCT_HSN_CODE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PRODUCT_UOM, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PRODUCT_QTY, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PRODUCT_RATE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PRODUCT_AMOUNT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PRODUCT_DISCOUNT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PRODUCT_TAXABLE_VALUE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BILL_ITEMS_PANELLayout.createSequentialGroup()
                        .addGroup(BILL_ITEMS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PRODUCT_CGST, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                            .addComponent(PRODUCT_SGST, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addGroup(BILL_ITEMS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PRODUCT_CGST_RATE)
                            .addComponent(PRODUCT_CGST_AMOUNT)
                            .addComponent(PRODUCT_SGST_RATE)
                            .addComponent(PRODUCT_SGST_AMOUNT)))
                    .addComponent(PRODUCT_TOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(BILL_TABLE_SCROLL_PANE, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(BILL_ITEMS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DUMMY_5, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(DUMMY_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PRODUCT_AMOUNT_TOTAL_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DUMMY_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PRODUCT_TAXABLE_VALUE_TOTAL_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PRODUCT_CGST_AMOUNT_TOTAL_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DUMMY_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PRODUCT_SGST_AMOUNT_TOTAL_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OVERALL_TOTAL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BILL_ITEMS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(DUMMY_1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addComponent(TOTAL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(DUMMY_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(QTY_TOTAL_INPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(BILL_ITEMS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IN_WORDS_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AMOUNT_INFO_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout CONTAINER_PANELLayout = new javax.swing.GroupLayout(CONTAINER_PANEL);
        CONTAINER_PANEL.setLayout(CONTAINER_PANELLayout);
        CONTAINER_PANELLayout.setHorizontalGroup(
            CONTAINER_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AGENCY_INFO_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BILL_ITEMS_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BILL_INFO_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CLIENT_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CLIENT_INFO_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        CONTAINER_PANELLayout.setVerticalGroup(
            CONTAINER_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CONTAINER_PANELLayout.createSequentialGroup()
                .addComponent(AGENCY_INFO_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(BILL_INFO_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(CLIENT_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(CLIENT_INFO_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(BILL_ITEMS_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CONTAINER_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(CONTAINER_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PRINT_BILL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PRINT_BILL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PRINT_BILL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PRINT_BILL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PRINT_BILL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ACKNOWLEDGEMENT;
    private javax.swing.JLabel ADD_CGST;
    private javax.swing.JLabel ADD_CGST_INPUT;
    private javax.swing.JLabel ADD_SGST;
    private javax.swing.JLabel ADD_SGST_INPUT;
    private javax.swing.JLabel AGENCY_ADDRESS;
    private javax.swing.JLabel AGENCY_CODE;
    private javax.swing.JLabel AGENCY_CODE_INPUT;
    private javax.swing.JLabel AGENCY_GSTIN;
    private javax.swing.JPanel AGENCY_INFO_PANEL;
    private javax.swing.JLabel AGENCY_PHONE;
    private javax.swing.JLabel AGENCY_STATE;
    private javax.swing.JLabel AGENCY_STATE_INPUT;
    private javax.swing.JLabel AMOUNT_BEFORE_TAX;
    private javax.swing.JLabel AMOUNT_BEFORE_TAX_INPUT;
    private javax.swing.JPanel AMOUNT_INFO_PANEL;
    private javax.swing.JLabel AMOUNT_IN_WORDS;
    private javax.swing.JLabel AMOUNT_IN_WORDS_INPUT;
    private javax.swing.JLabel AUTHORISED_SIGNATORY;
    private javax.swing.JPanel BILL_INFO_PANEL;
    private javax.swing.JPanel BILL_ITEMS_PANEL;
    private javax.swing.JTable BILL_TABLE;
    private javax.swing.JScrollPane BILL_TABLE_SCROLL_PANE;
    private javax.swing.JLabel BILL_TO_PARTY;
    private javax.swing.JPanel CLIENT_INFO_PANEL;
    private javax.swing.JPanel CLIENT_PANEL;
    private javax.swing.JPanel CONTAINER_PANEL;
    private javax.swing.JLabel DATE_OF_SUPPLY;
    private javax.swing.JLabel DATE_OF_SUPPLY_INPUT;
    private javax.swing.JLabel DUMMY_1;
    private javax.swing.JLabel DUMMY_2;
    private javax.swing.JLabel DUMMY_3;
    private javax.swing.JLabel DUMMY_4;
    private javax.swing.JLabel DUMMY_5;
    private javax.swing.JLabel DUMMY_6;
    private javax.swing.JLabel FOR_KARISHMA_AGENCIES;
    private javax.swing.JLabel FSSAI_NO;
    private javax.swing.JLabel GOD_NAME;
    private javax.swing.JLabel GST_REVERSE;
    private javax.swing.JLabel GST_REVERSE_INPUT;
    private javax.swing.JLabel INVOICE_DATE;
    private javax.swing.JLabel INVOICE_DATE_INPUT;
    private javax.swing.JLabel INVOICE_NO;
    private javax.swing.JLabel INVOICE_NO_INPUT;
    private javax.swing.JPanel IN_WORDS_PANEL;
    private javax.swing.JLabel KARISHMA_AGENCIES;
    private javax.swing.JLabel OVERALL_TOTAL;
    private javax.swing.JLabel PILLAYAR_SUZHI;
    private javax.swing.JLabel PLACE_OF_SUPPLY;
    private javax.swing.JLabel PLACE_OF_SUPPLY_INPUT;
    private javax.swing.JLabel PRODUCT_AMOUNT;
    private javax.swing.JLabel PRODUCT_AMOUNT_TOTAL_INPUT;
    private javax.swing.JLabel PRODUCT_CGST;
    private javax.swing.JLabel PRODUCT_CGST_AMOUNT;
    private javax.swing.JLabel PRODUCT_CGST_AMOUNT_TOTAL_INPUT;
    private javax.swing.JLabel PRODUCT_CGST_RATE;
    private javax.swing.JLabel PRODUCT_DESC;
    private javax.swing.JLabel PRODUCT_DISCOUNT;
    private javax.swing.JLabel PRODUCT_HSN_CODE;
    private javax.swing.JLabel PRODUCT_QTY;
    private javax.swing.JLabel PRODUCT_RATE;
    private javax.swing.JLabel PRODUCT_SGST;
    private javax.swing.JLabel PRODUCT_SGST_AMOUNT;
    private javax.swing.JLabel PRODUCT_SGST_AMOUNT_TOTAL_INPUT;
    private javax.swing.JLabel PRODUCT_SGST_RATE;
    private javax.swing.JLabel PRODUCT_TAXABLE_VALUE;
    private javax.swing.JLabel PRODUCT_TAXABLE_VALUE_TOTAL_INPUT;
    private javax.swing.JLabel PRODUCT_TOTAL;
    private javax.swing.JLabel PRODUCT_UOM;
    private javax.swing.JLabel QTY_TOTAL_INPUT;
    private javax.swing.JLabel REVERSE_CHARGE;
    private javax.swing.JLabel REVERSE_CHARGE_INPUT;
    private javax.swing.JLabel ROUNDED_OFF;
    private javax.swing.JLabel ROUNDED_OFF_INPUT;
    private javax.swing.JSeparator SEPARATOR_1;
    private javax.swing.JSeparator SEPARATOR_2;
    private javax.swing.JSeparator SEPARATOR_3;
    private javax.swing.JSeparator SEPARATOR_5;
    private javax.swing.JLabel SHOP_ADDRESS;
    private javax.swing.JLabel SHOP_ADDRESS_1;
    private javax.swing.JLabel SHOP_ADDRESS_1_INPUT;
    private javax.swing.JLabel SHOP_ADDRESS_INPUT;
    private javax.swing.JLabel SHOP_CODE;
    private javax.swing.JLabel SHOP_CODE_1;
    private javax.swing.JLabel SHOP_CODE_1_INPUT;
    private javax.swing.JLabel SHOP_CODE_INPUT;
    private javax.swing.JLabel SHOP_GSTIN;
    private javax.swing.JLabel SHOP_GSTIN_1;
    private javax.swing.JLabel SHOP_GSTIN_1_INPUT;
    private javax.swing.JLabel SHOP_GSTIN_INPUT;
    private javax.swing.JLabel SHOP_NAME;
    private javax.swing.JLabel SHOP_NAME_1;
    private javax.swing.JLabel SHOP_NAME_1_INPUT;
    private javax.swing.JLabel SHOP_NAME_INPUT;
    private javax.swing.JLabel SHOP_STATE;
    private javax.swing.JLabel SHOP_STATE_1;
    private javax.swing.JLabel SHOP_STATE_1_INPUT;
    private javax.swing.JLabel SHOP_STATE_INPUT;
    private javax.swing.JLabel S_NO;
    private javax.swing.JLabel TAX_INVOICE;
    private javax.swing.JLabel TOTAL;
    private javax.swing.JLabel TRANSPORT_MODE;
    private javax.swing.JLabel TRANSPORT_MODE_INPUT;
    private javax.swing.JLabel VEHICLE_NO;
    private javax.swing.JLabel VEHICLE_NO_INPUT;
    // End of variables declaration//GEN-END:variables

  public void printRecord() {
         PrinterJob printerjob = PrinterJob.getPrinterJob();
       printerjob.setJobName("PRINT RECORD");
       
       printerjob.setPrintable(new Printable() {
           @Override
           public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
               
              if(pageIndex>0)
              {
                  return Printable.NO_SUCH_PAGE;
              }
              Dimension dim = CONTAINER_PANEL.getSize();
              double cHeight = dim.getHeight();
              double cWidth  = dim.getWidth();
              
              double pHeight = pageFormat.getImageableHeight();
              double pWidth  = pageFormat.getImageableWidth();
              
              double pXStart = pageFormat.getImageableX();
              double pYStart = pageFormat.getImageableY();
              
              double xRatio = pWidth/cWidth;
              double yRatio = pHeight/cWidth;
              
              Graphics2D graphics2D = (Graphics2D)graphics;
              graphics2D.translate(pXStart, pYStart);
              graphics2D.scale(xRatio,yRatio);
              
//              Graphics2D graphics2D = (Graphics2D)graphics;
//              graphics2D.translate(pageFormat.getImageableX()*2, pageFormat.getImageableY()*2);
//              graphics2D.scale(0.54,0.75);
//              CONTAINER_PANEL.printAll(graphics);
              CONTAINER_PANEL.paint(graphics);
              return Printable.PAGE_EXISTS;
           }

       });
       
       boolean returningresult = printerjob.printDialog();
       //System.out.println(returningresult);
       if(returningresult)
       {
           try
           {
               
               printerjob.print();
               dispose();
            }
           catch(PrinterException e)
           {
               JOptionPane.showMessageDialog(this, "PRINTER ERROR \nRETRY AGAIN", "ERROR", JOptionPane.WARNING_MESSAGE);
           }
       }
       else
       {
           printerjob.cancel();
           dispose();
       }
    }  
}
        
