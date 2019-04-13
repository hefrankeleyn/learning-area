package con.hef.spittr.security;

import con.hef.spittr.domain.Spitter;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;

public class SpitterPermissionEvaluator implements PermissionEvaluator {

    private static final GrantedAuthority ADMIN_AUTHORITY = new SimpleGrantedAuthority("ROLE_ADMIN");
    @Override
    public boolean hasPermission(Authentication authentication, Object target, Object permission) {

        if (target instanceof Spitter){
            Spitter spitter = (Spitter) target;
            String username = spitter.getUsername();
            if ("delete".equals(permission)){
                return isAdmin(authentication) || username.equals(authentication.getName());
            }
        }
        throw new UnsupportedOperationException("hasPermission not supported for object < " + target + "" +
                "> and permission <" + permission + ">");
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        throw new UnsupportedOperationException();
    }

    private boolean isAdmin(Authentication authentication){
        return authentication.getAuthorities().contains(ADMIN_AUTHORITY);
    }
}
