package rom.buulean.pdfprinter.workers.application;

import org.springframework.stereotype.Service;
import rom.buulean.pdfprinter.workers.model.Worker;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkersService {

    private  List<Worker> workers = new ArrayList<>();

    public WorkersService() {
        findMockWorkers();
    }

    public List<Worker> findAllWorkers(){
        return workers;
    }

    private List<Worker> findMockWorkers() {
        workers.add( new Worker("Adam","Mickiewicz") );
        workers.add( new Worker("Juliusz","Słowacki") );
        workers.add( new Worker("Władysław","Reymont") );
        workers.add( new Worker("Wacław","Potocki") );
        return workers;
    }

}
