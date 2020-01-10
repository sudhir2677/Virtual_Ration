package com.IBHacakathon.Virtual_Ration.Repository;

import com.IBHacakathon.Virtual_Ration.Model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
    Vendor findByEmailAndPassword(String emailId, String password);
}
