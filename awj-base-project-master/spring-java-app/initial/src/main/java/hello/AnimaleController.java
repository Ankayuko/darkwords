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
  private List<Animale> persoane = new ArrayList<Animale>();

  AnimaleController() {
    Animale p1 = new Animale(1, "Caine");
    Animale p2 = new Animale(2, "Pisica");
    Animale p3 = new Animale(3, "Castor");

    persoane.add(p1);
    persoane.add(p2);
    persoane.add(p3);
  }

  @RequestMapping(value="/Animale", method = RequestMethod.GET)
  public List<Animale> index() {
    return this.persoane;
  }

  @RequestMapping(value="/Animale/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Animale p : this.persoane) {
      if(p.getId() == id) {
        return new ResponseEntity<Animale>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Animale/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Animale p : this.persoane) {
      if(p.getId() == id) {
        this.persoane.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

 @RequestMapping(value="/Animale/{id}/{name}", method = RequestMethod.POST)
  public ResponseEntity post(@PathVariable("id") int id, @PathVariable("name") String name) {
	Animale pers = new Animale(id, name);
	persoane.add(pers);
	return new ResponseEntity<Animale>(pers, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/Animale/{id}/{name}", method = RequestMethod.PUT)
  public ResponseEntity put(@PathVariable("id") int id, @PathVariable("name") String name) {	
  	for(Animale p : this.persoane) {
      		if(p.getId() == id) {
			p.setId(10);
			p.setName(name);
			return new ResponseEntity<Animale>(p, new HttpHeaders(), HttpStatus.OK);	
                }
  	}
	return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }





}