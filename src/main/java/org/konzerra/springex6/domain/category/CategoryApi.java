package org.konzerra.springex6.domain.category;

public final class CategoryApi {
    public static final String PUBLIC_BASE = "/public/api/v1/category";
    public static final String PROTECTED_BASE = "/protected/api/v1/category";

    public static final String FIND_BY_ID = PUBLIC_BASE + "/{id}";
    public static final String PAGINATED = PUBLIC_BASE + "/paginated";

    public static final String SAVE = PROTECTED_BASE;
    public static final String UPDATE = PROTECTED_BASE;
    public static final String DELETE_BY_ID = PROTECTED_BASE + "/{id}";
}
