package com.wfei.daliy.pojo.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by feiwen on 2018/4/10.
 */
@Data
public class GetUserDTO {

    @NotBlank(message = "usercode不能传空或空字符串")
    private String userCode;
    @NotNull(message = "userName不能为null")
    private String userName;
}
