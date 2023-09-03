package com.piryth.shapemonitorapi.appUser;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Nullable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
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
    private Record record;

    @Nullable
    @OneToOne
    private AdipometerMeasurements adipometerMeasurements;

    private Date date;

}
