package io.github.mhmmedinan.core_abstractions.auth;

import java.util.List;

public interface AuthorizedRoleService {
    List<String> getRoles(String username);
}
