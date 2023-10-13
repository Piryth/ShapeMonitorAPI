package com.piryth.shapemonitorapi.record;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class contains the data of adipometer results
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Adipometer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private float tricepsPly;
    private float bicepsPly;
    private float subScapularPly;
    private float supraIlliacPly;
}
