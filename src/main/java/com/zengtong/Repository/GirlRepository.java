package com.zengtong.Repository;

import com.zengtong.Container.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Null;
import java.util.List;

/**
 * Created by znt on 17-6-30.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    //通过罩杯来查询
    public List<Girl> findByCupSize(String CupSize);
}
