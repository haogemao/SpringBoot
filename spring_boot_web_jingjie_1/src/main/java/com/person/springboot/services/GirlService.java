package com.person.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.person.springboot.entities.Girl;
import com.person.springboot.enums.ResultEnum;
import com.person.springboot.exceptions.GirlException;
import com.person.springboot.mapper.GirlRespository;

@Service
public class GirlService {

    @Autowired
    private GirlRespository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlA.setMoney(2.3);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("A");
        girlB.setAge(6);
        girlB.setMoney(23.0);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            //返回"你还在上小学吧" code=100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            //返回"你可能在上初中" code=101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    public Girl findOne(Integer id) {
        return girlRepository.getOne(id);
    }
}
