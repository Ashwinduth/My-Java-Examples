lets talk about filters. as the name suggest,the filters can filter the request and response recieved from 
client and forward to sevlets.the object of filters are created as soon as we deploy the war file containing the filter class.
there after it starts the filtering the request and response recieved for the servlet for which we have mapped it.

in this example we have two filters mapped to same servlet.we have mapped them to our servlet by giving them same url pattern
as that of our servlet in web.xml. the filter are created and filter the response and requests in same order as that we have mentioned
them in web.xml. we have mapped the filter MyFilter before MyFilter1,so MyFilter iss called prior to MyFilter.

in this example,when the request is generated i.e request object is created,it goes to MyFilter ,then it goes to MyFilter1 and 
finally reaches MyFilterServlet. the response goes in reverse order as from MyFilterServlet to MyFilter1 and finally to MyFilter
therefore browser prints as:

Filter output from MyFilter response
Filter output from MyFilter1 response
count = 1
Filter output from MyFilter1 response
Filter output from MyFilter response 

when we deploy the war file,console shows the message of 
------MyFilter created-----
------MyFilter1 created-----

and when we send request for first time i.e go to the url of servlet,then it prints ------MyFilterServlet created-----

note that filter can be created  even if we donot have servlets class in war file.if we remove MyFilterServlet.class from classes 
folder and remove servlet info and mapping from web.xml and rebuild war file and re-deploy it,then you can stll see 
the messages of MyFilter created and MyFilter1 created  printed in console.