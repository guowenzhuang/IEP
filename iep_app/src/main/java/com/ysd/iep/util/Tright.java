package com.ysd.iep.util;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Data
@Accessors(chain = true)
public class Tright {
    private String permissionId;
    private String permissionValue;
    private String typeName;
    private String methodName;
    private Timestamp permissionLastUpdateTime;


}