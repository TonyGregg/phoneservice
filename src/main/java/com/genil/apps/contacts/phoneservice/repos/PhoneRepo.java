package com.genil.apps.contacts.phoneservice.repos;


import com.genil.apps.contacts.phoneservice.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Antony Genil Gregory on 1/12/2020 9:08 AM
 * For project : email-update
 **/
public interface PhoneRepo extends JpaRepository<Phone, Long> {
}
