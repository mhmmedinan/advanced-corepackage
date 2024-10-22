package io.github.mhmmedinan.core_application.pipelines.auth;

import java.util.List;

public interface AuthorizedRequest extends AuthenticatedRequest{
    List<String> getRequiredRoles();
}
