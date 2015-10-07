package mockitovseasymock;

public class MyApp
{
    MyService service;
    OtherService otherService;

    void operationOne()
    {
        service.operationOne();
    }

    void operationTwo(String args)
    {
        String operationTwo = otherService.operationTwo(args);
        otherService.operationThree(operationTwo);
    }

    void operationThree()
    {
        service.operationOne();
        otherService.operationThree("success");
    }
}

class MyService
{
    void operationOne()
    {
    }
}

class OtherService
{
    public String operationTwo(String args)
    {
        return args;
    }

    public void operationThree(String operationTwo)
    {
    }
}