this is fifth-b example of servlet.here we use both web.xml and annotation together.usually,when we give parameters by annoation
and also keep web.xml file,container will only efer the web.xml first,and if it doesnot containg servlet details,it will throw error.but if
we want container to refer to annotations in presence of web.xml,we must make some entries at top of web.xml as show in this folder.

if we give servlet mapping in web.xml and also give annoations,then container will consider only web.xml,and we can call servlet only
by name given as url pattern in web.xml....