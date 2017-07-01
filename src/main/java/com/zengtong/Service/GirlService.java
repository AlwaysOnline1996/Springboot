package com.zengtong.Service;

import com.zengtong.Container.Girl;
import com.zengtong.Repository.GirlRepository;
import com.zengtong.exception.GirlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;

/**
 * Created by znt on 17-6-30.
 */

@Service
public class GirlService {
    @Autowired
    GirlRepository girlRepository;
    @Transactional
    public void insertTwo(Girl girlA,Girl girlB){
        girlRepository.save(girlA);
        girlRepository.save(girlB);
    }


    public void getAge(Integer id) throws Exception{
        Integer age = girlRepository.findOne(id).getAge();
        if(age < 20){
            throw new GirlException("你还在上小学吧",100);
        }else if(age > 20 && age < 30){
//            return "你还在上初中吧"
            throw new GirlException("你还在上初中吧",101);
        } else{
            throw new GirlException("欢迎",-1);
        }
    }

    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
