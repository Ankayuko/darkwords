package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class CartiController {
  private List<Carti> carti = new ArrayList<Carti>();

  CartiController() {
    
    Carti p1 = new Carti(1, "A game of thrones"); 
    Carti p2 = new Carti(2, "A clash of kings"); 
    Carti p3 = new Carti(3, "A storm of swords"); 
    Carti p4 = new Carti(4, "A feast for crows"); 
    Carti p5 = new Carti(5, "A dance with dragons");

    carti.add(p1);
    carti.add(p2);
    carti.add(p3);
    carti.add(p4);
    carti.add(p5);
 
  }

  @RequestMapping(value="/Carti", method = RequestMethod.GET)
  public List<Carti> index() {
    return this.carti;
  }

@RequestMapping(value="/Carti", method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody Carti p) {
  carti.add(p);
  
    return new ResponseEntity<Carti>(p, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/Carti/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Carti p : this.carti) {
      if(p.getId() == id) {
        return new ResponseEntity<Carti>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Carti/{id}/{nume}", method = RequestMethod.PUT)
  public List<Carti> update(@PathVariable("id") int id,@PathVariable("nume") String nume){
    for(Carti p : this.carti){
      if(p.getId() == id)     {
      p.setName(nume);
      }
    }
    return this.carti;
  }
  
  @RequestMapping(value="/Carti/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Carti p : this.carti) {
      if(p.getId() == id) {
        this.carti.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
