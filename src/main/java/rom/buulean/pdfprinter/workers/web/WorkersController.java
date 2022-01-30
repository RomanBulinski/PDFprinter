package rom.buulean.pdfprinter.workers.web;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rom.buulean.pdfprinter.jasper.JasperPrinter;
import rom.buulean.pdfprinter.workers.application.WorkersService;
import rom.buulean.pdfprinter.workers.model.Worker;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping
public class WorkersController {

    private final WorkersService workersService;
    private final JasperPrinter jasperPrinter;

    @GetMapping("/workers")
    public List<Worker> findAllWorkers(){
        return workersService.findAllWorkers();
    }

    @GetMapping("/workers/print_pdf")
    public ResponseEntity getPdfPrint(){
        byte[] report = jasperPrinter.getBytePdfReport();
        return  ResponseEntity.ok(report);
    }

}
