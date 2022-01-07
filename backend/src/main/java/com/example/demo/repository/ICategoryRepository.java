package com.example.demo.repository;

import com.example.demo.entity.food.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "select * \n" +
            "from category\n" +
            "where delete_flag = false;", nativeQuery = true)
    List<Category> listAllCategory();

    @Modifying
    @Query(value = "update `category` set category_name = ?1, category_code = ?2 where (category_id = ?3)", nativeQuery = true)
    void updateCategory(String category_name, String category_code, Integer category_id);

    @Modifying
    @Query(value = "update `category` set delete_flag = true where (category_id = ?1)", nativeQuery = true)
    void deleteCategory(int categoryId);

    @Modifying
    @Query(value = "INSERT INTO `sprint3`.`category` (`category_code`, `category_name`, `delete_flag`) VALUES (?1, ?2,false);", nativeQuery = true)
    void saveCategory(String categoryCode, String categoryName);

    @Modifying
    @Query(value = "UPDATE `category` SET `category_code` = ?1, `category_name` = ?2, `delete_flag` = 0 WHERE (`category_id` = ?3);", nativeQuery = true)
    void updateCategory(String categoryCode, String name, int id);
}
