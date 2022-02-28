package com.tenniscourts.tenniscourts;

import com.tenniscourts.config.BaseRestController;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/tennis", consumes = "application/json", produces = "application/json")
public class TennisCourtController extends BaseRestController {

    private final TennisCourtService tennisCourtService;


    @PostMapping("/court")
    public ResponseEntity<Void> addTennisCourt(@Valid @RequestBody TennisCourtDTO tennisCourtDTO) {
        return ResponseEntity.created(locationByEntity(tennisCourtService.addTennisCourt(tennisCourtDTO).getId())).build();
    }

    @GetMapping("/court/{id}")
    public ResponseEntity<TennisCourtDTO> findTennisCourtById(@PathVariable Long id) {
        return ResponseEntity.ok(tennisCourtService.findTennisCourtById(id));
    }

    @GetMapping("/courtSchedules/{id}")
    public ResponseEntity<TennisCourtDTO> findTennisCourtWithSchedulesById(@PathVariable Long id) {
        return ResponseEntity.ok(tennisCourtService.findTennisCourtWithSchedulesById(id));
    }
}
