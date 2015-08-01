this is sixth example.in f6,we discussed about servlet config.it was specific to a servlet and other servlet could not access it.
if we want to make common parameter in web.xml to be shared between all servlets ,we can do it by servlet context.we define cofig parameters inside
servlets tag in web.xml,but we define context params outside servlets tags so that everyone can access it.we can get reference to
servlet context by getServletConetxt();

Servlet config objects: 
1)one servletConfig object per servlet
2) use it to pass deploy time info to servlet that we donot want to hardcode into sevlet.
