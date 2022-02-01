package rom.buulean.pdfprinter.jasper;

import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.engine.util.JRStyledText;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import rom.buulean.pdfprinter.workers.application.WorkersService;
import rom.buulean.pdfprinter.workers.model.Worker;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@AllArgsConstructor
@Service
public class JasperPrinter {

    private final WorkersService workersService;

    public byte[] getBytePdfReport() {

        setFontSettings();

        byte[] report = null;
        try {
            //Kompilacja *.jrxml -> *.jasper
            Resource reportResource = new ClassPathResource("reports/pracownicy.jrxml");
            InputStream reportStream = reportResource.getInputStream();
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);
            //Mozna zapisac plik jasper lokalnie
            JRSaver.saveObject(jasperReport, "temporaryJasper.jasper");

            //Przygotowanie Paramatrów do wstrzyknięcia
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("company", "SoftNet");

            Locale locale = new Locale("pl", "PL");
            parameters.put(JRParameter.REPORT_LOCALE, locale);

            //Przygotowanie Danych do wstrzyknięcia
            List<Worker> workers = workersService.findAllWorkers();
            JRDataSource dataSource = new JRBeanCollectionDataSource(workers, true);

            //Plik JasperReport(*.jasper) wypelnieny danymi i zwracany jako JasperPrint
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    jasperReport,
                    parameters,
                    dataSource);
//            new JREmptyDataSource());

            //Plik JasperPrint -> byte[] w  formacie PDF
            report = JasperExportManager.exportReportToPdf(jasperPrint);

        } catch (IOException | JRException e) {
            e.printStackTrace();
        }
        return report;
    }

    private static void setFontSettings() {
        final DefaultJasperReportsContext context = DefaultJasperReportsContext.getInstance();
        JRPropertiesUtil.getInstance(context).setProperty(JRStyledText.PROPERTY_AWT_IGNORE_MISSING_FONT, "true");
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
