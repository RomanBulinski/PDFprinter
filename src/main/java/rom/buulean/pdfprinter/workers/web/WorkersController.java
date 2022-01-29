package rom.buulean.pdfprinter.workers.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rom.buulean.pdfprinter.workers.application.WorkersService;
import rom.buulean.pdfprinter.workers.model.Worker;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping
public class WorkersController {

    private final WorkersService workersService;

    @GetMapping("/workers")
    public List<Worker> findAllWorkers(){
        return workersService.findAllWorkers();
    }

}
