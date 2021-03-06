/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package domainapp.dom.cliente;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;

import domainapp.dom.simple.SimpleObject;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        repositoryFor = Clientes.class
)
@DomainServiceLayout(
        named = "Clientes",
        menuOrder = "10"
)
public class ClientesMenu {


    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "1")
    public List<Clientes> listar() {
        return simpleObjectRepository.listar();
    }
    
    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "2")
    public List<Clientes> listarActivos() {
        return simpleObjectRepository.listarActivos();
    }
    
    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "3")
    public List<Clientes> listarInactivos() {
        return simpleObjectRepository.listarInactivos();
    }


    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "4")
    public List<Clientes> buscarPorNombre(
            @ParameterLayout(named="Nombre")
            final String nombre
    ) {
        return simpleObjectRepository.buscarPorNombre(nombre);
    }


    public static class CreateDomainEvent extends ActionDomainEvent<ClientesMenu> {}
    @Action(domainEvent = CreateDomainEvent.class)
    @MemberOrder(sequence = "4")
    public Clientes crear(
            @ParameterLayout(named="Nombre") final String nombre, 
            @ParameterLayout(named="Apellido") final String apellido,
            @ParameterLayout(named="Sexo") final Sexo sexo,
    		@ParameterLayout(named="DNI") final int dni,
            @ParameterLayout(named="Dirección") final String direccion, 
            @ParameterLayout(named="Teléfono") final String telefono,
    		@ParameterLayout(named="E-Mail") final String mail,
            @ParameterLayout(named="CUIT/CUIL") final String cuitcuil,
            @ParameterLayout(named="Fecha de Nacimiento") final Date fechaNacimiento, 
            @ParameterLayout(named="Notif. Cumpleaños") final boolean notificacionCumpleanios) {
        return simpleObjectRepository.crear(nombre, apellido, sexo, dni, direccion, telefono, mail, cuitcuil, fechaNacimiento, notificacionCumpleanios);
    }


    @javax.inject.Inject
    ClientesRepository simpleObjectRepository;

}
