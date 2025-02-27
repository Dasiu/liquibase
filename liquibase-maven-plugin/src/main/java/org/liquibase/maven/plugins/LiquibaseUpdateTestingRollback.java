package org.liquibase.maven.plugins;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.command.CommandScope;
import liquibase.exception.LiquibaseException;

/**
 * <p>Applies the DatabaseChangeLogs to the database, testing rollback. This is
 * done by updating the database, rolling it back then updating it again.</p>
 *
 * @description Liquibase UpdateTestingRollback Maven plugin
 * @goal updateTestingRollback
 */
public class LiquibaseUpdateTestingRollback extends AbstractLiquibaseUpdateMojo {

    @Override
    protected void doUpdate(Liquibase liquibase) throws LiquibaseException {
        try {
            liquibase.updateTestingRollback(new Contexts(contexts), new LabelExpression(getLabelFilter()));
        } catch (LiquibaseException exception) {
            handleUpdateException(exception);
        }
    }
}
