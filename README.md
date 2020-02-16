# This is a sample project for showing some of my competencies
First of all, I would like to mention that this is a sample project just to show my competencies in Java and software development.
 Defiantly, the solution is not very complete and there are many things which could be completed in a real project.
 
 One more thing, I was a bit confused during doing the project, in one hand keeping the signatureofthe Rest method requested, on the other hand, the data input structure for the Request is not related to the required context. 
 Meanwhile, I tried to keep the signature despite It does not seems correct.   
 
## Answer to the questions:
o What happens if another partner comes with a different format for the data?
 Just impalement a suitable Adaptor for the new structure and add it to the context.
 
o What happens if partner are able to offer a REST endpoint rather than file
exchange? No deference, we could add a new Adaptor with Rest client for calling the endpoint.

o What happens if a partner sends a new file with new prices every day?
I  used a  Scheduler for reading the data from all the Adaprors every day. If a new file comes, we read the new data.

o How could a partner with a potentially slow REST interface be integrated? I suggest an async way, we could gather the data from different customer in an Async way.

o How could your solution scale for multiple thousand requests per second? I just keep the data in memory. In the real situation we could use a way for keeping a larger amount of  data such as a database.

## Something could be added in a real situation
Since it was a demo, I missed somethings which are useful in a  real situation such as Validation, API documentation, customized Exception handling, Unit and Integration tests( Although the tests are notrequested in your context, I did two  Unit tests just for showing my knowledge).Moreover,  we could develop an automatic and configurable solution for reading the input data from different sources.  