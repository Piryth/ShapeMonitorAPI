package com.piryth.shapemonitorapi.record;

import com.piryth.shapemonitorapi.appUser.AppUser;
import jakarta.persistence.*;
import lombok.*;

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
    @OneToOne
    private AppUser appUser;
    private float weight;

    /*
     * Body fat can be measured by different methods :
     *  -  the user provides his body fat directly
     *  -  the body fat is calculated from weight, height, etc.
     *  - the user provides adipometer results
     */
    private float bodyFat;

    //@Nullable
    //@OneToOne
    //private Measurements measurements;

    //Skin fold measurment
    //@Nullable
    //@OneToOne
    //private Adipometer adipometerMeasurements;

    private Date date;

    @Enumerated(EnumType.STRING)
    private FatMassCalculationType fatMassCalculationType;

}
