package org.dhf;

import static org.junit.Assert.assertTrue;

import com.dhf.model.User;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        User user = new User();
        User user1 = new User();
        user.setUserName("nihao");
        user1.setUserName("nihao");
        System.out.println(user.hashCode());


    }
}
