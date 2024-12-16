<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:menu-bar code="master.menu.home">
    <acme:menu-left>
    
        <acme:menu-option code="master.menu.anonymous">
            <acme:menu-suboption code="master.menu.anonymous.favourite-link" action="http://www.example.com/"/>
        </acme:menu-option>

<!--         Enlace de cuenta visible solo para usuarios autenticados -->
        <acme:menu-option code="master.menu.account" access="isAuthenticated()">
            <acme:menu-suboption code="master.menu.account.details" action="/account/details"/>
        </acme:menu-option>

        <!-- Administrador -->
        <acme:menu-option code="master.menu.administrator.ttos" access="hasRole('Administrator')">
            <acme:menu-suboption code="master.menu.administrator.listae" action="/administrator/tratamiento/list-all"/> 
            <acme:menu-suboption code="master.menu.administrator.tratamiento.list" action="/administrator/tratamiento/list"/>
        </acme:menu-option>

        <acme:menu-option code="master.menu.administrator.donantes" access="hasRole('Administrator')">
            <acme:menu-suboption code="master.menu.administrator.donante.list" action="/administrator/donante/list"/>
            <acme:menu-suboption code="master.menu.administrator.donante.create" action="/administrator/donante/create"/>
        </acme:menu-option>

        <acme:menu-option code="master.menu.administrator.pacientes" access="hasRole('Administrator')">
            <acme:menu-suboption code="master.menu.administrator.paciente.list" action="/administrator/paciente/list"/>
        </acme:menu-option>

        <acme:menu-option code="master.menu.administrator.config" access="hasRole('Administrator')">
            <acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
            <acme:menu-suboption code="master.menu.administrator.populate-sample" action="/administrator/populate-sample"/>
            <acme:menu-separator/>
            <acme:menu-suboption code="master.menu.administrator.shut-down" action="/administrator/shut-down"/>
        </acme:menu-option>

        <!-- Oncologo -->
        <acme:menu-option code="master.menu.oncologo.ttos" access="hasRole('Oncologo')">
            <acme:menu-suboption code="master.menu.oncologo.listae" action="/oncologo/tratamiento/list-all"/> 
            <acme:menu-suboption code="master.menu.oncologo.tratamiento.list" action="/oncologo/tratamiento/list"/>
        </acme:menu-option>

        <acme:menu-option code="master.menu.oncologo.donantes" access="hasRole('Oncologo')">
            <acme:menu-suboption code="master.menu.oncologo.donante.list" action="/oncologo/donante/list"/>
        </acme:menu-option>

        <acme:menu-option code="master.menu.oncologo.pacientes" access="hasRole('Oncologo')">
            <acme:menu-suboption code="master.menu.oncologo.paciente.list" action="/oncologo/paciente/list"/>
        </acme:menu-option>

        <!-- Paciente -->
        <acme:menu-option code="master.menu.paciente.espera" access="hasRole('Paciente')">
            <acme:menu-suboption code="master.menu.paciente.listae" action="/paciente/tratamiento/list"/>
        </acme:menu-option>
    </acme:menu-left>

    <acme:menu-right>
        <!-- Opciones para usuarios no autenticados -->
        <acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
        <acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>
        
        <!-- Opción de cerrar sesión para usuarios autenticados -->
        <acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
    </acme:menu-right>
</acme:menu-bar>

