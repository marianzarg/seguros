package domainapp.dom.simple;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QSimpleObject extends PersistableExpressionImpl<SimpleObject> implements PersistableExpression<SimpleObject>
{
    public static final QSimpleObject jdoCandidate = candidate("this");

    public static QSimpleObject candidate(String name)
    {
        return new QSimpleObject(null, name, 5);
    }

    public static QSimpleObject candidate()
    {
        return jdoCandidate;
    }

    public static QSimpleObject parameter(String name)
    {
        return new QSimpleObject(SimpleObject.class, name, ExpressionType.PARAMETER);
    }

    public static QSimpleObject variable(String name)
    {
        return new QSimpleObject(SimpleObject.class, name, ExpressionType.VARIABLE);
    }

    public final NumericExpression<Integer> NAME_LENGTH;
    public final StringExpression name;
    public final NumericExpression<Integer> NOTES_LENGTH;
    public final StringExpression notes;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QSimpleObject(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.NAME_LENGTH = new NumericExpressionImpl<Integer>(this, "NAME_LENGTH");
        this.name = new StringExpressionImpl(this, "name");
        this.NOTES_LENGTH = new NumericExpressionImpl<Integer>(this, "NOTES_LENGTH");
        this.notes = new StringExpressionImpl(this, "notes");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QSimpleObject(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.NAME_LENGTH = new NumericExpressionImpl<Integer>(this, "NAME_LENGTH");
        this.name = new StringExpressionImpl(this, "name");
        this.NOTES_LENGTH = new NumericExpressionImpl<Integer>(this, "NOTES_LENGTH");
        this.notes = new StringExpressionImpl(this, "notes");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
