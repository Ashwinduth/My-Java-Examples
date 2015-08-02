servlets listeners are objects which listens for particular event related to servlets.

in this example,we see the the working of servlet context listener.it listens for the events of creation and destroy of 
servlet context object. ServletContextEvent is generated  when context is created and passes as argument to methods  of the 
listener.
after context is created,the code written inside contextInitalized is executed by container.as context is created immediately after
deployment,the listener prints "context created" in servler console after we deploy war file.the listener object is created by
container after the deployment of war file containg listener class.

when the context is destroyed,listener's contextDestroyed is called and it prints "context destroyed" .the context is destroyed when
we shutdown the server.
the servletcontext is also destroyed if we remove or overwrite the war file containing the class file of servlet.

note that we need not have a servlet class for contextlistener to work as context is created independent to servlet,and listener
listens to only context activities.

servlet context listeners are useful if we want to do some initialization tasks like setting context attributes shared by all
servlets .if we set context attributes in any one the servlet,than also we can do initialization,but that servlet should be
called before all other servlets,else they may get null values.

the class ServletContextEvent has method getServletContext that returns the context.
