this is first example of servlet.we create a basic servlet class MyServlet which extends servlet interface.
the init is called, "--init called--" message is printed on server console.this message is only printed when we request
servlet for the first time. then the service method prints message "service called" every time we send the request,but "--init called--"
is printed only once i.e when we request for the first time as the servlet object is created when we pass the request
for the first time and it's init method is called which executes the code to print that message.



similarly thw message "-----destroy called----"  is called when we stop the server,as the servlet is destroyed at that time and 
calls destroy method.the servlet is also destroyed if we remove or overwrite the war file containing the class file of servlet,