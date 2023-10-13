package com.piryth.shapemonitorapi.record;

import java.util.Date;

public record RecordDto(float weight, Date date,float bodyFat, String fatMassCalculationType) {}
