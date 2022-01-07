package com.example.demo.repository;

import com.example.demo.entity.food.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IFoodRepository extends JpaRepository<Food, Integer> {
    // lay het food
    @Query(value = "SELECT * FROM food \n" +
            "where delete_flag = 0", nativeQuery = true)
    List<Food> listAllFood();
    // findByid

    @Query(value = "SELECT * FROM food\n" +
            "where fad_id = ? \n" +
            ";", nativeQuery = true)
    Optional<Food> FoodById(int id);

    // lay ra 8 food
    @Query(value = "select * \n" +
            "from food\n" +
            "order by fad_id desc limit 8; ", nativeQuery = true)
    List<Food> listEight();

    //lay food theo category
    @Query(value = "select * \n" +
            "from food\n" +
            "where category_id = ?", nativeQuery = true)
    List<Food> findFoodByCategory(int id);

    // sap xep theo ten a - z
    @Query(value = "select * \n" +
            "from food\n" +
            "order by fad_name", nativeQuery = true)
    List<Food> sortFoodAtoZ();

    //create food
    @Modifying
    @Query(value = "INSERT INTO `sprintmodule3`.`food` (`delete_flag`, `fad_code`, `fad_image`, `fad_name`, `fad_price`, `category_id`)\n" +
            "VALUES (0,?1, ?2, ?3, ?4, ?5,?6);", nativeQuery = true)
    void createFood(String fad_code, String fad_image, String fad_name, Double fad_price, Integer category_id,String description);

    //update food

    @Modifying
    @Query(value = "UPDATE `food` SET `fad_code` = ?1, `fad_image` = ?2, `fad_name` = ?3, `fad_price` = ?4,  `category_id` = ?5 ,description = ?6\n" +
            "WHERE (`fad_id` = ?7);", nativeQuery = true)
    void updateFood(String fad_code, String fad_image, String fad_name, Double fad_price, Integer category_id, Integer id,String description);


    @Modifying
    @Query(value = "UPDATE `food` SET `delete_flag` = 1 WHERE (`fad_id` = ?)", nativeQuery = true)
    void deleteFood(int id);

}
