package com.yellowfortyfour.apollo;

import java.security.Permission;

public class ApolloSecurityManager extends SecurityManager
{

    @Override
    public void checkExit(int status)
    {
    
    }

    @Override
    public void checkAccess(ThreadGroup g)
    {
    }

    @Override
    public void checkPermission(Permission perm, Object context)
    {
     
    }

    @Override
    public void checkPermission(Permission perm)
    {

    }
}
