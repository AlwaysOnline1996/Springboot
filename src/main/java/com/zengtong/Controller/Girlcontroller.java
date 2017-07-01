package com.zengtong.Controller;

import com.zengtong.Container.Girl;
import com.zengtong.Repository.GirlRepository;
import com.zengtong.Service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by znt on 17-6-30.
 */
@RestController
public class Girlcontroller {

    @Autowired
    private GirlRepository girlRepository;

    //获得所有列表
    @GetMapping(value = "/girl")
    public List<Girl> getAll(){
        return girlRepository.findAll();
    }
    //添加一个列表
    @PostMapping(value = "/girl")
    public Girl putOne(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return girlRepository.save(girl);
    }
    //请求一个列表
    @RequestMapping(value = "/girl/{id}")
    public Girl getOne(@PathVariable("id")Integer id){
        return girlRepository.findOne(id);
    }
    // 更新一个女孩列表
    @PutMapping(value = "/girl/{id}")
    public Girl updateOne(@PathVariable("id")Integer id,
                          @RequestParam("age")Integer age,
                          @RequestParam("cupSize")String cupSize,
                          @RequestParam("name")String name){
        Girl girl = girlRepository.findOne(id);
        girl.setName(name);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    //通过罩杯查询列表
    @GetMapping(value = "/girl/{cupSize}")
    public List<Girl> getByCupSize(@PathVariable("cupSize")String cupSize){
        return girlRepository.findByCupSize(cupSize);
    }
    @Autowired
    private GirlService girlService;

    @PostMapping(value = "/girl/two/")
    public void girlTwo(@RequestParam("cupA") String cupA,
                        @RequestParam("nameA") String nameA,
                        @RequestParam("ageA")Integer ageA,
                        @RequestParam("cupB") String cupB,
                        @RequestParam("nameB") String nameB,
                        @RequestParam("ageB")Integer ageB){
        Girl girlA = new Girl();
        Girl girlB = new Girl();
        girlA.setAge(ageA);girlA.setCupSize(cupA);girlA.setName(nameA);
        girlB.setAge(ageB);girlB.setCupSize(cupB);girlB.setName(nameB);
        girlService.insertTwo(girlA,girlB);
    }

    @GetMapping(value = "/getAge/{id}")
    public void  getAge(@PathVariable("id")Integer id) throws Exception{
        girlService.getAge(id);
    }

}
