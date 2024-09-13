package io.github.minan65.core_application.pipelines.auth;

import an.awesome.pipelinr.Command;
import io.github.minan65.core_abstractions.auth.AuthorizedRoleService;
import io.github.minan65.core_crosscuttingconcerns.exceptions.types.AuthenticationException;
import io.github.minan65.core_crosscuttingconcerns.exceptions.types.AuthorizationException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AuthenticationBehavior implements Command.Middleware {

    @SneakyThrows
    @Override
    public <R, C extends Command<R>> R invoke(C command, Next<R> next) {
        if (command instanceof AuthenticatedRequest)
        {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if(authentication == null || !authentication.isAuthenticated())
                throw new AuthenticationException("You are not authenticated.");

            if(command instanceof AuthorizedRequest)
            {
                String username = authentication.getName();
                List<String> requiredRoles = ((AuthorizedRequest) command).getRequiredRoles();
           
               boolean hasAnyMatch = authentication
                .getAuthorities()
                .stream()
                .anyMatch(role->requiredRoles
                        .stream()
                        .anyMatch(x-> x.equalsIgnoreCase(role.getAuthority())));
                if (!hasAnyMatch)
                    throw new AuthorizationException("You are not authorized");
            }
        }
        return next.invoke();
    }
}
