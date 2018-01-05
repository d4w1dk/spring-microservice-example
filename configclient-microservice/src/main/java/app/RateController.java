package app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RefreshScope
class RateController {

    @Value("${rate}")
    String rate;

    @Value("${lanecount}")
    String lanecount;

    @Value("${tollstart}")
    String tollstart;

    @Value("${connstring}")
    String connstring;

    @RequestMapping("/rate")
    public String getRate(Model model) {

        model.addAttribute("rateamount", rate);
        model.addAttribute("lanes", lanecount);
        model.addAttribute("tollstart", tollstart);
        model.addAttribute("connstring", connstring);

        return "rateview";
    }
}
