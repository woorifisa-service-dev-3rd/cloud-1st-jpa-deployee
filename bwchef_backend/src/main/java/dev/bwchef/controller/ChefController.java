package dev.bwchef.controller;

import dev.bwchef.model.Chef;
import dev.bwchef.repository.ChefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chef")
@CrossOrigin(origins="http://localhost")
public class ChefController {

    @Autowired
    private ChefRepository chefRepository;

    @GetMapping
    public List<Chef> getAllChefs(){
        return chefRepository.findAll();
    }

    @PostMapping
    public Chef createChef(@RequestBody Chef chef){
        return chefRepository.save(chef);
    }
    @PutMapping("/{id}")
    public Chef updateChef(@PathVariable Long id, @RequestBody Chef chef){
        chef.setId(id);
        return  chefRepository.update(chef);
    }

    @DeleteMapping("/{id}")
    public void deleteChef(@PathVariable Long id){
        chefRepository.delete(id);
    }


}
