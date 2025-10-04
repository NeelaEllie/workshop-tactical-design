package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class TarifierungsergebnisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private List<String> validierungsfehler = new ArrayList<>();

    private List<String> hinweise = new ArrayList<>();
}
