package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

  @RequestMapping(value="/carti", method = RequestMethod.GET)
  public List<Carti> index() {
    return this.carti;
  }

  @RequestMapping(value="/carti/{nume}", method = RequestMethod.POST)
  public ResponseEntity create(@PathVariable("nume") String name) {
	  
	 Carti p = new Carti(this.carti.size() + 1,name); 
	 this.carti.add(p);
	
    return new ResponseEntity<Carti>(p, new HttpHeaders(), HttpStatus.OK);
  }


  
  @RequestMapping(value="/carte/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Carti c : this.carti) {
      if(c.getId() == id) {
        return new ResponseEntity<Carti>(c, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
   
   
  @RequestMapping(value="/carte", method = RequestMethod.PUT)
  public List<Carti> update(@RequestBody Carti carte){
    for(Carti c : this.carti){
      if(carte.getId() == c.getId())		  {
		  carti.set(carti.indexOf(c), carte);
      }
    }
    return this.carti;
  }
  
  
  @RequestMapping(value="/carte/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Carti c : this.carti) {
      if(c.getId() == id) {
        this.carti.remove(c);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
  
}