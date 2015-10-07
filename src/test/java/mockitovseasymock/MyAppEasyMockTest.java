package mockitovseasymock;

import org.easymock.Capture;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertTrue;

public class MyAppEasyMockTest
{
    MyApp app;
    MyService service;
    OtherService otherService;

    @Before
    public void initialize()
    {
        service = createMock(MyService.class);
        otherService = createMock(OtherService.class);
        app = new MyApp();
        app.service = service;
        app.otherService = otherService;
    }

    @Test
    public void verifySimpleCall()
    {
        service.operationOne();
        replay(service);
        app.operationOne();
        verify(service);
    }

    @Test
    public void verifyMultipleCalls()
    {
        String args = "one";
        expect(otherService.operationTwo(args)).andReturn(args);
        otherService.operationThree(args);
        replay(otherService);
        app.operationTwo(args);
        verify(otherService);
    }

    @Test(expected = RuntimeException.class)
    public void verifyException()
    {
        service.operationOne();
        expectLastCall().andThrow(new RuntimeException());
        replay(service);
        app.operationOne();
    }

    @Test
    public void captureArguments()
    {
        Capture<String> captured = new Capture<String>();
        service.operationOne();
        otherService.operationThree(capture(captured));
        replay(service, otherService);
        app.operationThree();
        verify(service, otherService);
        assertTrue(captured.getValue().contains("success"));
    }
}