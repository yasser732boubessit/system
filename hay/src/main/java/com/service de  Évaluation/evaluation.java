

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class evaluation {
    @RequestMapping("/hay")
   
    public String hay(){
        return " hay yasser ";
    }
    
}
