package rom.buulean.pdfprinter.workers.application;

import org.springframework.stereotype.Service;
import rom.buulean.pdfprinter.workers.model.Worker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.CharSequence.compare;

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

//        workers.add( new Worker("Adamus1","Mickiewicz",10) );
        workers.add( new Worker("Juliusz1","Mickiewicz",10) );
        workers.add( new Worker("Wacław1","Mickiewicz", 10) );
        workers.add( new Worker("Władysław1","Mickiewicz",10) );
        workers.add( new Worker("Adamus12","Mickiewicz",10) );
        workers.add( new Worker("Juliusz12","Mickiewicz",10) );
        workers.add( new Worker("Wacław12","Mickiewicz", 10) );
        workers.add( new Worker("Władysław12","Mickiewicz",10) );
        workers.add( new Worker("Adamus13","Mickiewicz",10) );
        workers.add( new Worker("Juliusz14","Mickiewicz",10) );
        workers.add( new Worker("Wacław15","Mickiewicz", 10) );
        workers.add( new Worker("Władysław16","Mickiewicz",10) );

        workers.add( new Worker("Adamus","Reymont",20) );
        workers.add( new Worker("Juliusz","Reymont",20) );
        workers.add( new Worker("Wacław","Reymont", 20) );
        workers.add( new Worker("Władysław","Reymont",20) );
        workers.add( new Worker("Adamus22","Reymont",20) );
        workers.add( new Worker("Juliusz22","Reymont",20) );

        workers.add( new Worker("Adamus","Słowacki",30) );
        workers.add( new Worker("Juliusz","Słowacki",30) );
        workers.add( new Worker("Wacław","Słowacki", 30) );
        workers.add( new Worker("Waldek1","Słowacki",10) );
        workers.add( new Worker("Józek2","Słowacki",10) );
        workers.add( new Worker("Józek3","Słowacki", 10) );
        workers.add( new Worker("Józek4","Słowacki",10) );
        workers.add( new Worker("Józek5","Słowacki", 10) );
        workers.add( new Worker("Józek6","Słowacki",10) );
        workers.add( new Worker("Józek7","Słowacki",10) );
        workers.add( new Worker("Józek8","Słowacki",10) );
        workers.add( new Worker("Józek9","Słowacki", 10) );
        workers.add( new Worker("Józek10","Słowacki",10) );

        workers.add( new Worker("Wacław","Potocki", 15) );
        workers.add( new Worker("Władysław","Potocki",15) );

        workers.add( new Worker("Adamus","Mickiewicz",10) );
        workers.add( new Worker("Juliusz","Mickiewicz",10) );
        workers.add( new Worker("Wacław","Mickiewicz", 10) );
        workers.add( new Worker("Władysław","Mickiewicz",10) );
        workers.add( new Worker("Wacław2","Mickiewicz", 10) );
        workers.add( new Worker("Władysław2","Mickiewicz",10) );
        workers.add( new Worker("Adamus3","Mickiewicz",10) );
        workers.add( new Worker("Juliusz3","Mickiewicz",10) );
        workers.add( new Worker("Wacław3","Mickiewicz", 10) );
        workers.add( new Worker("Władysław3","Mickiewicz",10) );
        workers.add( new Worker("Waldek1","Mickiewicz",10) );
        workers.add( new Worker("Józek2","Mickiewicz",10) );
        workers.add( new Worker("Józek3","Mickiewicz", 10) );
        workers.add( new Worker("Józek4","Mickiewicz",10) );
        workers.add( new Worker("Józek5","Mickiewicz", 10) );
        workers.add( new Worker("Józek6","Mickiewicz",10) );
        workers.add( new Worker("Józek7","Mickiewicz",10) );
        workers.add( new Worker("Józek8","Mickiewicz",10) );
        workers.add( new Worker("Józek9","Mickiewicz", 10) );
        workers.add( new Worker("Józek10","Mickiewicz",10) );


        workers.add( new Worker("Adamus","Potocki",30) );
        workers.add( new Worker("Juliusz","Potocki",30) );

        workers.add( new Worker("Adamus2","Mickiewicz",10) );
        workers.add( new Worker("Juliusz2","Mickiewicz",10) );

        Collections.sort(workers, (s1, s2) ->
                compare(s1.getSurname(), s2.getSurname()));

        return workers;
    }

}
