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
public class AnimaleController {
  private List<Animale> animale = new ArrayList<Animale>();

  AnimaleController() {
    Animale p1 = new Animale(1,"Caine");
    Animale p2 = new Animale(2,"Pisica");
    Animale p3 = new Animale(3,"Castor");

    animale.add(p1);
    animale.add(p2);
    animale.add(p3);
  }

  @RequestMapping(value="/Animale", method = RequestMethod.GET)
  public List<Animale> index() {
    return this.animale;
  }

@RequestMapping(value="/Animale", method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody Animale p) {
  animale.add(p);
  
    return new ResponseEntity<Animale>(p, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/Animale/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Animale p : this.animale) {
      if(p.getId() == id) {
        return new ResponseEntity<Animale>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Animale/{id}/{nume}", method = RequestMethod.PUT)
  public List<Animale> update(@PathVariable("id") int id,@PathVariable("nume") String nume){
    for(Animale p : this.animale){
      if(p.getId() == id)     {
      p.setName(nume);
      }
    }
    return this.animale;
  }
  
  @RequestMapping(value="/Animale/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Animale p : this.animale) {
      if(p.getId() == id) {
        this.animale.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
