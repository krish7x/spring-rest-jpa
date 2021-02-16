package com.edu.Student.service;

import com.edu.Student.dto.InternshipDTO;
import com.edu.Student.dto.InternshipIdentityDTO;

public interface InternshipService {
    InternshipIdentityDTO createAndUpdate(InternshipDTO internshipDTO);
}
