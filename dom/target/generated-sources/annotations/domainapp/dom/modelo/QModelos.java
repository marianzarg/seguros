package domainapp.dom.modelo;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QModelos extends PersistableExpressionImpl<Modelos> implements PersistableExpression<Modelos>
{
    public static final QModelos jdoCandidate = candidate("this");

    public static QModelos candidate(String name)
    {
        return new QModelos(null, name, 5);
    }

    public static QModelos candidate()
    {
        return jdoCandidate;
    }

    public static QModelos parameter(String name)
    {
        return new QModelos(Modelos.class, name, ExpressionType.PARAMETER);
    }

    public static QModelos variable(String name)
    {
        return new QModelos(Modelos.class, name, ExpressionType.VARIABLE);
    }

    public final NumericExpression<Integer> NAME_LENGTH;
    public final StringExpression nombre;
    public final BooleanExpression activo;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QModelos(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.NAME_LENGTH = new NumericExpressionImpl<Integer>(this, "NAME_LENGTH");
        this.nombre = new StringExpressionImpl(this, "nombre");
        this.activo = new BooleanExpressionImpl(this, "activo");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QModelos(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.NAME_LENGTH = new NumericExpressionImpl<Integer>(this, "NAME_LENGTH");
        this.nombre = new StringExpressionImpl(this, "nombre");
        this.activo = new BooleanExpressionImpl(this, "activo");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}