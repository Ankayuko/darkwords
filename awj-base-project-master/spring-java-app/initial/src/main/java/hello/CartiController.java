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
  private List<Carti> persoane = new ArrayList<Carti>();

  CartiController() {
    Carti p1 = new Carti(1, "A game of thrones");
    Carti p2 = new Carti(2, "A clash of kings");
    Carti p3 = new Carti(3, "A storm of swords");
    Carti p3 = new Carti(3, "A feast for crows");
    Carti p3 = new Carti(3, "A dance with dragons");

    persoane.add(p1);
    persoane.add(p2);
    persoane.add(p3);
  }

  @RequestMapping(value="/Carti", method = RequestMethod.GET)
  public List<Carti> index() {
    return this.persoane;
  }

  @RequestMapping(value="/Carti/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Carti p : this.persoane) {
      if(p.getId() == id) {
        return new ResponseEntity<Carti>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Carti/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Carti p : this.persoane) {
      if(p.getId() == id) {
        this.persoane.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

 @RequestMapping(value="/Carti/{id}/{name}", method = RequestMethod.POST)
  public ResponseEntity post(@PathVariable("id") int id, @PathVariable("name") String name) {
	Carti pers = new Carti(id, name);
	persoane.add(pers);
	return new ResponseEntity<Carti>(pers, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/Carti/{id}/{name}", method = RequestMethod.PUT)
  public ResponseEntity put(@PathVariable("id") int id, @PathVariable("name") String name) {	
  	for(Carti p : this.persoane) {
      		if(p.getId() == id) {
			p.setId(10);
			p.setName(name);
			return new ResponseEntity<Carti>(p, new HttpHeaders(), HttpStatus.OK);	
                }
  	}
	return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }





}