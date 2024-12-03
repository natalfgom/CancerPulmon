
<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:list>
    <acme:list-column code="authenticated.announcement.list.label.name" path="name" width="20%"/>
    <acme:list-column code="authenticated.announcement.list.label.status" path="status" width="10%"/>
    <acme:list-column code="authenticated.announcement.list.label.title" path="title" width="70%"/>
</acme:list>


