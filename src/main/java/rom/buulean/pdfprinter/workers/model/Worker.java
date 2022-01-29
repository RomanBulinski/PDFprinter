package rom.buulean.pdfprinter.workers.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Worker {

    private String name;
    private String surname;

    public Worker() {
    }
}
