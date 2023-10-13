package com.piryth.shapemonitorapi.record;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("shape-monitor/api/record")
public class RecordController {

    private final RecordService recordService;

    @PostMapping("add")
    public ResponseEntity<Record> addRecord(@RequestBody RecordDto recordDto) {
        return ResponseEntity.ok(recordService.addRecord(recordDto));
    }
    public ResponseEntity<Record> deleteRecord() {

    }


}
