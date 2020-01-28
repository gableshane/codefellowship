package com.example.codefellowship.models;

import com.example.codefellowship.models.*;
import org.springframework.data.jpa.repository.*;

public interface UserRepository extends JpaRepository<AppUser,Long> {

    public AppUser findByUsername(String username);
}
