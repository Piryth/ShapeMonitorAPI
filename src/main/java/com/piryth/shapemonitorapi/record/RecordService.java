package com.piryth.shapemonitorapi.record;

import com.piryth.shapemonitorapi.appUser.AppUser;
import com.piryth.shapemonitorapi.appUser.AppUserDto;
import com.piryth.shapemonitorapi.appUser.AppUserRepository;
import com.piryth.shapemonitorapi.appUser.AppUserService;
import com.piryth.shapemonitorapi.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class RecordService {
    private final RecordRepository recordRepository;
    private final AppUserService appUserService;
    private final AppUserRepository appUserRepository;

    public Record addRecord(RecordDto recordDto) {

        //Step 1 : creation of a new record
        Record record = new Record();
        record.setWeight(recordDto.weight());
        record.setBodyFat(recordDto.bodyFat());
        record.setDate(new Date());
        if(recordDto.date() != null) {
            record.setDate(recordDto.date());
        }
        //Step 2 : registering the record to the new user
        AppUserDto userDto = appUserService.getAuthenticatedUser();
        AppUser user = appUserRepository.findByUsername(userDto.username()).orElseThrow();
        user.getHistory().add(record);
        record.setAppUser(user);
        //Saving the user
        appUserRepository.save(user);
        //Saving the record
        return recordRepository.save(record);

    }
}
