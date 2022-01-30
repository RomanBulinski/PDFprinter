package rom.buulean.pdfprinter.jasper;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRSaver;

import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class JasperPrinter {

    public JasperPrinter()  {}

    public byte[] getBytePdfReport(){

        byte[] report = null;
        Resource reportResource = new ClassPathResource("reports/names2234.jrxml");
        try {
            InputStream reportStream = reportResource.getInputStream();
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("title1", "Employee Report");
            ;
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    jasperReport, parameters, new JREmptyDataSource() );

            report =  JasperExportManager.exportReportToPdf(jasperPrint);

        } catch (IOException | JRException e) {
            e.printStackTrace();
        }
        return report;
    }


    private void printPDFDirectlyFromJava(JasperPrint jasperPrint) throws JRException {
        JRPdfExporter exporter = new JRPdfExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(
                new SimpleOutputStreamExporterOutput("temporaryPDF.pdf"));

        SimplePdfReportConfiguration reportConfig
                = new SimplePdfReportConfiguration();
        reportConfig.setSizePageToContent(true);
        reportConfig.setForceLineBreakPolicy(false);

        SimplePdfExporterConfiguration exportConfig
                = new SimplePdfExporterConfiguration();
        exportConfig.setMetadataAuthor("buulean");
        exportConfig.setEncrypted(true);
        exportConfig.setAllowedPermissionsHint("PRINTING");

        exporter.setConfiguration(reportConfig);
        exporter.setConfiguration(exportConfig);

        exporter.exportReport();
    }




}
