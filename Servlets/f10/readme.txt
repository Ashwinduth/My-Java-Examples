this is tenth example and it contains program for Servlet context attribute.

the context attributes persists throught the lifecycle of servlet and between different servlets in same war file or context.
in this example,only one servlet is depicted,when we refresh the page after loading servlet,the count value persists,which show that
context attributes persists from request to other.

Attributes:

whenever we want to share the data dynamically,we use attributes. we have three types of Attributes based on their scope:
1) Servlet context attributes: valid till servlet destroys
2) Servlet request attributes: valid throughout life of response and request 
3) Servlet session attribute: valid for each session,form login to logout.

Servlet context is not thread safe,so better use it in synchronized block.

