package com.playdata.orderingservice.client;

import com.playdata.orderingservice.common.dto.CommonResDto;
import com.playdata.orderingservice.ordering.dto.UserResDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "user-service") // 호출하고자 하는 서비스의 이름 (유레카에 등록된)
public interface UserServiceClient {

    @GetMapping("/findByEmail")
    CommonResDto<UserResDto> findByEmail(@RequestParam String email);

    @PostMapping("/users/emails")
    CommonResDto<List<UserResDto>> getUsersByIds(@RequestBody List<Long> userIds);

}
