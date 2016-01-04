package hu.jusoft.gerevet.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import hu.jusoft.gerevet.repository.model.Examination;
import hu.jusoft.gerevet.repository.model.InvoiceGroups;
import hu.jusoft.gerevet.repository.model.Item;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Regina Seres on 1/4/2016.
 */
@Controller
public class PDFExportingController {

    private static String FILE = "c:/Users/Gidu/Desktop/FirstPdf.pdf";

    private static Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);

    private static Font boldDataFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

    private static Font dataFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL);

    public void generatePDF(Examination examination) {
        try {
            generateInvoicePDFByExamination(examination);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void generateInvoicePDFByExamination(Examination examination) throws FileNotFoundException {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            addTitlePage(document, examination);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private void addMetaData(Document document) {
        document.addTitle("My first PDF");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Lars Vogel");
        document.addCreator("Lars Vogel");
    }

    private void addTitlePage(Document document, Examination examination)
            throws DocumentException {
        addHeader(document, examination);
        addBuyerAndSeller(document, examination);
        addNewLine(document);
        BigDecimal netTotal = addSaleData(document, examination);
        addSummaryData(document, examination, netTotal);
    }

    private void addNewLine(Document document) throws DocumentException {
        Paragraph p = new Paragraph("", headerFont);
        addEmptyLine(p, 2);
        document.add(p);
    }

    private void addHeader(Document document, Examination examination) throws DocumentException {
        Paragraph p;
        p = new Paragraph("SZÁMLA", headerFont);
        document.add(p);
        p = new Paragraph("Számlaszám: " + examination.getInvoice().getInvoiceId(), boldDataFont);
        p.setAlignment(Element.ALIGN_RIGHT);
        addEmptyLine(p, 2);
        document.add(p);
    }

    private void addBuyerAndSeller(Document document, Examination examination) throws DocumentException {
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        PdfPCell seller = getPartyAddress("From:",
                "Ceg neve",
                "Ceg Varosa",
                "Ceg cime");
        table.addCell(seller);
        PdfPCell buyer = getPartyAddress("To:",
                examination.getPatient().getName(),
                examination.getPatient().getCity(),
                examination.getPatient().getAddress());
        table.addCell(buyer);
        document.add(table);
    }

    private BigDecimal addSaleData(Document document, Examination examination) throws DocumentException {
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10);
        table.setSpacingAfter(10);
        table.setWidths(new int[]{7, 5, 2, 2});
        table.addCell(getCell("Csoport", Element.ALIGN_CENTER, dataFont, true));
        table.addCell(getCell("Megjegyzés", Element.ALIGN_CENTER, dataFont, true));
        table.addCell(getCell("Ár", Element.ALIGN_CENTER, dataFont, true));
        table.addCell(getCell("Összesen", Element.ALIGN_CENTER, dataFont, true));

        BigDecimal netTotal = new BigDecimal(0);

        for (InvoiceGroups invoiceGroup : examination.getInvoice().getInvoiceGroup()) {
            PdfPCell invoiceGroupCell = getCell(invoiceGroup.getName(), Element.ALIGN_LEFT, boldDataFont, false);
            invoiceGroupCell.setBorder(Rectangle.LEFT);
            table.addCell(invoiceGroupCell);
            table.addCell(getCell("", Element.ALIGN_LEFT, boldDataFont, false));
            table.addCell(getCell("", Element.ALIGN_LEFT, boldDataFont, false));
            BigDecimal total = new BigDecimal(0);
            java.util.List<PdfPCell> cells = new ArrayList<>();
            for (Item item : invoiceGroup.getItems()) {
                total = total.add(item.getPrice());
                cells.add(getCell("", Element.ALIGN_LEFT, dataFont, true));
                cells.add(getCell(item.getDescription(), Element.ALIGN_LEFT, dataFont, true));
                cells.add(getCell(item.getPrice().toString(), Element.ALIGN_LEFT, dataFont, true));
                cells.add(getCell("", Element.ALIGN_LEFT, dataFont, true));
            }
            table.addCell(getCell(total.toString(), Element.ALIGN_LEFT, boldDataFont, true));

            for (PdfPCell cell : cells) {
                table.addCell(cell);
            }
            netTotal = netTotal.add(total);
        }
        document.add(table);

        return netTotal;
    }

    private void addSummaryData(Document document, Examination examination, BigDecimal netTotal) throws DocumentException {
        BigDecimal tax = netTotal.multiply(new BigDecimal("0.25"));
        BigDecimal bruttoTotal = netTotal.add(tax);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{3, 3, 3, 2, 4});
        PdfPCell dateInformationLabelCell = new PdfPCell();
        dateInformationLabelCell.addElement(new Paragraph("Számla dátuma:", boldDataFont));
        dateInformationLabelCell.addElement(new Paragraph("Fizetési határidő:", boldDataFont));
        dateInformationLabelCell.addElement(new Paragraph("Fizetés dátuma:", boldDataFont));
        dateInformationLabelCell.setBorder(PdfPCell.NO_BORDER);
        table.addCell(dateInformationLabelCell);

        PdfPCell dateInformation = new PdfPCell();
        dateInformation.addElement(new Paragraph(convertDate(examination.getInvoice().getInvoceDate(), "yyyy.MM.dd"), dataFont));
        dateInformation.addElement(new Paragraph(convertDate(examination.getInvoice().getDayOfPayment(), "yyyy.MM.dd"), dataFont));
        dateInformation.addElement(new Paragraph(convertDate(examination.getInvoice().getDayOfPayment(), "yyyy.MM.dd"), dataFont));
        dateInformation.setBorder(PdfPCell.NO_BORDER);
        table.addCell(dateInformation);

        PdfPCell cell = new PdfPCell();
        cell.setBorder(PdfPCell.NO_BORDER);
        table.addCell(cell);

        PdfPCell payInformation = new PdfPCell();
        payInformation.addElement(new Paragraph("Összesen: ", boldDataFont));
        payInformation.setBorder(PdfPCell.NO_BORDER);
        table.addCell(payInformation);

        PdfPCell payDatas = new PdfPCell();
        payDatas.addElement(new Paragraph(netTotal.toString(), dataFont));
        payDatas.addElement(new Paragraph(tax.toString(), dataFont));
        payDatas.addElement(new Paragraph("_______", dataFont));
        payDatas.addElement(new Paragraph(bruttoTotal.toString(), dataFont));
        payDatas.setBorder(PdfPCell.NO_BORDER);
        payDatas.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(payDatas);

        document.add(table);
    }

    private PdfPCell getPartyAddress(String who, String name, String city, String address) {
        PdfPCell cell = new PdfPCell();
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.addElement(new Paragraph(who, boldDataFont));
        cell.addElement(new Paragraph(name, dataFont));
        cell.addElement(new Paragraph(city, dataFont));
        cell.addElement(new Paragraph(address, dataFont));
        return cell;
    }

    private PdfPCell getCell(String value, int alignment, Font font, boolean border) {
        PdfPCell cell = new PdfPCell();
        cell.setUseAscender(true);
        cell.setUseDescender(true);
        Paragraph p = new Paragraph(value, font);
        p.setAlignment(alignment);
        cell.addElement(p);
        if (!border)
            cell.setBorder(PdfPCell.NO_BORDER);

        return cell;
    }

    private String convertDate(Date d, String newFormat) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(newFormat);
        return sdf.format(d);
    }

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}