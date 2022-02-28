package com.tenniscourts.guests;

import com.tenniscourts.config.persistence.BaseEntity;
import com.tenniscourts.reservations.Reservation;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Guest extends BaseEntity {

  @Column
  @NotNull
  private String name;

  @OneToOne(mappedBy="guest")
  private Reservation reservation;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Guest guest = (Guest) o;
    return getId() != null && Objects.equals(getId(), guest.getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
