package Shopping;

import java.awt.*;
import java.awt.print.*;
import java.util.StringTokenizer;

//Printing a receipt
public class Print implements Printable{

    private String receiptToPrint;
    private StringTokenizer st;

   //Constructor is forming a receipt look
    public int print(Graphics g, PageFormat pf, int page)
            throws PrinterException {

        //without this statement a printer wouldn't stop adding empty pages to print que
       if (page > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        g2d.setFont(new Font("Dialog",0,5));

        st = new StringTokenizer(receiptToPrint,"\n");
        int y=100;
        while(st.hasMoreTokens()){
            g.drawString(st.nextToken().replace("\t","  "),100,y);
            y+=5;
        }
        return PAGE_EXISTS;
    }
    //method that printing prepared Graphic file
    public void printReceipt(){
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
              ex.getMessage();
            }
        }
    }

    public void setReceiptToPrint(String receiptToPrint) {
        this.receiptToPrint = receiptToPrint;
    }
}
