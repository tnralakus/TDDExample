package com.vogella.testing.mockito.first.test;

import org.easymock.Mock;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoAnnotationTest
{
    /*
    // assume there is a class MyDatabase
    @Mock
    MyDatabase databaseMock;

    @Test
    public void testQuery()  {
        // assume there is a class called ClassToTest
        // which could be tested
        ClassToTest t  = new ClassToTest(databaseMock);

        // call a method
        boolean check = t.query("* from t");

        // test the return type
        assertTrue(check);

        // test that the query() method on the
        // mock object was called
        verify(databaseMock).query("* from t");
    }
    */
}
