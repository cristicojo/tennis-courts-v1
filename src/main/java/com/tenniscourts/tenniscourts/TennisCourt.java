package com.tenniscourts.tenniscourts;

import com.tenniscourts.config.persistence.BaseEntity;
import com.tenniscourts.schedules.Schedule;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TennisCourt extends BaseEntity {

    @Column
    @NotNull
    private String name;

    @OneToMany(mappedBy = "tennisCourt")
    @ToString.Exclude
    private List<Schedule> scheduleList;
}
