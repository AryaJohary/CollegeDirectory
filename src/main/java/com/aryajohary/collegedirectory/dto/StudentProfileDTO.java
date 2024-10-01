package com.aryajohary.collegedirectory.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StudentProfileDTO extends BaseProfileDTO {

    private String photo;
    private int departmentId;
    private String year;

}
