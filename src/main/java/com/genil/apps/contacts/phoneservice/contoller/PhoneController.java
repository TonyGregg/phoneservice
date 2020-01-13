package com.genil.apps.contacts.phoneservice.contoller;

import com.genil.apps.contacts.phoneservice.environment.InstanceInformationService;
import com.genil.apps.contacts.phoneservice.model.Phone;
import com.genil.apps.contacts.phoneservice.repos.PhoneRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * Created by Antony Genil Gregory on 1/12/2020 9:09 AM
 * For project : email-update
 **/
@RestController
@RequestMapping("/api/v1/contacts")
@Slf4j
public class PhoneController {
    @Autowired
    private PhoneRepo phoneRepo;

    @Autowired
    InstanceInformationService instanceInformationService;

    @GetMapping("/phone/all")
    public List<Phone> getAllEmails(@RequestParam @Max(200) @Min(0) Integer pageNumber,
                                    @RequestParam @Max(100) @Min(5) Integer size) {
        log.info("Retrieving all phone numbers. Page Number " + pageNumber + "Size "+size);
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(Sort.Direction.ASC,"email"));
        List<Phone> phoneList = phoneRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return phoneList;
    }

    @PostMapping("/phone")
    Phone newPhone(@Valid @RequestBody Phone phone) {
        log.info("Phone object passed by client "+phone);
        return phoneRepo.save(phone);
    }

    @GetMapping("/phone/{id}")
    Phone getOnePhone(@PathVariable(value = "id") Long id){
        Phone phone = phoneRepo.findById(id).orElseThrow(() -> new RuntimeException("Phone ID not found"));
        phone.setPhoneServiceInstanceInfo(instanceInformationService.retrieveInstanceInfo());
        return phone;
    }


}
