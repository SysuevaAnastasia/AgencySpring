package controller;

import entity.Agency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import service.AgencyService;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/agency")
public class AgencyController {
    private final Logger logger = LoggerFactory.getLogger(AgencyController.class);
    private final AgencyService agencyService;

    @Autowired
    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @GetMapping()
    public ResponseEntity<List<Agency>> listAllAgency() {
        List<Agency> agencies = agencyService.getAll();
        if (agencies.isEmpty()) {
            logger.warn("The list of agencies is empty");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok().body(agencies);
    }

    @GetMapping("/{agencyId}")
    public ResponseEntity<Agency> getAgency(@PathVariable("agencyId") Long agencyId) {
        Agency agency = agencyService.getById(agencyId);
        if (agency == null) {
            logger.warn("No such agency with id: " + agencyId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(agency);
    }

    @PostMapping("/add")
    public ResponseEntity<Long> addAgency(@RequestBody Agency agency) throws ExecutionException, InterruptedException {
        Long id = agencyService.insert(agency).get();
        return ResponseEntity.ok().body(id);
    }

    @PutMapping("/change")
    public ResponseEntity<String> updateAgency(@RequestBody Agency agency) throws ExecutionException, InterruptedException {
        String result = agencyService.update(agency).get();
        if (result.equals("")) {
            logger.warn("No update such agency");
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("delete/{agencyId}")
    public ResponseEntity<String> deleteAgency(@PathVariable("agencyId") Long agencyId) throws ExecutionException, InterruptedException {
        String result = agencyService.delete(agencyId).get();
        if (result.equals("")) {
            logger.warn("No delete such agency with id: " + agencyId);
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        return ResponseEntity.ok().body(result);
    }
}
