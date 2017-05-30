package dev.nnd.roomygoogle.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Entity annotation use class name as default table's name, you can specify custom name if you want it
 * <br>
 * Note : Table name is case INsensitive in SQLITE
 */
@Entity
public class User {
    @PrimaryKey private String userId;
    @ColumnInfo(name = "name") private String name;
    @ColumnInfo(name = "age") private int age;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
