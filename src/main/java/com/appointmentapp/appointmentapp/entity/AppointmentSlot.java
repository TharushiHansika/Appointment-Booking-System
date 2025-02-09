package com.appointmentapp.appointmentapp.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointmentSlots") 
public class AppointmentSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Date is required")
    @Column(nullable = false)
    private LocalDate date;

    @NotNull(message = "Start time is required")
    @Column(nullable = false)
    private LocalTime startTime;
    
    @NotNull(message = "End time is required")
    @Column(nullable = false)
    private LocalTime endTime;

    @Column(nullable = false)
    private Boolean isBooked = false; 

    @OneToOne(mappedBy = "appointmentSlot", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Appointment appointment;

    public void bookSlot() {
        this.isBooked = true;
    }
    
    public void releaseSlot() {
        this.isBooked = false;
    }

    @Override
    public String toString() {
        return "AppointmentSlot [id=" + id + ", date=" + date + ", startTime=" + startTime + 
               ", endTime=" + endTime + ", isBooked=" + isBooked + "]";
    }
}
