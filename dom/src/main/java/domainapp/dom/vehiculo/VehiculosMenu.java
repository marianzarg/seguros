package domainapp.dom.vehiculo;

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

import domainapp.dom.cliente.Clientes;
import domainapp.dom.cliente.ClientesMenu;
import domainapp.dom.cliente.ClientesRepository;
import domainapp.dom.cliente.Sexo;
import domainapp.dom.cliente.ClientesMenu.CreateDomainEvent;


@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        repositoryFor = Vehiculos.class
)
@DomainServiceLayout(
        named = "Vehiculos",
        menuOrder = "2"
)
public class VehiculosMenu {
	
	  @Action(semantics = SemanticsOf.SAFE)
	    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
	    @MemberOrder(sequence = "2")
	    public List<Vehiculos> listar() {
	        return vehiculosRepository.listar();
	    }
	    
	    @Action(semantics = SemanticsOf.SAFE)
	    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
	    @MemberOrder(sequence = "3")
	    public List<Vehiculos> listarActivos() {
	        return vehiculosRepository.listarActivos();
	    }
	    
	    @Action(semantics = SemanticsOf.SAFE)
	    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
	    @MemberOrder(sequence = "4")
	    public List<Vehiculos> listarInactivos() {
	        return vehiculosRepository.listarInactivos();
	    }


	    @Action(semantics = SemanticsOf.SAFE)
	    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
	    @MemberOrder(sequence = "5")
	    public List<Vehiculos> buscarPorDominio(
	            @ParameterLayout(named="Dominio")
	            final String dominio
	    ) {
	        return vehiculosRepository.buscarPorDominio(dominio);
	    }
	    

	    public static class CreateDomainEvent extends ActionDomainEvent<VehiculosMenu> {}
	    @Action(domainEvent = CreateDomainEvent.class)
	    @MemberOrder(sequence = "1")
	    public Vehiculos crear(
	            @ParameterLayout(named="Dominio") final String dominio,
	    		@ParameterLayout(named="Año") final int anio,
	    		@ParameterLayout(named="Numero de Motor") final String numeroMotor,
	    		@ParameterLayout(named="Numero de Chasis") final String numeroChasis){
	        return vehiculosRepository.crear(dominio, anio, numeroMotor, numeroChasis);
	    }


	    @javax.inject.Inject
	    VehiculosRepository vehiculosRepository;

}