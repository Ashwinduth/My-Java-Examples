this is third example of servlet.here we extend httpservlet class to make our servlet http protocol specific.the service method of http servlet
does the job of identifying the request method and calls appropriate method.if we override service ,then the method is not decided automatically.
so better donont override service method.we must write required code in doGet,doPost etc. methods

now in case we donot override the doPost method and browser send post request,the doPost of httpServlet is called that prints post method not supported.
