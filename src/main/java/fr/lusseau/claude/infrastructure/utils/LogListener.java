package fr.lusseau.claude.infrastructure.utils;

import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;
import io.quarkus.arc.Priority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.utils
 * @date 13/08/2022
 */
@Interceptor
@Priority(1)
@LogAudited
public class LogListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogListener.class.getName());

    @AroundInvoke
    public Object audit(InvocationContext context) throws Exception {
        LOGGER.info("Calling Method : " + context.getMethod().getName() + " On Class : " + context.getClass().getCanonicalName());
        return context.proceed();
    }
}
