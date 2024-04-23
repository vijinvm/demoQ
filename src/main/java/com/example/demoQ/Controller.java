package com.example.demoQ;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class Controller {
@Autowired
private UserRepository p;
@GetMapping("/user")
public Page<User>a1(@RequestParam int page,
		@RequestParam int size){
	return p.findAll(PageRequest.of(page, size));
}


@GetMapping("/user/{id}")
public User a4(@PathVariable int id) {
	return p.findById(id).orElse(null);
}
@PostMapping("/user")
public User a5(@RequestBody User user) {
	return p.save(user);
}
@PutMapping("/user/{id}")
public User a6(@PathVariable int id,@RequestBody User user) {
	return p.findById(id).map(e->{e.setFirstname(user.getFirstname());
	e.setLastname(user.getLastname());
	return p.save(e);
})
			.orElse(null);
}
@DeleteMapping("/user/{id}")
public void a7(@PathVariable int id) {
	p.deleteById(id);
}
@Autowired
private VehicleRepository b;

@GetMapping("/vehicle")
public Page<Vehicle>b1(@RequestParam int page,
		@RequestParam int size){
	return b.findAll(PageRequest.of(page, size));
}

@GetMapping("/vehicle/{id}")
public Vehicle b4(@PathVariable int id) {
	return b.findById(id).orElse(null);
}
@PostMapping("/vehicle")
public Vehicle b5(@RequestBody Vehicle vehicle) {
	return b.save(vehicle);
}
@PutMapping("/vehicle/{id}")
public Vehicle b6(@PathVariable int id,@RequestBody Vehicle vehicle) {
	return b.findById(id).map(e->{e.setName(vehicle.getName());
	e.setYear(vehicle.getYear());
	return b.save(e);
})
			.orElse(null);
}
@DeleteMapping("/vehicle/{id}")
public void b7(@PathVariable int id) {
	b.deleteById(id);
}
}