package mockitovseasymock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class MyAppMockitoTest
{
    MyApp app;
    MyService service;
    OtherService otherService;

    @Before
    public void initialize()
    {
        service = mock(MyService.class);
        otherService = mock(OtherService.class);
        app = new MyApp();
        app.service = service;
        app.otherService = otherService;
    }

    @Test
    public void verifySimpleCall()
    {
        app.operationOne();
        verify(service).operationOne();
    }

    @Test
    public void verifyMultipleCalls()
    {
        String args = "one";
        when(otherService.operationTwo(args)).thenReturn(args);
        app.operationTwo(args);
        verify(otherService).operationTwo(args);
        verify(otherService).operationThree(args);
        verifyNoMoreInteractions(otherService);
        verifyZeroInteractions(service);
    }

    @Test(expected = RuntimeException.class)
    public void verifyException()
    {
        doThrow(new RuntimeException()).when(service).operationOne();
        app.operationOne();
    }

    @Test
    public void captureArguments()
    {
        app.operationThree();
        ArgumentCaptor capturedArgs = ArgumentCaptor
                .forClass(String.class);
        verify(service).operationOne();
        verify(otherService).operationThree(capturedArgs.capture().toString());
        assertTrue(capturedArgs.getAllValues().contains("success"));
        verifyNoMoreInteractions(service, otherService);
    }
}