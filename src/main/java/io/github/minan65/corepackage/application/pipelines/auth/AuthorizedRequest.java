package io.github.minan65.corepackage.application.pipelines.auth;

import java.util.List;

public interface AuthorizedRequest extends AuthenticatedRequest{
    List<String> getRequiredRoles();
}
