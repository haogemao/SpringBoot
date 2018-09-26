package com.person.springboot.exceptions;

import com.person.springboot.utils.ResultVOUtil;
import com.person.springboot.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
//    @ResponseStatus(HttpStatus.FORBIDDEN) //返回状态码
    public ResultVO handle(Exception e){
        if (e instanceof SellException) {
            log.error("发生错误，错误信息={}",e.getMessage());
            SellException sellException = (SellException) e;
            return ResultVOUtil.error(sellException.getCode(), sellException.getMessage());
        }
        else{
            log.error("发生错误，错误信息={}",e.getMessage());
//            return ResultVOUtil.error(1,"未知错误");
            return ResultVOUtil.error(1,e.getMessage());
        }
    }
}
