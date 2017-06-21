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

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.Auditing;
import org.apache.isis.applib.annotation.CommandReification;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.Publishing;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;
import org.apache.isis.applib.util.ObjectContracts;

@javax.jdo.annotations.PersistenceCapable(
        identityType=IdentityType.DATASTORE,
        schema = "simple",
        table = "Clientes"
)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy= VersionStrategy.DATE_TIME,
        column="version")
@javax.jdo.annotations.Queries({
        @javax.jdo.annotations.Query(
                name = "buscarPorNombre", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.dom.simple.Clientes "
                        + "WHERE nombre.indexOf(:nombre) >= 0 ")
})
@DomainObject(
        publishing = Publishing.ENABLED,
        auditing = Auditing.ENABLED
)
public class Clientes implements Comparable<Clientes> {

    //region > title
    public TranslatableString title() {
        return TranslatableString.tr("Cliente: {nombre}", "nombre", getNombre());
    }
    //endregion

    //region > constructor
    public Clientes(final String nombre) {
        setNombre(nombre);
    }
    
    public Clientes(String nombre, String apellido, int dni, String direccion, String telefono, String mail,
			String cuitcuil, Date fechaNacimiento, boolean notificacionCumpleanios) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.mail = mail;
		this.cuitcuil = cuitcuil;
		this.fechaNacimiento = fechaNacimiento;
		this.notificacionCumpleanios = notificacionCumpleanios;
		this.activo = true;
	}


	//endregion

    //region > name (read-only property)
    public static final int NAME_LENGTH = 40;

    @javax.jdo.annotations.Column(allowsNull = "false", length = NAME_LENGTH)
    private String nombre;
    @Property(
            editing = Editing.DISABLED
    )
    public String getNombre() {
        return nombre;
    }
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
    
    @javax.jdo.annotations.Column(allowsNull = "false", length = NAME_LENGTH)
    private String apellido;
    @Property(
    		editing = Editing.DISABLED
    )
    public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

    @javax.jdo.annotations.Column(allowsNull = "false")
    private int dni;
    @Property(
    		editing = Editing.DISABLED
    )
    public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	
    @javax.jdo.annotations.Column(allowsNull = "false", length = NAME_LENGTH)
    private String direccion;
    @Property(
    		editing = Editing.DISABLED
    )
    public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}	

    @javax.jdo.annotations.Column(allowsNull = "false", length = NAME_LENGTH)
    private String telefono;
    @Property(
    		editing = Editing.DISABLED
    )
    public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}	

    @javax.jdo.annotations.Column(allowsNull = "false", length = NAME_LENGTH)
    private String mail;
    @Property(
    		editing = Editing.DISABLED
    )
    public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}	

    @javax.jdo.annotations.Column(allowsNull = "false", length = NAME_LENGTH)
    private String cuitcuil;
    @Property(
    		editing = Editing.DISABLED
    )
    public String getCuitcuil() {
		return cuitcuil;
	}
	public void setCuitcuil(String cuitcuil) {
		this.cuitcuil = cuitcuil;
	}	
	
    @javax.jdo.annotations.Column(allowsNull = "false", length = NAME_LENGTH)
    private Date fechaNacimiento;
    @Property(
    		editing = Editing.DISABLED
    )
    public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}		
	
    @javax.jdo.annotations.Column(allowsNull = "false")
    private boolean notificacionCumpleanios;
    @Property(
    		editing = Editing.DISABLED
    )
    public boolean getNotificacionCumpleanios() {
		return notificacionCumpleanios;
	}
	public void setNotificacionCumpleanios(boolean notificacionCumpleanios) {
		this.notificacionCumpleanios = notificacionCumpleanios;
	}	
	
    @javax.jdo.annotations.Column(allowsNull = "false")
    private boolean activo;
    @Property(
    		editing = Editing.DISABLED
    )
    public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}	
	
    //endregion

	
	//region > updateName (action)
    public static class UpdateNameDomainEvent extends ActionDomainEvent<Clientes> {}
    @Action(
            command = CommandReification.ENABLED,
            publishing = Publishing.ENABLED,
            semantics = SemanticsOf.IDEMPOTENT,
            domainEvent = UpdateNameDomainEvent.class
    )
    public Clientes updateName(@ParameterLayout(named="Nombre") final String nombre) {
        setNombre(nombre);
        return this;
    }
    public String default0UpdateName() {
        return getNombre();
    }
    public TranslatableString validate0UpdateName(final String name) {
        return name != null && name.contains("!")? TranslatableString.tr("Exclamation mark is not allowed"): null;
    }

    //endregion
    
    //region > delete (action)
    public static class DeleteDomainEvent extends ActionDomainEvent<Clientes> {}
    @Action(
            domainEvent = DeleteDomainEvent.class,
            semantics = SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE
    )
    public void delete() {
        final String title = titleService.titleOf(this);
        messageService.informUser(String.format("'%s' deleted", title));
        repositoryService.remove(this);
    }

    //endregion

    //region > toString, compareTo
    @Override
    public String toString() {
        return ObjectContracts.toString(this, "name");
    }
    @Override
    public int compareTo(final Clientes other) {
        return ObjectContracts.compare(this, other, "nombre");
    }

    //endregion

    //region > injected dependencies

    @javax.inject.Inject
    RepositoryService repositoryService;

    @javax.inject.Inject
    TitleService titleService;

    @javax.inject.Inject
    MessageService messageService;

    //endregion

}
