package categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class A
{
    @Test
    public void a()
    {
        System.out.println("fail");
    }

    @Category(SlowTests.class)
    @Test
    public void b()
    {
    }
}