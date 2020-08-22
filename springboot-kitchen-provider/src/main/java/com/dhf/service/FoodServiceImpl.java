package com.dhf.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dhf.dao.FoodMapper;
import com.dhf.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Component
@Service(interfaceClass = FoodService.class,version = "1.0.0",timeout = 15000)
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public HashMap<String, ArrayList<String>> selectFoodAll() {
        //序列化Redis的key  尽可能可视化key   （可选）
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);

        HashMap<String, ArrayList<String>> foodlists = new HashMap<>();

        Map food = redisTemplate.opsForHash().entries("foodlist");
        foodlists = (HashMap<String, ArrayList<String>>) food;

        if (food.isEmpty()){
            synchronized (this) {
                food = redisTemplate.opsForHash().entries("foodlist");
                if (food.isEmpty()) {
                    ArrayList<Food> list = foodMapper.selectFoodAll();
                    for(Food f :list){
                        ArrayList<String> names = foodMapper.selectByType(f.getTypeId());
                        redisTemplate.opsForHash().put("foodlist",f.getFoodSort(),names);
                        foodlists.put(f.getFoodSort(),names);
                        System.out.println("从数据库中拿数据");
                    }
                }
            }
        }

        return foodlists;
    }
}
