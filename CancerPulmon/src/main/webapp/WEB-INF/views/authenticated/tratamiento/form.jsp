<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<%-- <acme:form>
	<acme:input-textbox code="authenticated.tratamiento.form.label.tipoTratamiento" path="tipoTratamiento"/>	
	<acme:input-textbox code="authenticated.tratamiento.form.label.estadoTratamiento" path="estadoTratamiento"/>
	<acme:list-column code="authenticated.tratamiento.list.label.paciente.nuhsa" path="paciente.nuhsa" width="20%"/>
	<acme:list-column code="authenticated.tratamiento.list.label.paciente.name" path="paciente.name" width="20%"/>
	<acme:list-column code="authenticated.tratamiento.list.label.paciente.surname" path="paciente.surname" width="20%"/>
	<acme:list-column code="authenticated.tratamiento.list.label.paciente.genero" path="paciente.genero" width="20%"/>
	 <acme:list-column code="authenticated.tratamiento.list.label.paciente.fechaNacimiento" path="paciente.fechaNacimiento" width="20%"/>
	<acme:list-column code="authenticated.tratamiento.list.label.paciente.grupoSanguineo" path="paciente.grupoSanguineo" width="20%"/>
</acme:form>
 --%>
 
 <acme:form>
    <acme:input-textbox code="authenticated.tratamiento.form.label.tipoTratamiento" path="tipoTratamiento"/>    
    <acme:input-textbox code="authenticated.tratamiento.form.label.estadoTratamiento" path="estadoTratamiento"/>
    <acme:input-textbox code="authenticated.tratamiento.form.label.urgencia" path="urgencia"/>
    <acme:input-textbox code="authenticated.tratamiento.form.label.paciente.nuhsa" path="nuhsa" />
    <acme:input-textbox code="authenticated.tratamiento.form.label.paciente.name" path="name" />
    <acme:input-textbox code="authenticated.tratamiento.form.label.paciente.surname" path="surname" />
    <acme:input-textbox code="authenticated.tratamiento.form.label.paciente.genero" path="genero" />
    <acme:input-textbox code="authenticated.tratamiento.form.label.paciente.fechaNacimiento" path="fechaNacimiento" />
    <acme:input-textbox code="authenticated.tratamiento.form.label.paciente.grupoSanguineo" path="grupoSanguineo" />
</acme:form>
 