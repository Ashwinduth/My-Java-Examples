the contextattribute listener listens for context attribute events . all three methods are defined in Listener class,but i have
shown working of only two i.e attributes added and attributes removed as i could not find the method to replace attributes.

The message of attribute added is printed when we send a request to one of two servlets as servlets does the job of removing
and adding attribute.when we call ListenerServlet,it adds attribute attr1 and removes attr2,and  listener prints message
i.e attr1 added with value sai and the message of attr2 removed.

the class ServletContextAttributeEvent has methods public String getName() and public String getValue().