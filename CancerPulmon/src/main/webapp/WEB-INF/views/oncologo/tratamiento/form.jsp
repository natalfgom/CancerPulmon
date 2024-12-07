<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:form>

    <acme:input-textbox code="authenticated.tratamiento.form.label.estadoTratamiento" path="estadoTratamiento"/>  

    <acme:input-textbox code="authenticated.tratamiento.form.label.tipoTratamiento" path="tipoTratamiento" readonly="true"/>
    <acme:input-textbox code="authenticated.tratamiento.form.label.paciente.nuhsa" path="nuhsa" readonly="true"/>
    <acme:input-textbox code="authenticated.tratamiento.form.label.paciente.name" path="name" readonly="true"/>
    <acme:input-textbox code="authenticated.tratamiento.form.label.paciente.surname" path="surname" readonly="true"/>
    <acme:input-textbox code="authenticated.tratamiento.form.label.paciente.genero" path="genero" readonly="true"/>
    <acme:input-textbox code="authenticated.tratamiento.form.label.paciente.fechaNacimiento" path="fechaNacimiento" readonly="true"/>
    <acme:input-textbox code="authenticated.tratamiento.form.label.paciente.grupoSanguineo" path="grupoSanguineo" readonly="true"/>

    <jstl:choose>
        <jstl:when test="${acme:anyOf(_command, 'show|update|delete')}">
            <acme:submit code="oncologo.tratamiento.form.button.update" action="/oncologo/tratamiento/update"/>
        </jstl:when>
    </jstl:choose>
</acme:form>

 