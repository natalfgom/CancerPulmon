<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:form >
    <acme:input-url code="authenticated.paciente.list.label.nuhsa" path="nuhsa"/>
    <acme:input-url code="authenticated.paciente.list.label.name" path="name"/>
    <acme:input-url code="authenticated.paciente.list.label.surname" path="surname"/>
    <acme:input-url code="authenticated.paciente.form.label.genero" path="genero"/>
    <acme:input-url code="authenticated.paciente.form.label.fechanacimiento" path="fechaNacimiento"/>
    <acme:input-url code="authenticated.paciente.form.label.gruposanguineo" path="grupoSanguineo"/>
     <acme:input-moment code="administrator.paciente.form.label.afectado" path="afectado"/>

<%--    <acme:submit  --%>
<%--     code="tratamiento"  --%>
<%--     action="/oncologo/tratamiento/create?pacienteId=${pacienteId}" /> --%>


   <acme:button  code="oncologo.tto" action="/oncologo/tratamiento/create?pacienteId=${pacienteId}"/>
   

</acme:form>

<!-- oncologo.paciente.form.button.createTreatment -->