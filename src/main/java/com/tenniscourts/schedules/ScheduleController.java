package com.tenniscourts.schedules;

import com.tenniscourts.config.BaseRestController;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/tennis", consumes = "application/json", produces = "application/json")
public class ScheduleController extends BaseRestController {

    private final ScheduleService scheduleService;



    @PostMapping("/schedule")
    public ResponseEntity<Void> addScheduleTennisCourt(@Valid @RequestBody ScheduleDTO scheduleDTO) {
        return ResponseEntity.created(locationByEntity(scheduleService.addSchedule(scheduleDTO).getId())).build();
    }

    @GetMapping("/schedule/dates")
    public ResponseEntity<List<ScheduleDTO>> findSchedulesByDates(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                                  @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(scheduleService.findSchedulesByDates(LocalDateTime.of(startDate, LocalTime.of(0, 0)), LocalDateTime.of(endDate, LocalTime.of(23, 59))));
    }

    @GetMapping("/schedule/{id}")
    public ResponseEntity<ScheduleDTO> findByScheduleId(@PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.findSchedule(id));
    }
}
