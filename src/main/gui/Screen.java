package main.gui;

import Shopping.Print;
import Shopping.Receipt;
import Shopping.ShoppingCart;
import products.Product;
import products.ReadCsvFile;
import products.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Screen extends JFrame implements ActionListener{

    private boolean wrongBarcodeFormat=false;

    String myPath = "product2.csv";
    File myFile = new File(myPath);
    ReadCsvFile myRead = new ReadCsvFile(myFile);

    ShoppingCart sc = new ShoppingCart();


    JTextField barcodeField = new JTextField(10);
    JTextArea receiptArea = new JTextArea(500,100);
    JScrollPane scroll ;
    JLabel description=new JLabel("Podaj kod kreskowy"),status=new JLabel("Status: ");
    JButton add=new JButton("Dodaj produkt"),print=new JButton("Drukuj/Zapisz"),close=new JButton("Zamknij program");

    public Screen(){

        //Wyglad prostego gui
        super("Impaq");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        setBounds(0,0,800,600);
        setLayout(null);

        status.setBounds(300,520,300,30);
        description.setBounds(50,220,200,30);

        add.setBounds(0,280,200,20);
        print.setBounds(0,310,200,20);
        close.setBounds(0,340,200,20);

        barcodeField.setBounds(50,250,100,20);
        receiptArea.setBounds(0,0,500,780);
        receiptArea.setFont(new Font("Dialog",0,15));
        receiptArea.setText("\tNAZWA\tCENA\n");
        receiptArea.setEnabled(false);

        scroll = new JScrollPane(receiptArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(300,0,480,500);

        add.addActionListener(this);
        close.addActionListener(this);
        print.addActionListener(this);


        add(add);
        add(print);
        add(close);
        add(description);
        add(status);
        add(barcodeField);
        add(scroll);
        setVisible(true);

    }

    //Obluga przyciskow

    public void actionPerformed(ActionEvent evt){
        Object source= evt.getSource();
        //Polymorphism here
       myRead = new ReadCsvFile(myFile);
       myRead.readMyCsvFile();


        Scanner scanner = new Scanner(myRead);
        if(source==add){
            wrongBarcodeFormat=false;

            if(barcodeField.getText().isEmpty()==false) {
                receiptArea.setText("\tNAZWA\tCENA\n");
try {
    sc.addProductToShoppingCart(scanner.searchBarcode(Integer.parseInt(barcodeField.getText())));
}catch(NumberFormatException ex){
    status.setText("Status: Product not found");
}
                for (Product i : sc.products) {
                    receiptArea.append("\n\t" + i.getName() + "\t" + i.getPrice());
                }
                double roundOff = Math.round(sc.getSumOfPrices() * 100.0) / 100.0;
                String sum = "\n\n\tłączna kwota do zaplaty :" + roundOff + "zł";
                receiptArea.append(sum);
                status.setText("Status: ");

            if(scanner.isBarcodeFound()==false&&wrongBarcodeFormat==false){
                status.setText("Status: Product not found");
                receiptArea.setText("\tNAZWA\tCENA\n");
            }}else status.setText("Satus: Invalid bar-code");

        }
        if(source==close){
            if(receiptArea.getText().equals("\tNAZWA\tCENA\n")){
                System.exit(1);
            }else{status.setText("Status: Print the receipt before exiting");}
        }
        if(source==print){

            Receipt receipt = new Receipt(sc);
            receipt.prepareRecepit();
            receipt.saveReceipt();
            receiptArea.setText("\tNAZWA\tCENA\n");

            Print print = new Print();
            print.setReceiptToPrint(receipt.readyReceipt);
            print.printReceipt();

        }
    }

}
