package com.luox.repositoty;

import com.luox.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by luox on 2017/6/1.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    //通过年龄查找女生
    public List<Girl> findByAge(Integer age);
}
