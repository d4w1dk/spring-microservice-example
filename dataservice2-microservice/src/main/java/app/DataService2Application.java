package app;


import brave.Span;
import brave.Tracer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;



import javax.inject.Inject;
import java.util.Hashtable;

@SpringBootApplication
@RestController
public class DataService2Application {

    public static void main(String[] args) {
        SpringApplication.run(DataService2Application.class, args);
    }

    @Inject
    private Tracer tracer;

    @RequestMapping(value = "/customer/{cid}/vehicledetails", method = RequestMethod.GET)
    public @ResponseBody
    String getCustomerVehicleDetails(@PathVariable Integer cid) throws InterruptedException {

        String result;

        Span s = this.tracer.currentSpan();
        s.name("vehicledetails");
        try {
            //add tags
            s.tag("customerid", cid.toString());

            Thread.sleep(500);

            Hashtable<Integer, String> vehicles = new Hashtable<>();
            vehicles.put(100, "Lincoln Continental; Plate SNUG30");
            vehicles.put(101, "Chevrolet Camaro; Plate R7TYR43");
            vehicles.put(102, "Volkswagen Beetle; Plate 6CVI3E2");

            result = vehicles.get(cid);

        } finally {
            s.finish();
        }

        return result;
    }

}
