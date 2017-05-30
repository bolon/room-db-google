package dev.nnd.roomygoogle.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;


/**
 * Wrapper for SQLite query (Retrofit alike)
 */
@Dao
public interface UserDao {

    @Query("SELECT * FROM user WHERE name LIKE :userName AND " + "age = :age")
    List<User> getUserWithparam(String userName, int age);

    @Query("SELECT * FROM user")
    List<User> getAllUser();

    @Query("SELECT * FROM user WHERE userId LIKE :userId")
    List<User> getUser(String userId);

    @Query("SELECT * FROM user WHERE name LIKE :userName LIMIT :limit")
    List<User> getUserByName(String userName, int limit);

    @Query("SELECT * FROM user WHERE userId IN (:userId)")
    List<User> getUserInRange(String userId);

    @Insert
    void insertAll(User... user);

    @Delete
    void delete(User user);
}
