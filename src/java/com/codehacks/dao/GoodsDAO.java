package com.codehacks.dao;

import com.codehacks.model.Goods;
import java.util.List;

/**
 *
 * @author E238958
 */
public interface GoodsDAO {
    
    public void persistGoods(Goods good);
    
    public List<Goods> getAllGoodsByEmail(String email);
    
    public void updateGoodStatus(Goods good);
}
