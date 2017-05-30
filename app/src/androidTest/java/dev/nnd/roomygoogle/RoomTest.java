package dev.nnd.roomygoogle;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import dev.nnd.roomygoogle.db.AppDatabase;
import dev.nnd.roomygoogle.db.User;
import dev.nnd.roomygoogle.db.UserDao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Android dev on 5/30/17.
 */

@RunWith(AndroidJUnit4.class)
public class RoomTest {
    private UserDao userDao;
    private AppDatabase appDatabase;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getContext();
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        userDao = appDatabase.getUserDao();
    }

    @Test
    public void insertUser() {
        User user = TestUtils.createUser();
        user.setUserId("id123");
        user.setName("paijo");
        user.setAge(1);

        userDao.insertAll(user);
        User resultUser = userDao.getUserByName("paijo", 1).get(0);

        assertEquals(user.getUserId(), resultUser.getUserId());
    }

    @After
    public void closeDb() {
        appDatabase.close();
    }

    User[] generateUser(int SIZE) {
        User[] tempUsers = new User[SIZE];

        User user = new User();

        for (int i = 0; i < SIZE; i++) {
            user.setAge(i);
            user.setName("name_" + i);
            user.setUserId("u_id" + i);

            tempUsers[i] = user;
        }

        return tempUsers;
    }
}
