package Shopping;

import java.awt.*;
import java.awt.print.*;
import java.util.StringTokenizer;


public class Print implements Printable{

    private String receiptToPrint;
    StringTokenizer st;

    public int print(Graphics g, PageFormat pf, int page)
            throws PrinterException {


        if (page > 0) {
            return NO_SUCH_PAGE;
        }


        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        st = new StringTokenizer(receiptToPrint,"\n");
        int y=100;
        while(st.hasMoreTokens()){
            g.drawString(st.nextToken().replace("\t","  "),100,y);
            y+=20;
        }


        return PAGE_EXISTS;
    }
    public void printReceipt(){
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
              /* The job did not successfully complete */
            }
        }
    }

    public void setReceiptToPrint(String receiptToPrint) {
        this.receiptToPrint = receiptToPrint;
    }
}
