package io.github.minan65.core_abstractions.auth;

import java.util.List;

public interface AuthorizedRoleService {
    List<String> getRoles(String username);
}
