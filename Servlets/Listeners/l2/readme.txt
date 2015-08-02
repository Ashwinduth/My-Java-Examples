in previous example,we saw working of servlet context listeners.this example contains servlet request listener.this listener 
listens for requests,and executes the code inside requestInitialized when a request is created and requestDestroyed when request
is destroyed.

the class ServletRequestEvent has method getServletRequest which returns the request which was generated.so we can access
the request in listener and perform some tasks on it like setContentType etc.
