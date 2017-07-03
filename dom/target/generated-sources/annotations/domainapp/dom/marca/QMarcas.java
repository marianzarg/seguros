package domainapp.dom.marca;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QMarcas extends PersistableExpressionImpl<Marcas> implements PersistableExpression<Marcas>
{
    public static final QMarcas jdoCandidate = candidate("this");

    public static QMarcas candidate(String name)
    {
        return new QMarcas(null, name, 5);
    }

    public static QMarcas candidate()
    {
        return jdoCandidate;
    }

    public static QMarcas parameter(String name)
    {
        return new QMarcas(Marcas.class, name, ExpressionType.PARAMETER);
    }

    public static QMarcas variable(String name)
    {
        return new QMarcas(Marcas.class, name, ExpressionType.VARIABLE);
    }

    public final NumericExpression<Integer> NAME_LENGTH;
    public final StringExpression marcasNombre;
    public final BooleanExpression activo;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QMarcas(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.NAME_LENGTH = new NumericExpressionImpl<Integer>(this, "NAME_LENGTH");
        this.marcasNombre = new StringExpressionImpl(this, "marcasNombre");
        this.activo = new BooleanExpressionImpl(this, "activo");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QMarcas(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.NAME_LENGTH = new NumericExpressionImpl<Integer>(this, "NAME_LENGTH");
        this.marcasNombre = new StringExpressionImpl(this, "marcasNombre");
        this.activo = new BooleanExpressionImpl(this, "activo");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
