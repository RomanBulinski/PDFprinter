package rom.buulean.pdfprinter;

import net.sf.jasperreports.engine.JRException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rom.buulean.pdfprinter.jasper.JasperPrinter;

@SpringBootApplication
public class PdFprinterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdFprinterApplication.class, args);

//        try {
//            JasperPrinter jasperPrinter = new JasperPrinter();
//        } catch (JRException e) {
//            e.printStackTrace();
//        }
    }
}
