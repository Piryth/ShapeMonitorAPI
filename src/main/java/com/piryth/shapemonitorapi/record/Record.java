package com.piryth.shapemonitorapi.record;

import jakarta.persistence.*;
import lombok.*;

import javax.annotation.Nullable;
import java.util.Date;

/**
 * A record represents a weight tracker entry
 */
@Entity
@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
@Setter
@Table(name = "record")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private float weight;

    /*
     * Body fat can be measured by different methods :
     *  -  the user provides his body fat directly
     *  -  the body fat is calculated from weight, height, etc.
     *  - the user provides adipometer results
     */
    private float bodyFat;

    @Nullable
    @OneToOne
    private Measurements measurements;

    //Skin fold measurment
    @Nullable
    @OneToOne
    private AdipometerMeasurements adipometerMeasurements;

    private Date date;


}
