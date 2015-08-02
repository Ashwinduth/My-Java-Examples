in this example,i have mapped single filter to two servlets.
 
as we know,the container creates the object of servlet only once,as we have mapped it only once in web.xml. the container 
creates the object of servlet with the name that we provided in web.xml in tag <servlet-name> . as object should have unique
name,only one object exists  with name 
but if we want to create multiple objects of same servlet,we can give different name to same servlet and map them to different 
url patterns.in this case,container creates different objects of same servlet class.

in same way,we can create two or more objects of same filter class and can map to different servlets.but we cannot map same 
filter object to multiple servlets.

