-In tests everything should be under the control of the developer i.e. how the interaction are happening and what interactions are happening.
In EasyMock this aspect is more visible as the developer must put down all of these interaction in his code
but in Mockito, the framework takes care of all interactions and the developer is just concerned with their verification ( if any).
-EasyMock is better for the unit testing as it forces the developer to take control of things. Mockito due to its assumptions and considerations hides this control under the carpet
and thus is not a good choice. But Mockito offers certain things that are quite useful(eg. junitRunner, call chaining) and EasyMock should have one in its next release.